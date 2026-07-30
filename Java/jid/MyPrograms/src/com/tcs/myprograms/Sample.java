package com.tcs.myprograms;

import java.util.ArrayList;
import java.util.Scanner;

public class Sample {
	public static String time11;
	public static String time22;
	public static String time3;
	
	public static void calTime(String time1,String time2) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter first time..=");
		String time11=sc.nextLine();
		System.out.print("Enter second time..=");
		String time22=sc.nextLine();
		String time3=time11+" "+ time22;
		//System.out.println(time3);
		String[] item=time3.split(" ");
		int item1=Integer.parseInt("ABC"/*item[0]*/);
		int item2=Integer.parseInt(item[1]);
		int item3=Integer.parseInt(item[2]);
		int item4=Integer.parseInt(item[3]);
		int i1=item1+item3;
		int i2=item2+item4;
		if (i1>24 && i2>60) {
			i1=(i1-24)+1;
			i2=i2-60;
			System.out.println("The Time is: " + i1+":"+i2);
		} else if(i1<24 && i2<60) {
			System.out.println("The Time is: " + i1+":"+i2);
		} else if (i1>24 && i2<60) {
			i1=(i1-24);
			System.out.println("The Time is: " + i1+":"+i2);
		} else if (i1<24 && i2>60) {
			i1=(i1+1);
			i2=i2-60;
			System.out.println("The Time is: " + i1+":"+i2);
		}
		//System.out.println(i1+":"+i2);
//		System.out.println(item2);
//		System.out.println(item3);
//		System.out.println(item4);
		
	}
	public static void main(String... args) {
		
		calTime(time11,time22);
	}
	
}