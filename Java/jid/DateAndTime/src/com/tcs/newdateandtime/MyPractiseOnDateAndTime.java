package com.tcs.newdateandtime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class MyPractiseOnDateAndTime {
	public static void myPractiseOnDateAndTime() {
//		String cityName =cityName;
		ZoneId GMT = ZoneId.of("GMT");
		ZoneId Dubai = ZoneId.of("Asia/Dubai");
		ZoneId Los_Angeles = ZoneId.of("America/Los_Angeles");
		ZoneId Kolakata = ZoneId.of("Asia/Kolkata");
		ZoneId Karachi= ZoneId.of("Asia/Karachi");
		ZoneId cityName = null;
		LocalTime currentTime = LocalTime.now(Kolakata)/* .now(Los_Angeles) */;
		String AMPM= currentTime.getHour() < 12 ? "AM" : "PM";
		System.out.println("After adding +12.30 hrs to: " + Los_Angeles + " the time in"
				+ " \nKolkata/IST is: "
				+ currentTime/* .plusMinutes(750) */ + " "
		+  AMPM + "  \n\\\"Note:\\\" we added 750 minutes to Los_AngelesTime to Get IST.");
		
		LocalTime Los_AngelesTime = LocalTime.now(Los_Angeles); // change names here
		String AMPM1= Los_AngelesTime.getHour() < 12 ? "AM" : "PM";
		System.out.println("\nThe Real Los_AngelesTime is: " + Los_AngelesTime + " "+ AMPM1
				+ "\n\"Note:\" Los_AngelesTime is -12.30 hrs or -750 Minutes"
				+ " behind to IST \n 12.5 Hours * 60 Minutes = 750 Minutes :)");
		// GMT - 0 towards east it adds +1 and towards west id adds -1
		// USA ~ America/Los_Angeles = GMT -7, INDIA ~ Asia/Kolkata= GMT+5.30, 
		// DUBAI ~ Asia/Dubai= GMT+4.00.
		
	// Clarification ~ I am doing this program on 20 Sep,2022 3.30 PM IST (GMT 10.00 AM)
	// We are based on GMT ~ coz it is universal
	// In Los_Angeles time is 3.00 AM, to bring Los_Angeles time to IST, we need to add
	// 12.30 hrs or 750 minutes, coz we are ahead of 12.30 hrs to Los_Angeles.
	// Los_Angeles ~ GMT -7 , Kolkata ~ GMT +5.30 hrs = 7 + 5.30 -> 12 .30
	}

	public static void main(String[] args) {
	/*	Scanner sc = new Scanner(System.in);
		System.out.println("Enter city name to know exact time..=");
		String name = sc.next();
		ZoneId<String> cityName =  name; */
		myPractiseOnDateAndTime();
	}
}


