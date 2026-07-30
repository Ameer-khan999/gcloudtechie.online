package com.tcs.exceptionhandlings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Checking {
	
	static int index;
	static Integer indx=5;

	public static void checking(int index) throws ArrayIndexOutOfBoundsException,InputMismatchException {
		
		int[] item= {1,2,3,4,5,6}; 
		try {
			if (index<item.length) {
				System.out.println(item[index-1]);
			} else if (index > item.length) {
				throw new ArrayIndexOutOfBoundsException();
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("\nplease,Enter a number below or equal to "+ item.length);
		} finally {
			System.out.println("\nEnd of Method..");
		}
	}
	public static void main(String[] args) {
		// checking(index);
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter index..=");
		int index=sc.nextInt();
		try {
			if(isNumeric(index)==true) {
				System.out.println("I succeed");
			} else {
				throw new InputMismatchException();
			}
		}  catch (InputMismatchException e) {
			System.out.println("Please enter a number");
		}finally {
			System.out.println("Idea is wrong..");
		}
		
		
		checking(index);
		
		
	}
	private static boolean isNumeric(Integer indx2) {
		// TODO Auto-generated method stub
		return true;
	}

}
