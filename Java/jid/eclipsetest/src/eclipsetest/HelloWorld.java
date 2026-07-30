package eclipsetest;
import java.util.Scanner;

public class HelloWorld {
	//static int unitsA=60;
	//static int unitsB=70;

	static void A(int unitsA,int usageA) {
		System.out.println(usageA * 1.95);
	}
	static void A1(int unitsA,int usageA) {
		System.out.println(usageA * 3.10);
	}
		
	static void B(int unitsB,int usageB) {
		System.out.println(usageB * 3.40);
	}
	static void B1(int unitsB,int usageB) {
		System.out.println(usageB * 4.80);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//HelloWorld a=new HelloWorld();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter units in A category..");
		int unitsA=sc.nextInt();
		System.out.print("Enter usage in A category..");
		int usageA=sc.nextInt();
		System.out.print("Enter units in B category..");
		int unitsB=sc.nextInt();
		System.out.print("Enter usage in B category..");
		int usageB=sc.nextInt();
		if(unitsA == 0) {
			System.out.println("Please enter a valid number..");
		}
		else if(unitsA < 50) {
			A(unitsA,usageA);
		}
		else if(unitsA > 50) {
			A1(unitsA,usageA);
		}
		if(unitsB > 100 && unitsB < 200) {
			B(unitsB,usageB);
		}
		else if(unitsB >= 200 && unitsB <= 300) {
			B(unitsB,usageB);
		}

		
		
	}

}
