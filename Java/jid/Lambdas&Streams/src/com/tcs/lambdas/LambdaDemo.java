package com.tcs.lambdas;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
import java.util.function.Function;

/*interface Hi {
	void salutation();
}*/
interface CacheIterator {
	boolean hasNext();
	Bookmark next();
}



interface Test {
	abstract void apply();
}

public class LambdaDemo {
	private Bookmark[] items;
	private int next=0;
	//Hi greetings=(() -> {return "How are You"; };
	public LambdaDemo(int size) {
		items= new Bookmark[size];
	}
	
	public void add(Bookmark item) {
		if(next < items.length) // { 
			items[next++] = item;
	//	}
	}
	
	public CacheIterator iterator() {
		return new MyCacheIterator();
	}
	
	public void go(Test test) {
		test.apply();
	}
	
	private class MyCacheIterator implements CacheIterator {
	  private int i =0;
	  
	  @Override
	  public boolean hasNext() {
		  return i < items.length;
	  }
	  
	  @Override
	  public Bookmark next() {
		  return items[i++];
	  }
	}
	
	public static void main(String[] args) {
		LambdaDemo recommendedItems = new LambdaDemo(5);
		
		Bookmark item1=new Bookmark();
		item1.setId(2000);
		item1.setTitle("Aagadu");
		item1.setRating(1.0);
		
		Bookmark item2 = new Bookmark();
		item2.setId(2001);
		item2.setTitle("Sainikidu");
		item2.setRating(2.0);
		
		Bookmark item3 = new Bookmark();
		item3.setId(2002);
		item3.setTitle("Atadu");
		item3.setRating(4.0);
		
		Bookmark item4 = new Bookmark();
		item4.setId(2003);
		item4.setTitle("Dookudu");
		item4.setRating(3.0);
		
		Bookmark item5 = new Bookmark();
		item5.setId(2004);
		item5.setTitle("Okkadu");
		item5.setRating(5.0);
		
		recommendedItems.add(item1);
		recommendedItems.add(item2);
		recommendedItems.add(item3);
		recommendedItems.add(item4);
		recommendedItems.add(item5);
		
		CacheIterator iterator = recommendedItems.iterator();
		
		System.out.println("Printed normally..");
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		
		Arrays.sort(recommendedItems.items, new Comparator<Bookmark>() {

			@Override
			public int compare(Bookmark o1, Bookmark o2) {
				// TODO Auto-generated method stub
				return o1.getRating() < o2.getRating() ? 1: -40;
			}
		});
	
	System.out.println("\nSorted by rating (using anonymous class) ...");
	iterator = recommendedItems.iterator();
	
	while (iterator.hasNext()) {
		System.out.println(iterator.next().getTitle());
	}
	
	// Lambdas
	
	Arrays.sort(recommendedItems.items, (o1, o2) ->   new Integer(o1.getTitle().length()).compareTo(new Integer(o2.getTitle().length())));
	System.out.println("\nSorted by length of title in asec (using Lambda) ...");
	iterator = recommendedItems.iterator();
	
	while (iterator.hasNext()) {
		System.out.println(iterator.next().getRating());
	}
	
	final Comparator<Bookmark> SORT_LENGTH =( (o1, o2) -> {return  (new Integer(o1.getTitle().length()).compareTo(new Integer(o2.getTitle().length())));});
	Arrays.sort(recommendedItems.items,SORT_LENGTH );       // above lamda expression returns int value so we need box it 
	System.out.println("\nSorted by length of title in asec (using singleton via passing Lambda) ...");
	iterator = recommendedItems.iterator();
	
	while (iterator.hasNext()) {
		System.out.println(iterator.next().getTitle());
	}
	
	new LambdaDemo(5).go(() ->  System.out.println("Lamda Via Methods"));
	
	// Fresco
	 
	System.out.println("\nFrescoplay");
	Arrays.sort(recommendedItems.items, (o1,o2) -> o1.getTitle().compareTo(o2.getTitle()));
	  iterator = recommendedItems.iterator();
	  //Rating() < o2.getRating() ? 1: -40
	  
	  while (iterator.hasNext()) { 
		  System.out.println(iterator.next().getTitle());
	  }
  }
	
	
	
}		
	 

