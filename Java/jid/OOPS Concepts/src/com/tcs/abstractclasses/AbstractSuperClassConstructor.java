package com.tcs.abstractclasses;

// Note:- we can Instatiate AbstractClasses  but we can create Constructors 
// In fact compiler automatically inserts a no args constructor
public class AbstractSuperClassConstructor {
	static String name;
	public AbstractSuperClassConstructor(String name) {
		this.name=name;
	}
	
	public static void main(String[] args) {
	//	AbstractSuperClassConstructor b= new AbstractSuperClassConstructor(); // we cannot
		AbstractSuperClassConstructor b= new AbstractSuperClassConstructor("Ameer");
		System.out.println("SuperClassConstructor: " + b.name);
	}
}
