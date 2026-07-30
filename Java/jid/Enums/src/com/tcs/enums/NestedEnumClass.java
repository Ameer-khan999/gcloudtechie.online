package com.tcs.enums;

public class NestedEnumClass {
	public enum NestedEnum {
		BIOGRAPHY,
		HORROR;
	}
	
	public static void main(String[] args) {
		for(NestedEnum bookGenre : NestedEnum.values()) {
			System.out.println(bookGenre);
			System.out.println(bookGenre.ordinal());
			System.out.println(bookGenre.getDeclaringClass());
			System.out.println(bookGenre.getClass());
		}
	}
}
