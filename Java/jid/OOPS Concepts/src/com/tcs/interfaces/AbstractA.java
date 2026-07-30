package com.tcs.interfaces;

public abstract class AbstractA implements A, B /* ,B */ {

	public void bar() {
		System.out.println("AbstractA: bar");
	}

	public void foo() {
		System.out.println("AbstractA: foo");
	}

	public void classHasPreferenceThanDefaultMethod() {
		System.out.println("AbstractA: classHasPreferenceThanDefaultMethod(): ");
	}
}
