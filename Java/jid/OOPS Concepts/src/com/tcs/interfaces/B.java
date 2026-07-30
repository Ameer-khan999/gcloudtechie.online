package com.tcs.interfaces;

public interface B {
	int VAL=/*42;*/ TestClient.getVal();

	void foo(); /*
				 * {
				 * 
				 * System.out.println("B: foo"); }
				 */
	
	// the above foo() method is in interface so we have to declare that method as abstract method
	// like currently had or without body or declare as static or defualt.
	
	/*
	 * public default void go() {
	 * 
	 * }
	 */
}