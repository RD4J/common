package com.rd4j.common.spring.boot.aop;

import com.rd4j.common.annotation.MethodCatchException;
import com.rd4j.common.enums.ResultCode;
import com.rd4j.common.exception.IllegalCodeException;
import com.rd4j.common.exception.IllegalResultClassException;
import com.rd4j.common.exception.UnifyCustomException;
import com.rd4j.common.pojo.Result;
import com.rd4j.common.util.Check;
import com.rd4j.common.util.Clazzs;
import com.rd4j.common.util.Formatter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 方法异常捕获AOP处理实现类<br>
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 * @see MethodCatchException
 * @see UnifyCustomException
 * @see Result
 * @see ResultCode
 */
@Aspect
@Component
public class MethodCatchExceptionAspect {

    @Pointcut("@annotation(com.rd4j.common.annotation.MethodCatchException)")
    public void methodCatchExceptionPointcut() {
    }

    @Around("methodCatchExceptionPointcut()")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        Logger logger = LoggerFactory.getLogger(pjp.getTarget().getClass());

        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Class<?> clazz = targetMethod.getReturnType();
        String methodName = targetMethod.getName();

        try {
            return pjp.proceed();
        } catch (Throwable ex) {
            // 如果异常在方法列表中则直接抛出
            Class<?>[] exceptionClassses = targetMethod.getExceptionTypes();
            for (Class<?> exceptionClass : exceptionClassses) {
                if (ex.getClass().isAssignableFrom(exceptionClass)) {
                    throw ex;
                }
            }
            return handleThrowable(logger, methodName, clazz, ex);
        }
    }

    private Object handleThrowable(Logger logger, String methodName, Class<?> resultClazz, Throwable throwable) throws Throwable {
        // 找出自定义异常
        UnifyCustomException unifyCustomException = findUnifyCustomException(throwable);
        // 输出日志
        printLog(logger, methodName, throwable, unifyCustomException);
        // 创建返回值
        return createResult(resultClazz, unifyCustomException);
    }

    private static UnifyCustomException findUnifyCustomException(Throwable throwable) {
        if (throwable instanceof UnifyCustomException) {
            return (UnifyCustomException) throwable;
        } else if (Check.isNotNull(throwable.getCause())) {
            return findUnifyCustomException(throwable.getCause());
        } else {
            return null;
        }
    }

    private static void printLog(Logger logger, String methodName, Throwable throwable, UnifyCustomException unifyCustomException) {
        // TODO 打印方法请求参数
        if (null == unifyCustomException || Check.isNull(unifyCustomException.logPrintLevel())) {
            logger.error(Formatter.message("调用{}方法异常.", methodName), throwable);
            return;
        }

        String title = Formatter.message("调用{}方法异常. Code={}, Message={}",
                methodName,
                unifyCustomException.code(),
                unifyCustomException.message());

        switch (unifyCustomException.logPrintLevel()) {
            case DEBUG:
                logger.debug(title, throwable);
                break;
            case INFO:
                logger.info(title, throwable);
                break;
            case WARN:
                logger.warn(title, throwable);
                break;
            default:
                logger.error(title, throwable);
                break;
        }
    }

    private static Object createResult(Class<?> resultClazz, UnifyCustomException unifyCustomException) {
        // 如果方法返回值为void的类型, 则不处理
        if (Void.class.equals(resultClazz)) {
            return null;
        }
        // 非Result类则报错
        if (!Result.class.isAssignableFrom(resultClazz)) {
            throw new IllegalResultClassException("返回值非Result类或其子类,不推荐使用当前注解");
        }

        int code;
        String message;

        if (null == unifyCustomException) {
            code = ResultCode.SYSTEM.code();
            message = ResultCode.SYSTEM.describe();
        } else if (unifyCustomException.ifReturnErrorMessage()) {
            code = unifyCustomException.code();
            message = unifyCustomException.message();
        } else {
            code = unifyCustomException.code();
            message = "请联系管理员！";
        }

        if (unifyCustomException.code() == ResultCode.SUCCESS.code()) {
            throw new IllegalCodeException("在对类的方法进行异常捕获时,获取到的异常Code码不能等于{},在系统定义中{}为成功码",
                    ResultCode.SUCCESS.code(),
                    ResultCode.SUCCESS.code());
        }

        return ((Result) Clazzs.newInstance(resultClazz)).setFailed(code, message);
    }
}
