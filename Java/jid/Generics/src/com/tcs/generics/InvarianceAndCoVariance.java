package com.tcs.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InvarianceAndCoVariance {
	// invariance is responsible for compile time type safety
	// item 25: prefer lists over arrays.
	
	public static void main(String[] args) {
		// Invariance
		go(new ArrayList<Number>());
		go(new LinkedList<Number>());
      //  go(new List<Integer>());
		 // List<Number> is not a subtype of List<Integer> even though
		// Integer is a subtype of Number, in one word we cannot assign an instance of
		// List<Number> to a List<Integer>.this is for ensuring compile time type safety.
		// go(new ArrayList<Integer>());
		
		
		// Covariance
		go(new Double[1]); // not gives any error
		go(new Integer[1]); // gives java.lang.ArrayStoreException coz Integer not Double
		
		
	}
	
	// InVariance
	
	static void go(List<Number> list) {}
	
	// CoVariance
	static /* Number[] */void go(Number[]  list) {
		list [0]  = 24.5; // gives java.lang.ArrayStoreException coz Integer not Double
		// return list;
	}

}

// Note:-

/*
 InVariance:- since Integer is a subtype of Number but it is not considering this and giving 
 Compilation error but it is Complaining when we passed ArrayList & LinkedList coz of List.
 
 CoVariance:- In CoVariance compiler not complaining coz Integer is a subtype of Number but 
 we are getting java.lang.ArrayStoreException coz we passed Integer value instead of Double.
*/
