package com.tcs.myprograms;

import java.util.ArrayList;
import java.util.List;

public class MyGenericException <T>  /* extends Exception */{
	public static void main(String[] args) {
		System.out.println("\n\twe cannot write Generics in Exceptions..");
		MyGenericException mg=new MyGenericException();
		List<Integer> list = new ArrayList<>();

		list.add(10);

		list.add(20);

		list.add(30);

		mg.go(list);

		int element = list.get(3);
	}
	
	void go(List<? super T> list) {
		//   list.addAll(25.5);
		   list.add(35, null);
	}
}
