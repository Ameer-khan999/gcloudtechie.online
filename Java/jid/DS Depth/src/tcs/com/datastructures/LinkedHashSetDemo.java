package tcs.com.datastructures;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class LinkedHashSetDemo {
	public static void linkedHashSetDemo() {
		
		// HashSet
		Set<String> hashSet = new HashSet<>();
		hashSet.add("Raj");
		hashSet.add("John");
		hashSet.add("Anita");
		System.out.println("hashSet: " + hashSet + " // order is not preserved with HashSet");
		
		// LinkedHashSet
		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Raj");
		linkedHashSet.add("John");
		linkedHashSet.add("Anita");
		System.out.println("\nlinkedHashSet: " + linkedHashSet + " // order is preserved with LinkedHashSet");
		
		System.out.println("\nNote:- LinkedHashSet is slightly slower than HashSet..");
		
		// TreeSet to sort
		Set<String> treeSet = new TreeSet<>();
		treeSet.add("Raj");
		treeSet.add("John");
		treeSet.add("Anita");
		System.out.println("\ntreeSet: " + treeSet + " // elements are sorted in alphabetical Order");
		
		// random data with TreeSet
		Set<String> treeSet1 = new TreeSet<>();
		treeSet1.add("Raj");
		treeSet1.add("111");
		treeSet1.add("Ameer");
		System.out.println("\ntreeSet1: " + treeSet1 + " // elements are sorted..!");
		
	}
	
	public static void main(String[] args) {
		linkedHashSetDemo();
	}
}
