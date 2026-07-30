package com.tcs.pra;

import java.util.Arrays;
import java.util.List;

import com.tcs.pra.P.Passenger;

public class PExtraction {
	public static List<Passenger> method() {
		Passenger p1 = new Passenger("Ameer Khan",24,4000);
		Passenger p2 = new Passenger("Sameer Khan",28,7000);
		Passenger p3 = new Passenger("karimulla Khan",58,9000);
		Passenger p4 = new Passenger("Fayaz Khan",8,400);
		
		return Arrays.asList(p1,p2,p3,p4);
	}
}
