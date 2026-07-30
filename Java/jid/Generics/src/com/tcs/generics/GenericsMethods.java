package com.tcs.generics;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GenericsMethods<E> {

	// This are very imp to implement static utility methods which are very
	// reusable.
	// item 26: favor generics types.
	/**
	 * -> generics types are appropriate for container classes like the ones
	 * collections API -> which can store any kind of elements, i.e., this classes
	 * are very generics, Infact all collections classes we saw are generified.
	 * 
	 * -> Before generics was introduced collection API classes were using Object
	 * type as polymorphic type for storing elements. i.e., method add would use
	 * Object as the method parameter type and we know that it can lead to
	 * ClassCastException at Runtime. so generics help us to write safer code due to
	 * compile time safety benefit that it gives. hence if we happended to write a
	 * generics classes than we should make them into generic types. similarly there
	 * also a generic methods and there is an item dedicated for that
	 * 
	 * Item 27: favor generics methods -> we know that with generic types the client
	 * code has a diff flexibilty to use diff type arguments.similarly the generic
	 * methods has its own typa parameters and clients can get flexibilty to use
	 * diff type arguments, and also we can compile time safety and implicit
	 * casting(compiler applies) benefits.
	 * 
	 * Note:- Class level parameter cannot be used in a static contexts, it can be
	 * only use in instances.
	 */

	// Demonstrates:
	// (a) Type argument inference via method arguments & target types
	// (b) Explicit type argument specification
	// (c) Generic Constructor
	// (D) aggregate method fiexd from wildcards demo(Done).
	static void genericsMethodsDemo() {
		System.out.println("\nInside genericsMethodsDemo..");
		typeArgInference(22.0);
		typeArgInference("Java");

		// compile time safety benefit in a generic method
		Double s = typeArgInference1(22.9);
		// Double s1=typeArgInference1("Java");
		// Throws error coz we are Storing String Java to type Double.

		// compile time safety benefit in a generic method ~ wrong argument
		/* String */ Integer[] na = new /* String */ Integer[100];
		Collection<Integer /* Number *//* String *//* Object */> cs = new ArrayList();
		arrayToCollection(na, cs);

		// Type argument Inference via target type
		List<String> strval = typeArgInferenceFromTargetType1();
		List<Integer> intval = typeArgInferenceFromTargetType1();

		// Integer int1=typeArgInferenceFromTargetType1();

		// Type arg inference from method invocation context ~works from java 8(shows
		// for java 7 )
		GenericsMethods.targetTypeInvoker1(typeArgInferenceFromTargetType1()); // from 8
		// List<String> compares with List<T> here List<String> from targetTypeInvoker1
		// acts like a target type. Note:- we get an error if it is other than List<T>
		GenericsMethods.targetTypeInvoker1(new ArrayList<>());

		GenericsMethods.targetTypeInvoker2(typeArgInferenceFromTargetType1()); // Infers as Object
		// There is no type arguemnt and target type so it Infers as Object
		List<Integer> intList = GenericsMethods.targetTypeInvoker2(typeArgInferenceFromTargetType1());
		// Eclispe showing Integer not Object Coz it has Target type List<Integer>
		// earlier
		// we dont have any Target Type thats why eclipse shown Object

		GenericsMethods.targetTypeInvoker2(new ArrayList<>()); // Showing Object
		List<String> strList = GenericsMethods.targetTypeInvoker2(new ArrayList<>());
		// both are showing String coz it has Target type of List<String>

		// Inferring Most specific super type
		Serializable ser = typeArgInference1("", new ArrayList()); // for best look below line
		Collection col = typeArgInference1(new ArrayList(), new HashSet());
		// ArrayList and HashSet are sub classes of Collection so we are not getting
		// error
		// if we give HashMap insted of HashSet will get error, lets try
		// Collection col1=typeArgInference1(new ArrayList(),new HashMap()); will get
		// error

		List<Integer> intList1 = Arrays.asList(1, 2);
		List<Integer> intList2 = Arrays.asList(3, 4);
		List<Integer> intList3 = new ArrayList<>();
		aggregate(intList1, intList2, intList3);
		System.out.println("intList33: " + intList3);

	}

	// Type argument inference via method argument
	public static <T> void typeArgInference(T object) {
		System.out.println("Type Argument: " + object.getClass().getName());
	}

	public static <T> T typeArgInference1(T object) {
		System.out.println("Type Argument: " + object.getClass().getName());
		return object;
	}

	// Type argument inference via Target Type
	public static <T> List<T> typeArgInferenceFromTargetType1() {
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("123");

		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);

		return (List<T>) list; // or return (List<T>) list;

		// Note:- the return type and target type must and should equal otherwise will
		// get
		// error and never forget to type cast at return statement.

	}

	public static <T> T typeArgInferenceFromTargetType2() {
		List<String> list = new ArrayList<>();
		list.add("abc");

		List<Integer> list1 = new ArrayList<>();
		list1.add(123);
		return (T) "";
	}

	public static void main(String[] args) {
		genericsMethodsDemo();
		typeArgInference(new GenericsDemo());
		// typeArgInferenceFromTargetType2();
		System.out.println(GenericsMethods.typeArgInferenceFromTargetType1());

		// System.out.println(GenericsMethods.typeArgInferenceFromTargetType2());
	}

	static <T> void arrayToCollection(T[] a, Collection<T> c) {
		for (T o : a) {
			c.add(o); // correct
		}
	}

	static void targetTypeInvoker1(List<String> item) {
		for (String s : item) {
			System.out.println("Element is: " + s);
		}
	}

	static <T> List<T> targetTypeInvoker2(List<T> list) {
		return list;
	}

	static <T> T typeArgInference1(T object1, T object2) {
		System.out.println("Most specific type argument Inferred: " + object2.getClass().getName());
		return object1;
	}

	// Valid aggreagte methods

	public static <E> void aggregate(List<E> l1, List<E> l2, List<E> l3) {
		l3.addAll(l1);
		l3.addAll(l2);
	}

}
