package com.tcs.polymorphism;

import java.lang.ProcessHandle.Info;

public class User {
	public int id=1000;
	public String userType="User";
	
	public /* static */void printUserType() { 
		// the instance method from Staff cannot override this method,
		// if we declare this method as static
		System.out.println("User Ameer calling by super keyword\n");
	}
	 
	
	public void saveWebLink() {
		System.out.println("User: saveWebLink\n");
		
		postAReview(" ");
		staticMethod(10);
	}
	
	/*
	 * public void postAReview() { System.out.println("User: postAReview\n"); }
	 */
	
	public Review postAReview(String reviewText) {
		System.out.println("User : postAReview");
		Review review=new Review(reviewText);
		return review;
	}
	
	//method binding concept
	public void instanceMethod(double d) {
		System.out.println("\n");
		System.out.println("METHOD BINDING CONCEPT");
		System.out.println("User double: instnaceMethod\n");
	}
	
	public void instanceMethod(User u) {
		System.out.println("\n");
		System.out.println("method binding concept");
		System.out.println("User User: instnaceMethod\n");
	}
	
	public final void finalMethod() {
		
	}
	
	public static void staticMethod(int ex) {
		System.out.println("User ex: staticMethod");
	}

	
	public void displayUserInfo() {
		System.out.println("\nprinting user Info");
		System.out.println("id: " + id);
		System.out.println("userType: " + userType);

	}
	 
	
}	
	
	

	


