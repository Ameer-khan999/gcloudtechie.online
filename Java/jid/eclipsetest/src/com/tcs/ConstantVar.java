package com.tcs;
// import java.util.Scanner;

//### Another topic
/* 
  CONSTANT VARIABLES.
  
 1.compile-time constants
   --> public static final double PI=3.14159..
 2.Compiler optimization
   --> int x = Math.PI -> int x= 3.14159..
       Stored in .class file
	   
   --> final
   --> primitive or string
   --> initialized in declaration statement
   --> initialized with compile-time constant expression.
   
## Constant variables ~ valid examples.

1.final int x=20;
2.final String x="hello";
3.final int x=23+5;
4.final String x="hello"+"world!";
5.final int z=5;
  final int x=23+z; // z is hard-wired.

## Constant variables ~ Invalid examples.  

1.int z=5;
2.final int x=23+z; //coz z is not final
3.final int x=getVal();

4.public class Test {
	final int x;
	public Test() {
		x=23; // cannot declare here,we have to declare in declaration statement.
	}
}

5.public class Test {
	static final int x;
	static {
		x=23;
	}
}
*/

public class ConstantVar {
	// static byte m;
	static void switchExample() {
		System.out.println("\nInside switchExample..");
		final byte month2=2;// compulsory declare value here dont decalre variables like m //m;  // if we not put final then it won't work
		byte month=2;// m;
		switch(month) {
		case 1:System.out.println("jan");
			   break;
		case month2:System.out.println("feb");
		   	   break;
		case 3:System.out.println("mar");
		       break;
		default:System.out.println("April defalt value");
		}
		
		
	}
	public static void main(String[] args) {
		switchExample();
//		Scanner sc=new Scanner(System.in);
//		System.out.print("Enter Month value.=");
//		byte m=sc.nextByte();
	}

}
