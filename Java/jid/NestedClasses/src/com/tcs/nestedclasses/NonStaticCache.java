package com.tcs.nestedclasses;

/**
 * Non static meber classes are instance of Outer class and that is mainly used to implements
 * the Adapters.
 * 
 * Adapters are used to produce diff views of Outer class objects.
 * @author ameer
 *
 */

interface CacheIterator {
	boolean hasNext();

	Bookmark next();
}

public class NonStaticCache { // cache is going to hold the Bookmark Objects
	// Bookmark item1 = new Bookmark(); Here item1 is a Bookmark Object
	private Bookmark[] items; // Bookmark will be stored in this array called items.
	private int next = 0;

	public NonStaticCache (int size) {
		items = new Bookmark[size];
	}

	public void add(Bookmark item) {
		if (next < items.length)
			items[next++] = item;
	}

	public CacheIterator iterator() {
		return new MyCacheIterator();
	}

	private class MyCacheIterator implements CacheIterator {
		// Non static member class
		private int i = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < items.length;
		}
		@Override
		public Bookmark next() {
			// TODO Auto-generated method stub
			return items[i++];
		}

	}

	public static void main(String[] args) {
		NonStaticCache  recommendedItems = new NonStaticCache (4);

		Bookmark item1 = new Bookmark();
		item1.setId(2000);
		item1.setTitle("Atadu");
		item1.setRating(4.0);

		Bookmark item2 = new Bookmark();
		item2.setId(2001);
		item2.setTitle("Dookudu");
		item1.setRating(3.0); 

		Bookmark item3 = new Bookmark();
		item3.setId(2002);
		item3.setTitle("Aagadu");
		item1.setRating(1.0);

		Bookmark item4 = new Bookmark();
		item4.setId(2003);
		item4.setTitle("Sanikudu");
		item1.setRating(2.0);

		recommendedItems.add(item1);
		recommendedItems.add(item2);
		recommendedItems.add(item3);
		recommendedItems.add(item4);

		CacheIterator iterator = recommendedItems.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
	}
}
