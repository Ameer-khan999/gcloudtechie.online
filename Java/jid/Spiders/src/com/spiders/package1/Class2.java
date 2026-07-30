package com.spiders.package1;

import java.util.Map;

public class Class2 extends Class1 {
	public static void main(String[] args) {
		Class1 c1= new Class2();
		System.out.println(c1.a());
		System.out.print(c1.hashmapDemo());
		System.out.println("\nhashMapReturn(): " + hashMapReturn());
		
		// c1.hashmapDemo();
	}
	
	
	public static Map<String, Integer> hashMapReturn() { 
		return Class1.hashmapDemo();
	}
	 
}
