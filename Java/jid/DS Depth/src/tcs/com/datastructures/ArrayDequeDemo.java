package tcs.com.datastructures;



import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;



public class ArrayDequeDemo {
	private static void dequeTest() {
		System.out.println("\nInside deque Test..");
		
		// Queue - FIFO
		/* Queue */  Deque  deque = new  ArrayDeque<>();  /* LinkedList<>(); */
		deque.add("walden");
		deque.add("Harry potter");
		deque.add("head first java");
		System.out.println("\ndeque while adding using Queue(Fifo): " + deque);
		
		System.out.println("\nPrinting Queue while removing elements in FIFO Order....");
		System.out.println("\t-> " + deque.remove());  // removeFirst
		System.out.println("\t-> " + deque.remove());
		System.out.println("\t-> " + deque.remove());
		// System.out.println(deque.remove()); // throws java.util.NoSuchElementException coz deque is empty.
		
		// stack - LIFO
		
		deque.push("walden");
		deque.push("Harry potter");
		deque.push("head first java");
		System.out.println("\ndeque while pushing using Stack(Lifo): " + deque);

		System.out.println("\nPrinting Stack while removing elements in LIFO Order....");
		System.out.println("\t-> " + deque.pop()); // removeLast
		System.out.println("\t-> " + deque.pop());
		System.out.println("\t-> " + deque.pop());
		 
		
	}
	
	public static void main(String[] args) {
		dequeTest();
		System.out.println("\nNote:- we can also use LinkedList instead of ArrayDeque but\nArrayDeque is recommedned for queue implementation.. ");
	}
}

// Note 1:- ArrayDeque,LinkedList implements both Queue & Deque interface and can perform Queue(FIFO) operations
// means we can give both Queue & Deque as ref_type to ArrayDeque and LinkeList.


// Note 2:- But We cannot perform Stack(LIFO) operations if we declare Queue as Ref_type.

// Note 3:- Best recommendeation is Deque interface as Ref_type instead of Queue and ArrayDeque as Obj_type instead of LinkedList,and it also gives best performance.