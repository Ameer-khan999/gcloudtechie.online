package com.tcs.pra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Student {
	private int num;
	private String name;
	
	
	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	


	static int n;
	public static void main(String[] args) {
		System.out.println("Enter a num..=");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		prdicateAndConsumer();
		
		Student s1 = new Student(19323,"Ameet");
		Student s2 = new Student(19345,"Khan");
		Student s3 = new Student(14959,"Anjali");
		Student s4 = new Student(84868,"Khas");
		
		List<Student> s5 = Arrays.asList(s1,s2,s3,s4);
		List<Student> data = new ArrayList<>();
		data.addAll(s5);
		System.out.println(data);
		
		List<String> c = data.stream().map(Student::getName).
				filter(name -> name.contains("K")).collect(Collectors.toList());
		System.out.println(c);
	}
	
	public static void prdicateAndConsumer() {
		Predicate<Integer> predicate = n -> n >= 12;
		//System.out.println(predicate.test(n));
		
	}
}
