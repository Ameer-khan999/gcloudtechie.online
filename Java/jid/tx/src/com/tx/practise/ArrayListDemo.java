package com.tx.practise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListDemo {
	private static void  arrayListDemoWithCollections() throws IndexOutOfBoundsException {
		try {
			Collection<Integer> list1=new ArrayList<>();
			list1.add(1);
			list1.add(121);
			list1.add(2);
			list1.add(3);
			list1.add(3);
			list1.add(null);
			System.out.println("list1:"  + list1);
			list1.remove(121);
			System.out.println("Removed");
			System.out.println("list1: "  + list1);
			} catch (IndexOutOfBoundsException a) {
				System.out.println("Index Out of Range");
			} finally {
				System.out.println("Executed");
			}
	}
	
	public static void main(String[] args) {
		arrayListDemoWithCollections();
	}
}
