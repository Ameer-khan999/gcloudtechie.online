package com.tcs.myprograms;

public class Demo {
	
	public static void main(String[] args) {
		int a=30, b=45;
		System.out.println("before: " + a + b);
		swapFunction(b,a);
		System.out.println("After: " + a + b);
	}

	public static void swapFunction(int a, int b) {
		// TODO Auto-generated method stub
		int c=a;
		a=b;
		b=c;
		
	}

}
