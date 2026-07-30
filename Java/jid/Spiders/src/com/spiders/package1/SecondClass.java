package com.spiders.package1;


public class SecondClass extends FirstClass  {
	
	
	public int retrivingDefaultVariable() {
		System.out.println("defaultVariable from SecondClass: " + defaultVariable);
		return defaultVariable;
	}
	 
	public static void main(String[] args) {
		
		SecondClass fc = new SecondClass();
		fc.retrivingDefaultVariable();
		 
		/*
		 * FirstClass fc = new FirstClass(); System.out.println(fc.defaultVariable);
		 */
		// System.out.println(FirstClass.getPrivateVariable());
		 System.out.print("The value: " + Manum.valueLevel());
	}
}
