/**
 *  ** Exceptions
 *  -> Exceptions are nothing but errors, we have to handle that in compile(checked)time or runtime(unchecked).
 *     --> if we are using throws and try-catch statements then those are checked exceptions.
 *     A.Exceptional situations.
 *     1.Partner server is down ~ connect to another server.
 *     2.database is down.
 *  -> No control
 *  -> then this software called as robust otherwise it called as fragile code(like a braked glass).
 *  -> Object of class java.lang.Throwable.Exception.IOException.FileNotFoundException
 */


package com.tcs.exceptionhandlings;

import java.io.FileNotFoundException;
import java.io.IOException;





public class ExceptionsDemo {
	

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Scanner sc=new Scanner(System.in);
		 * System.out.print("Enter Destination number..="); int dest=sc.nextInt();
		 */
		System.out.println("\nInside main..");
		try {
			share();
			System.out.println("\nShare: FileNotFoundException..");
		} catch (FileNotFoundException e) {
			System.out.println("\nMain: FileNotFoundException");
			throw e;
			
			// TODO Auto-generated catch block
			// e.printStackTrace();
			//System.out.println("\nFile Not Found Please Check The C Drive..");
		     //System.out.println("\nEnd of main..");
		}
	}

	private static void share() throws FileNotFoundException {
		System.out.println("\nInside share..");
		try {
		
			HTTPConnect.send(2,"hello", "http://www.google.com");
			System.out.println("After invoking send..");

		} /*
			 * catch (IOException e) { // TODO Auto-generated catch block
			 * //e.printStackTrace(); System.out.println("\nConnecting to another server");  // this gives error
			 * }
			 */ catch (FileNotFoundException e) {   // FileNot is subclass of IOException,so always place subclass(FileNot) ahead of superclass(IO)
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("\nFile Not Found Please Check The C Drive..");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("\nConnecting to another server");
		} 
		
		catch (IllegalArgumentException e) {
			System.out.println("\nPlease enter number either 0 or 1"); // generally this is a unckecked exception we dont need to catch,
																		// it occurs due to programming flaws
		} finally {
			System.out.println("\nInside share's finally");
		}
		 

		System.out.println("\nEnd of share..");
	}
}