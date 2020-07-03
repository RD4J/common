package com.rd4j.common.function;

import java.util.function.BiFunction;

@FunctionalInterface
public interface ThrowExceptionBiFunction<T, U, R, E extends Throwable> {
    R apply(T t, U u) throws E;
}
