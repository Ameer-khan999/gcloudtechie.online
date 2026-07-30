package com.tcs.interfaces;

/**
 * 
 * @author ABC Inc
 *
 */

public interface C extends A ,B  {
	void fooBar();
	
	
	// default methods.
	// void go(); // ABC company wants to add method go() in their API
	
	/* this interface are linked with company XYZ in concrete class and Client TestClient.
	 so we have to must and should implement this abstract method in Concrete class X otherwise we will 
	 get compilation error for clients at class X and TestClient, to avoid this problem simply ABC company has to add default method in Interface C 
	 instead of abstract method void go(); !!
	 
	 remove comments to void go(); for better understanding 
	 
	 now i am going to create default method in interface C instead of abstract method.
	*/
	
	/* final */ default void go() { // we  cannot add final keyword to this methods
		System.out.println("C: go");
		staticMethod(); // from default we calling staticMethod like helper method
	} // without breaking Client code ABC Company added new method go() successfully in their Interface C.
	  // thats the beauty of defaults methods.
	
	// this is called binary compatibility means no need to compile code again.
	// if we compiled successfully without errors thats called source compatibilty.
	// remember this two new words.
	
	// Note:- default methods should be write only in interfaces.
	
	default void classHasPreferenceThanDefaultMethod() {
		System.out.println("default methods does not have Preference Than classes: ");
		
		
		
	}
	// Note:- default methods of interfaces cannot override object classes methods

	// static methods in interfaces.
	static void staticMethod() {
		System.out.println("C: staticMethod");
	}
}
