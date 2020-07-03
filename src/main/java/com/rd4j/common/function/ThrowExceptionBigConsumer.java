package com.rd4j.common.function;

@FunctionalInterface
public interface ThrowExceptionBigConsumer<T, U, F, E extends Throwable> {

    void accept(T t, U u, F f) throws E;
}
