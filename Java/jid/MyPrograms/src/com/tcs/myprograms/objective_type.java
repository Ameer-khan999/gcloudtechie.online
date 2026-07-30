package com.tcs.myprograms;

import java.util.Scanner;

public class objective_type  {
	
	private String gender;
	
	public void setGender() throws /*IllegalArgumentException*/ NullPointerException  {
		try {
			if(gender.equals("male") || gender.equals("female") || gender.equals("transgender")) {
				this.gender=gender;
				System.out.println("The gender is" + gender);
			}
				
		} catch(/*IllegalArgumentException*/NullPointerException e) {
			System.out.println("OOPS ! You are passed Null Value");
		}
			//throw new IllegalArgumentException("Wrong gender");
	}
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			int i = 0,j=0;
			 int num = 0,num1=0;
			while(i<4) {
				num=(++i * 5);
				System.out.println(i);
			
			}
			System.out.println(num);
		 while(j<4) {
			num1=(j++ * 5);
			System.out.println(j);
		 } System.out.println(num1);
		
		}
		
		finally {
			System.out.println("ClassNotFoundException");
		}
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your gender..=");
	String gender=sc.next();
	objective_type ot=new objective_type();
	ot.setGender();
	}

}
