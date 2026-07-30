package com.tcs.jvminternals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author ameer
 * reflection is nothing but meta info of classes,methods and interfaces.
 * 
 *  Reflection Use Cases:-
 *   1. Class browsers in IDE
 *   2. processing annotations , e.g., ORM frameworks,JUnit
 *   3. Dynamic proxies.
 *   
 *  Introspect known/unknown code
 *  Affect runtime behaviour due to introspection.
 *  
 */

public class ReflectionDemo {
	// Class object access demonstration + meta-information access
		public static void demoClassObjectAccess() {
		    System.out.println("\nIn demoClassObjectAccess ...");
		    
		    // Using objectRef.getClass()
		 	String[] strArray = {"a", "b", "c"};
		 	System.out.println("\nstrArray.getClass().getName(): " + strArray.getClass().getName());
		    
		    // Using for Class.forName
		    Class clazz = null;
		    try {
			    clazz = Class.forName("com.tcs.jvminternals.User");		    
			} catch(ClassNotFoundException e) {
	            System.out.println("\nCan't find class ...");		
			}		
			System.out.println("\nclazz.getName(): " + clazz.getName());
			System.out.println("clazz.isInterface(): " + clazz.isInterface());
			System.out.println("clazz.getInterfaces(): " + clazz.getInterfaces().length);
			System.out.println("clazz.getSuperclass().getName(): " + clazz.getSuperclass().getName());
					
			// Exception is thrown as Class.forName cannot be used on primitives
			try {
			    System.out.println("\nClass.forName(\"boolean\").getName(): " + Class.forName("boolean").getName());
			} catch(ClassNotFoundException e) {
	            System.out.println("\nClassNotFoundException due to Class.forName(\"boolean\").getName()");		
			}			
			
			// Using .class
			System.out.println("\nint.class.getName(): " + int.class.getName());
		}
		
		// Demonstrates instance creation & method invocation
		public static void demoCoreReflection(Class clazz) throws InstantiationException, 
		        IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		    System.out.println("\nIn demoCoreReflection ...");
		    
		    Object object = null;
			try {
			    object = clazz.newInstance(); // MUST HAVE DEFAULT CONSTRUCTOR		    
			} catch(InstantiationException e) {	
	            System.out.println("Can't instantiate ...");		
			} catch (IllegalAccessException e) {	
	            System.out.println("Can't access ...");		
			}		
			System.out.println("object.getClass(): " + object.getClass().getName());
		    // System.out.println("clazz.getDeclaredMethodsAmeer(): " + clazz.getDeclaredMethods());
			
			for (Method m : clazz.getDeclaredMethods()) {
			    System.out.println("Method name: " + m.getName());
			    if (m.getReturnType() == void.class) {
			    	System.out.println("Method's return type is void!!! ");
			    }
			}
			for (Constructor c : clazz.getDeclaredConstructors()) {
			    System.out.println("Constructor: " + c.getName() + ", # parameters: " + c.getParameterTypes().length);
			}
			
			// Fetch constructor & invoke it
			@SuppressWarnings("unchecked")
			Constructor<User> userConstructor = clazz.getDeclaredConstructor(int.class, String.class, String.class, String.class, String.class);
			@SuppressWarnings("unchecked")
			User user = userConstructor.newInstance(101, "john", "john@semanticsquare.com", "male", "user");
			
			// Fetch method & invoke it
		    @SuppressWarnings("unchecked")
			Method m = clazz.getDeclaredMethod("saveWebLink", String.class, String.class);
			Object result = m.invoke(user, "http://www.google.com", "Google");
			System.out.println("Result of invoking saveWebLink: " + ((Boolean)result).booleanValue());
		}
		
		public static void main(String[] args) throws Exception {
	    	demoClassObjectAccess();		
			demoCoreReflection(Class.forName("com.tcs.jvminternals.User"));
		}
}
