package com.tcs.frescoplay.fp.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
public class FIUsingPredicate {
   public static void main(String args[]){
      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
      System.out.println("Print even numbers:");
      eval(list, n-> n % 2 == 0 ? true:false);
      
   // Predicate
     // Predicate<boolean> p = 1 > 2 ? true:false;
   }
   public static void eval(List<Integer> list, Predicate<Integer> predicate) {
      for(Integer n: list) {		
         if(predicate.test(n)) {
            System.out.println(n);
         }
      }
   }
   
   
   
   
   public static void findFact(int n) {
	   List<Integer> l = Arrays.asList(n);
	   for(Integer k:l) {
		   
	   }
   }
}

/*  1. Predicate:- 

	Predicate - Functional Interface
	
	public interface Predicate<T>
	Method Detail:
	
	boolean test(T t)
	
	Evaluates this predicate on the given argument.
	
	Parameters:
	
	t - the input argument
	
	Returns: true if the input argument matches the predicate, otherwise false

*/

/* 2. Consumer:- 

	Consumer - Functional Interface
	public interface Consumer<T>
	Method Detail:
	
	void accept(T t)
	
	Accepts a single argument and does not return any value.
	
	Parameters:
	
	T - the type of the input to the operation
*/

/* 3. Supplier:-

	Supplier - Functional Interface
	public interface Supplier<T>
	Method Detail:
	
	T get()
	
	Accepts no arguments but it returns a value.
	
	Returns:
	
	T - the type of results supplied by this Supplier.
*/

// Points - To Remember

// 1. Only one abstract method is allowed in any functional interface
// 2. A functional interface is valid even if the @FunctionalInterface annotation would 
//    be omitted. It is only for informing the compiler to enforce single abstract method
//    inside interface.
// 3. If an interface declares an abstract method overriding a method of java.lang.Object,
//    it does not count. e.g. Comparator is a functional interface even though it declared
//    two more abstract methods.

// exapmle for 3rd point
@FunctionalInterface
interface A {
	void A();
	// void B(); this gives error
	// String B(); gives error
	String toString(); // not gives an error coz toString() method belong to Object Class
	// and we know object class is mother of all classes.
	// means methods of all object class are eligible for FI.
	boolean equals(Object obj); 
	// int hashCode(Object o); gives error need to check this
	
}