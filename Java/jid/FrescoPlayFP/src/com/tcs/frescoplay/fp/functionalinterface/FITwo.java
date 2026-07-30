package com.tcs.frescoplay.fp.functionalinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class FITwo {
	
	public static void eval() {
		List<Integer> l = Arrays.asList(1,2,3);
		for ( Integer k : l) {
			System.out.println(k);
		}
		
	}
	
	public static void s(String a) {
		
		Consumer<String> c = s -> System.out.println(a);
		c.accept(a);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		String input= null;
		System.out.print("Enter a number..=");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine().trim());
		/*
		 * for ( int i =0;i < n ;i++) { input = br.readLine().trim(); }
		 */
		
		System.out.println(n);	
		s("Ameer");
		eval();
		Supplier<Double> a1 = () -> Math.random();
		System.out.println(a1.get());
		
		int[] a= {1,2,3} ;
		int i=0;
		System.out.println(a[++i]);
		
	}

}
