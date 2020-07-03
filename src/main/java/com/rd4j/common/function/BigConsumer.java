package com.rd4j.common.function;

@FunctionalInterface
public interface BigConsumer<T, U, F> {

	void accept(T t, U u, F f);
}
