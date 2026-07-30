package tcs.com.datastructures;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
	private static void treeMapDemo() {
		System.out.println("\nInside treeMapDemo..");
		TreeMap<String, Integer> map1 = new TreeMap<>();
		map1.put("John", 25);
		map1.put("Raj", 27);
		map1.put("Anita", 29);
		
		System.out.println("map1: " + map1);
		
		System.out.println("\nIterating Using entrySet..");
		Set<Map.Entry<String,Integer>> mappings = map1.entrySet();
		for(Map.Entry<String, Integer> mapping:mappings) {
			System.out.println("Name: " + mapping.getKey() + ", Age: " + mapping.getValue());
			if ( mapping.getKey().equals("John")) {
				mapping.setValue(26);
			}
		}
		System.out.println("\nAfter setValue: " + map1);
	//	map1.floorEntry("Raj").setValue(22); // throws java.lang.UnsupportedOperationException
		// Note:- we cannot invoke setValue() method on floorEntry or ceilingEntry methods coz of
		// they produce some instance but we can invoke while iterating over entrySet() method only.
	}
	
	public static void main(String[] args) {
		treeMapDemo();
	}
}
