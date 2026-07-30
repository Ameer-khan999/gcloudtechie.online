package com.tx.inhertinace;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * Mother m = new YoungerDaughter(); m.mother(); m.c(); m.d();
		 */
		
		Mother m = new Boy();
		m.mother();
		//m.motherl();
		m.c();
		m.d();
		//m.f();
		
		ElderDaughter e =new YoungerDaughter();
		e.c();
		e.d();
		e.f();
		e.mother();
		e.motherl();
		
		
		Mother m1 =new YoungerDaughter();
		
		try {
			m1.c();
			m1.d();
			m1.mother();
		}
		catch(ClassCastException ce) {
			ce.getMessage();
			System.out.println("error");
		}
	}
}


/** 
 * 1. if we are implementing interface we need to add unimplemented methods to the class or make 
 * that class abstract, coz in abstract classes no need to implement interface methods.
 * 
 * 2. If a abstract class implementing interface and another class extending that abstract class
 *  than that normal class has to add unimplemnted methods from both means, from abstract class
 *  and interface.
 *  
 *  for best practise refer this package.
 */
