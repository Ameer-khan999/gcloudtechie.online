package com.tcs.jvminternals;

/**
 * Demonstrates,
  (i) class is NOT loaded on accessing a compile-time constant. Constant is fetched from .class file
  (ii) On accessing a non compile-time constant, class & its super-class are LOADED and INITIALIZED
  (iii) On instantiating the class, it is loaded from memory (loading was done previous step) and 
         (a) superclass constructor is run, i.e., CONSTRUCTOR CHAINING
		 	(b) its instance variables are initialized and instance initializer block is run
		 	(c) its own constructor is run
 * @author ameer
 *
 */

interface SuperInterface {
	int STATIC_FINAL3 = new ClassInitializationDemoOriginal().getInt();
	int STATIC_FINAL5 = new ClassInitializationDemoOriginal().getInt5();
	static void staticMethod() {
		System.out.println("Superinterface: staticMethod");
	}
	
}

class ObjectReference {
	ObjectReference() {
	  System.out.println("ObjectReference: constructor");
	}
}

class Superclass {
    static {
	    System.out.println("Superclass: static initializer");
	}
    {
	    System.out.println("Superclass: instance initializer");
	}
    Superclass () {
    	System.out.println("Superclass: constructor");
	}    
}

class Subclass extends Superclass implements SuperInterface {
	static final int STATIC_FINAL = 47/* (int) (Math.random() * 5); */;	// compile time constant
	static final int STATIC_FINAL2 = (int) (Math.random() * 5);
	
	//static String stringLiteral = "hello";	
	//public static int STATIC_FINAL4 = new ClassInitializationDemo().getInt();
	
	ObjectReference objectReference = new ObjectReference();
	static {
		System.out.println("Subclass: static initializer");
		//staticFinal = 47;
	}		
	Subclass () {
		System.out.println("Subclass: constructor");	    
	}	
	// Instance initializer is copied to the beginning of constructor by compiler
	{
		System.out.println("Subclass: instance initializer");	
	}
}

public class ClassInitializationDemoOriginal {
	{
		System.out.println("\nClassInitializationDemoOriginal: instance initializer");
	}
	
	static {
		System.out.println("\nClassInitializationDemoOriginal: static initializer (Initialization Stage)");
	}
	
	static int getInt() {
		System.out.println("ClassInitializationDemoOriginal: getInt()");
		return 3;
	}
	
	static int getInt5() {
		System.out.println("ClassInitializationDemoOriginal: getInt5()");
		return 5;
	}
	
	public static void main(String[] args) {
		System.out.println("\nJVM Invoked the main method...");
		System.out.println("Subclass.STATIC_FINAL: " + Subclass.STATIC_FINAL);
		//System.out.println("Subclass.stringLiteral: " + Subclass.stringLiteral);
		System.out.println("Invoking Subclass.STATIC_FINAL2  ... ");
		System.out.println("Subclass.STATIC_FINAL2: " + Subclass.STATIC_FINAL2); 
		System.out.println("\nInstantiating Subclass ...");
		new Subclass();
		System.out.println("Superinterface.STATIC_FINAL3: " + SuperInterface.STATIC_FINAL3);
		//Superinterface.staticMethod();
	}
}

/*
 * we did run as config -> arguments -> -verbose.class
 * 
 * starts from main class than main method than static blocks than we are invoking subclass but class loads from 
   super interface,superclass to subclass coz subclass extending and implemting interface and super class thats why..
 
 * static final int STATIC_FINAL = 47 --> comple time since it not calling any classes and executes diectly coz already 
   compiler knows the value.
   
 * static final int STATIC_FINAL2 = (int) (Math.random() * 5); --> this loads the math classes than interface,super class and than 
   subclass..
   
   Note:- as per my idea jvm starts from main method and than static blocks and its inits later instance blocks and their inits.
 */



