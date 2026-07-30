package com.tcs.interfaces;

public interface FunctionalInterface {
	// exactly having one abstract method is called functional Interface.
	// Not having any methods is called Marker Interface.
	// having one or more methods are called regular Interfaces.
	// void test();// if i disable this comment we will get compilation error at TestClient Class coz 
	// FunctionalInterface must contain only one abstract method but it can also contain more than one default
	// methods and static methods.
	
	
	// Note:- having more than one abstract method not called as Functional Interface but it can called as 
	// regular Interface, here what is make nonsense! , hm it means we cannot create lambda expressions that
	// you need to aware about this that we can only give lambda expressions if the inteface is functional
	// so if you want to work on lamda expressions than make your interface functional means create only one
	// abstract method.
	abstract void test1();
	
	default void test2() {
		// Not a problem with default methods in a FunctionalInterface.
	}
	
	default void test3() {
		// Functional Interface can contain more than one default method but not abstract
	}
	
	static void test4() {
		// Functional Interface can contain static methods too.
	}
	
	static void test5() {
		// Functional Interface can contain more than one static methods too.
	}
	
// 	String t(); we cannot do this, if we do this than this interface is not a Functional
	String toString(); // we can do this,still this interface is an Functional, we know
	// String class belongs to Object class, and Object is mother of all classes.
}
