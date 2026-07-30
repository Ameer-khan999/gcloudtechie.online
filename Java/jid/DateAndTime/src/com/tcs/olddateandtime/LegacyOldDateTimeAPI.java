package com.tcs.olddateandtime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class LegacyOldDateTimeAPI {
	@SuppressWarnings("deprecation")
	// Date class
	public static void legacyDateAPI() {
		System.out.println("Date class..\n");
		Date currentDate=new Date();
		System.out.println("currentFullDate: " + currentDate);
		System.out.println("currentDate: " + currentDate.getDate());
		System.out.println("currentDay: " + currentDate.getDay());
		System.out.println("currentHours: " + currentDate.getHours());
		System.out.println("currentMinutes: " + currentDate.getMinutes());
		System.out.println("currentMonth: " + currentDate.getMonth());
		// Note: we are getting currentMonth-1, means months indeex starts from 0 -> 11
		// This is one of the problem in Date class ~ prior to 8
		// want to set year 2022 than directly you cannot you have to do 2022-1900 = 122
		// means Date(122,8,20) -> refers to 20 Sep,2022
		// means Date(-2,8,20) -> refers to 20 Sep,1898  --> 1900-2 = 1898
		// after java 8 Date class is still in use but some stuff deprecated.(removed)
		// @Deprecated
		// As of JDK version 1.1,replaced by Calendar.get(Calendar.DAY_OF_MONTH).
	}
	
	// Calender class
	public static void legacyCalenderAPI() {
		System.out.println("Calender class..\n");
		
		Calendar expiryDate=new GregorianCalendar(2022,8,30); // month 8 means sep not aug
		/* GregorianCalendar is a subclass of Calendar and year problem of 1900 in Date 
		   hasbeen addressed in Calendar class and month problem of 0-11 is same. */
	//	System.out.println("expiryDate: " + expiryDate);
		System.out.println("expiryDate: " + expiryDate.getTime());
		
		// The real case scenario is if you want to extend subscription time, than you can
		expiryDate.add(Calendar.MONTH, 11);
		System.out.println("\nexpiryDate after extend: " + expiryDate.getTime());
		
		expiryDate.add(Calendar.MONTH, 6);
		System.out.println("\nexpiryDate after twice extend: " + expiryDate.getTime());
		
		expiryDate.roll(Calendar.MONTH, 12); // roll not increases year even if you add 
		// 12 months
		System.out.println("\nexpiryDate after role (year remains same): " + expiryDate.getTime());
	}
	
	// Time Zone
	public static void timeZone() {
	//	System.out.println("Different TimeZones in world..\n");
		String[] timeZones = TimeZone.getAvailableIDs();
	// 	System.out.println(timeZones); 
		List<String> store=new ArrayList<>();
		for(String timeZone : timeZones) {
			store.add(timeZone);
		}  // will get diff timeZones
		System.out.println(store);
		// no-arg constructor below ==> default timezone
		Calendar gameStartTime = new GregorianCalendar(TimeZone.getTimeZone("Asia/Tokyo")); 
		gameStartTime.set(2022, Calendar.JANUARY, 19, 1, 00);
		// System.out.println("gameStartTime: " +  gameStartTime);
		System.out.println("gameStartTime.getTime: " +  gameStartTime.getTime());
		System.out.println("London time -- MONTH/DAY at hr:min:sec (AM/PM) -- " + (gameStartTime.get(Calendar.MONTH) + 1) + "/" + gameStartTime.get(Calendar.DAY_OF_MONTH) + " at " + gameStartTime.get(Calendar.HOUR) + ":" + gameStartTime.get(Calendar.MINUTE) + " (" + ((gameStartTime.get(Calendar.AM_PM) == 0) ? "AM" : "PM") + ")");
		
		gameStartTime.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		System.out.println("Indian time -- MONTH/DAY at hr:min:sec (AM/PM) -- " + (gameStartTime.get(Calendar.MONTH) + 1) + "/" + gameStartTime.get(Calendar.DAY_OF_MONTH) + " at " + gameStartTime.get(Calendar.HOUR) + ":" + gameStartTime.get(Calendar.MINUTE) + " (" + ((gameStartTime.get(Calendar.AM_PM) == 0) ? "AM" : "PM") + ")");
		
		gameStartTime.setTimeZone(TimeZone.getTimeZone("GMT-08:30"));
		System.out.println("Custome time -- MONTH/DAY at hr:min:sec (AM/PM) -- " + (gameStartTime.get(Calendar.MONTH) + 1) + "/" + gameStartTime.get(Calendar.DAY_OF_MONTH) + " at " + gameStartTime.get(Calendar.HOUR) + ":" + gameStartTime.get(Calendar.MINUTE) + " (" + ((gameStartTime.get(Calendar.AM_PM) == 0) ? "AM" : "PM") + ")");
		
		// DST: Change Calendar.JANUARY to Calendar.JULY. GMT would be 8 and London would be at 9 (GMT+1)
		// UK observes DST from March to October (British Summer Time)
		
		// After/Before demonstration
		Calendar gameFinal = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		gameFinal.set(2017, Calendar.JULY, 16, 9, 00);
		System.out.println("After? " + gameStartTime.after(gameFinal));
		System.out.println("Before? " + gameStartTime.before(gameFinal)); 
	}
	
	public static void main(String[] args) {
	//	legacyDateAPI();
	//	legacyCalenderAPI();
	 timeZone();
	}
}