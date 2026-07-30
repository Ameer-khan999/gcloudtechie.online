package com.tcs.interfaces;

public class MyClass implements APrivateInterface {
	public static void main(String[] args) {
		
		APrivateInterface a = new MyClass();
		a.defaultMethod();
		System.out.println("");
		APrivateInterface.staticMethod();
	}

	@Override
	public void fg() {
		// TODO Auto-generated method stub
		
	}
}
