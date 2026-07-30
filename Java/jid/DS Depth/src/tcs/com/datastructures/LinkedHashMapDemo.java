package tcs.com.datastructures;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Demo: 
 * 	1. See output with and without commenting get() calls
 *    2. See output when accessOrder=false with get() calls. get calls do not have any influence
 *    3. Finally, change object type from LRUCache to LinkedHashMap and see output. 
 *       All 5 mappings will be printed as removeEldestEntry would return false by default
 */

public class LinkedHashMapDemo {
	private static void lruCacheTest() {
		System.out.println("\nInside lruCacheTest...");
		Map<String, String> lruCache = new /*LinkedHashMap*/LRUCache<>(16,0.75f,true); // try with true and false
		                                                   // LRUCache for fixed size.
		lruCache.put("a", "A");
		lruCache.put("b", "B");
		lruCache.put("c", "C");
		System.out.println("lruCache: " + lruCache);
		
		lruCache.get("a"); // multiple gets to "a" will not make a difference.
 		lruCache.get("a");
		lruCache.get("a");
		System.out.println("lruCache for get a: " + lruCache);
		
		lruCache.get("b");
		System.out.println("lruCache for get b: " + lruCache);
		
		lruCache.put("d", "D");
		System.out.println("lruCache adding D: " + lruCache);
		
		lruCache.put("e", "E");
		System.out.println("lruCache adding E: " + lruCache);
		
		lruCache.get("a");
		System.out.println("lruCache for get a: " + lruCache); // getting recent element in last if we pass true
	
		lruCache.put("f", "F");
		System.out.println("lruCache adding F: " + lruCache);
	}
	
	public static void main(String[] args) {
		lruCacheTest();
	}
}
	
	// LRUCache for fixed size.
class LRUCache<K,V> extends LinkedHashMap<K,V> {
	private static final int MAX_ENTRIES = 3;
	
	public LRUCache(int initialCapacity, float loadFactor, boolean accessOrder) {
		super(initialCapacity,loadFactor,accessOrder);
	}
	
	// Invoked by put and putAll after inserting a new entry into the map.
	public boolean removeEldestEntry(Map.Entry eldest) {
		return size() > MAX_ENTRIES;
		// return false; // same as normal linked hash map.
	}
}


