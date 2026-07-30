package com.tcs.concurrencypart1;

public class MySecondThread extends Thread {
	
	public void run() {
		System.out.println("\nInside run..");
		go(); 
	}
	
	private static void go() {
		System.out.println("\nInside go..");
		more(); // go() intern invokes more()
	}
	
	private static void more() {
		System.out.println("\nInside more..");
		
		System.out.println("\nPrefer 1st approach coz that is loosely coupled means it has its own class\n"
				+ "Task a work and Thread a Worker and this 2nd approach is tight coupled\n"
				+ "means all logic placed in  one class,so this is not a good..");
	}

	public static void main(String[] args) {
		Thread myThread=new MySecondThread ();
		myThread.start();
		
		System.out.println("\nInside main..");

	}

}
