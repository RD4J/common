package com.rd4j.common.function;

@FunctionalInterface
public interface ThrowExceptionSupplier<T, E extends Throwable> {

    T get() throws E;
}
