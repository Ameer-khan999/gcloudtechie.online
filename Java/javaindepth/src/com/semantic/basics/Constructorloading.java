/* Constructor overloading used to provide convenience for clients to craete objects

*/
class Constructorloading {
	int id;
	String name;
	int age;
	char gender;
	long phone;
	double gpa;
	boolean international;
	double tutionfees=12000.0;
	double internationalfees=5000.0;
	static int computecount;
	//double tutionfees=tutionfees + internationalfees;
	
	
	
	
	Constructorloading/*con1*/(int newid,String newname,int newage,char newgender,long newphone,double newgpa) {
		/*id=newid;
		name=newname.toUpperCase();
		age=newage;
		gender=newgender;
		phone=newphone;
		gpa=newgpa;
		
		//compute();  // from Constructors we can also invoke methods..:)
		computecount=computecount+1;
		
		//return; // we cannot it blocks below lines
		System.out.println("\nID: " + id);
		System.out.println("Name: " + name);
		System.out.println("age: " + age);
		System.out.println("phone: " + phone);
		System.out.println("gpa: " + gpa);
		//System.out.println("Degree: " + Degree);
		System.out.println("tutionfees: " + tutionfees);
		System.out.println("computecount: " +computecount );
		//System.out.println("\n");*/
		// int i=10; // do not write above on this() it gives compile error.
		this(newid,newname,newage,newgender,newphone,newgpa,false); //1.Must be first,2.only one per constructor
		//3.no recursive constructor it means con1 has no param boolean isinternational if remove false from con1 it
		//goes to recursive loop.4.pass only local or objects do not pass instance variables
		// we wrote this() becuase when we have constructor overloading it gives some mainatanance issue like function 
		// applicable to one construct and not applicable to another construct.
		 // ex: discount,uppercase etc....
		
		int i=10; // we can write below to this() it does not gives compile error.

	}
	
	Constructorloading/*con2*/(int newid,String newname,int newage,char newgender,long newphone,double newgpa,boolean isinternational) {
		id=newid;
		name=newname.toUpperCase();
		age=newage;
		gender=newgender;
		phone=newphone;
		gpa=newgpa;
		international=isinternational;
		//compute();  // from Constructors we can also invoke methods..:)
		computecount=computecount+1;
		if(international) {
			tutionfees = tutionfees + internationalfees;
			//return; // we can and it gives only true value
		}
		if(gpa > 3.5) {
			tutionfees=tutionfees-1000;
		}
		//return; // we cannot it blocks below lines
		System.out.println("\nID: " + id);
		System.out.println("Name: " + name);
		System.out.println("age: " + age);
		System.out.println("phone: " + phone);
		System.out.println("gpa: " + gpa);
		//System.out.println("Degree: " + Degree);
		System.out.println("tutionfees: " + tutionfees);
		System.out.println("computecount: " +computecount );
	}
	// Constructorloading() {} // Constructor overloading coz we have two Constructors.
	//void compute() {
			//}
			
	//Instance initializers 
	// 1.can refer static members
	//2 Multiple initializers  ~ executes in order
	// 3. Constructors share code
	public Constructorloading() {
		System.out.println("Instance initializers with no-args");  // line 1
	}
	
	public Constructorloading(int id) {
		System.out.println("Instance initializers with args");     // line 2
	}
	
	{
		System.out.println("Instance initializers....");  // prints first then prints line 1 or 2 accrdng to constructor type..
	}
	
	// Note: Static initializers needs multiple lines to initiate
	
	public static void main(String... args) {
		Constructorloading s=new Constructorloading(1000,"Ameer",23,'M',7396_712_666L,7.8,true);
		//s.compute();
		Constructorloading s1=new Constructorloading(1001,"Sameer",27,'M',9985_491_126L,2.8,true);
		//s1.compute();
		Constructorloading s2=new Constructorloading(1002,"Anita",22,'F',7396_721999L,3.8);
		//s2.compute();
		System.out.println("Constructorloading.computecount: " +Constructorloading.computecount );
		
		Constructorloading cl=new Constructorloading(1);
	}

			
	
}
