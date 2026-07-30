package com.tcs.myprograms;

import java.util.Map;

public class CheckingStaticClass1 {
	public static Map<String,Integer> checkingStaticClass1() {
		System.out.println("Map<String,Integer>: " + CheckingStaticClass.checkingStaticClass());
		return CheckingStaticClass.checkingStaticClass();
	}
	
	public static void main(String[] args) {
		checkingStaticClass1();
	}
}
