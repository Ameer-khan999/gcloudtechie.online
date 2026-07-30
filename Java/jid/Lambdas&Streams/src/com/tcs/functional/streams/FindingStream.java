package com.tcs.functional.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.tcs.functional.streams.SlicingStream.Book;

public class FindingStream {
	private static Supplier<? extends Book> getDefault;

	public static void main(String[] args) {
		List<Book> books= new ArrayList<>();
		
		books.addAll(DataExtractionSlice.getFromAmazon("Java"));
		books.addAll(DataExtractionSlice.getFromBarnesAndNoble("Java"));
		
		match(books); // intermediate opration and it returns Stream Objects.
	}
	
	// findFirst needs more work in parallel env. Use findAny if it does the job.
	// java.util.Optional ~ 
	// (a) to avoid dealing with null -- in case of find, 
	// (b) to know if stream is empty -- in case of reduction operation

	private static void match(List<Book> books) {
		System.out.println("Finding Streams..\n");
		Optional<Book> withMethods = books.stream()
		.filter(d -> d.getRating() >= 4.8 && d.getPrice() <= 50).findAny();
		
		if(withMethods.isPresent()) {
			System.out.println("withMethods: " + withMethods);
		} 
		else {
			System.out.println("Not Found !!");
		}
		
		books.stream()
			 .filter(d -> d.getRating() >= 4.8 && d.getPrice() <= 50)
			 .findAny()
			 .orElseGet(FindingStream.getDefault);
		
		
		Optional<Book> result = Optional.ofNullable(books.stream()
				.filter(d -> d.getRating() >= 4.8 && d.getPrice() >= 50).findAny()
				.orElse(FindingStream.getDefault()));
		
		System.out.println("result: " + result);
		
		Optional<Book> opt = Optional.ofNullable(/* books.get(0) */null);
		System.out.println("opt: " + opt.isPresent());
	}
	
	private static void print(Book b) {
		System.out.println(b);			 
	}
	
	private static Book getDefault() {			
		System.out.println("default ...");
		return new Book(0, "", 4.0, 25.0, "Amazon");
	}
}
