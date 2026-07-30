package test;
import java.util.Scanner;

class Test {
	int id=2;
	String name="Khan";
	static int i;
	void Test(int id, String name) {
		id=this.id;
		name=this.name;
		System.out.println(id);
		System.out.println(name);
		
	}
	void Test(int id,String name,double gpa) {
		System.out.println(id);
		System.out.println(name);
		System.out.println(gpa);
		
		
	}
	public static void main(String... args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter id: ");
		int id=sc.nextInt();
		System.out.print("Enter name: ");
		String name=sc.next();
		System.out.print("Enter gpa: ");
		double gpa=sc.nextDouble();
		
			
		
	    Test s=new Test();
	    Test s1=new Test();
	    s.Test(id,name);
	    s1.Test(id,name,gpa);
	
		
	}
}