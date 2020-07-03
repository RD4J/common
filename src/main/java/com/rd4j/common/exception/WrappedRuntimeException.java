package com.rd4j.common.exception;

/**
 * 包裹成运行时异常
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class WrappedRuntimeException extends RuntimeException {

    private Exception m_exception;

    public WrappedRuntimeException(Exception e) {

        super(e.getMessage(), e, false, false);

        m_exception = e;
    }

    public WrappedRuntimeException(String msg, Exception e) {
        super(msg, e, false, false);
        m_exception = e;
    }

    public Exception getException() {
        return m_exception;
    }
}
