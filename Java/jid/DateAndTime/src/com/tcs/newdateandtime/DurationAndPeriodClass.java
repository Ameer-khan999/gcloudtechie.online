package com.tcs.newdateandtime;

import java.time.Duration;
import java.time.Instant;
// Use Case 3: Age Calculation (Period)
// Use Case 4: Interval timing ( Instant & duration)
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;

public class DurationAndPeriodClass {
	public static void durationAndPeriodClass() {
		LocalDate birthday = LocalDate.of(1998, Month.JUNE, 10);
		LocalDate today = LocalDate.now(); // current date from system clock
		
		// Period to Capture Dates
		Period period=birthday.until(today); // Period to Capture Dates
		System.out.println("Complete age: " + period.toString());
		System.out.println("Years: " + period.getYears());
		System.out.println("Months: " + period.getMonths());
		System.out.println("Days: " + period.getDays());
		System.out.println("Days: " + period.withYears(100) + "\n\n");
		
		// Duration to Capture Time
		System.out.println("LocalDateClass.localDateClass() invoked to cal elapsedTime..");
		Instant startTime = Instant.now();
		System.nanoTime(); // recommended to cal elapsedTimes instead of Instant.now() 
		                   // coz designed  specailly for this pupose 
		LocalDateClass.localDateClass();
		Instant endTime = Instant.now();
		
		Duration elapsedTime = Duration.between(startTime, endTime);
		System.out.println("\nCalculated elapsedTime in millis: " + elapsedTime.toMillis());
		
		// Partial Classes
		System.out.println("\nChristamas: " + MonthDay.of(Month.DECEMBER, 25)); 
		// gives Month and Date Info
		System.out.println("credit Card Expiry Date: " + YearMonth.of(2027, 9));
		// we know that cards have partial info of year and month on their cards like 12/27
		
		// This are the main Core classes that frequently uses.
		// Don't forget to check the API
	}
	public static void main(String[] args) {
		durationAndPeriodClass();
	}

}
