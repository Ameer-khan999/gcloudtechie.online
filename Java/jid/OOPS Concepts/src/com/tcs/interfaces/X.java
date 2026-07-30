package com.tcs.interfaces;

/**
 * 
 * @author XYZ Inc
 *
 */

public class X extends /* D */ AbstractA  implements A,B,Cloneable, C {

	
	@Override
	public void foo() {
		System.out.println("X: foo");
		System.out.println("VAL:" + A.VAL);
		System.out.println("VAL:" + B.VAL);
		System.out.println("Class D VAL: " + D.VAL);
		// if we not give fully qualified name as A.VAl and B.VAL compiler gives ambiguous error coz VAL
		// presented in both A and B interfaces.
	}

	
	public void bar() {
		System.out.println("X: bar");
	}
	
	public void fooBar() {
		System.out.println("X: fooBar");
	}
	
	public C clone() {
		try {
			return (C) super.clone();
		} catch (CloneNotSupportedException cnse) {
			System.out.println("Clone Not Supported..!!");
			// cnse.printStackTrace();
		}
		return null;
	}
		
	/*
	 * public void go() { System.out.println("X: go"); }
	 */
	
	public void classHasPreferenceThanDefaultMethod() {
		System.out.println("Always class method has preference than default methods in interfaces..");
		System.out.println("\nif you want to call default method surely then invoke super: ");
		C.super.classHasPreferenceThanDefaultMethod();
	}
	
	public void inheritanceTest() {
		go(); // we can do this.
		// staticMethod(); we cannot do this
	}
}
	 
	 


