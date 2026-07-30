package com.tx.crud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Student implements StudentInterface {
	
	private  int rollNo;
	private  String name;
	private  long phoneNumber;
	
	public int getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public Student(int rollNo,String name,long phoneNumber) {
		this.rollNo=rollNo;
		this.name=name;
		this.phoneNumber=phoneNumber;
	}
	
	public Student() {
		
	}
	
	
	
	public static void main(String[] args) {
		List<Student> student = new ArrayList<>();
		
		//Student student1 = new Student(rollNo,name,phoneNumber);
		//student.add(student1);
		
		Student s = new Student();
		s.createStudent();
		student.add(s);
		System.out.println(student);
		
		try {
			System.out.println("Hi " + student.get(0).getRollNo() + " your roll is: "
					+ student.get(1).getName() + " and phone number is: " 
					+ student.get(0).getPhoneNumber());
		} catch(Exception e) {
			System.out.println("Something gone :)");
		}
		
	}
	
	@Override
	public void createStudent() {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Please enter your roll number:\t");
			rollNo = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter a number");
		}
		
		try {
			System.out.println("Please enter your name:\t");
			name = sc.next();
		} catch (Exception e) {
			System.out.println("Please enter a string");
		}
		
		try {
			System.out.println("Please enter your phone number:\t");
			phoneNumber = sc.nextLong();
			
		} catch (Exception e) {
			System.out.println("Please enter a number");
		}
		
		System.out.println("Student Created: " + name);
	}
	
	@Override
	public void deleteStudent(int indexNo) {
		// TODO Auto-generated method stub
		
	}
}
