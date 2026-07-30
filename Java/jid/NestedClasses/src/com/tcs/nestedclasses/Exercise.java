package com.tcs.nestedclasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



public class Exercise {
	
	public static final Comparator<Notes> TITLE_COMPARATOR= new Comparator<Notes>() {
		public int compare(Notes o1, Notes o2) {
			return ((Notes)o1).getTitle().compareTo(((Notes)o2).getTitle());
		}
	}; // singleton
	
	public static final Comparator<Notes> YEAR_COMPARATOR= new Comparator<Notes>() {
		public int compare(Notes o1, Notes o2) {
			//return ((Notes)o1).getTitle().compareTo(((Notes)o2).getTitle());
			// we cannot compareTo on primitive types for that we need to box it
			//return Integer.valueOf(o1.getYear()).compareTo(o2.getYear());
			// return Integer.valueOf(o1.getYear()).compareTo(o2.getYear());
			return o1.getYear() < o2.getYear() ? 1: -1;
		}
	}; // singleton
	
	
	public void treesetDemo() {
		Notes note1=new Notes("Harry Potter","Ameer",1998);
		Notes note2=new Notes("Saddam Hussein","James Morg",1980);
		Notes note3=new Notes("Harry Potter","meer",1998);
		Notes note4=new Notes("Once Upon A Time","Battu",1987);
		Notes note5=new Notes("A Man","Khan",2004);
		
	/*	Set<Notes> notes=new TreeSet<Notes>(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((Notes)o1).getTitle().compareTo(((Notes)o2).getTitle());
			}
		});*/ // Anonymous class
	Set<Notes> notes = new TreeSet<>( (o1,o2) -> { return o1.getYear() < o2.getYear() ? 1: -1; });
	// or else we can pass singleton field YEAR_COMPARATOR insted of lamda expression
		notes.add(note1);  									 
		notes.add(note2);
		notes.add(note3);
		notes.add(note4);
		notes.add(note5);
		
		for(Notes n:notes) {
			// System.out.println(Notes.getYear());
			System.out.println("notes are: " + n);
		}
		
	Set<Notes> notess = new TreeSet<>(TITLE_COMPARATOR);
	// notess.add((Notes) notes);
	notess.addAll(notes);
	
	for(Notes n1:notess) {
		// System.out.println(Notes.getYear());
		System.out.println("\nnotess are: " + n1);
	}
	}
	

	public static void main(String[] args) {
		Exercise  e=new Exercise ();
		e.treesetDemo();
	}
}

class Notes implements Comparable {
	private String title;
	private String author;
	private  int year;
	
	public String getTitle() {
		return title;
	}
	
	public void settitle(String title) {
		this.title=title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor() {
		this.author=author;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year=year;
	}
	
	public Notes(String title,String author,int year) {
		super();
		this.title=title;
		this.author=author;
		this.year=year;
	}
	
	@Override
	public String toString() {
		return "Notes [ title = " + title + ", author = " + author + ", year = " + year + " ]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		//return getTitle().compareTo(((Notes) o).getTitle());
		return getTitle().compareTo(((Notes) o).getTitle());
	}
}


/*class AuthorComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		return ((Notes)o1).getAuthor().compareTo(((Notes)o2).getAuthor());
	}
	
}*/ // without anonymous class
