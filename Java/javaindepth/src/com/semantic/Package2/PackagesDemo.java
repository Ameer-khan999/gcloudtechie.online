package com.semantic.Package2;
import com.semantic.Package1.AccessingPackages;
 public class PackagesDemo {
	 public static void main(String... args) {
		 System.out.println("Hi Ameer !");
		 new com.semantic.Package1.AccessingPackages().foo();
	 }
 }