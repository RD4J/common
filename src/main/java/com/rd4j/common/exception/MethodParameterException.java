package com.rd4j.common.exception;

import com.rd4j.common.util.Formatter;

/**
 * 方法参数异常
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class MethodParameterException extends RuntimeException {

    public MethodParameterException(String message, Object... argArray) {
        super(Formatter.message(message, argArray));
    }
}
