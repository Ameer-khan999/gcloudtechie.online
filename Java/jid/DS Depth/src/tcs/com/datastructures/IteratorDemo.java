package tcs.com.datastructures;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;


public class IteratorDemo {
	
	private static  List<Integer> arrayListDemoWithList() {
		List<Integer> list1=new ArrayList<>();
		// ArrayList is a class implemented by List Interface.
		list1.add(1);
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(9);
		list1.add(10);
		System.out.println("list1:A"  + list1);
		
		// removing elements
		/*
		 * list1.remove(1); list1.remove(3); list1.remove(3);
		 */
		return list1;
	}
	
	private static void iteratorDemo(List<Integer> list1) {
		System.out.println("\nInside IteratorDemo..");
		
		Iterator<Integer> iterator = list1.iterator();  // Iterator interface and iterator method is used to delete element during iteration.
		while (iterator.hasNext()) {
			int element=iterator.next();
			System.out.println("Elements are: " + element);
			
			if(element==9) {
				iterator.remove();  // without invoking next() dont invoke remove() coz it gives compilation error 
				iterator.forEachRemaining(Filter::add);
			}
		}
		System.out.println("list1: " + list1);
		list1.forEach(System.out::println);
		list1.forEach(Filter::filter);
		list1.forEach(new Filter());	// requires implementing Consumer coz accept() method belongs to Consumer	
	}
	
	public static void main(String[] args) {
		List<Integer> list2=arrayListDemoWithList();
		iteratorDemo(list2);
	}
	
}	
	// Filter class filter method for forEach statement.

	class Filter  implements Consumer  {
		static void filter(Integer i) {
			if(i==1) {
				System.out.println(i);
			}
		}

		public void accept(Object i) {
			if ((int) i==1) {
				System.out.println(i);
			}
			
		}
		
		static void add(Integer i) {
			System.out.println(i+5);
		}
	}