package com.spiders.package1;

public class FirstClass {
	private int privateVariable = 10;
	int defaultVariable = 20;
	public int publicVariable = 30;
	
	public int getPrivateVariable() {
		System.out.println("privateVariable from FisrtClass: " + privateVariable);
		return privateVariable;
	} // always create getter and setter methods for private variables.
	  // this is called information hiding priniciples
	
	public static void main(String[] args) {
		FirstClass fc = new FirstClass();
		fc.getPrivateVariable();
	}
}
