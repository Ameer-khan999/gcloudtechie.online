package com.tcs.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UnBoundedWildCards<E> extends GenericsDemo {

	public static void main(String[] args) {

		// Raw type demo:
		// rawTypeTest();

		List<String> strList1 = Arrays.asList("a", "b", "c", "e");
		List<String> strList2 = Arrays.asList("b", "c", "d", "e");

		getCommonElementsCountWithRawTypes(strList1, strList2);
		getCommonElementsCountWithUnBoundedWildCards(strList1, strList2);

		Container<String> strStore = new Store<>();
		strStore.set("java");
		Container<Integer> intStore = new Store<>();
		intStore.set(8989);

		// now we are using UnBoundedWildCard(?) to store the value that is stranger to
		// us
		Container<?> someStore = strStore/* genericsDemo().stringStore() */;
		// we dont know what value does strStore Hold and we are assinging it to
		// someStore
		Object object = someStore.get();
		System.out.println(object); // Avoid this type of Concepts
		// for this we can use Bounded
		// WildCards or generics methods.

		
		 
		// valid aggregate passed bounded wildcards(E)
		List<Integer> intList1 = Arrays.asList(1, 2);
		List<Integer> intList2 = Arrays.asList(3, 4);
		List<Integer> intList3 = new ArrayList<>();
		aggregate(intList1, intList2, intList3);
		System.out.println("Valid intList3: " + intList3);
		
		// Invalid aggregate passed unbounded wildcards(?)
		List<Integer> intList11 = Arrays.asList(1, 2);
		List<Integer> intList22 = Arrays.asList(3, 4);
		List<Integer> intList33 = /*Arrays.asList(5, 6)*/new ArrayList<>();
		invalidAggregate(intList11, intList22, intList33);
		System.out.println("Invalid intList33: " + intList33);

	}

	// with Raw Type
	public static int getCommonElementsCountWithRawTypes(List list1, List list2) {
		int count = 0;
		for (Object element : list1) {
			if (list2.contains(element)) {
				count++;
			}

		}
		System.out.println("getCommonElementsCountWithRawTypes(List list1,List list2): " + count);
		System.out.println("Note: Avoid Using Raw Types");
		return count;
	}

	// with UnBounded WildCards
	public static int getCommonElementsCountWithUnBoundedWildCards(List<?> list1, List<?> list2) {
		int count = 0;
		for (Object element : list1) {
			if (list2.contains(element)) {
				count++;
			}

		}
		System.out.println("\ngetCommonElementsCountWithUnBoundedWildCards(List<?> list1,List<?> list2): " + count);
		return count;
	}

	// invalid methods
	public static void invalidAggregate(List<?> l1, List<?> l2, List<?> l3) {
		// l3.addAll(null); // null Ok but throws java.lang.NullPointerException
		// l3.addAll(l2); // we cannot perform this methods add/addAll in UnBounded
		// Wildcards
		// since this are class level methods,for this we can use Bounded
		// WildCards or generics methods, Note:- we can perform contains method

	}

	// valid aggregate
	public static <E> void aggregate(List<E> l1, List<E> l2, List<E> l3) {
		l3.addAll(l1);
		l3.addAll(l2);
	}
	// using unbounded wildcards we cannot perform add.addAll methods but we can
	// with
	// this type
}

// Note Points to remember
/*
 * 1. Dont use at Class level like class Ex<?> gives error
 * 
 * 2. use at type parameters
 * 
 * 3. use at ref type
 * 
 * 4. dont use like this <?,?> compiler gets confuse to invoke which one.
 */
