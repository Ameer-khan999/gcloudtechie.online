package com.tcs.inputoutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class Testing {
	private static void testingMethod() throws InputMismatchException,IOException {
	int data;
	try(BufferedReader in= new BufferedReader(new InputStreamReader(System.in))) {
		if((data=in.read()) != isInt()) {
			System.out.println("Done");
		} else {
			System.out.println("UnDone");
		}
	} catch(InputMismatchException e) {
		System.out.println("OOPS !");
	}
	}
	private static int isInt() {
		// TODO Auto-generated method stub
		
		return 0;
	}
	public static void main(String[] args) {
		try {
			testingMethod();
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
