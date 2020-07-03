package com.rd4j.common.exception;

import com.rd4j.common.enums.ResultCode;
import com.rd4j.common.util.Check;
import com.rd4j.common.util.Formatter;
import org.slf4j.event.Level;

/**
 * 外部调用异常
 * 
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class ExternalCallException extends CustomException {

    public ExternalCallException(String message, Object... argArray) {
        this(ResultCode.CALL.code(), message, argArray);
    }

    public ExternalCallException(int code, String message, Object... argArray) {
        super(code, Formatter.message(message, argArray));
        checkIfCanUseCode();
    }

    public static ExternalCallException create(Integer code, String message) {
        return Check.isNull(code) ? new ExternalCallException(message) : new ExternalCallException(code, message);
    }

    @Override
    public void checkIfCanUseCode() {
        if (ResultCode.CALL.verification(code)) {
            throw new IllegalCodeException("验证异常code范围不能={}", code);
        }
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
}
