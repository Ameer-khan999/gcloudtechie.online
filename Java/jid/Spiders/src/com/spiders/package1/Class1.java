package com.spiders.package1;

import java.util.HashMap;
import java.util.Map;

public class Class1 {
	public static int a=1;
	
	public static int a() {
		// System.out.println("Hi");
		return Class1.a;
	}
	
	public static Map<String, Integer> hashmapDemo() {
		System.out.println("Inside HashMap\n");
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("John",26); // cannot call add/addAll coz Map does not supports this methods
		map1.put("Raj",28);
		map1.put("Anita",null);
		// System.out.println("map1: " + map1);
		return map1;
	}
}
