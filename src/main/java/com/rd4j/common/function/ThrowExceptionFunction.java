package com.rd4j.common.function;

@FunctionalInterface
public interface ThrowExceptionFunction<T, R, E extends Throwable> {
    R apply(T t) throws E;
}
