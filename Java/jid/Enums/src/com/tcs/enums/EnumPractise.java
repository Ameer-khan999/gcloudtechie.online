package com.tcs.enums;

// Behaviour is identical across all constants.
public enum EnumPractise {
	MALE(0),
	FEMALE(1),
	TRANSGENDER(2);
	
	private EnumPractise(int sex) { // accepts only private
		this.sex=sex;
	}
	
	private int sex; // state
	
	public int getSex() { // behaviour
		return sex;
	}
	
	public static void main(String[] args) {
		EnumPractise[]  e= EnumPractise.values();
		System.out.println(e.length);
		
		for(EnumPractise e1: EnumPractise .values()) {
			System.out.println(e1.name() + "=" + e1.getSex());
		}
	}
}
