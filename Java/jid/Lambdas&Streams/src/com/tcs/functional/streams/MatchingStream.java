package com.tcs.functional.streams;

import java.util.ArrayList;
import java.util.List;

import com.tcs.functional.streams.SlicingStream.Book;

public class MatchingStream {

	public static void main(String[] args) {
		List<Book> books= new ArrayList<>();
		
		books.addAll(DataExtractionSlice.getFromAmazon("Java"));
		books.addAll(DataExtractionSlice.getFromBarnesAndNoble("Java"));
		
		match(books); // intermediate opration and it returns Stream Objects.
	}
	// Quries on match
	// A. Is there at least one highly rated book ( >= 4.8) that is inexpensive ( <=50) ~ anyMatch
	// B. Do all the books have a rating >= 4.8 ~ allMatch
	// C. Check if none of books have bad rating (2.0)? ~ noneMatch
	private static void match(List<Book> books) {
		
		// Type 1 ~ anyMatch
		boolean anyMatch = books.stream().anyMatch(d -> d.getTitle() == "Java1" && 
				d.getPrice() <= 50);
		System.out.println("anyMatch rating >=4.5 and price < 50?: " + anyMatch);
		
		// Type 2 ~ allMatch
		boolean allMatch = books.stream().allMatch(d -> d.getRating() >= 4.5);
		System.out.println("allMatch rating >= 4.5? : " + allMatch);
	
		 // just for clarity we can also do this 
	/*	boolean allMatchtype2 = books.stream().noneMatch(d -> d.getRating() < 4.5);
		System.out.println("allMatchtype2?: " + allMatchtype2);*/ // but this not clear
		// above is simpler than this, we can choose simpler
		
		// Type 3
		boolean noneMatch = books.stream().noneMatch(d -> d.getRating() <= 2.0);
		System.out.println("nonematch rating <= 2.0? :  " + noneMatch);
		
		// just for clarity we can also do this 
		boolean allMatch2 = books.stream().allMatch(d -> d.getRating() > 2.0);
		System.out.println("allMatch2 rating > 2.0? :  " +allMatch2);
		
		boolean anyMatch2 = books.stream().anyMatch(d -> d.getRating() > 2.0);
		System.out.println("anyMatch2 rating > 2.0? :  " +anyMatch2);
	}
}
