package com.tcs.generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author ameer
 * 					Type-Eraser
 * Note:- we created 3 Store() instances of 3 diff Objects ,it does not mean we created 3 
 *        instances,actually there is a concept of type-eraser from compiler it erases the 
 *        all parameters(Ex: String,Integer) and type parameters(Ex: T) and applies explicit
 *        casting on get method based on their return types. for example
 *        
 *    Ex1: Compiler explictly casts String type when we invoke get() method on stringStore
 *             because it has return type of String. similarly on Inetger and List<Integer>.
 *             
 *    Ex2: Compiler explictly casts Integer type when we invoke get() method on intgerStore
 *          because it has return type of Integer.
 *          
 *    Ex3: Compiler explictly casts List<Integer> type when we invoke get() method on listStore
 *         because it has return type of List<Integer>.
 *         
 *         In one word ~ compiler applies = type eraser + explicit casting.
 * 			
 */

public class GenericsDemo {
	
	public static void main(String[] args) {
		Container<String> stringStore = new Store<>();
		stringStore.set("Java");
		System.out.println("stringStore: " + stringStore.get());
		
		Container<Integer> integerStore = new Store<>();
		integerStore.set(1);
		System.out.println("\nintegerStore: " + integerStore.get());
		
		Container<List<Integer>> listStore = new Store<>();
		listStore.set(Arrays.asList(1,2,3));
		System.out.println("\nlistStore: " + listStore.get());
		
		
		/*
		 * Container1<Map<String,Integer>> mapStore = new Store1<>();
		 * mapStore.set("Java",21); System.out.println(mapStore.get());
		 */
		 
	// Note On Restrictions 1: never use primitivess(Ex: int,double) as parameterized type.
    // Note On Restrictions 2: Never use in static context ( both in methods and varaibles).
		
		List<Number> list  = new ArrayList<>();
		list.add(1);
		list.add(new Integer(2296078));
		list.add(new Double(24000.75));
		list.add(new Long(7396712666L));
		list.add(null);
	//	list.add("Ameer"); // it gives error at compile time(this is main concept of Generics). 
		System.out.println("\nlist with Number as Parameter  type: " + list);
		// Integer and Double are subtypes of Number but not string,so we can also pass 
		// subtypes 
		
		// But here we can face some issues if we not use Generics.
		// here we are not getting comiple time error but we will surely get runtime error.
		// we will get java.lang.ArrayStoreException at java.util.LinkedList because we are
		// supposed to store an ArrayList Objects not an LinkedList  Objects. but in case Of 
		// array the type safety is ensured at runtime only and at above example the type
		// safety ensured at copmile time only due to Generics.
		// so this kind of issues we have to face if we are not using Generics.
		List[] l = new ArrayList[6];
		l[0] = new ArrayList();
		l[1] = new ArrayList();
	//	l[2] = new LinkedList(); // Not reporting at comiple time but throws error at runtime.
		
	
		System.out.println(ternaryName(5));
		
		returingListWithoutGenerics();
		
	}
	// Just example on teranary operator.
	private static String ternaryName(int i) {
		return i <= 5 ? "Ameer" : "Khan";
	}
	
	public static void returingListWithoutGenerics() {
		List li=new LinkedList();
		li.add(1);
		li.add(2296078);
		li.add(24000.75);
		li.add(7396712666L);
		System.out.println("returingListWithoutGenerics: " + li);
	}
	
	/*
	 * public static void returingArray() { Array[] a=new Array[5]; a[0]=1; }
	 */ // we cannot add like this
}

	// Container interface
interface Container<T> {
	void set(T a);
	T get();
}


	// Store class
class Store<T> implements Container<T> {
	private T a;

	public void set(T a) {
		this.a=a;
	}

	public T get() {
		return a;
	}
}



