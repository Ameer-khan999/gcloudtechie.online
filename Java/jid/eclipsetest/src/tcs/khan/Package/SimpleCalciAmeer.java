package tcs.khan.Package;

import java.util.Scanner;

public class SimpleCalciAmeer {
	/*static private double firstval;
	static private double secondval;
	private static String operator;
	public static double simpleCalci() {
		String[] opes= {"+","-","*","/","%"};
		for(int i=0;i<=opes.length;i++ ) {
			if(operator.equals("+")) {
				double result=firstval+secondval;
				System.out.println("\nfirstval+secondval: " + result);
				
			}else if(operator.equals("-")) {

				double result=firstval-secondval;
				System.out.println("\nfirstval-secondval: " + result);
				
			}
		return 1.0;
		}
		double result=firstval+secondval;
		System.out.println("\nfirstval+secondval: " + result);
		
		double result2=firstval-secondval;
		//System.out.println("\nfirstval-secondval: " + result2);
		
		double result3=firstval*secondval;
		//System.out.println("\nfirstval*secondval: " + result3);
		
		double result4=firstval/secondval;
		//System.out.println("\nfirstval/secondval: " + result4);
		
		double result5=firstval%secondval;
		//System.out.println("\nfirstval%secondval: " + result5);
		
		return result;
		
		
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter first value: ");
		double firstval=sc.nextDouble();
		
		System.out.print("Enter second value: ");
		double secondval=sc.nextDouble();
		
		System.out.print("Choose One Operator=+,-,*,/ or % ");
		String operator=sc.nextLine();
		
		simpleCalci();
		
	}*/
	public static void main(String... args) {
		String s1=getInput( "Enter First Numeric Value: ");
		String s2=getInput( "Enter First Numeric Value: ");
		String op=getInput( "Enter operation:(+ - * / %): ");
		
		double result=0;
		
		switch (op) {
		case "+":
			result=addValues(s1,s2);
				break;
		case "-":
			result=subValues(s1,s2);
				break;
		case "*":
			result=mulValues(s1,s2);
				break;
		case "/":
			result=divValues(s1,s2);
				break;
		case "%":
			result=modValues(s1,s2);
				break;
		default:
			System.out.println("Unrecognized Op..");
			return;
		
		}
		System.out.print("The Ans is: " + result);
		
	}
	private static String getInput(String prompt) {
		System.out.print(prompt);
		Scanner sc=new Scanner(System.in);
		return sc.nextLine();
	}
	
	private static double addValues(String s1,String s2) {
		Double d1=Double.parseDouble(s1);
		Double d2=Double.parseDouble(s2);
		return d1+d2;
	}
	
	private static double subValues(String s1,String s2) {
		Double d1=Double.parseDouble(s1);
		Double d2=Double.parseDouble(s2);
		return d1-d2;
	}
	
	private static double mulValues(String s1,String s2) {
		Double d1=Double.parseDouble(s1);
		Double d2=Double.parseDouble(s2);
		return d1*d2;
	}
	
	private static double divValues(String s1,String s2) {
		double d1=Double.parseDouble(s1);
		double d2=Double.parseDouble(s2);
		return d1/d2;
	}
	
	private static double modValues(String s1,String s2) {
		double d1=Double.parseDouble(s1);
		double d2=Double.parseDouble(s2);
		return d1%d2;
	}
	
	//}
}
