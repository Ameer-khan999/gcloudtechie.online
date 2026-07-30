package com.tcs.interfaces;

/**
 * @author Client Inc

 */

import java.util.*;

public class TestClient {
	public static int getVal() {
		return 101;
	}
	
	public static void main(String[] args) {
		TestClient tc=new TestClient();
	 //A a=new A(); it gives comiplation error coz we cannot Instantiate A as object coz A is interface.
	 //A a=new AbstractA(); it gives comiplation error coz we cannot Instantiate A as object coz AbstarctA 
		                    // is abstract class 
	 //AbstractA a=new X(); // it does not sees ref type,it sees obj type, 
		                    // no matter whether we kept AbstractA or A as ref type,both will work
	 A a=new X();
	 a.foo();
	 a.bar();
	 ((C) a).fooBar(); 
	 // fooBar() is not in A compiler checks ref type A whether method is existed in A or not
	 // so we have to apply caste as like this " ((C) a).fooBar(); " 
	 
	 // or we can do by create new instantiate as C ref type. like below
	 
	 System.out.println("\nor we can do..!\n");
	 
	 C c=new X();
	 c.foo();
	 c.bar();
	 c.fooBar();
	 c.go();
	 c.classHasPreferenceThanDefaultMethod();
	 
		
		C clone = ((X) c).clone();
		if (clone != c) {
			System.out.println("Clone Cretaed..!!");
		}
		new TestClient().lambdaTest(() -> System.out.print("\nJava-In-Depth"));
		System.out.println("\tThis is a FunctionalInterface");
		// this is the implementation of lambdaTest method,In case if the FunctionalInterface has two 
		// abstract methods then compiler get confused to implement which method and it gives error 
		// Note :- we can add default methods even that the FunctionalInterface remain FunctionalInterface
		
		// static concept in inheritance
		
		// c.staticMethod(); // this is not possible coz we cannot invoke through object as we know that
		// static and interface are stateless and cannot be instantiate to objects.
		C.staticMethod(); // so always Invoke via interface name only otherwise you will get compile error.
	}
	
	 void lambdaTest(FunctionalInterface fi) {
		fi.test1();
	}
}
