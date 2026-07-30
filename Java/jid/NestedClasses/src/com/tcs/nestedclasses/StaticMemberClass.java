package com.tcs.nestedclasses;

import java.util.Arrays;
import java.util.Comparator;


public class StaticMemberClass { 
	private Bookmark[] items; // Bookmark will be stored in this array called items.
	private int next = 0;
	
	

	public StaticMemberClass(int size) {
		items = new Bookmark[size];
	}

	public void add(Bookmark item) {
		if (next < items.length)
			items[next++] = item;
	}
	
	
	public CacheIterator iterator() {
		return new MyIterator();
	}
	
	private class MyIterator implements CacheIterator {
		
		private int i = 0;

		@Override
		public boolean hasNext() {
			return i < items.length;
		}

		@Override
		public Bookmark next() {
			// TODO Auto-generated method stub
			return items[i++];
		}
	}

	public static void main(String[] args) {
		StaticMemberClass recommendedItems = new StaticMemberClass(5);

		Bookmark item1 = new Bookmark();
		item1.setId(2000);
		item1.setTitle("Atadu");
		item1.setRating(6.0);

		Bookmark item2 = new Bookmark();
		item2.setId(2001);
		item2.setTitle("Dookudu");
		item2.setRating(5.0); 

		Bookmark item3 = new Bookmark();
		item3.setId(2002);
		item3.setTitle("Aagadu");
		item3.setRating(3.0);

		Bookmark item4 = new Bookmark();
		item4.setId(2003);
		item4.setTitle("Sainikudu");
		item4.setRating(4.0);
		
		Bookmark item5 = new Bookmark();
		item5.setId(2004);
		item5.setTitle("Brahmotsavam");
		item5.setRating(2.0);

		recommendedItems.add(item1);
		recommendedItems.add(item2);
		recommendedItems.add(item3);
		recommendedItems.add(item4);
		recommendedItems.add(item5);

		CacheIterator iterator = recommendedItems.iterator();
//		CacheIterator iterator1 = recommendedItems.new MyIterator();
		// we can also do this 

		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		
		Arrays.sort(recommendedItems.items,Bookmark.RATING_COMPARATOR);
		
		System.out.println("\nSorted Titles Based on Ratings using Static Nested Classes: ");
		iterator=recommendedItems.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		
		Arrays.sort(recommendedItems.items,new Bookmark.ComparatorList.RatingComparator());
		// as you can see we are not creating an instance of the Enclosed Object.it is possible with
		// sttaic member Class. we dont need an instance of Outer Class.
		
		System.out.println("\nSorted Titles Based on Ratings using Static Nested Helper Classes: ");
		iterator=recommendedItems.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		
		Arrays.sort(recommendedItems.items, new Bookmark.ComparatorList.StringLengthComparator());
		System.out.println("\nSorted by String length (Static Member Class also using Helper Classes) ...");
		iterator = recommendedItems.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
	}		
}		
