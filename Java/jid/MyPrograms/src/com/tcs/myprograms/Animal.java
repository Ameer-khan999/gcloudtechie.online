package com.tcs.myprograms;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Animal {
	public void animalSound() {
		System.out.println("The Animals Makes a Sounds..");
		List<String> l = new LinkedList<>();
	    for(int i=1;i<5;i++) {
	    	Scanner sc=new Scanner(System.in);
	    	System.out.print("Enter items..=");
	    	String items=sc.next();
	    	l.add(items);
	    }
	    System.out.println(l.indexOf("Ameer"));
	}
	
	
	
	public static void main(String[] args) {
		Animal animal=new Animal();
		Animal sheep=new Sheep();
		Animal dog=new Dog();
		
		animal.animalSound();
		sheep.animalSound();
		dog.animalSound();
		
	}
}

class Sheep extends Animal {
	
	public void animalSound() {
		System.out.println("\nThe Sheep Makes a Sound Myaaaaa..");
	}
	 
}

class Dog extends Animal {
	
	public void animalSound() {
		System.out.println("\nThe Dog Makes a Sound Bow Bow..");
	}
	 
}




