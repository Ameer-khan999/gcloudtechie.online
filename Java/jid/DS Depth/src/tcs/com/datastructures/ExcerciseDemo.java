package tcs.com.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ExcerciseDemo extends BookFlight  {
	
	Deque confirmedList=new ArrayDeque<>();
	//String[] a=e.bookFlight(firstName,lastName);
	//confirmedList.add();
		
	public static void main(String[] args) {
		System.out.print("Enter firstname..=");
		Scanner sc=new Scanner(System.in);
		String firstName=sc.nextLine();
		System.out.print("Enter lasttname..=");
		String lastName=sc.nextLine();
		
		/*
		 * ExcerciseDemo e = new ExcerciseDemo(); e.bookFlight(firstName,lastName);
		 */
		BookFlight bf= new BookFlight();
		bf.bookFlight(firstName, lastName);
		
		bf.getFirstName();
	}



}
