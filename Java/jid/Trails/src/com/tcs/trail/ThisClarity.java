package com.tcs.trail;

public class ThisClarity {
	ThisClarity i;
	public static String number() {
		return "Hi";
	}
	
	public  ThisClarity toDouble() {
		return this.i;
	}
	
	public static void main(String[] args) {
		ThisClarity t = new ThisClarity();
		System.out.println(t.toDouble());
		System.out.println(ThisClarity.number());
	}
}
