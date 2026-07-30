package com.tcs.enums;

public enum BookGenre {
	// basic enum
	BIOGRAPHY,AMEER; // we need to end this ; semicoluns if you need to add other than constants
	//HORROR;
	// we wanted to test methods in Enum, and those methods will be invoked on these enum constants.
	// enums can have methods like static,instance and main methods
	
	public static void main(String[] args) {    
		for (BookGenre bookGenre : BookGenre.values()) {
			// invoking values() method returns an array of above constants
			// now we are going to invoke the diff methods in the enum class on each of the constants
            System.out.print("\nName: " + bookGenre); //toString Note:- toString() internally invokes name()
            System.out.print(", name(): " + bookGenre.name().toString());
            System.out.print(", Ordinal: " + bookGenre.ordinal());
            System.out.print(", Declaring Class: " + bookGenre.getDeclaringClass());	
            System.out.print(", compareTo(BIO -> AMEER): " + bookGenre.compareTo(BookGenre.AMEER));
            System.out.print(", equals(HORROR): " + bookGenre.equals(BookGenre.BIOGRAPHY));
         }  
		// Note:- compareTo(with below) returns -ve value Ex:- BIOGRAPHY.comapreTo(AMEER) = -1
		// Note:- compareTo(with above) returns +ve value Ex:- AMEER.comapreTo(BIOGRAPHY) = +1
    }
}