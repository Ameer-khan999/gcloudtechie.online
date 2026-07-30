package com.tcs.myprograms;

import java.util.InputMismatchException;

public class MySampleProgram {
	/*
	 * public static void main(String[] args) { mySampleProgram(5,7); }
	 */

	public static int mySampleProgram(int a,int b) throws InputMismatchException {
		
		try {
			System.out.println("The value of s is :" + a);
			System.out.println("The value of c is :" + b);

		} catch (InputMismatchException e) {
			System.out.println("OOPS !");
		}
		 
			
		return 0;
		
		
		
	}
}