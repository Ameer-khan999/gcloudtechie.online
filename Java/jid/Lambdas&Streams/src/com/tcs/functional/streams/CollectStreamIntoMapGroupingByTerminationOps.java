package com.tcs.functional.streams;

import java.util.List;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.HashMap;

// import java.security.KeyStore.Entry; just aware about this Entry too 
// we need Entry from Map not from security, but it imports automatically by Ctrl + O

import com.tcs.functional.streams.SlicingStream.Book;

public class CollectStreamIntoMapGroupingByTerminationOps {
	public static void collectToMap(List<Book> books) {
		System.out.println("UnSorted key using Map..");
		Map<Long,Book> map = books.stream().limit(5)		
	//	.collect(toMap(b -> b.getISBN(), b -> b)); // with this we got duplicate key error
		.collect(toMap(Book::getISBN,Function.identity(), // we used b -> b coz we need Book as value thats it
				(b1,b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2));
		// In order to avoid duplicate error from 1st toMap(2 params) we used overloaded 
		// 2nd toMap( 3 params) method and we gave constuctor ref and we used identity 
		// method coz identity also returns t -> t as we used in 1st toMap() b -> b, and
		// whenever you have like this b -> b than you can do this Function.identity(),and
		// 3rd parameter is used to get key by comparing price of Book to avoid duplicate
		// keys error enocunter from 1st toMap(Book::getISBN,Function.identity()).
		
		for(Entry<Long, Book> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		boolean isInstanceOf =  map instanceof HashMap;
		System.out.println("\nmap is instanceof HashMap ?: " + isInstanceOf);
		
		System.out.println("\nSorted Key by passing Supplier as TreeMap");
		Map<Long,Book> mapSorted = books.stream()
				.collect(toMap(Book::getISBN,Function.identity(),
						(b1,b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2,
				() -> new TreeMap()));
		// this is 3rd overloaded toMap( 4 params) and 4th param is Supplier TreeMap
		// as we know TreeSet and TreeMap gives sorting elements and unique too.
		
		for(Entry<Long, Book> entry : mapSorted.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
	
		
		// now if we want to group stream elements by avoiding dupliacte ratings of books
		// and key is ISBN and value is Book fields.
		Map<Double, List<Book>> ratings = mapSorted.values().stream()
				.collect(groupingBy(Book::getRating));
		System.out.println();
		for(Entry<Double, List<Book>> entry : ratings.entrySet()) {
			System.out.println("Key: " + entry.getKey());
			System.out.println("Value: " + entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		List<Book> books= new ArrayList<>();
		books.addAll(DataExtractionSlice.getFromAmazon("Java"));
		books.addAll(DataExtractionSlice.getFromBarnesAndNoble("Java"));
		collectToMap(books);
	}
}
