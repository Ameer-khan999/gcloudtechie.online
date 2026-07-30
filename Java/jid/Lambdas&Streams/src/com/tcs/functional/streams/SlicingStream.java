package com.tcs.functional.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SlicingStream {
	public static class Book implements Comparable {
		private long ISBN;
		private String title;
		private double rating;
		private double price;
		private String source;
		
		Book(long ISBN,String title,double rating,double price,String source) {
			this.ISBN=ISBN;
			this.title=title;
			this.rating=rating;
			this.price=price;
			this.source=source;
		}

		public long getISBN() {
			return ISBN;
		}

		public void setISBN(long iSBN) {
			ISBN = iSBN;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public double getRating() {
			return rating;
		}

		public void setRating(double rating) {
			this.rating = rating;
		}
		
		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		@Override
		public int hashCode() {
			return Objects.hash(ISBN);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			return ISBN == other.ISBN;
		}

		@Override
		public String toString() {
			return "Book [ISBN=" + ISBN + ", title=" + title + ", rating=" + rating + ", price=" + price + ", source="
					+ source + "]";
	
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return Long.valueOf(ISBN).compareTo(((Book)o).getISBN());
		} 
		
	}
	
	public static void main(String[] args) {
		List<Book> books= new ArrayList<>();
		
		books.addAll(DataExtractionSlice.getFromAmazon("Java"));
		books.addAll(DataExtractionSlice.getFromBarnesAndNoble("Java"));
		
		slice(books); // intermediate opration and it returns Stream Objects.
	}
	

	// Print at most 5 DISTINCT books with rating >= 4.5
	// DB world: select distinct (ISBN) from book where rating >= 4.5 limit 0, 5;
	/* private static void slice(List<Book> books) {
		books.stream().
		filter(d -> d.getRating() >= 4.5)
		.peek( d -> System.out.println(d.getTitle() + " " + d.getRating() + " " +
		d.getSource()))
		.skip(0).distinct().limit(2) // slicing methods
		.map(d -> d.getTitle()) // takes input X gives Output Y
		.forEach(System.out::println);
	} */
	
	// Type 2: Example collect Note:- collect is not slicing operation, just for clarity
	private static void slice(List<Book> books) {
		Set<String> result = books.stream().
		filter(d -> d.getRating() >= 4.5) // filter takes an input and produces same type
		.distinct().limit(5) 			  // of output
		.map(d -> d.getTitle()) 		  // where as map can take an input and it can 
		.collect(Collectors.toSet());	  // produce another type
		
		for ( String title : result) {
			System.out.println("title: " + title);
		}
		
		// example for map 
		System.out.println("\nExample for map..");
		Stream<Book> streamBooks = books.stream().filter(d -> d.getRating() >= 4.5)
			.distinct().limit(6);
		
		Stream<? super Number> streamsString = streamBooks.map( d -> d.getTitle());
		// Here you can see map takes Stream Book as input and produced Stream String,
		// Double,Long  as output, So it need not be sametype !.
		// This is called declarative programming.
		streamsString.forEach(System.out::println);
	}
}
