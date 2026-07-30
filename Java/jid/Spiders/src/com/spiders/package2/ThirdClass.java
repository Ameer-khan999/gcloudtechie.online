package com.spiders.package2;

import com.spiders.package1.FirstClass;

public class ThirdClass extends FirstClass {
	public static void main(String[] args) {
		FirstClass fc=new ThirdClass();
		System.out.println("publicVariable from ThirdClass: " + fc.publicVariable);
	}
}
