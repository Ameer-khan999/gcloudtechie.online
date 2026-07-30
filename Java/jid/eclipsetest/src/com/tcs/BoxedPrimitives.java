/* 
 * wrapper classes

 *1.byte ~ Byte
 *2.short ~ Short
 *3.int ~ Integer
 *4.long ~ Long
 *5.float ~ Float
 *6.double ~ Double
 *7.char ~ Character
 *8.boolean ~ Boolean
 */

package com.tcs;

import java.util.ArrayList;

public class BoxedPrimitives {
public static void boxedPrimitives() {
		
		// This are also called as wrapper classes
		Byte boxedByte=Byte.valueOf((byte) 128);
		Short boxedShort=Short.valueOf((short) 34000);
		Integer boxedInteger=Integer.valueOf(9); // static factory
		Long boxedLong=Long.valueOf(7396712666L);
		Float boxedFloat=Float.valueOf((float) 9.6);
		Double boxedDouble=Double.valueOf(9.6666);
		Character boxedCharacter=Character.valueOf('c');
		Boolean boxedBoolean=Boolean.valueOf(true);
		
		Integer boxedInt=Integer.valueOf("9"); // every box primitive has string value except char
		//Integer invalid=Integer.valueOf("nine"); // it gives error coz dont write letters like --> "nine" 
		Double boxedDou=Double.valueOf("9.66");
		
		// Unwrapping boxedPrimitives
		int primitiveInteger=boxedInteger.intValue(); // returning type value
		Integer boxedInteger1=new Integer(8); // Not recommend
		
		System.out.println("boxedByte is = " + boxedByte);
		System.out.println("boxedShort is = " + boxedShort);
		System.out.println("boxedInteger is = " + boxedInteger);
		System.out.println("boxedLong is = " + boxedLong);
		System.out.println("boxedFloat is = " + boxedFloat);
		System.out.println("boxedDouble is = " + boxedDouble);
		System.out.println("boxedCharacter is = " + boxedCharacter);
		System.out.println("boxedBoolean is = " + boxedBoolean);
		System.out.println("\nboxedInt is = " +  boxedInt);
		// System.out.println("invalid if it contains alpha letters = " + invalid);
		System.out.println("\nboxedDouble is = " +  boxedDou);
		System.out.println("\nUnwrapping primitiveInteger  is = " +  primitiveInteger);
		System.out.println("\ncreating object like this \" Integer boxedInteger = new Integer(8); \" is removed: " + boxedInteger1);
		
		
		System.out.println("\n\"Note:\" It is always recommended to use primitives instead ofd primitives..");
		// Where we have to use those boxed primitives.
		// for ex: we have a csv file "Ameer,M,1998,5.2" to print in primitive type
		String doc="Ameer,M,1998,5.3";
		String[] items=doc.split(",");
		String name=items[0];
		char ch=items[1].charAt(0);
		int dateOfBirth=Integer.parseInt(items[2]);
		double rating=Double.parseDouble(items[3]);
		
		System.out.println(" ");
		System.out.println(doc);
		System.out.println(items);
		System.out.println(name);
		System.out.println(ch);
		System.out.println(rating);
		System.out.println(dateOfBirth);
		
		Integer i=Integer.valueOf(items[2]);
		System.out.println("valueOf: " + i);
		
		// utilty methods using character class
		boolean isLetter= Character.isLetter(dateOfBirth);
		boolean isDigit= Character.isDigit(ch);
		System.out.println("1998 isLetter ?: " + isLetter);
		System.out.println("m isDigit ?: " + isDigit); // for more vist character class.
		
		// for double class
		boolean isdouble=Double.isNaN(0.0/0.0);
		System.out.println(isdouble);
		
		// for integer class
		String binary=Integer.toBinaryString(5);
		System.out.println("int to Binary: " + binary);
		String intToString=Integer.toString(1998);
		System.out.println("intToString: " + intToString);
	
		
	
		//populate DS
		ArrayList ids=new ArrayList();
		ids.add(987);//java 5 ~ Auto boxing --> Automatically boxes a primitive
		ids.add(1123);
		System.out.println(ids);
		
		// GENERICS used to store same type of data  
		ArrayList<Double> idS=new ArrayList<>(); //Note: <Double> always use boxed primitives 
		                                         // do not use primitives <double>
		idS.add(8.567);
		idS.add(10.84645);
		System.out.println(idS);
		 System.out.println("Please wait for 8 seconds...!!");
		
	}
    public static void main(String... args) {
    	boxedPrimitives();
    	veryExpensive();
    	veryExpensive1();
    }
    public static void veryExpensive() {
        Long sum=0L;
        for(long i=0;i<Integer.MAX_VALUE;i++) {
          sum=sum+i;
        }
       
        System.out.println("sum value in  more than 5 sec using both boxed and non boxed primitives: " + sum);
    }
    public static void veryExpensive1() {
    long sum=0L;
    for(long i=0;i<Integer.MAX_VALUE;i++) {
      sum=sum+i;
    }
    System.out.println("\nsum value in 1 second using only primitives: " + sum);
    System.out.println("\nSo,Always prefer primitives over boxed primitives..");
}
}
	
//Auto-Boxing In detail...

/*  // Auto-boxing
  Integer boxed=25;
  Integer boxed = new Integer(25); // jvm auto do's
 
 //Auto-unboxing
  int j=boxed;
  int j=boxed.intValue(); // jvm auto do's
 
*/

/*
// method invocation
  /* ArrayList list=new ArrayList();
   list.add(5);
      |
     Auto boxing
     list.add(new Integer(25));
     
  */
 
  
  /*
  Auto-boxing:
 	 void go(Integer boxed) {}
       go(25);
       
  Auto-Unboxing:
 	 void go(int i ) {}
      go(new Integer(25));
      
  */

 /*
  *  Operations
   
   Integer boxed=new Integer(25);
   boxed++;
   int i=3 * boxed;
   
   
   --> No Auto-boxing for Arrays
      Integer[] items=new int[] {1,2}; // compilation error coz Integer[] and int[] are not same
 */

/*
 * Item 49: prefer primitive typs over boxed primitives.
 * Boxed primitives are classes.
     1. == & !=  --> identity comparison
     2.<,<=,>,>= --> Auto-boxing.
 * Mixed Type computations lead to confusing results.
     Integer i;
     void unbelievable() {
         if(i==0) { // i is box and 0 is primitive it makes false and did not print weird
           System.out.println("weird");
         }
      }
      
* Time & Space Efficiency
 A.  void veryExpensive() {
      Long sum=0L;
      for(long i=0;i<Integer.MAX_VALUE;i++) {
        sum=sum+i;   --> 1.auto-unboxes sum
                         2.addition
                         3.auto boxes again
                         4.coz sum is box i is primitive so it takes nearly 7 Seconds.
      }
    }
         
  B. void veryExpensive() {
      long sum=0L;
      for(long i=0;i<Integer.MAX_VALUE;i++) {
        sum=sum+i; --> Here both sum and i are primitives,so there is no box unboxing thats why it executes in 1.5 seconds.
      }
     }        	
 */





