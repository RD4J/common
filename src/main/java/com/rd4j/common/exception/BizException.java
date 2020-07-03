package com.rd4j.common.exception;

import com.rd4j.common.enums.ResultCode;
import com.rd4j.common.util.Check;
import com.rd4j.common.util.Formatter;
import org.slf4j.event.Level;

/**
 * 业务异常
 * 
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class BizException extends CustomException {

    public BizException(String message, Object... argArray) {
        this(ResultCode.BIZ.code(), message, argArray);
    }

    public BizException(int code, String message, Object... argArray) {
        super(code, Formatter.message(message, argArray));
        checkIfCanUseCode();
    }

    public static BizException create(Integer code, String message) {
        return Check.isNull(code) ? new BizException(message) : new BizException(code, message);
    }

    @Override
    public void checkIfCanUseCode() {
        if (ResultCode.BIZ.verification(code)) {
            throw new IllegalCodeException("业务异常code范围不能={}", code);
        }
    }

    /**
     * 日志打印级别
     *
     * @return 结果
     */
    @Override
    public Level logPrintLevel() {
        return Level.INFO;
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
