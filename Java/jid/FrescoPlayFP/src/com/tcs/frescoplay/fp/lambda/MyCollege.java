package com.tcs.frescoplay.fp.lambda;

import java.util.Arrays;

interface CacheIterator {
	boolean hasNext();
	College next();
}

class College {

	int id;
	String name;
	int age;
	long pincode;
	
	
	public College(int id, String name, int age, long pincode) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.pincode = pincode;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public long getPincode() {
		return pincode;
	}

}



 
public class MyCollege {
	private College[] items;
	private int next=0;
	
	public MyCollege(int size) {
		items = new College[size];
	}
	
	public void add(College item) {
		if ( next < items.length) {
			items[next++] = item;
		}
	}
	
	public CacheIterator iterator() {
		return new MyCollegeIterator();
	}
	
	public class MyCollegeIterator implements CacheIterator {
		int i =0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < items.length;
		}

		@Override
		public College next() {
			// TODO Auto-generated method stub
			return items[i++];
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCollege mc = new MyCollege(4);
		
		College c1 = new College(1,"Ameer",24,521165);
		College c2 = new College(2,"Divya",23,521000);
		College c3 = new College(2,"Gowtham",23,521164);
		College c4 = new College(2,"Jazz",20,521999);
		
		mc.add(c1);
		mc.add(c2);
		mc.add(c3);
		mc.add(c4);
		
		CacheIterator iterator = mc.iterator();
		
		Arrays.sort(mc.items, ((o1,o2) -> Long.valueOf(o1.getPincode()).compareTo(o2.getPincode())));
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getPincode());
		}
		
	}
	
	public void result() {
		
		
	}

}
