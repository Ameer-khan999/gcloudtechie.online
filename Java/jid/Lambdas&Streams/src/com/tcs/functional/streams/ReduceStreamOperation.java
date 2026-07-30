package com.tcs.functional.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.tcs.functional.streams.SlicingStream.Book;

public class ReduceStreamOperation {
	public static void main(String[] args) {
		List<Book> books= new ArrayList<>();
		
		books.addAll(DataExtractionSlice.getFromAmazon("Java"));
		books.addAll(DataExtractionSlice.getFromBarnesAndNoble("Java"));
		
		reduce(books); // termination operation and it is optional method
		reduceImperatively(books);
		overLoadedReductions();
	//	E(books);
	}
	
	public static void E(List<Book> book) {
		book.stream().filter(d -> d.getRating() >= 4.5)
				.distinct().skip(4).limit(5) 
		.forEach(System.out::println);
	}
	
	// Type:1better
	public static void reduce(List<Book> books) {
		System.out.println("reduce method..");
		books.stream().filter(b -> b.getRating() >= 4.5)
		.reduce((b1,b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2)
		// reduce is a optional method.
		.ifPresent(b -> System.out.println(b));
	}
	
	
	// Limitations:-
	// 1. Cumbersome
	// 2. Parallelizing is painful.
	// 3. Synchronizing shared mutable variable is expensive
	public static void reduceImperatively(List<Book> books) {
		System.out.println("\nreduce imperatively..");
		Book result=null;
		
		for(Book book:books) {
			// Initialize result with first book having rating >=4.5 or not, if yes it continues to another if condition
			if(result==null) {
				if(book.getRating() >= 4.5) {
					result=book;
				}
				System.out.println("In 1st if condition result is: " + result);
				continue;
			}
			if (book.getRating() >= 4.5 && result.getPrice() > book.getPrice()) {
				result=book;
				// here target is getting current book.getPrice()
				// for better understanding change the values in DataExtraction Class.
			}
		}
		
		System.out.println("Imperatively reduce: " + result);
	}
	
	// static overloaded reduce
	public static void overLoadedReductions() {
		System.out.println("\noverloaded reductions..");
		
		String[] grades = {"A", "A", "B"};
		
		// Version ~ 2
		String concat1 = Arrays.stream(grades)
		.reduce(/* new String() */ /* or */ "",(s1,s2) -> s1 + s2);
		System.out.println("concat1: " + concat1);
		// go with version 2 if both parameters types are same
		// this version Using Binary operator
	
		// Version ~ 3
		StringBuilder concat2= Arrays.stream(grades)
		.reduce(new StringBuilder(),(sb,s) -> sb.append(s),
					(sb1,sb2) -> sb1.append(sb2));
		System.out.println("concat2: " + concat2);
		// You have parameters with two diff type than go with 3 version
		// thid version using BiFunction and both works with parallel streams.
		
		
		// Instructor Assignment
		StringBuilder concat3 = Arrays.stream(grades)
				.map ( s -> new StringBuilder(s)).
				reduce( new StringBuilder(), (sb1,sb2) -> sb1.append(sb2));
					// or 
		      //  reduce( new StringBuilder(), StringBuilder::append);
		System.out.println("concat3: " + concat3);
		
		// here we cannot do //concat3.forEach(System.out::println); why ?
				// Not find any reason and we have to dig that
	}
}
