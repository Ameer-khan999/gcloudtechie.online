package tcs.com.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Malik {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your employee number:");
		int c = sc.nextInt();
		int a[] = new int[3];
		a[0]=1;
		a[1]=2;
		a[2]=3;
		//System.out.println(a[0]);
		
		List<Integer> b = new ArrayList<>();
		b.add(2296078);
		b.add(2018440);
		b.add(397756);
		b.add(4);
		
		//System.out.println(b.get(3));
		for(Integer object : b) {
			if(object==c) {
				System.out.println("User found");
			} else {
				System.out.println("User not found");
			}
			//System.out.println(object);
		}
	}
}
