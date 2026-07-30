package com.tcs.abstractclasses;

//import com.tcs.interfaces.*;

// Note:- We will face some issues if we import interface package and implements A 
// Interface coz AbstractSuperClass gets interface property and AbstractSuperClass is being
// extending by AbstractSubClass and AbstractSubClass is being extending by ConcreteSubClass
// in last we have to implement unimplemented foo() and bar() methods of interface A in
// ConcreteSubClass ufff very confusing, hmm so remove comments of implement A and above
// imported interface package u will get to know exactly what is happening.. :)
abstract class AbstractSuperClass /* implements A */{
	
	abstract  void test1(); /*{
		System.out.println("null");
	}*/
	   
	/*
	 * System.out.println("overridden"); }
	 */
	abstract void test2();
	// Note abstact methods does not contains curly braces (Ex:- {} )
	
	
	
	
	

}
