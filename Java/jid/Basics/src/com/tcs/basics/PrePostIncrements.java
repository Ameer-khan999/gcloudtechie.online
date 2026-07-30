package com.tcs.basics;

public class PrePostIncrements {
	public static void main(String[] args) {
		int x=7,y =7;
		System.out.println("x: " + x + " y: " + y);
		 x = x++; // 7
		 y= ++y;  // 8
		// y = y--;
		System.out.println("x++: " + x); // 7
		System.out.println("++y: " + y); // 8
		
		x = ++x;
		y= y++;
	//	y = y+1;
		System.out.println("++x: " + x); // 8
		System.out.println("y++: " + y); // 8
		System.out.println("y+1: " + y); // 8
		
		System.out.println(8 << 2);    // 8^0 = 8, 8^1 = 16, 8^2 = 32
		System.out.println(8 >>> 4);  // 8^0 = 8, 8^1= 4, 8^2 =4 8^3 = 1, 8^4 = 0
		
		for(x=7; x < 15; x++) {
			System.out.println("loop: " + x);
		}
	}
}
