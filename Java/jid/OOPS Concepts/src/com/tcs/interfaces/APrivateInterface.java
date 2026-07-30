package com.tcs.interfaces;

public interface APrivateInterface {
	public default void defaultMethod() {
		System.out.println("defaultMethod!!");
		privateMethod();
	}
	public static void staticMethod() {
		System.out.println("staticMethod!!");
		privateMethod();
	}
	
	private static void privateMethod() {
		System.out.println("privateMethod!!");
	}
	
	public void fg();
}
