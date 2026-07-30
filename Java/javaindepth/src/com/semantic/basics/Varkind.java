/*Instanve & Static:
-Declared at class-level
-Scope:Entire class
-Gets default value*
-cannot be re-initialized within the class
  
   Instance:Represents object store
   -Values are unique to object
   -From outside class:Accessible via object reference
   
   Static:
   
   -Values are unique to class ~ One copy per class(shared across the objects)
   -from outside class:Accessible via class name or object reference
   
   Instance and static variables are also referred to as fields or attributes.attributes is more commonly 
   associated with instance variables.
 */

class Varkind {
	static int computecount;
	int id;
	String name;
	String gender;
	int age;
	double gpa;
	char degree;
	boolean international;
	double tutionfees=12000.0;
	double internationalfees=5000.0;
	//static Varkind s3;
	//if (name=="Ameer") { We cannot start this control statements at class level but we can in constr,methods etc..
	//}

	
	void compute() {
		computecount=computecount+1;
		int nextid=id+1;
		if (international) {
			tutionfees=tutionfees+internationalfees;
		}
		System.out.println("\nid: "+ id);
		System.out.println("name:" + name);
		System.out.println("gender: " + gender);
		System.out.println("age: " + age);
		System.out.println("gpa: " + gpa);
		System.out.println("degree: " + degree);
		System.out.println("tutionfees: " + tutionfees);
		System.out.println("computecount: " + computecount);
		
		//static Varkind s3;
	}
	public static void main(String[] args) {
		Varkind s1=new Varkind();
		s1.id=1000;
		s1.name="Ameer khan";
		s1.gender="Male";
		s1.age=23;
		s1.gpa=7.2;
		s1.degree='A';
		s1.international=true;
		s1.compute();
		
	    Varkind s2=new Varkind();
		s2.id=1001;
		s2.name="Sameer khan";
		s2.gender="Male";
		s2.age=27;
		s2.gpa=8.0;
		s2.degree='A';
		s2.international=false;
		s2.compute();
		
		Varkind s3=new Varkind();
		s3.id=1002;
		s3.name="Anita";
		s3.gender="Female";
		s3.age=20;
		s3.gpa=4.0;
		s3.degree='c';
		s3.international=true;
		s3.compute();
		/*in this main method there are 4 variables namely,args,s1,s2,s3 
		   This variables scope permits to only within method and it is also called as local variables and 
		   it needs initialization mandatory.
		   */

		
		System.out.println("computecount: " +s2.computecount);

	}
}
		