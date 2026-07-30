package com.tcs.functionalstandardinterfaces;

import java.util.ArrayList;
import java.util.List;

public class CheckingDoubtsHereAboutExceptionsAndSuppliers {

	public static void main(String[] args) {
		List<Integer> integers=new ArrayList<>();
		for(int i=0;i<20;i++) {
			integers.add(i);
		}
		
		System.out.println(integers);
		
		try {
			if(integers.size() /*==*/ /*>*/ < 30) {
				throw new ArrayIndexOutOfBoundsException("Not Recommended !");
			}  else {
				System.out.println("Not right assume !");
			} 
		} catch (Exception e) {
		//	e.printStackTrace();
			System.out.println(e.getMessage() + " ~ " + integers);
			// e.getMessage() prints Not Recommended ! 
			
			System.out.println(e.getMessage().compareTo("Not Recommended !") + " ~ " +  
			integers.indexOf(19));
			
			System.out.println( integers.indexOf(219) + " Now we have clarity about e"
					+".getMessage() and if integer is not in List it reuturns -1 value"
					+ " as index number..");
		} finally {
			System.out.println("Finally ! Ended with question mark ? Haha");
		}
		
	}

}

// The question is why we need Supplier interface and its one and only method get(), Hmm
// in  FunctionalStandardInterfaceDemo we have Supplier and it supplies message only if
// erroFlag is true in case if it fails it does not return anything. 

// now in this program we have a else option if condition fails this program too nothing
// returns

// Than why Supplier why we cannot follow without supplier like this program ?
