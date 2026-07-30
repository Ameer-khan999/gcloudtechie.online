package com.tcs.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvoidUsingRawTypes<T> implements Container<T> {
	private T a;
	
	public void set(T a) {
		this.a = a;
	}
	
	public T get() {
		return a;
	}
	
	public static void rawTypeTest() {

		List<String> strList1 = Arrays.asList("a", "b", "c");
		List<String> strList2 = Arrays.asList("b", "c", "d");
		getCommonElementsCountWithRaw(strList1, strList2);	
	}
	
	public static int getCommonElementsCountWithRaw(List list1, List list2) { // use unbounded wildcards
		int count = 0;
		for (Object element : list1) {
			if (list2.contains(element)) {
				count++;
			}
		}
		System.out.println("Common elements count with RawType: " + count);
		return count;
	}
	
	
	public static void rawTypeTest2() {
		System.out.println("\n\nInside rawTypeTest ...");
		int ISBN = 1505297729;
	    List<Double> prices = new ArrayList<>();
	    
	    HalfIntegrator.getPrice(ISBN, prices);
	    Double price = prices.get(0);
	}



	// WildCards ~ if you tempt to sue Raw types that you dont care about Objects in the list
	//             use Unbounded WildCards, it gives compile time safety guarantee.
	

	public static void rawTypeTest1() {

		List<String> strList1 = Arrays.asList("a", "b", "c");
		List<String> strList2 = Arrays.asList("b", "c", "d");
		getCommonElementsCountWithWildCards(strList1, strList2);	
	}
	
	public static int getCommonElementsCountWithWildCards(List<?> list1, List<?> list2) { // use unbounded wildcards
		int count = 0;
		for (Object element : list1) {
			if (list2.contains(element)) {
				count++;
			}
		}
		System.out.println("\nCommon elements count with WildCards: " + count);
		return count;
	}
	
	public static void main(String[] args) {
		rawTypeTest();
		rawTypeTest1();
	//	rawTypeTest2();
		
		
		Container<String> stringStore= new AvoidUsingRawTypes<>();
		stringStore.set("Java");
		
		Container<Integer> integerStore= new AvoidUsingRawTypes<>();
		integerStore.set(1);
		
		Container<?> someStore = stringStore;
		Object object = someStore.get();
		System.out.println("\nStored element is : " + object);
		
		Container<?> someStore1 = integerStore;
		Object object1 = someStore1.get();
		System.out.println("\nStored element is : " + object1);
		
		// we are using Unbounded WildCards with do not care, means we dont need to know 
		// which type of Data we are storing, In case we need to know than use generics or 
		// wildcards.
	}
	
}


class HalfIntegrator {
	
	public static void getPrice(int ISBN, List prices) { // here List is Raw Type 
		prices.add(45);
	}
	
}	
/*
 * interface Container<T> { void set(T a); T get(); }
 */