package com.tcs;

public class MathDemo1 {
	public static void main(String... args) {
		mathDemo();
	}

	private static void mathDemo() {
		// TODO Auto-generated method stub
		//lottery [1,100]
		double random = Math.random(); // [0.0,1.0)
		int winner = (int) (random*100) + 1;
		
		System.out.println(random);
		System.out.println(winner);
		
	}
}