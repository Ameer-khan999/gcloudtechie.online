package com.tcs.myprograms;

import com.tcs.myprograms.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Program extends MySampleProgram {
	static int s,c;
	static String name="Hi";
	
	private static void methodEx() throws InputMismatchException {
		ArrayList<Integer> arraylist=new ArrayList<>();
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter s value :");
			s=sc.nextInt();
			System.out.println("Enter c value :");
			c=sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("OOPS ! enter input as integer type");
		} finally {
			System.out.println("Ya it's working..");
		}
		arraylist.add(s);
		System.out.println("arraylist: " + arraylist);
		"name".concat("Ammer khan");
		System.out.println("Name is: " + name);
		
	}
	public static void main(String[] args) {
		methodEx();
		mySampleProgram(s,c);
		
	}

}
