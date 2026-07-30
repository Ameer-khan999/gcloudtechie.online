package com.tcs.concurrencypart1;

import java.util.concurrent.TimeUnit;

public class MyFirstThread {
	// Note:- This approach is recommended coz this is loosely coupled.

	public static void main(String[] args)  {
		Task task = new Task();
		Thread thread=new Thread(task); // NEW
		thread.start();
	//	thread.start(); // throws java.lang.IllegalThreadStateException because
// once the run() method successfully completed it goes to Dead or Terminate state
// so we cannot start that thread again and the thread object still presents in heap
// memory but it is useless, GC will take care of this object.

		
		  try { 
		//	Thread.sleep(3000); // sleep is a static method 
			TimeUnit.SECONDS.sleep(1); // TimeUnit is enum class and this is readable 
											// way than above Thread.sleep
		  } catch (InterruptedException e) { // Checked
			 System.out.println("\nInterrupted other thread");
		  }  catch (IllegalArgumentException e) { // Unchecked
			 System.out.println("\nU Passed negative Argument"); 
		  }
		  
		  System.out.println("\nInside main");
	}
}

// creating another class
class Task implements Runnable {
	public void run() { // Runnable interface contains only 1 unimplemented method 
						// run()
		System.out.println("\nInside run");
		go(); // run() invokes go()
	}
	
	private static void go() {
		System.out.println("\nInside go");
		more(); // go() intern invokes more()
	}
	
	private static void more() {
		System.out.println("\nInside more");
		
		System.out.println("\nNote:- keep running program you can see switching "
				+ "between threads and the \nthread scheduler is not behaving "
				+ "consistently and relying on this thread \nis "
				+ "not good for our program but preferred over 2nd approach MySecondThread."
				);
	}
}	
	
	
