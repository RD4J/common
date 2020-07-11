package com.rd4j.common.exception;

import com.rd4j.common.enums.ResultCode;
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

}
