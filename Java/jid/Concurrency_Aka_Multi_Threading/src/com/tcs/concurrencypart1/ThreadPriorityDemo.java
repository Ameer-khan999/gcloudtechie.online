package com.tcs.concurrencypart1;

public class ThreadPriorityDemo {
	/* previously we saw Launching and sleeping of threads and now we can see below
	 1. How a thread can get a ref to its own Object,basically Thread is a Object.
	 2. we can also see how we can Name Threads, If we have multiples threads
	 3. we can aslo see how we can priortize threads, if we have bunch of threads.
	 	The thread scheduler will do favour with that thread priority. and we will 
	 	also see why we need theam
	 4. we can also see join methods.
	 */

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		
		Thread t1=new Thread(new EmailCampaign());
		Thread t2=new Thread(new DataIntegrator());
		
		t1.setName("EmailCampaign");
		t2.setName("DataIntegrator");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		// setName,setPriority and start are methods of Thread class
		
		
		try {
			// main thread will suspended until t2 Dies.
			t2.join();
			t2.join(1); // there is also a overloaded method of join that takes
			// argument in seconds, this will start main thread if t2 not died in
			// 1 second
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("\nInside main..");
		
		System.out.println("\nwe can clearly see that even we gave Max priority to t1 \n"
				+ "but t2 is running sometimes so we cannot trust this...keep running program \n"
				+ "you can see that.");
		
		
		
		
	}
}

class EmailCampaign implements Runnable {
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println( Thread.currentThread().getName());
			if(i==5) {
				// Hint to Scheduler that thread is willing to
				// yield its current use of CPU
				Thread.currentThread().getName();
			}
		}
	}
}

class DataIntegrator implements Runnable {
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
