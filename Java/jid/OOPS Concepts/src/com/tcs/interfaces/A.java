package com.tcs.interfaces;

public interface A {
	int VAL = 5;
	abstract void foo();
	void bar();
	
	
	default void go() {
		System.out.println("A: go");
	}
	
	// Note:- 
	  // 1.Classs has higher precedence than default methods in interfaces
	  // 2. sub intefaces has higher precedence than super Interface so C: go is calling 
	   // instead of A: go.
	
}
	
