package com.tcs.newdateandtime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

import com.tcs.olddateandtime.*;
/* we are going to see this demo in 4 use cases
	Use Case 1. Software Date Renewal using LocalDate
*/
public class LocalDateClass {
	
	// LocalDate Class
	public static void localDateClass() {
		LocalDate expiryDate=LocalDate.of(2022, Month.SEPTEMBER, 20);
		// New API Does not contains Consrtuctors, it contains static factory methods.
		// Here of() is static factory method and it is overloaded method.
		// public static LocalDate of(int year,Month month,int dayOfMonth) { some logic }
		// Item 22: use static factory methods instead of constructors
		// Month enum has months constants Note:- Month.SEPTEMBER (SEPTEMBER is constant)
		System.out.println("expiryDate: " + expiryDate + "   \"Note:\" LocalDate Class"
				+ " Only Gives Date..");
		
		LocalDate newExpiryDate = expiryDate.plusMonths(15).plusDays(15);
		// gives benefits of chaining methods like above
		System.out.println("New Expiry Date: " + newExpiryDate);
		// in LocalDate class plus,minus,isAfter and isBefore methods are there, for more
		// check later this API
		
		// other methods in LocalDate API
		System.out.println("Getting Expiring Year: " + newExpiryDate.getYear());
		System.out.println("Getting Expiring Month: " + newExpiryDate.getMonth());
		System.out.println("Getting Expiring DayOfMonth: " + newExpiryDate.getDayOfMonth());
		System.out.println("Getting Expiring WeekOfMonth: " + newExpiryDate.getDayOfWeek());
		System.out.println("Getting Expiring lengthOfMonth: " + newExpiryDate.lengthOfMonth());
		System.out.println("Getting Expiring yearIsleap: " + newExpiryDate.isLeapYear());
		System.out.println("Getting Expiring lengthOfYear: " + newExpiryDate.lengthOfYear());
		
		 // get returns an int 
		 System.out.println("\nyear again: " + newExpiryDate.get(ChronoField.YEAR)); 
		 System.out.println("month again: " + newExpiryDate.get(ChronoField.MONTH_OF_YEAR));
		 System.out.println("day of month again: " + newExpiryDate.get(ChronoField.DAY_OF_MONTH));
		 
		 // parse string 
		 LocalDate epoch = LocalDate.parse("1970-01-01"); // yyyy-mm-dd 
		 System.out.println("\nepoch year: " + epoch.getYear());
		 
		 LocalDate gameStartDate= LocalDate.of(2022, Month.SEPTEMBER, 20);
	}
	
	
	
	public static void main(String[] args) {
		localDateClass();
	/* 	LegacyOldDateTimeAPI l= new LegacyOldDateTimeAPI();
		LegacyOldDateTimeAPI.timeZone(); imported for sample from another package */
	}
}