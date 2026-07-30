
package com.tcs.abstractclasses;

public class ConcreteSubClass extends AbstractSubClass {
	// Note:- if we extended AbstractSuperClass instead of AbstractSubClass than we need
	// to add unimplemented test1() method here otherwise will end up with an error.
	void test2() {
		System.out.println("test2 in concrete  extending super");
	}
	void test3() { // this instance method cannot override static method from AbstractSubClass.test3()
		System.out.println("test3 in concrete  extending super");
	}
	
	public static void main(String[] args) {
		
		AbstractSubClass concrete=new ConcreteSubClass();
		 		
		concrete.test1();
		concrete.test2();
		concrete.test3();
	System.out.println();	
	System.out.println("Now you are in confusion state by seeing above output that how test2()\nand test3()"
		+ " concrete  extending super but test1() sub extending \nsuper because in polymorphism we saw"
		+ " ref type and obj type if both \nmethods presented in both classes than compiler picks from" 
		+ " Obj type \nmeans sub type, if not presens than from ref type means super type, \nNow in our "
	    + "case test2() in concrete and test3() presented in both \nConcreteSubClass and in AbstractSubClass, "
		+ "now we know that compiler \npicks obj type thats why we got concrete extending super and test1()"
		+ " \nonly presented in AbstractSubClass. Hope You clear :)");
		 
	
	//  AbstractSubClass abs=new AbstractSubClass();
	//  AbstractSuperClass abs1=new AbstractSuperClass();
	// we cannot instantiate AbstractSuperClass or AbstractSubClass coz both are abstract classes.
	}
	/*
	 * @Override void test1() { System.out.println("yes");
	 * 
	 * }
	 */
}

// play with code by modifying inheritance class from Super to Sub and Sub to Super, we can understand
// how methods are overriding and you can too understand about abstract classes..
