/*Type casting
----------------
   Assign variables or literals of one type to variable of another type.
   
   int --> long
   int <-- byte
 -Only numeric to numeric casting is possible.
 -cannot cast to boolean or vice versa
 -implicit or explicit
 
--> IMPLICIT
--------------
--> Samller to larger ~ widening conversion
     int x=65;
	 long y=x;(implicit casting by compiler)
	 
	 byte(8) --> short(16) --> int(32) --> long(64) --> float(32) --> double(64)
     	                          ^
								  |
								  |
								  |
						char(16)---
	--> Integer to floating point is implicit too
	
-->EXPLICIT
-------------
-->larger to smaller ~ narowing conversation
   reverse of implicit is explicit
   
   long y=42;
   int x=int(y)
   
   we can do with UTF-16 Unsigned integers
   byte b=65;
   char c=(char)b; // c="A";
   orchar c=65;//c="A";
   
   Information loss in explicit casting
     --> Out of range assignments
	     -> byte narrowByte=(byte) 123456;//64
     --> truncation
	     -> floating point to integer/char will always truncate
		 -> int x=(int) 3.14f;//x=3;
		 -> int y=(int)0.9;//y=0
		 -> char c=(char)65.5;//'A'
		 
   Casting use Cases
      --> Implicit casting 
	    -> float f1=3.133f;
		-> float f2=4.135f;      go(double d1,double d2) {
		                         	....
		                           }
	  	-->go(f1,f2)
		
	  --> expklicit casting
	     -> double avg=(2+3)/2;//2.0,not 2.5
		 -> double avg=(double) (2+3)/2;
*/   

class Typecasting {
	static void typecasting() {
		System.out.println("\nInside explicit casting..");
		long y=42;
		System.out.println(y);
		int x=(int)y;
		//int c=40;
		double d=40.0;
		int c=(int)d;
		System.out.println(d);
		System.out.println(c);
	       // Information loss due to out-of-range assignment
      byte narrowdByte = (byte)123456;
	  System.out.println("narrowdByte: " + narrowdByte); 
	  
	  // Truncation
	  int iTruncated = (int)0.99;
	  System.out.println("iTruncated: " + iTruncated); 
	  
	  // Implicit cast (int to long)
	  y = x;
	  
	  // Implicit cast (char to int)
	  char cChar = 'A';
	  int iInt = cChar; 
	  System.out.println("iInt: " + iInt);
	  
	  // byte to char using an explicit cast
	  byte bByte = 65;
	  cChar = (char)bByte; // special conversion (widening from byte --> int followed by narrowing from int --> char)
	  System.out.println("cChar: " + cChar);

	}
	public static void main(String[] args) {
		typecasting();
	}
	
}


/* Statements and objects reference

-->Objects reference
Ex:- Student s=new Student(); Note:- Student is reference type and s is object refer variable
     1.Student=Allocate space for reference variable
	 2.=      = student object address
	 3.Student() = Allocate space for new student object
	 
--> Bit Depth & default
  --> Bit depth ~ JVM specific
  --> Default ~ null
     ->Student s;
	   s.updateprofile();//NullPointerexception
	   
-->Statements:-

1.Involves one or more expressions
2.expression ~ evaluated to single value
  -> involves literals,variables,operators,and method calls
Example:-
  1.int count=x*getcount();
  -> here x,getcount(),x*getcount(),count=x*getcount()
                       <-------------------------------->compound expressions

-->statements and types

1.declaration statements,E.g..,int count=25;

2.expression statements                                |
 
   -->count=25;//assignment statements
   -->getcount();//metyhod invocation statements
   -->count++;//incremental statements
3.Control flow statements  
    if(count<100) {
	}
  
 Note:- 1 can declare at class level but 2,3 cannopt declare at class level we hacve to declare at methods or constrtuctors etc..
 */