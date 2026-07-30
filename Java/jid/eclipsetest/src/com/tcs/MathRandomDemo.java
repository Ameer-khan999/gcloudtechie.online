package com.tcs;
import java.util.Scanner;

public class MathRandomDemo {
	public static void main(String[] args) {
		mathDemo();
	}
	

	private static void mathDemo() {
		// TODO Auto-generated method stub
		//lottery [1,100]
		double random = Math.random(); // [0.0,1.0)
		int winner = (int) (random*100) + 1;
		
		System.out.println(random);
		System.out.println(winner);
		
		// round ~ rounding floating point to nearest integers.
		long distance1=Math.round(random);
		int distance2=Math.round((float)(random));
		System.out.println(distance1);
		System.out.println(distance2);
		
		// ceil ~ round-up
		double ceil1=Math.ceil(random);
		double ceil2=Math.ceil(25.0);
		//int ceil3=Math.ceil((float)(random));
		
		System.out.println(ceil1);
		System.out.println(ceil2);
		//System.out.println(ceil3);
		
		// floor ~ round-down
		double floor1=Math.floor(random);
		double floor2=Math.floor(25.8);
		//int ceil3=Math.ceil((float)(random));
		
		System.out.println(floor1);
		System.out.println(floor2);
		
		// max and min
		double max=Math.max(26, 26.5);
		System.out.println("max value is..=" + max);
		
		double min=Math.min(26, 26.5);
		System.out.println("min value is..=" + min);
		
		double pow=Math.pow(2.0, 4.0);
		System.out.println("power value is..=" + pow);
		
		double sqrt=Math.sqrt(pow);
		System.out.println("sqrt value is..=" + sqrt);
		
//		double cqrt=Math.cqrt(pow);
//		System.out.println("max value is..=" + max);
		
		double abs=Math.abs(-26.5);
		System.out.println("abs value of -26.5 is..=" + abs);
		
		double sqrt1=Math.sqrt(0.0/0.0);
		System.out.println("sqrt value is..=" + sqrt1 + " ~ Note:\"Not a num\" ");
		
		// doc of machine learning ~ count power of deep learning like a twitter trend
		
		double idf=Math.log(100/8);
		System.out.println("Inverse Doc Frequency value is..=" + idf);
		
		
		
			
		
	}
}