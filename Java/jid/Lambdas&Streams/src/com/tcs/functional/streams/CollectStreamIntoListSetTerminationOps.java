package com.tcs.functional.streams;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static java.util.stream.Collectors.*;

import com.tcs.functional.streams.SlicingStream.Book;

public class CollectStreamIntoListSetTerminationOps {
	//version 1 and we have collect toList() predefined method why we need to do like this
	// recommednded is version 2 that is in below
	public static void collectVesrion1(List<Book> books) {
		List<Book> list2 = books.stream().filter( b -> b.getPrice() >= 50)
		.map( d -> d.getTitle()).distinct().limit(6)
		.collect( () -> new ArrayList(),  // ~ Supplier ~ we can do ArraList::new
				       // take container means return type
					   ( a, t ) -> a.add(t), // ~ BiConsumer ~ we can do ArrayList::add
					   // a ~ stands for container in this case ArrayList, so a would be accumulator
					   // t ~ we are adding the input stream element to this, means filtered output 
					   (a1,a2) -> a1.addAll(a2)); // ~ combiner ~ we can ArrayList::addAll
		              // it takes 2 containers a1, a2, remeber ArrayList has addAll() method
		              // for clarification about combiner see example() method in below
		System.out.println("\nlist2 size : " + list2.size());
		System.out.println("list2 in version 1: " + list2);
	}
	
	// example for combiner concept, 
	public static void example() {
	//	Set<String> l1 = new TreeSet<>(); works fine but better example is List coz both
		// are matching for clarification
		List<String> l1 = new ArrayList<>();
		l1.add("Ameer");
		l1.add("Khan");
		
		List<String> l2 = new ArrayList<>();
		l2.addAll(l1);
		System.out.println(l2);
	}
	
	// version 2 collect toList() ~ recommended
	public static void colletToCollectionInList(List<Book> books) {
		List<Book> list1 = books.stream().filter( b -> b.getRating() >= 4.5).
				/*map(d -> d.getTitle()).*/distinct()/* .limit(5) */.collect(/* Collectors. */toList());
		// toList() and toSet() returns an instance of Collector interface.
		// distinct() removes duplicates 
		//.forEach(System.out::println);
	//	System.out.println("list1: " + list1.size());
	//	System.out.println("list1: " + list1);
		System.out.println("Hi");
		for (Book list:list1) {
			System.out.println(list);
		}
	}
		
	
	// collect toSet()	
	public static void colletToCollectionInSet(Set<Book> books) {
		Set<String> set1= books.stream().filter( b -> b.getRating() >= 4.5).
				map(d -> d.getTitle())/* .limit(5) */.collect(/* Collectors. */toSet());
		// distinct() removes duplicates but we do not need coz Set is already does this
		System.out.println("\nset1 size(): " + set1.size());
		System.out.println("set1 in Set: " + set1); 
		
					// or we can do another thing is 
		TreeSet<? extends Object> set2 = books.stream().filter( b -> b.getRating() >= 4.5).
				map(d -> d.getTitle()).collect(/* Collectors. */toCollection(() -> new TreeSet()));
		// toCollection passes supplier 
		System.out.println("\nset2.size() :" + set2.size());
		System.out.println("directly TreeSet set: " + set2);
		// we can ionvoke toCollection and pass supplier if we want some other implementations
		
		// Note:- when we are working on TreeSet remember few things that you need to 
		// definitely invoke hashCode,equals and compareTo methods if possible compare() too.
		
		
	}
		
		public static void main(String[] args) {
			List<Book> books= new ArrayList<>();
			books.addAll(DataExtractionSlice.getFromAmazon("Java"));
			books.addAll(DataExtractionSlice.getFromBarnesAndNoble("Java"));
			collectVesrion1(books);
			colletToCollectionInList(books);
			example();
			
			
			Set<Book> booksSet= new TreeSet<>();
			// One thing SEt invokes HashSet and cannot cast to TreeSet so we cannot perform
			// and we will end up with classCastExcpetion for that definitely we need to
			// implement compareTo method in the Book Class in order to avoid error
			// and it sorts elements according to ISBN and ensures uniqueness
			// if you remove compareTo method from Book class again you will get an error
			booksSet.addAll(DataExtractionSlice.getFromAmazon("Java"));
			booksSet.addAll(DataExtractionSlice.getFromBarnesAndNoble("Java"));
			colletToCollectionInSet(booksSet); 
		}
		
}

// Note Points:- 

 // 1. we can also give method and constructor references to collect methods
 // 2. by adding sttaic keyword at the place of importing package we can only give method 
 // name instaed of Classname.methodName
      // for Example:- we dont need as Collectors.toList(), simply we can do toList().
      // import static java.util.stream.Collectors.*;
