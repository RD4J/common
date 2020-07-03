package com.rd4j.common.util;

import com.rd4j.common.exception.BizException;
import com.rd4j.common.exception.ExternalCallException;
import com.rd4j.common.exception.VerifyException;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * 断言
 */
public class Assert<E extends Exception> {

    private final BiFunction<Integer, String, E> generateException;

    private Assert(BiFunction<Integer, String, E> generateException) {
        this.generateException = generateException;
    }

    /**
     * 验证
     */
    public static Assert<VerifyException> VERIFY = create(VerifyException::create);

    /**
     * 业务
     */
    public static Assert<BizException> BIZ = create(BizException::create);

    /**
     * 外部调用
     */
    public static Assert<ExternalCallException> EXTERNAL_CALL = create(ExternalCallException::create);

    public static <E extends Exception> Assert<E> create(BiFunction<Integer, String, E> generateException) {
        return new Assert<E>(generateException);
    }

    public static <E extends Exception> void isTrue(boolean expression, Supplier<E> supplier) throws E {
        if (!expression) {
            throw supplier.get();
        }
    }

    public static <E extends Exception> void isFlase(boolean expression, Supplier<E> supplier) throws E {
        if (expression) {
            throw supplier.get();
        }
    }

    public void throwException(String message, Object... formatArg) throws E {
        throw generateException.apply(null, Formatter.message(message, formatArg));
    }

    public void throwException(int code, String message, Object... formatArg) throws E {
        throw generateException.apply(code, Formatter.message(message, formatArg));
    }

    public void isTrue(boolean expression, String message, Object... formatArg) throws E {
        if (!expression) {
            throw generateException.apply(null, Formatter.message(message, formatArg));
        }
    }

    public void isTrue(boolean expression, int code, String message, Object... formatArg) throws E {
        if (!expression) {
            throw generateException.apply(code, Formatter.message(message, formatArg));
        }
    }

    public void isFlase(boolean expression, String message, Object... formatArg) throws E {
        if (expression) {
            throw generateException.apply(null, Formatter.message(message, formatArg));
        }
    }

    public void isFlase(boolean expression, int code, String message, Object... formatArg) throws E {
        if (expression) {
            throw generateException.apply(code, Formatter.message(message, formatArg));
        }
    }
}
