package com.rd4j.common.exception;

import com.rd4j.common.enums.ResultCode;
import com.rd4j.common.util.Formatter;
import org.slf4j.event.Level;

/**
 * 自定义异常
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class CustomException extends RuntimeException implements UnifyCustomException {
    protected int code;

    public CustomException(int code, String message, Object... argArray) {
        super(Formatter.message(message, argArray));
        this.code = code;
        checkIfCanUseCode();
    }

    /**
     * 错误码
     *
     * @return 结果
     */
    @Override
    public int code() {
        return code;
    }

    /**
     * 错误消息
     *
     * @return 结果
     */
    @Override
    public String message() {
        return getMessage();
    }

    /**
     * 日志打印级别
     *
     * @return 结果
     */
    @Override
    public Level logPrintLevel() {
        return Level.ERROR;
    }

    /**
     * 是否返回错误消息
     *
     * @return 结果
     */
    @Override
    public boolean ifReturnErrorMessage() {
        return false;
    }

    @Override
    public String toString() {
        return Formatter.message("code:{} message:{}", code, message());
    }
}
