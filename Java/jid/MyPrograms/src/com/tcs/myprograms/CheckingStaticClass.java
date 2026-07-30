package com.tcs.myprograms;

import java.util.HashMap;
import java.util.Map;

public class CheckingStaticClass {
	public static Map<String, Integer> checkingStaticClass() {
		Map<String,Integer> map= new HashMap<>();
		map.put("Ameer",24);
		System.out.println(map);
		return map;
	}
	
	public static void main(String[] args) {
		checkingStaticClass();
	}
}
