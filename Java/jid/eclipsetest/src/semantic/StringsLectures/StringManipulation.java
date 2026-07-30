/* 

--> 1.StringBuilder
   --> From java 5
   1.Example:
       StringBuilder sb=new StringBuilder();
	   sb.append("Hello");
	   String s=sb.append("Good").append("morning").toString();//in StringBuilder string inits with char,so we used toString() to convert.
   2.Other Methods:length,delete,insert,reverse,replace
   3.Not Synchronized. leads to data corruption but we can externally synchronize using concurrency.
   
 --> StringBuffer
    --> Obosolete. Use StringBuilder!
	--> Synchronized ~ slow
	--> API compatible with StringBuilder.
	--> Mostly uses in single thread
    --> StringBuilder is more recommended than StringBuffer.

 --> Item 51: Beware the performance of string concatenation.
 
    --> Item 51: + Operator.
	     1.Combining few Strings is fine.
		 2.With Each concatenation,
		    a.) Contents of both strings are copied.
			b.) New StringBuilder is created and appended with both strings.
            c.) Return string via toString()
          Example: concatening a,b,c in loop.
                   s+="a"; //copy of ""&a are made to generate a
                   s+="b";//copy of a&b are made to generate ab
                   s+="c";//copy of ab&c are made to generate abc
           3.Also,StringBuilder is created for each concatenation.
           4.Time consuming ~ O(N^2),Space consuming
		   
	--> Item 51: Use StringBuilder()
	     1.O(N)
		 2.A/C one benchmark
		    --> StringBuilder = 300 x times +operator
			--> StringBuilder = 2 x times StringBuffer
		   

       Note1: Use StringBuilder the performance is important.
       Note2: Use + operator only the strings are few.	 
*/


import java.lang.String;
import java.text.NumberFormat;
import java.util.Locale;
public class StringManipulation {
	public static void Man() {
		// String Concatenation.
		System.out.println("Hello"+"World !"); //HelloWorld !
		System.out.println("Hello"+"World !"+"125"); //HelloWorld !125
		System.out.println("Hello"+"World !"+125);   //HelloWorld !125
		System.out.println("Hello"+"World !"+125+25.5); //HelloWorld !12525.5
		System.out.println(125+25.5+"Hello"+"World !");  //150.5HelloWorld !
		
		
		String s="hello "+"world ";
		System.out.println("S: "+s);
		StringBuffer sb=new StringBuffer(s);
		sb.append("Good ").append("Morning !").toString();
		System.out.println("Sb: "+sb);
		System.out.println("Sb.length: "+sb.length());
		sb.delete(sb.indexOf("Morning"),sb.length());
		System.out.println("Sb: "+sb);
		sb.delete(1,5);
		System.out.println("Sb.delete(int,int): "+sb);
		sb.insert(1,"ey");
		System.out.println("Sb.insert(int,String): "+sb);
		sb.reverse();
		System.out.println("Sb.reverse(): "+sb);
		sb.replace(1,5,"hello");
		System.out.println("Sb.replace(int,int,String): "+sb);
		
	}
		
	/*public static void formatNums() {
		double doubleValue=12_22_309.99;
		NumberFormat numberFormat=NumberFormat.getNumberInstance();
		System.out.println("NumberFormat: " + numberFormat.format(doubleValue));
		
	
		NumberFormat integerFormat=NumberFormat.getIntegerInstance();
		System.out.println("IntegerFormat: " + integerFormat.format(doubleValue));
		
		numberFormat.setGroupingUsed(false);
		System.out.println("IntegerFormat: " + numberFormat.format(doubleValue));
		
		Locale locale=new Locale( language: "de", country: "DE");
		NumberFormat localFormat=NumberFormat.getNumberInstance(locale);
		System.out.println("localFormat: " + localFormat.format(doubleValue));
		
		NumberFormat currencyFormat=NumberFormat.getCurrencyInstance(locale);
		System.out.println("currencyFormat: " + currencyFormat.format(doubleValue));
		
		DecimalFormat decimalFormat=new DecimalFormat( pattern: "$000.000"); //$001.00
		System.out.println("DecimalFormat: " + decimalFormat.format(number: 1));
		
		DecimalFormat decimalFormat=new DecimalFormat( pattern: "$000.00"); //$005.89 loossy data 1
		System.out.println("DecimalFormat: " + decimalFormat.format(number: 5.891));
		
		DecimalFormat decimalFormat=new DecimalFormat( pattern: "$##0.00#"); //$5.891 gives exact data.
		System.out.println("DecimalFormat: " + decimalFormat.format(number: 5.891));
	}*/
	public static void main(String... args) {
		Man();
		EscapeSequence();
		//formatNums();
	}
		
    public static void EscapeSequence() {
		String str="Hello \"World\" ! \'Good Morning\\\' \n\tThis is Ameer Khann :)      \bhi";
		System.out.println("\n\"Escape Sequences:\"\n ");
		System.out.println(str);
		
		char[] s2={'\"','"','l','l','o'};
		//char c=' \"F\" '; // This gives error
		System.out.println(s2);
		//System.out.println(c);
	}
	
	/*Escape Sequences
	1.Character Preceded by \
	2.To Use Special Characters in strings & Character Literals.
	
	Escape Sequences Are:
	1. \" ~ double quote(not required in char literal)
	2. \' ~ single quote(not required in string literal)
	3. \n ~ new line
	4. \t ~ tab space
	5. \\ ~ backslash
	6. \r ~ carriage return
	7. \b ~ backspace
	8. \f ~ formfeed
    Note: Except this "\u0041" all other characters after \ gives error because only u is the unicode char.
    */
	
}
	
	