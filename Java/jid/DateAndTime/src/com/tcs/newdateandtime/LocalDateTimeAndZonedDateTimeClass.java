package com.tcs.newdateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeAndZonedDateTimeClass {

	public static void localDateTimeAndZonedDateTimeClass() {
		LocalDate gameStartDate= LocalDate.of(2022, Month.SEPTEMBER, 20);
		LocalTime time=LocalTime.of(1, 30, 50);
		LocalDateTime gameStartTime = LocalDateTime.of(gameStartDate, time);
		System.out.println("GameStartTime: " + gameStartTime);
		
		// ZonedDateTime Class
		ZonedDateTime zonedGameStartTime = ZonedDateTime.of(gameStartTime, ZoneId.of("Asia/Kolkata"));
		System.out.println("\nZonedGameStartTime (\"Asia/Kolkata\"): " + zonedGameStartTime + "  \n\"Note:\" +5:30 hrs ahead to GMT..");
		
		ZonedDateTime dubaiTime = zonedGameStartTime.withZoneSameInstant(ZoneId.of("Asia/Dubai"));
		System.out.println("\nDubaiTime (\"Asia/Dubai\"): " + dubaiTime + "  \"Note:\" +4:00 hrs ahead to GMT..");
		
		ZonedDateTime pacificStandardTime = zonedGameStartTime.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
		System.out.println("\nPacificStandardTime (\"America/Los-Angels\"): "
		+ pacificStandardTime + "  \n\"Note:\" -7:00 hrs behind to GMT..");
		
		System.out.println("\n\"Note:\" In GMT Standard Asia Side +hrs (East)  and America Side "
				+ "-hrs (West) and this divides \nfrom London calculates with 8.00..");
		
		ZonedDateTime gmt = zonedGameStartTime.withZoneSameInstant(ZoneId.of("GMT"));
		System.out.println("\nGMT (\"GMT\"): " + gmt + "  \"Note:\" Z Notation Occurs"
				+ " for GMT/UTC");
		
	}
	public static void main(String[] args) {
		localDateTimeAndZonedDateTimeClass();
		
	}

}
