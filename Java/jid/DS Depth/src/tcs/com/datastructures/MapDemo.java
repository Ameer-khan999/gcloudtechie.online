package tcs.com.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	
		public static void hashmapDemo() {
			System.out.println("Inside HashMap\n");
			Map<String, Integer> map1 = new HashMap<>();
			map1.put("John",26); // cannot call add/addAll coz Map does not supports this methods
			map1.put("Raj",28);
			map1.put("Anita",null);
			System.out.println("map1: " + map1);
			
			map1.put("Anita", 24);
			System.out.println("\nmap1 after adding Anita's Age: " + map1);
			
			// containsKey
			System.out.println("\nContains Name John ? : " + map1.containsKey("John"));
			
			// containsValue
			System.out.println("\nContains Age 27 ? : " + map1.containsValue(27));
			
			// get age
			System.out.println("\nJohns Age ? : " + map1.get("John"));
			
			// Type1:- Iterating Using keySet returns Set..
			System.out.println("\nIterating Using keySet..");
			Set<String> names = map1.keySet();
			for(String name : names) {
				System.out.println("Name: " + name + ", Age: " + map1.get(name)); 
				// get() method does search and it is little bit expensive when large keys mapped to one value
				// probably to one bucket.
				// Type 2 is recommended for iterating
			}
			
			// Type2:- Iterating Using entrySet returns set of all mappings with Nested
			//         Interface Entry(K,V)..
			System.out.println("\nIterating Using entrySet..");
			Set<Map.Entry<String, Integer>> mappings = map1.entrySet();
			for(Map.Entry<String, Integer> mapping : mappings) {
				System.out.println("Name: " + mapping.getKey() + ", Age: " + mapping.getValue());
			} // getKey() and getValue() are the methods of Nested Entry Interface, 
			  // Type2 is recommended over Type1 for fastness.
			
			names.remove("Anita");
			System.out.println("\nAfter removing Anita: " + map1);
			
			// clear method
			names.clear();
			System.out.println("\nAfter Clearing All Data: " + map1);
			
			// more complex way of creating maps.
			
			Map<String, Map<String, Object>> userProfile = new HashMap<>();
			// User 1
			Map<String, Object> profile = new LinkedHashMap<>();
			profile.put("Age", 25);
			profile.put("Dept", "CS");
			profile.put("City", "Vijayawada");
			
			userProfile.put("John", profile);
			
			// User 2
			profile = new HashMap<>();
			profile.put("Age", 29);
			profile.put("Dept", "CS");
			profile.put("City", "Vuyyuru");
			
			userProfile.put("Raj", profile);
			
			System.out.println("\nuserProfile: " + userProfile);
			
			Map<String, Object> profile1= userProfile.get("John");
			int age = (Integer) profile1.get("Age");
			System.out.println("Age: " + age);
			
			// Type2:- Iterating Using entrySet returns set of all mappings with Nested
						//         Interface Entry(K,V)..
			System.out.println("\nIterating Using entrySet..");
			Set<Map.Entry<String, Map<String, Object>>> complex =userProfile.entrySet();
			for(Map.Entry<String, Map<String, Object>> complex1 : complex) {
				
				Set<Map.Entry<String, Object>> complexx = profile.entrySet();
				for (Map.Entry<String, Object> complexx1 : complexx) {
					System.out.println("Name: " + complex1.getKey()  + ", " + complexx1.getKey() + ": " + complexx1.getValue());
				}
				 
				// System.out.println("Name: " + complexs.getKey() + ", Age: " + complexs.getValue());
				
			}
			
			
			Map<String, Object> profile2= userProfile.get("Raj");
			int age1 = (Integer) profile2.get("Age");
			System.out.println("Age: " + age1);
			
			// Exrecise: try using second constructor, putAll, clear, values and other methods.
		}
		
	
		
		
	public static void main(String[] args) {
		 hashmapDemo();
		
		ImmutableObject imu = new ImmutableObject();
		// imu.immutableKeyDemo();
	}
}

// immutable objects
class ImmutableObject {
	public static void immutableKeyDemo() {
		System.out.println("\nInside immutableKeyDemo..");
		List<Integer> list = new ArrayList<>(); // Arraylist use hashCode so we will get null if we add 
		                                        // mul mutable elements  
												// press F3 for details on Classes
		list.add(1);
		
		Map<List<Integer>, Integer> map= new HashMap<>();
		map.put(list, 1); // hashCode applies on key
		
		list.add(2);
		
		System.out.println(map.get(list));
		// we are getting null coz ArrayList overriding hashCode(generating diff hashCodes) for 2nd time.
		
		// Not overrides hashCode 
		Student s = new Student(1,null);
		Map<Student,Integer> map2=new HashMap<>();
		map2.put(s, 1);
		map2.put(s,2);
		// this will use the objects identity which is typically memory address.
		// this constructors never override hashCode (generates same hashCodes) and equals methods
		s.setName("John");
		System.out.println(map2.get(s));
		
		// very careful while working on mutable objects.
	}
	
	
}

class Student {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public Student(int id,String name) {
		super();
		this.id=id;
		this.name=name;
	}
}
