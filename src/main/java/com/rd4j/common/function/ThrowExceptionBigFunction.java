package com.rd4j.common.function;

@FunctionalInterface
public interface ThrowExceptionBigFunction<T, U, F, R, E extends Throwable> {
    R apply(T t, U u, F f) throws E;
}
