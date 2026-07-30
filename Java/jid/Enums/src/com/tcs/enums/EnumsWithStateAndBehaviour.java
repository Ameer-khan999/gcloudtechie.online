package com.tcs.enums;

import java.util.Scanner;

public enum EnumsWithStateAndBehaviour {
	BIOGRAPHY(12),
	HORROR(15); // Note:- Constants must be first
	
	public static String s; // we can put static context  in enums
	public int minAgeToRead; // variable minAgeToRead is nothing but state
	
	private EnumsWithStateAndBehaviour(int minAgeToRead) {
		this.minAgeToRead=minAgeToRead;
	} // constructor is used to initialize the state minAgeToRead (variable)
	
//	public int minAgeToRead; // variable is state
	public int getMinAgeToRead() { // method is behaviour
		return minAgeToRead;
	}
	
	public static void some() {
		for(EnumsWithStateAndBehaviour bookGenre: EnumsWithStateAndBehaviour.values()) {
			System.out.print("\nName: " + bookGenre); //toString Note:- toString() internally invokes name()
            System.out.print(", name(): " + bookGenre.name().toString());
            System.out.print(", Ordinal: " + bookGenre.ordinal());
            System.out.print(", Declaring Class: " + bookGenre.getDeclaringClass());	
            System.out.print(", compareTo(BIO -> HORROR): " + bookGenre.compareTo(EnumsWithStateAndBehaviour.HORROR));
            System.out.print(", equals(HORROR): " + bookGenre.equals(EnumsWithStateAndBehaviour.BIOGRAPHY));
            System.out.println(", minAgeToRead: " + bookGenre.getMinAgeToRead());
		}
	}
	
	public static void main(String[] args) {
	// 	EnumsWithStateAndBehaviour e= new EnumsWithStateAndBehaviour();
		// we cannot instantiate enums like interfaces
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter which Book you want to read..=");
		String bookName=sc.next();
		System.out.print("Enter your age..=");
		int age=sc.nextInt();
		
		EnumsWithStateAndBehaviour[] bookGenre1= EnumsWithStateAndBehaviour.values();
		// as we know that EnumsWithStateAndBehaviour.values() will return array of above constants
		// thats why we kept ref type as EnumsWithStateAndBehaviour[]
		System.out.println("Length: " + bookGenre1.length); // just for an idea if we remove [] will get error
		
		for(EnumsWithStateAndBehaviour bookGenre: EnumsWithStateAndBehaviour.values()) {
			if (bookName.toUpperCase().equals(BIOGRAPHY) && bookGenre.getMinAgeToRead() >= 12) { 
				System.out.println("You can read this : " + bookGenre.name() + " Book :)");
			} else if (bookName.toUpperCase().equals(HORROR) && bookGenre.getMinAgeToRead() >= 15 ) {
				System.out.println("You can read this : " + bookGenre.name()  + " Book :)");
			} else {
				System.out.println("Sorry ! Your Age is Not correct.. ! to read this Book " 
						+ bookGenre.name());
			}
			
		}
		
		EnumsWithStateAndBehaviour.some();
	}
}
