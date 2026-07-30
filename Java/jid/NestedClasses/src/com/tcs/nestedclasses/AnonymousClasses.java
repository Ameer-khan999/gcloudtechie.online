package com.tcs.nestedclasses;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Anonymous classes are good for defining Function Objects while non static member classes
 * for Adapters.
 * 
 * with anonymous classes we no need to cretae nested classes as we can pass instantiate
 * Interfaces as parameters and we can implement methods into it.
 * 
 * @author ameer
 *
 */


public class AnonymousClasses { // AnonymousClasses is going to hold the Bookmark Objects
	// Bookmark item1 = new Bookmark(); Here item1 is a Bookmark Object
	private Bookmark[] items; // Bookmark will be stored in this array called items.
	private int next = 0;
	
	private static final Comparator<Bookmark> RATING_COMPARATOR = new Comparator<Bookmark>() {
		// Here RATING_COMPARATOR is Descriptive C means we no need to write this logic 
		// every time.
		
		{ // cannot have Named Constructors and Classes, we can do just initializer like below
			System.out.println("Instance Initializer..\n");
		}
		@Override
		public int compare(Bookmark o1, Bookmark o2) {
			// TODO Auto-generated method stub
			return o1.getRating() < o2.getRating() ? 1: -1;
		}
		
	};

	public AnonymousClasses(int size) {
		items = new Bookmark[size];
	}

	public void add(Bookmark item) {
		if (next < items.length)
			items[next++] = item;
	}
	
	// below returns new MyCacheIterator ( for previous demo understanding only) 
	public CacheIterator iterator() {
		
		/* final */ int count=0; // we wrote here for just information thats it.
//		count++; // if we declared final we cannot do this, if not we cannot do that try 
		// by removing comments and reason is for simplicity
		
		// Instance variable "items" will be accessed via hidden reference
		//  But, local variable "count" will be copied as inner class's instance variable
	CacheIterator iterator=new CacheIterator() { // Anonymous class creates top level class
		// pass ref to AnonymousClass object ref to for newly created Anonymous Class.
		// it passes this ref means a hidden ref to access instance variable items from 
		// enclosing class AnonymousClasses
		private int i = 0;

		@Override
		public boolean hasNext() {
			System.out.println(count); // if we want to access this local variable count
			// it must be final in prior to java 8 after 8 no need to be final but it 
			// shold not be changed anywhere within the scope of the method and it is called
			// effectively final it means final
			return i < items.length;
		}

		@Override
		public Bookmark next() {
			// TODO Auto-generated method stub
			return items[i++];
		}

	};
		return iterator;
	}
// 	count++; we cannot increment in anywhere
	public static void main(String[] args) {
		AnonymousClasses recommendedItems = new AnonymousClasses(4);

		Bookmark item1 = new Bookmark();
		item1.setId(2000);
		item1.setTitle("Atadu");
		item1.setRating(5.0);

		Bookmark item2 = new Bookmark();
		item2.setId(2001);
		item2.setTitle("Dookudu");
		item2.setRating(4.0); 

		Bookmark item3 = new Bookmark();
		item3.setId(2002);
		item3.setTitle("Aagadu");
		item3.setRating(2.0);

		Bookmark item4 = new Bookmark();
		item4.setId(2003);
		item4.setTitle("Sainikudu");
		item4.setRating(3.0);

		recommendedItems.add(item1);
		recommendedItems.add(item2);
		recommendedItems.add(item3);
		recommendedItems.add(item4);

		CacheIterator iterator = recommendedItems.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
//		/* private */ int count=0; // we cannot declare modifiers
/*		Arrays.sort(recommendedItems.items, new Comparator<Bookmark>() {

			@Override
			public int compare(Bookmark o1, Bookmark o2) {
				// TODO Auto-generated method stub
				// small clarity on scope of variables in nested classes topic.
				int count=0; // we can shadow local variable in nested class
		//		return o1.getRating() < o2.getRating() ? -1 : 1; Increment Order 1 --> 4
				return o1.getRating() < o2.getRating() ? 1 : -1; // Decrement 4 --> 1
			}
			
		}); This logic wrote in RATING_COMPARATOR than simply we can pass this name for 
		every time we need by assigning this type descriptive named variable. 
*/		
		
		Arrays.sort(recommendedItems.items,RATING_COMPARATOR);
		
		System.out.println("\nSorted Titles Based on Ratings using anonymous classes: ");
		iterator=recommendedItems.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		
		// Another Example to show that we can aslo inherit an anonymous class can be
		// used to implement a class
		new FooBar(5) { // foobar instance or Object of FooBar
			void go() {
				System.out.println("y in FooBar: " + y);
			}
		}.go(); // invoked go() on FooBar, little bit Strange ! :)
	}
}

class FooBar {
	protected int y=0;
	
	public FooBar(int x) {
		y=x;
	}
}

