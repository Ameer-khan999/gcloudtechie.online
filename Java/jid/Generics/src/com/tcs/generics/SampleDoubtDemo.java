package com.tcs.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleDoubtDemo {
	// diff B/w Store<T> and Strore<?>
	// 1. Store<T> is class level -> stores unknown type
	// 2. Store<?> is parameter level -> stores any type
	// Note:- We cannot decalre Store<?> at class level
	public static void main(String[] args) {
		
		// using Unbounded wildcard List<?>
		go(new ArrayList<Integer>());
		go(new ArrayList<String>());
		go(new ArrayList<Object>());
		go(new ArrayList<BoundedWildCards>());
		
				
		// using upper Bounded wildcards as Object as Bound ( extends )
		go1(new ArrayList<String>()); // will get error if we place Number instead of Object in method go1()
		go1(new ArrayList<Integer>());
		go1(new ArrayList<Object>()); // will get error if we place Number instead of Object in method go1()
		go1(new ArrayList<BoundedWildCards>()); // will get error if we place Number instead of Object in method go1()
		
		go2(new ArrayList<Number>());
		go2(new ArrayList<Integer>());
		go2(new ArrayList<Double>());
//		go2(new ArrayList<Object>()); // if we  ? extends Number, we cannot invoke super types Ex: Object
										// but we can invoke Integer coz Integer is sub type to Number
		
		// using Lower bounded wildcards as String as Bound ( super )
		go3(new ArrayList</*Number*/Object>()); // will get error if we place Number instead of Object
		
		go4(new ArrayList<Object>());
		go4(new ArrayList<Number>());
//		go4(new ArrayList<Integer>()); // if we  ? super Number, we cannot invoke sub types Ex:Integer
										// but we can invoke Object coz object is super type to Number
		
		// for better Understanding
		List<Integer> l=Arrays.asList(1,2);
		
		SampleDoubtDemo.go(l);
		SampleDoubtDemo.go1(l);
		SampleDoubtDemo.go2(l);
//		SampleDoubtDemo.go3(l); // throws error  
//		SampleDoubtDemo.go4(l); // throws error
		
	}
	
	public static void go(List<?> list) {
		
	}
	
	public static void go1(List<? extends /* Number */Object> list) {
		
	}
	
	public static void go2(List<? extends  Number > list) {
		
	}
    
    public static void go3(List<? super String> list) {
		
	}
    
    public static void go4(List<? super Number> list) {
		
	}

}
