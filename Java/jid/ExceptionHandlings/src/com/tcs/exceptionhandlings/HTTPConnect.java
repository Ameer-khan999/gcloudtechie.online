package com.tcs.exceptionhandlings;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HTTPConnect {
	public static void send(int destination, String data, String partner) throws FileNotFoundException, IOException {
		System.out.println("\nInside send..");
		if (destination < 0 || destination > 1) { // pre condition to detect illegal arguments 
			throw new IllegalArgumentException();
		}
		if (destination == 0) {
			throw new FileNotFoundException();
		} else if (destination == 1) {
			throw new IOException();
		}

		System.out.println("\nEnd of send..");
	}

}
