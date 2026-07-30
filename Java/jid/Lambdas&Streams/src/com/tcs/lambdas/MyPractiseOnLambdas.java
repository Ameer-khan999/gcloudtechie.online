package com.tcs.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

interface CacheIterator1 {
	boolean hasNext();
	Information next();
}


public class MyPractiseOnLambdas extends Information {
	private Information[] items;
	
	private int next=0;
	
	public MyPractiseOnLambdas(int size) {
		items= new Information[size];
	}
	
	public void add(Information item) {
		if(next < items.length) 
			items[next++] = item;
	}
	
	public MyCacheIterator iterator() {
		return new MyCacheIterator();
	}
	
	private class MyCacheIterator implements CacheIterator1 {
		private int i=0;

		@Override
		public boolean hasNext() {
			return i<items.length;
		}

		@Override
		public Information next() {
			return items[i++];
		}
		
	}

	public static void main(String[] args) {
		MyPractiseOnLambdas mpl = new MyPractiseOnLambdas(4);
		
		
		Information i1 =new Information();
		i1.setName("Sameer Khan");
		i1.setAge(28);
		i1.setMobileNumber(9985491126L);
		
		Information i2 =new Information();
		i2.setName("Karimulla Khan");
		i2.setAge(50);
		i2.setMobileNumber(9703281317L);
		
		Information i3 =new Information();
		i3.setName("Shakira Begum");
		i3.setAge(47);
		i3.setMobileNumber(7396722133L);
		
		Information i4 =new Information();
		i4.setName("Ameer Khan");
		i4.setAge(24);
		i4.setMobileNumber(7396712666L);
		
		mpl.add(i1);
		mpl.add(i2);
		mpl.add(i3);
		mpl.add(i4);
// 		System.out.println(mpl.items); // this is mystery i have to find, only giving ref
		MyCacheIterator iterator= mpl.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
		
		final Comparator<Information> SORT_BYLENGTHOFNAME = ((o1,o2) -> {return  (new Integer(o1.getName().length()).compareTo(new Integer(o2.getName().length())));});
		final Comparator<Information> SORT_BYAGE= ((o1,o2) -> Integer.valueOf(o1.getAge()).compareTo(o2.getAge()));
		final Comparator<Information> SORT_BYMOBILENUMBER= ((o1,o2) -> Long.valueOf(o1.getMobileNumber()).compareTo(o2.getMobileNumber()));
		final Comparator<Information> SORT_BYNAME= ((o1,o2) -> (o1.getName()).compareTo(o2.getName()));
	
		
		Arrays.sort(mpl.items, SORT_BYMOBILENUMBER);
		System.out.println("\nSorted By Name..");
		iterator = mpl.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
		
	/*	Set<? super Information> storesSuperAndSubClass= new TreeSet<>(SORT_BYMOBILENUMBER);
		storesSuperAndSubClass.add(mpl);
		storesSuperAndSubClass.add(i4);
		System.out.println(storesSuperAndSubClass);
		
		Set<? extends Information> storesSuperAndSubClass1= new TreeSet<>(SORT_BYMOBILENUMBER);
		storesSuperAndSubClass1.add(mpl);
		storesSuperAndSubClass1.add(i4);
		System.out.println(storesSuperAndSubClass1);
		
		
		Set<? super MyPractiseOnLambdas> storesSubAndOwnClass= new TreeSet<>(SORT_BYMOBILENUMBER);
		storesSubAndOwnClass.add(mpl);
		storesSubAndOwnClass.add(i4);
		System.out.println(storesSubAndOwnClass); */
		
		Set<String> storesSubAndOwnClass2= new TreeSet<>();
		storesSubAndOwnClass2.add("A");
		storesSubAndOwnClass2.add("K");
		storesSubAndOwnClass2.add("H");
		storesSubAndOwnClass2.add("Z");
		storesSubAndOwnClass2.add("B");
		System.out.println("\nTreeset: " + storesSubAndOwnClass2);
		for(String s: storesSubAndOwnClass2) {
			System.out.println(storesSubAndOwnClass2);
		}
		// Just for Idea
		
		Set<String> storesSubAndOwnClass3= new LinkedHashSet<>();
		storesSubAndOwnClass3.add("A");
		storesSubAndOwnClass3.add("K");
		storesSubAndOwnClass3.add("H");
		storesSubAndOwnClass3.add("Z");
		storesSubAndOwnClass3.add("B");
		System.out.println("LinkedHashSet: " + storesSubAndOwnClass3);
	//	System.out.println(storesSubAndOwnClass3.iterator().next().strip());
		for (Iterator iterator2 = storesSubAndOwnClass3.iterator(); iterator2.hasNext();) {
			String string = (String) iterator2.next();
			System.out.println(string);
		}
	}

}



class Information {
	private String name;
	private int age;
	private long mobileNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
