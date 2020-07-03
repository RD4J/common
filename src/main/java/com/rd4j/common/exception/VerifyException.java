package com.rd4j.common.exception;

import com.rd4j.common.enums.ResultCode;
import com.rd4j.common.util.Check;
import com.rd4j.common.util.Formatter;
import org.slf4j.event.Level;

/**
 * 验证异常
 * 
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class VerifyException extends CustomException {

    public VerifyException(String message, Object... argArray) {
        this(ResultCode.VERIFY.code(), message, argArray);
    }

    public VerifyException(int code, String message, Object... argArray) {
        super(code, Formatter.message(message, argArray));
        checkIfCanUseCode();
    }

    public static VerifyException create(Integer code, String message) {
        return Check.isNull(code) ? new VerifyException(message) : new VerifyException(code, message);
    }

    @Override
    public void checkIfCanUseCode() {
        if (ResultCode.VERIFY.verification(code)) {
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
        return Level.DEBUG;
    }

    /**
     * 是否返回错误消息
     *
     * @return 结果
     */
    @Override
    public boolean ifReturnErrorMessage() {
        return true;
    }
}
