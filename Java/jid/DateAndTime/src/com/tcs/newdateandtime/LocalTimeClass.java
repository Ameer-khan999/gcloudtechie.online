package com.tcs.newdateandtime;

import java.time.LocalTime;

//  Use case 2: Game start time using LocalTime
public class LocalTimeClass {
	public static void localTimeClass() {
		LocalTime time=LocalTime.of(9, 30, 50);
		System.out.println("LocalTime With Seconds: " + time);
		
		LocalTime time1=LocalTime.of(10,39);
		System.out.println("\nLocalTime Without Seconds: " + time1);
	}
	
	public static void main(String[] args) {
		localTimeClass();
	}
}
