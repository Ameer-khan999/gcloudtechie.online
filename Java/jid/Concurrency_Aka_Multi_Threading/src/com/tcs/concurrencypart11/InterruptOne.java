package com.tcs.concurrencypart11;

import java.util.concurrent.TimeUnit;

public class InterruptOne {
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
			thread.interrupt();
		  } catch (InterruptedException e) { // Checked
			 System.out.println("\nInterrupted other thread");
		  }  catch (IllegalArgumentException e) { // Unchecked
			 System.out.println("\nU Passed negative Argument"); 
		  }
		  
		  System.out.println("Inside main");
	}
}

// creating another class
class Task implements Runnable {
	public void run() { // Runnable interface contains only 1 unimplemented method 
						// run()
		System.out.println("Inside run");
		try {
			TimeUnit.SECONDS.sleep(9);
		} catch (InterruptedException e) {
			System.out.println("After about 3 seconds the main Thread is invoking this"
					+ " interrupt() method and the second Thread\nis being Interrupted !..\\n");
		}
		go(); // run() invokes go()
	}
	
	private static void go() {
		System.out.println("Inside go");
		more(); // go() intern invokes more()
	}
	
	private static void more() {
		System.out.println("Inside more");
		
		System.out.println("\nNote:- keep running program you can see switching "
				+ "between threads and the \nthread scheduler is not behaving "
				+ "consistently and relying on this thread \nis "
				+ "not good for our program but preferred over 2nd approach MySecondThread."
				);
	}
}
