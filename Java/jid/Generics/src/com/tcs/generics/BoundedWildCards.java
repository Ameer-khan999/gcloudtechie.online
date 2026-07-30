package com.tcs.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class BoundedWildCards {
	 private static final int REPLACEALL_THRESHOLD     =   11;
	/**
	 * we know that generics are Invariance(sees compile time safety),we get ClassCastException
	 * Book is Subtype of Bookmark but List<Book> is not a Subtype of List<Bookmark>
	 * 
	 * @param args
	 */
	
	// Invariance Workaround ~ for harmless scenarios Where type safety is not a concern
	static <T extends /*Object*/Number> void invarianceWorkaround(List<T> list,T element) {
	// we can pass Number or its Subtypes otherwise will get error
	// list.add(new Double(23.3));// we cannot do this coz T is Unknown, we have to write
	// bounded wildcard like List<Number>,List<Integer>,List<Double>.
		
		T element1 = (T) new Double(23.3);
		list.add(element1);
		// we can compromise compile time safety by doing this but at runtime it throws exception
		// so avoid this type code
	}

	public static void main(String[] args) {
		BoundedWildCards.invarianceWorkaround(new ArrayList<Number>(),23.8);
	//	BoundedWildCards.invarianceWorkaround(new ArrayList<Integer>(),23.8); // Integer is sub of Number
		// we cannot pass integer and Double values. above line gives error
	//	BoundedWildCards.invarianceWorkaround(new ArrayList<String>()); // throws an error
		// since Object is supertype for all calsses we can prevent above error bt extending
		// Object instead of Number
		
		List<Integer> list1=new ArrayList<>();
		BoundedWildCards.invarianceWorkaround(list1,23);
		
		// calling display method
		boundedWildCardsDemo();
	}
	
	// Demo On Bounded Wildcards ~ Important
	public static void boundedWildCardsDemo() {
		System.out.println("\nInside Bounded Wildcards Demo..");
		List<Integer> intList=Arrays.asList(11,12,13);
		display(intList);
		
		List<Double> doubleList=Arrays.asList(11.1,12.2,13.3);
		display(doubleList);
		
		List<Number> numList=new ArrayList<>();
		aggregateWithconsumer(intList,doubleList,numList);
//		aggregate(intList,doubleList,numList);
		System.out.println("numList: " + numList);
		
		// some imp methods ,press F3 to see methods
		Collections.addAll(new ArrayList<Object>(),2,3);
		Collections.copy(numList, doubleList);
		System.out.println("\nnumList: " + numList); 
		System.out.println("Collections.disjoint: " + Collections.disjoint(intList, doubleList));
		// gives false if both values are same
		
		// type arg inference is Integer with wildcard type version of replaceAll!
		BoundedWildCards.replaceAll(numList, 11.1, 44); // replaces the all values of  11.1 to 44.
		System.out.println("numList after replacing values: " + numList);
		
		ArrayList<Number> numlist=new ArrayList<>(doubleList);
		System.out.println("numlist: " + numlist);
		
		ArrayList<Integer> numlist1=new ArrayList<>(intList);
		System.out.println("numlist1: " + numlist1);
		
		ArrayList<Double> numlist2=new ArrayList<>(doubleList);
		System.out.println("numlist2: " + numlist2);
		
/*		ArrayList<Integer> numlist3=new ArrayList<>(doubleList);
		System.out.println("numlist1: " + numlist); */
		// getting error coz type is Integer and value is Double, so we cannot do this
		// Cannot infer type arguments for ArrayList<>
	}
	
	
	// method using upper bounded wildcard Note:- This is not a Generic method
	public static void display(List<? /*super*/extends Number> list) { // producer of data
		for(/*Object*/Number element : list) {
			System.out.println("\ndisplay()/element: " + element/* .intValue() */);
			// Note:- intValue() gives only int values not double values
		}
	//	list.add(null); // we can add null but gives runtime error as UnSupported
		// Note:- add is a class level method,
	//	list.add(22); // we cannot consume data if we use extends,
		// we can add by changing extends as super
	}
	
	// same display() method as above but this time using Generic method
	// Note:- This is not Method overloading, Generics does not have any overloading concept
	// recommended for repetative tasks, if need only once above is recommended.
 /*	static <T extends Number> void display(List<T> list) {
		for(Number element:list) {
			System.out.println("\ndisplay()/element: " + element);
		}
	}
 */	
	// generic method preferrable over below method
	public static <E> void aggregateWithconsumer(List<? extends E> l1,List<? extends E> l2,
			List<? /*extends*/super E> l3) {
		l3.addAll(l1); // Class level methods need lower bounded wildcards means super
		l3.addAll(l2); // and we are consuming l1 & l2 so use super instead of extends
	} 
	
	
	/*
	 * public static <E> void aggregate(List<E> l1,List<E> l2,List<E> l3) {
	 * l3.addAll(l1); l3.addAll(l2); }
	 */
	
	// Demonstrates the exact match as it both produces & consumes data
	static <T> boolean replaceAll(List<T> list, T oldVal, T newVal) {
		boolean result = false;
        int size = list.size();
        if (size < REPLACEALL_THRESHOLD || list instanceof RandomAccess) {
            if (oldVal==null) {
                for (int i=0; i<size; i++) {
                    if (list.get(i)==null) {
                        list.set(i, newVal);
                        result = true;
                    }
                }
            } else {
                for (int i=0; i<size; i++) {
                    if (oldVal.equals(list.get(i))) {
                        list.set(i, newVal);
                        result = true;
                    }
                }
            }
        } else {
            ListIterator<T> itr=list.listIterator();
            if (oldVal==null) {
                for (int i=0; i<size; i++) {
                    if (itr.next()==null) {
                        itr.set(newVal);
                        result = true;
                    }
                }
            } else {
                for (int i=0; i<size; i++) {
                    if (oldVal.equals(itr.next())) {
                        itr.set(newVal);
                        result = true;
                    }
                }
            }
        }
        return result;
	}
	
}
