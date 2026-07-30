package com.tcs.concurrencypart1;

import java.util.concurrent.TimeUnit;

/* Volatile variables:- it means something happend in thread A is clearly visible to 
   thread B and others Threads too it gives only guarantee of memeory visisbility.
   we saw this thing in synchronized methods.the exact meaning of volatile is something
   that changed very rapidly and unpredictable. both establishes a happen before
   ordering logic.thsi are particularly for shared  and mutable data.
   
   Volatile is recommended over synchronization and it also much readable without
   two additional methods.
*/

public class VolatileVariableDemo {
	private static volatile boolean stop;

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			public void run() {
				while(!stop) { System.out.println("In while.."); }
			}
		}).start();
		
		TimeUnit.SECONDS.sleep(5);
		stop=true;
		System.out.println("Thread stopped after 5 sec by passing true to stop variable.");
	}
}

/* This is one way to stop a thread,However it may not be applicable in certain scenarios
 * for instance if a thread goes certain states like waiting or time waiting or block due to
 * invocation of blocking methods such as wait,sleep or join than we would really dont know
 * when they will get back to running state and check this top flag, for such scenarios only
 * interruption is the solution.
 */
