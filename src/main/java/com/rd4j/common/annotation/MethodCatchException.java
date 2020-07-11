package com.rd4j.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * 方法异常捕获注解<br>
 * 此注解作用于方法上,捕获的异常需要实现{@link com.rd4j.common.exception.UnifyCustomException}接口,异常才能解析出Code和Message参数.<br>
 * 方法返回值也可以是void类型,那样的话只会处理异常信息的打印功能<br>
 * 如存在返回值,返回值必须继承{@link com.rd4j.common.pojo.Result},否则不支持使用<br>
 * 如果是其它Exception的话,会认为是系统异常,统一返回code={@link com.rd4j.common.enums.ResultCode#FAIL}, message={@link com.rd4j.common.enums.ResultCode#FAIL#describe()}<br>
 * 如果在方法上显式抛出异常的话则不会对异常进行处理<br>
 * <p>
 * <p>
 * 具体处理实现见{@link com.rd4j.common.spring.boot.aop.MethodCatchExceptionAspect}<br>
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 * @see com.rd4j.common.spring.boot.aop.MethodCatchExceptionAspect
 * @see com.rd4j.common.exception.UnifyCustomException
 * @see com.rd4j.common.pojo.Result
 * @see com.rd4j.common.enums.ResultCode
 */
@Documented
@Inherited
@Retention(RUNTIME)
@Target(METHOD)
public @interface MethodCatchException {
}
