package com.tcs.generics;

public class GenericConstructors<T> {
	
	// Generic Constructors are Rare !
	<E extends T> GenericConstructors(E object) { 
		new GenericConstructors<Number>(12.0); // T is Number and E is Double
		new GenericConstructors<>(12.0); // both T & E are Double
		new <Double>GenericConstructors<Number>(12.0); // Type witness
	//	new <Double>GenericConstructors<>(12.0); // error coz could have Inferred from arg
		GenericConstructors<Number> gd =new GenericConstructors<>(12.0);// To Avoid Invariance
		
	}
		

	public static void main(String[] args) {
		System.out.println("\n\t\t\t\t\tHey :)");
	}

}
