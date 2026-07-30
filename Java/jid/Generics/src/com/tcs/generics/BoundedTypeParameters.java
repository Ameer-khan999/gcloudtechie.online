package com.tcs.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BoundedTypeParameters<T extends List /* & String */ /* & Serializable */ & Collection> {
	// if we use Serializable bound will get error at below line coz List is not subtype of
	// Serializable but we cannot get error at below 2nd and 3rd line( ArrayList,LinkedList)
	// coz they are subtypes of Serializable. 
	BoundedTypeParameters<List> list = new BoundedTypeParameters<>();
	BoundedTypeParameters<ArrayList> list1 = new BoundedTypeParameters<>();
	BoundedTypeParameters<LinkedList> test = new BoundedTypeParameters<>();
	
 //	BoundedTypeParameters<Collection> coll = new BoundedTypeParameters<>();
	// we got error coz Collection is super type to List
	// note:- we gave Collection interface as bound but still we are getting error coz
	// there is av List interface s Bound and this are mismatching.
	
	public void go(T list) {
		list.add(0,new Object());
// Compiler gets Confuse if We gives T as parameter type in method go(), we will get some errors lets see that
		// 1. extend bound at class level (Ex:- class BoundedTypeParameters<T extends List>)
		// 2. give direct bound as parameter type (EX:- public void go(List list) { } )
		// 3. add cast to method ( Ex:- ((List).list).add(0,new Object()); )
		
	// in one word if we remove step1 we will get error to overcome that do step 2 or stpe 3.
	}
	
	public static void main(String[] args) {
		System.out.println("\nHey folks ! This is all about BoundedTypeParameters..!");
	}

}

// Note points:-
 /*
 1. Always pass only one class prior to interfaces, if we pass more than 1 class or else if 
 	we pass interface first instead of class we will get error.
 	
 2. we can pass many interfaces, Not a problem.
 
 3. never pass arrays and primitives as bounds, we will get error. Ex:- List[],int
 
 */
