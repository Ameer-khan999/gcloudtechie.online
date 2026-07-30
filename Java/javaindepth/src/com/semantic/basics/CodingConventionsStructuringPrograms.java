public class CodingConventionsStructuringPrograms {
	public void codingConventionsStructuringPrograms() {}
}

/*
Coding Conventions Structure.

1.Class Organization
-> Variables  ~ static followed by instance
-> Static initializers
-> Static nested classes
-> Static methods
-> Instance initializers
-> Constructors
-> Instance nested classes
-> Methods


2.Class Size
-> The Single Responsibility Principle
   --> Helps create better abstractions
   --> Helps in having fewer lines of code
-> Less than 2000 lines

3.Methods
-> Small & focussed
   --> Should do only one thing
   
-> Refactor long methods
   --> Software reuse
   --> Clean and readable code
   
-> Group methods with similar functionality e.g., like Strings and subStrings.
   
   Type 1: 
			int search (int[] list,int ket) {
				// Step 1: Sort
				..........
				..........
				// Step 2: Binary search
				..........
				..........
			}
			
   Type 2:
			
			int search (int[] list,int ket) {
				sort(list);
				binarySearch(list,key);
			}
			
-> Clean code : A HAndbook of Agile Softaware craftsmanship BY Robert C.Martin.

4. Local variables
-> Item 45: Minimize the scope of local variables

-> Decalre where first used
	(Right)								(Wrong) // coz for unerstanding so write variables before calling methods
    -------								-------
	void go() {							void go() {
		// 50 lines of code					double d=3.14;
		
		double d=3.14;					// 50 lines of code	
		foo(d);							foo(d);
	}									}

5.Loops 
-> Prefer for over while

				While:
				
				Step 1 :  int[] list1= getRandomArray(3);
						  int i=0;
						  while (i < list1.length)
							foo(list1[i++]);
				   
				Step 1.1: int[] list2= getRandomArray(3);
						  int j=0;
						  while (i < list2.length)  --> here we forget to replace i with j,it compiles fine,but in runtime 
							foo(list1[j++]);			it gives big blunder in real world.
							
				For:
				
			    Step 2  : int[] list1= getRandomArray(3);
						  for(int i: list1) {
							  foo(i);
						  }
						  
				Step 2.2: int[] list2= getRandomArray(3);
						  for(int i: list2) {
							  foo(j);  // Gives compilation error, we can find error before blunder
						  }
						  
-> So prefer for over while.

**) Coding Stylistic

6.Braces 
-> Beginning brace ~ End of line
-> Ending brace ~ Start of the statement
	void go() {
		..
	}
7.Indentation 
-> Indent blocks by 4 spaces(or 1 tab)
    public  class XYZ {
		public void foo() {
			if() {
			}
		}
	}
	
8.Wrapping Lines
    --> Line length ~ 80 characters
-> Break after comma, e.g., method calls & declarations
-> Break before operator, e.g., if blocks,arithmetic ops.
-> Use 8-space rule(or 2-tab)

9. Comments
-> Copde overview
-> Non-Obvious design decisions
-> Frequent comments -> poor code quality
-> Use descriptive method & variable names such as easily understandable.
				EX: int search(int[] list, int key) {
						sort(list);
						binarySearch(list,key);
				}
10. Comment Types
-> implementation comments
   --> // & /*..*/ 
/*   --> Code documentation
	 --> Disable code, e.g, if(x<7 /* && y>3 *//*){...}
-> Documentation Comments (or javadoc comments + block comments) ~ rare
    --> /**...*//*
	--> API(implementation free)
	--> javadoc ~ To extract to HTML files
	--> methods,classes and constructors

-> Used Inside methods or with private fields
		--> Block comments     /* like this Don't use // */
/*		--> Single-line comments //
		--> Trailing comments   /* like this or use // */ // Appear on same line
