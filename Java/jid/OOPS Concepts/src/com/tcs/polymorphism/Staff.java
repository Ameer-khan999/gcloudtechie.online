package com.tcs.polymorphism;

public class Staff extends User {
	public static int id=2;
	public void getId() {
		System.out.println("id: " + id);
		System.out.println("super.id: " + super.id);
	}

	public /* static */ void printUserType() { // we cannot use super keyword in static
	// we cannot override printUserType() from User class if they declares that method as static.
		super.printUserType();
		System.out.println("Staff\n");
	}
	
	/*
	 * public void postAReview() { System.out.println("Staff: postAReview\n"); }
	 */
	
	public Review postAReview(String reviewText) {
		
		System.out.println("Staff : postAReview");
		Review review=super.postAReview(reviewText);
		review.setApproved(true);
		return review;
		//return new Review(reviewText);
		
	}
	
	// we cannot use super in static methods

	public void staticMethod() {
		super.postAReview("static method");
	}
	
	/*
	 * public static void staticMethod() { super.postAReview("static method"); }
	 */ // we cannot use in static content.
	 
	// Method binding concept
	public void instanceMethod(int d) {
		System.out.println("method binding concept");
		System.out.println("Staff int: instnaceMethod\n");
	}
	
	public void instanceMethod(Staff s) {
		System.out.println("method binding concept");
		System.out.println("Staff Staff: instnaceMethod\n");
	}
	
	// public void finalMethod() {} 
	// we cannot override final methods that is already declared in User class.
	
	public static void staticMethod(int ex) {
		System.out.println("Staff ex: staticMethod");
	}
	
	public /*void Staff1()*/ Staff() {
		userType="Staff";
	}
	// if we use Staff constructor we will get userType="Staff" from Staff class
	// if we use void method like Staff1 we will get usertype="User" from user class
	// so here Constructor is matters,try once by removing void and 1 as constructor.
	
	/*
	 * public void displayUserInfo() { System.out.println("\nprinting user Info");
	 * System.out.println("id: " + id); System.out.println("userType: " + userType);
	 * 
	 * 
	 * }
	 */
	
}	


