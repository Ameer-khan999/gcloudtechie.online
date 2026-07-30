package tcs.com.datastructures;

import java.lang.reflect.Array;

/*import java.util.ArrayList;
import java.util.Collection;*/
import java.util.*;

public class ArrayListDemo {
	private static void  arrayListDemoWithCollections() throws ArrayIndexOutOfBoundsException {
		/*Collection*/List<Integer> list1=new ArrayList<>(); // change to Collection for benefit
		// ArrayList is a class implemented by List Interface.
		list1.add(1);
		list1.add(121);
		list1.add(2);
		list1.add(3);
		list1.add(3);
		list1.add(null);
		System.out.println("list1:"  + list1);
		
		// removing elements
		try {
			list1.remove(121); 
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("Uff");
		}
		
		
		list1.remove(3);
		list1.remove(3);//  since we have Collection as ref type compiler checks the exact methods in Collection first later
		//  it founds exact method as boolean java.util.Collection.remove(Object o) thats why jvm deleting elements with objects 
		// not with index number,this is also called method binding.
		// if we want to delete with index num change ref type from Collection to List(Integer java.util.List.remove(int index))
		// and we will get IndexOutOfBoundException due to ArrayList has only 5 size not 121.
		System.out.println("list1:"  + list1);
		
		// lets add some positinal add elements
//		list1.add(0,10);
		
	}
	
	private static void  arrayListDemoWithList() throws ArrayIndexOutOfBoundsException {
		List<Integer> list1=new ArrayList<>();
		// ArrayList is a class implemented by List Interface.
		list1.add(1);
		list1.add(121);
		list1.add(2);
		list1.add(3);
		list1.add(3);
		list1.add(null);
		System.out.println("list1:"  + list1);
		
		// removing elements
		
//			list1.remove(121); // and we will get IndexOutOfBoundException due to ArrayList has only 5 size not 121.
			list1.remove(3);
			list1.remove(4);
			System.out.println("list1:"  + list1);
		
			
		
		//  since we have Collection as ref type compiler checks the exact methods in Collection first later
		//  it founds exact method as boolean java.util.Collection.remove(Object o) thats why jvm deleting elements with objects 
		// not with index number,this is also called method binding.
		// if we want to delete with index num change ref type from Collection to List(Integer java.util.List.remove(int index))
		// and we will get IndexOutOfBoundException due to ArrayList has only 5 size not 121.
		
			// lets add some positinal add elements
			list1.add(0,10);
			
			System.out.println("\nlets add some positinal add and remove elements");
			System.out.println("list1:"  + list1);
			
			list1.set(0, 9);
			System.out.println("list1:"  + list1);
			
			
			// Bulk operations
			System.out.println("\nnow we will perform some Bulk Operations");
			Collection<Integer> list2=new ArrayList<>();
			list2.add(9);
			list2.add(3);
			
			list1.removeAll(list2);
			System.out.println("list1 after removeAll list2: " + list1);
			
			list2.add(1);
			
			list1.retainAll(list2);
			System.out.println("list1 after retainAll : " + list1);
			
			list1.addAll(list2);
			System.out.println("list1 after addAll : " + list1);
			
			System.out.println("list1 after list1.set(2,2): " + list1.set(2,2));
			
			// search operations
			System.out.println("\nNow Search Operations");
			System.out.println("list1.contains(1): " + list1.contains(1));
			System.out.println("list1.indexOf(1): " + list1.indexOf(1));
			System.out.println("list1.lastIndexOf(1):" + list1.lastIndexOf(1));
			System.out.println("list1: " + list1);
			
			
			// Range-view: subList (new list is backed by original)
			System.out.println("\nnew list is backed by original");
			List<Integer> list3 = list1.subList(2, 3); // element 3 is optional.
			list3.set(0, 6);
			System.out.println("list1: " + list1);
			list3.add(0, 7);
			System.out.println("list1: " + list1);
			
			// checking whether list3 will updates or not if we make changes in list1
			System.out.println("\n checking whether list3 will updates or not if we make changes in list1");
			list1.set(2, 8);
			System.out.println("list1: " + list1);
			System.out.println("list3: " + list3);
			
//			list1.add(0,8); // in list3 at 0 index 8 element is already existed , so we cannot add from list1 means
			// we cannot change structural changes from original list but we can from sublist.so thats why we are getting 
			// java.util.ConcurrentModificationException.
			// Note:- we can do set but we cannot do add.
			
//			System.out.println("list3: " + list3);
			System.out.println("list1: " + list1);
			
			// iterating elements
			for (int element:list1) {
				System.out.println("elements are: " + element);
			
			 
			// Generates ConcurrentModificationException
						if (element == 9) { // we cannot remove element with foreach loop during iteration for that we have 
							//  to use iterator method and the next concept is iterator method.
							list1.remove(Integer.valueOf(element)); // valueOf is used due to its caching
							// we cannot add or remove on underlined ArrayList it throws  ConcurrentModificationException
							// but set can be done and it also called as fail-fast-iterator coz of fastly failing.
							// All ArrayList and LinkedList faces this, so we can only Use Iterator to achieve this.
						}
			}
			
	}
	
	
	public static void main(String[] args) {
		arrayListDemoWithCollections();
		System.out.println(" ");
		arrayListDemoWithList();
	}
		
}
