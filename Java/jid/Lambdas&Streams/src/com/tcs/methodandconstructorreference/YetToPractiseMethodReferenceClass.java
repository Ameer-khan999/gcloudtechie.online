package com.tcs.methodandconstructorreference;

public class YetToPractiseMethodReferenceClass {
	public static String/* why not Data */ methodReference(Data a) {
		return a.getName();
	}
	
	public static void main(String[] args) {
		//methodReference("Ameer");
	}
}

class Data {
	private String name;
	
	public String getName() {
		return name;
	}
}