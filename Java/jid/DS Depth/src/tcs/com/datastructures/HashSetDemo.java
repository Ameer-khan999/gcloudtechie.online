package tcs.com.datastructures;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetDemo {
	// private static final String  = null;

	public static void hashSetDemo() {
		Set<String> set1 = new LinkedHashSet<>();
		set1.add("a");
		set1.add("b");
		set1.add("a");
		
		System.out.println("set1: " + set1);
		System.out.println("we can able to see only 1 a in set1 even we added 2 a's\ninto set and this coz of uniqueness of HashSet..");
		
		Book book1 = new Book("Walden","Henry",1854);
		Book book2 = new Book("Walden","Henry",1854);
		
		Set<Book> set2 = new HashSet<>();
		set2.add(book1);
		set2.add(book2);
		
		System.out.println("set2: " + set2);
		
	}
	
	public static void main(String[] args) {
		hashSetDemo();

	}
	
}


class Book {
	private String title;
	private String author;
	private int year;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author=author;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this. year= year;
	}
	
	public Book(String title, String author, int year) {
		super();
		this.title=title;
		this.author=author;
		this.year=year;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, title, year);
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
		return Objects.equals(author, other.author) && Objects.equals(title, other.title) && year == other.year;
		
		// this will call automatically from souece -> getting hashCode() & equals().
	}
	
	/*
	 * public int hashCode() { return title.hashCode(); }
	 * 
	 * public boolean equals(Object o) { return (year==(((Book) o).getYear())) &&
	 * (author.equals((((Book) o).getAuthor()))); // return (year == (((Book)
	 * o).getYear())) && (author.equals((((Book)o).getAuthor()))); }
	 */ // we wrote this manually but no need to write this coz it is already developed in in-built.
	
	

	
}
