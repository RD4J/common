package com.rd4j.common.exception;

import com.rd4j.common.enums.ResultCode;
import com.rd4j.common.pojo.Result;
import com.rd4j.common.util.Check;
import com.rd4j.common.util.Clazzs;
import org.slf4j.Logger;
import org.slf4j.event.Level;

/**
 * 统一自定义异常标准
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public interface UnifyCustomException {

    /**
     * 错误码
     *
     * @return 结果
     */
    int code();

    /**
     * 错误消息
     *
     * @return 结果
     */
    String message();

    /**
     * 日志打印级别
     *
     * @return 结果
     */
    Level logPrintLevel();

    /**
     * 是否返回错误消息
     *
     * @return 结果
     */
    boolean ifReturnErrorMessage();

    /**
     * 检查是否能使用的code
     */
    default void checkIfCanUseCode() {
        if (code() == ResultCode.SUCCESS.code()) {
            throw new IllegalCodeException("自定义错误code参数不能设置0");
        }
    }

    /**
     * 查找统一自定义异常
     *
     * @param throwable 异常
     *
     * @return 统一自定义异常 or null
     */
    public static UnifyCustomException findUnifyCustomException(Throwable throwable) {
        if (throwable instanceof UnifyCustomException) {
            return (UnifyCustomException) throwable;
        } else if (Check.isNotNull(throwable.getCause())) {
            return findUnifyCustomException(throwable.getCause());
        } else {
            return null;
        }
    }

    /**
     * 打印日志
     *
     * @param logger               日志对象
     * @param title                标题
     * @param throwable            异常对象
     * @param unifyCustomException 统一异常标准对象
     */
    public static void printLog(Logger logger, String title, Throwable throwable, UnifyCustomException unifyCustomException) {
        if (null == unifyCustomException) {
            logger.error(title, throwable);
            return;
        }

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

    /**
     * 创建Result对象
     *
     * @param clazz                必须继承Result类的class
     * @param unifyCustomException 统一的自定义异常
     * @param <R>                  继承Result类
     *
     * @return 创建根据自定义异常返回的数据拼装的Result对象
     *
     * @see Result
     */
    public static <R extends Result> R createResult(Class<R> clazz, UnifyCustomException unifyCustomException) {
        int code;
        String message;

        if (null == unifyCustomException) {
            code = ResultCode.SYSTEM.code();
            message = ResultCode.SYSTEM.describe();
        } else if (unifyCustomException.code() == ResultCode.SUCCESS.code()) {
            throw new IllegalCodeException("在对类的方法进行异常AOP时,获取到异常的Code=1,由于1为成功Code标记");
        } else if (unifyCustomException.ifReturnErrorMessage()) {
            code = unifyCustomException.code();
            message = unifyCustomException.message();
        } else {
            code = unifyCustomException.code();
            message = "请联系管理员！";
        }

        return Clazzs.newInstance(clazz).setFailed(code, message);
    }
}
