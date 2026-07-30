package com.tcs.abstractclasses;

abstract class AbstractSubClass extends AbstractSuperClass {

	@Override
	void test1() {
		System.out.println("test1 in sub extending super");
	}

	/* static */ void test3() {
		System.out.println("test3 in sub  extending super");
	}

	/*
	 * abstract void test(); if we removed this comment will get an error coz in
	 * concreteclass to implement unimplemented methods in case if we are trying to
	 * inherit AbstractSubClass.
	 * 
	 * Another case is if we not declared methods in abstract class with abstract
	 * keyword than we have to add body to that method. we know abstract methods
	 * does not contain body.
	 */

}
