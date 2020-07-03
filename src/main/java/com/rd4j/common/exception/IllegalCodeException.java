package com.rd4j.common.exception;

import com.rd4j.common.util.Formatter;

/**
 * 非法code异常
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class IllegalCodeException extends RuntimeException {
    public IllegalCodeException(String message, Object... argArray) {
        super(Formatter.message(message, argArray));
    }
}
