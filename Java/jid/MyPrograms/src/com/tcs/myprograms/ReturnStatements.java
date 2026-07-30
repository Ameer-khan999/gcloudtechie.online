package com.tcs.myprograms;

import java.util.Scanner;

public class ReturnStatements {
	String b;
	String c;
	public String getSting(String a) {
		System.out.println(c);
		return a;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a name..=");
		String b=sc.nextLine();
		
		ReturnStatements rs=new ReturnStatements();
		String c=rs.getSting(b);
		System.out.println(c);
	}

}
