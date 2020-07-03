package com.rd4j.common.function;

@FunctionalInterface
public interface BigFunction<T, U, F, R> {

    R apply(T t, U u, F f);
}
