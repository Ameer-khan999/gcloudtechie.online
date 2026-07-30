/* Strings

--> String is an object of a class
--> String class uses character arrray to store text.
--> java uses UTF-16 for characters
--> String is sequence of unicode characters 
--> String is immutable

String object ~ immutable sequence of unicode characters.
String pool ~ Save memory
we can concatenate using + operator.


String manipulation..

Some Common operations are
1.comparison
2.searching
3.examining individual characters
4.extracting substrings
5.Case translation
6.replaceAll
7.split

3rd party String utilities for cleaner code
1.Apache common langs ~ StringUtils
2.Guava's String utility classes.

for more visit String API's in google.
*/



import java.lang.String;
import java.lang.Math;
import java.util.*;
import java.util.Scanner;
//import java.lang.Iterable;

public class Strings {
	public static String s;//,s1,s2,s3;
	public static String temp;
	
	/*public static void Stringz(String s) {
		
		System.out.println(s3);
		/*System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);*/
	//
	public static double simpleCal() {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter First value: ");
		double firstval=sc.nextDouble();
		System.out.print("Enter Second value: ");
		double secondval=sc.nextDouble();
		
		double result=firstval+secondval;
		System.out.println("\nfirstval+secondval: " + result);
		
		double result2=firstval-secondval;
		System.out.println("\nfirstval-secondval: " + result2);
		
		double result3=firstval*secondval;
		System.out.println("\nfirstval*secondval: " + result3);
		
		double result4=firstval/secondval;
		System.out.println("\nfirstval/secondval: " + result4);
		
		double result5=firstval%secondval;
		System.out.println("\nfirstval%secondval: " + result5);
		
		return result;//,result2,result3,result4,result5;
		/*return result;
		return result2;
		return result3;
		return result4;
		return result5;*/
		//System.out.println(result); //After return no statements will work
		/*System.out.println("firstval+secondval: " + result1);
		System.out.println("firstval-secondval: " + result2);
		System.out.println("firstval*secondval: " + result3);
		System.out.println("firstval/secondval: " + result4);
		System.out.println("firstval%secondval: " + result5);*/
	}
		
	public static void main(String... args) {
		/*Strings s=new Strings();//Empty string  worst way to creating strings
		Strings s1=new Strings("Hello Ameer !");*/
		
		//char[] cArray={'A','m','e','e','r'};
		//Strings s3=String(cArray);
		String s="  Hello Ameer " + "Khan !"; // string literal
		System.out.println(s);   //Best way to create strings
		// Equals comparision
		System.out.println("\nInside String Manipulations..");
		System.out.println("\ns:"+s.equals("HELLO WORLD"));
		System.out.println("\ns:"+s.equalsIgnoreCase("HELLO WORLD"));
		System.out.println("\ns:"+s.equalsIgnoreCase("HELLO AMEER KHAN !"));
		System.out.println("\ns negative:"+s.compareTo("hELLO WORLD"));
		System.out.println("\ns positive:"+s.compareTo("HELLO WORLD"));
		System.out.println("\ns Negative:"+s.compareTo("zELLO WORLD"));
	    System.out.println("\ns Length is: " + s.length()); 
        System.out.println("\ns is empty or not: " + s.isEmpty());
		System.out.println("\nsgets byte value: " + s.getBytes());		
		//System.out.println("s is Integer or not: " + s.isInteger());
		
		//Searching
		
		System.out.println("\ns.contains(HELLO WORLD):"+s.contains("HELLO WORLD"));
		System.out.println("\ns.contains(Ameer):"+s.contains("Ameer"));
		System.out.println("\ns.Startswith(Hello):"+s.startsWith("Hello"));
		System.out.println("\ns.Startswith(Ameer):"+s.startsWith("Ameer"));
		System.out.println("\ns.endsWith(Hello):"+s.endsWith("Hello"));
		System.out.println("\ns.endswith(!):"+s.endsWith("!"));
		System.out.println("\ns.indexOf(r):"+s.indexOf("r"));
		System.out.println("\ns.indexOf(r):"+s.indexOf("o"));
		System.out.println("\ns.lastindexOf(e):"+s.lastIndexOf("e"));
		
		//examining individual characters.
		
		System.out.println("\ns.charAt(6):"+s.charAt(6));
		//String g="Hello Chimpu";
		String g=new String("Hello Chimpu");
		char[] char1=g.toCharArray();
		System.out.println(char1);
		
		// Extracting substrings
		System.out.println("\ns.substring(4):"+s.substring(4));
		System.out.println("\ns.substring(4,10):"+s.substring(4,10));
		
		// Converting to cases  (Note:String is immutable,So only copy is returned.)
		System.out.println("\ns.toUppercase:"+s.toUpperCase());
		System.out.println("\ns.toLowercase:"+s.toLowerCase());
		
		System.out.println("\ns.trim:"+s.trim());  // returns a copy of string after trimming leading any whitespaces.
		
		// Replace (Replaces comma's with white spaces)
		
		System.out.println("\ns.replaceAll:"+s.replaceAll(" ","_"));
		System.out.println("\ns.replaceAll:"+s.replaceAll("e","r"));
		
		//Split(Splits the document in a words or splits the line of text using delimiters such as comma,tab,white space etc..)
		System.out.println("s.split(o):");
		String[] sa=s.split(" "); // we cannot iterate a expression,we need array or lang.Iterable package and we cannot convert string to string in 
		                          // for each loop.So best is use split method to itraete. 
		for(String temp:sa) {
			System.out.println(temp);
		}
		if(temp == "Ameer") {
			System.out.println("Yes its ok..!");
		}
		else {
			System.out.println("Not ok..");
		}
		
		//static methods (include overloaded methods)
		System.out.println("\nString value of(1.3):" + String.valueOf(1.3));
		
		//String formats
		/*int qty=10;
		String size="M";
		//System.out.println("Shirt size is %s,Quantity is %d",qty,size);
		String.format("Shirt size is %s,Quantity is %d",qty,size);*/ //Not workout
		
		
		//Wrapper Classes
		simpleCal();
		
		String wrap="3.76";
		Double d=Double.parseDouble(wrap);
		Double d1=Double.parseDouble(wrap);
		System.out.println("Wrapper class Double: " + d +"," + d1);
		//Integer i1=Integer.parseInteger(wrap);
		//System.out.println("Wrapper class Integer: " + i1);
		
		
				
		
		
		
		
		
		
		//Stringz(s3);
	}
}