/* Accessing Classes
Packages are nothing but directories of file system

1.Same Package ~ direct access 
2.Different Package 
   --> import
   --> Fully-qualified class name ~ rare!
   
 there are two ways two import statement
 1.implicit --> import java.util.*; // it imports all classes but this is bad decision it causes conflict and it can breaks code.
                import java.sql.*; // this both have Date Class, here compiler gives error
 2.Explicit --> import java.util.Date; // Most of the developers use this type,better clarity,preferred etc..
 
 -> Fully qualified Class name
    -> Alternate to import 
       -> java.util.ArrayList list=new java.util.ArrayList();
    -> Required if using java.util.Date & java.sql.Date

Here we have some solutions for how to impoprt packages in real scenario.

Solution 1:
    -> Use only one explicit import
        import java.util.Date;
		import java.sql.*;
		..........
		
		
		Date date; // from util
		java.sql.Date date2; // Fully qualified class from sql
		
Solution 2:
    -> Use only fully qualified names
	    import java.util.*;
		import java.sql.*;
		
		.......
		java.util.Date date;
		java.sql.Date date2;
		
		
Invalid Imports:
   -> This invalid imports gives compilation error
      import java.util.Date;
		import java.sql.Date;
		
		

Any Side Effects in Using import ?
   -> Nope!!
     1.Does not makes your class bigger.
     2.Does not effect runtime performance
     3.Saves from fully qualified names ~ compiler does this	


Avoiding Package name  conflict:-

For example a student developed math.geometry package and a oracle has the same math.geometry package this leads to 
naming conflict while compile time.To avoid this use proper naming conventions.
1.use organizations reverse internet doamin name. Ex: edu.siddhartha.math.geometry
                                                      com.oracle.math.geometry
2.Lowercase alphabets,rarely digits
3.Short ~ generally,less than 8 characters
4.Meaningful abbreviations, e.g. util for utilities.
5.Acronyms are fine, e.g., awt for abstract window toolkit.
6.Never start with java or javax.
	 
 */
 
 //import java.util.Date;
 //import java.sql.Date;
 package com.semantic.Package1;
 public class AccessingPackages {
	 
	 public static void foo() {
		 java.util.Date date=new java.util.Date();
		 java.util.ArrayList list;// list=new ArrayList();
	
		 //java.sql.Date date1=new java.sql.Date();
		 System.out.println("From util package: " + date);
		 //System.out.println(date1);
	 }
	 public static void main(String... args) {
		 foo();
	 }
 }