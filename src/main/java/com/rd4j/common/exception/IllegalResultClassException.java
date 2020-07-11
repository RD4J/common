package com.rd4j.common.exception;

import com.rd4j.common.pojo.Result;
import com.rd4j.common.util.Formatter;

/**
 * 非法的Result class<br>
 *
 * @see Result
 */
public class IllegalResultClassException extends RuntimeException {
    public IllegalResultClassException(String message, Object... argArray) {
        super(Formatter.message(message, argArray));
    }
}
