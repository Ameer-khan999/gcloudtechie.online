package com.tcs.trail;

import java.util.Scanner;

interface Abc {
	public String A(int b,int c);
}

public class Pallindrome<T> {
	
	public static void main(String[] args) {
		Abc a=(b,c) ->  /*System.out.println(*/c > b ? "Ameer" : "Khan";
		a.A(5,8);
		System.out.println("Haha");
	}
}
