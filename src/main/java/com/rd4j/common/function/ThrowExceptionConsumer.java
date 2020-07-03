package com.rd4j.common.function;

@FunctionalInterface
public interface ThrowExceptionConsumer<T, E extends Throwable> {

    void accept(T t) throws E;
}
