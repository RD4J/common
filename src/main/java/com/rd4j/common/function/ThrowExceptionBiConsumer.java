package com.rd4j.common.function;

@FunctionalInterface
public interface ThrowExceptionBiConsumer<T, U, E extends Throwable> {

    void accept(T t, U u) throws E;
}
