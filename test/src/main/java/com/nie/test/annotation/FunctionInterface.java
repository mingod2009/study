package com.nie.test.annotation;

@FunctionalInterface
public interface FunctionInterface {

	static void info() {
		System.out.println("");
	}
	default void bar() {
		System.out.println("");
	}
	void test();
}
