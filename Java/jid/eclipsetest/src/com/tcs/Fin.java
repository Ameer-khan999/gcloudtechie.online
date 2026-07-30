package com.tcs;

import java.util.Scanner;
import java.lang.Math;

@SuppressWarnings("unused")
public class Fin {
	
	public double rate=10.5;
	public static double rate1;
	//public static double timeMonth;
	//public static double amount;
	//public static double Rate;
	public static double IntRate;
	public static double timeInMonths=0;
	public static double t;

	
	/*
	 * public void calMethod() { double rate1=this.rate; double
	 * timeInMonths=timeMonth/12; double IntRate=rate1 * amount; double t= amount +
	 * IntRate;
	 */
	//}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Amount..=");
		int amount=sc.nextInt(); 
		System.out.print("Enter Interest rate..="); 
		double Rate=sc.nextDouble(); 
		System.out.print("Enter Time Period..="); 
		double timeMonth=sc.nextDouble();
		
		 
		 
		
		Fin f=new Fin();
		f.getCalMethod(amount,Rate,timeMonth);
	}
	
	public void getCalMethod(double amount,double Rate,double timeMonth) {
		
		double rate1=this.rate;
		double timeInMonths=timeMonth/12;
		double IntRate=(rate1 * amount * timeInMonths)/100;
		double t= amount + IntRate;
		System.out.println("The rate is..=" + Rate);
		System.out.println("The amount is..=" + amount);
		System.out.println("The months are..=" + timeMonth);
		System.out.println("The Interest is..=" + IntRate);
		System.out.println("The Time Period is..=" + timeInMonths);
		System.out.println("The total is..=" + t);
	}
	
	
}