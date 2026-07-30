package com.tcs.myprograms;

import java.util.ArrayList;
import java.util.Scanner;

/*
Input Format
The first line of input consists of number of test cases, T

The first line of each test case consists of number of gifts Chantu Bantu have to buy, N

The second line of each test case consists of number of gifts available in the shop, G

The thirds line of each test case consists of G space-separated integers representing the price of G gifts where the first integer represents the price of first gift and so on.



Constraints
1<= T <=10

1<= G <=100000

1<= N <=G

0<= Price of Gift <=10000000



Output Format
For each test case, print the minimum amount of money Chantu Bantu has to pay to buy the N gifts.

Sample TestCase 1
Input
2
3
8
50 70 30 100 80 20 150 10
4
6
10 20 32 412 500 11*/


public class TechGig {
	
	public static int T;
	public static int G;
	public static int N;
	public static int priceOfGift;
	public static void calPrice() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter T value..=");
		int T=sc.nextInt();
		int i=0;
		while(i<T ) {
			System.out.println("Enter G value..=");
			int G=sc.nextInt();
			
			System.out.println("Enter N value..=");
			int N=sc.nextInt();
			
			System.out.println("Enter priceOfGift..=");
			int priceOfGift=sc.nextInt();
			
			int k=1;
			ArrayList<Integer> list1=new ArrayList<>();
			while(k<G) {
				
				list1.add(priceOfGift);
				k++;
				
			}
			System.out.println(list1);

			
				
			i++;
			
		}
		/*
		 * for(int j=1;j<=G;j++) {
		 * 
		 * ArrayList<Integer> list=new ArrayList<>(); int k=0; while(k<=G) {
		 * list.add(priceOfGift); k++; } System.out.println(list);
		 */
		
				
		//}
		/*
		 * System.out.println(T); System.out.println(G); System.out.println(N);
		 */
			
	}
	public static void main(String... args) {
		calPrice();
	}
}
