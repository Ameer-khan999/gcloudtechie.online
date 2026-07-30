class FinalKeywordTest {
	public static void main(String[] args) {
	FinalKeyword f1=new FinalKeyword("Ameer","male");
	
	FinalKeyword f2=new FinalKeyword("Sameer","male");
	
	FinalKeyword f3=new FinalKeyword("Shakira","female");
	
	System.out.println("F1 is:" + f1.getName());
	System.out.println("F2 is:" + f2.getName());
	System.out.println("F3 is:" + f3.getName());
	
	System.out.println("F1 is:" + f1.getName());
	System.out.println("F2 is:" + f2.getName());
	System.out.println("F3 is:" + f3.getName());
	}
		
}
// 2222222222
/* Final Local variable
1.Constant for life of the block
   --> public void register(final int courseid) {
	   courseid++;// Illegal
   }
 */


// 33333333333333
/* Final static variable
1.Constant irrespective of # instances
    --> public static final int MAX_VALUE = 0x7ffffff;
2.MUST be initialized initialized in
    --> Declaration
	--> static initializer
3.Naming Convention
    --> All CAPS with underscore separating words
	--> priavte static final int COPY_THRESHOLD = 10;
*/


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