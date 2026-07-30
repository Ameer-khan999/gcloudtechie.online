package com.tcs.functional.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Practise {
	public static void main(String[] args) {
		List<College> dataCollege = new ArrayList<>();
		
		dataCollege.addAll(PractiseData.getFromSiddhartha('A'));
		dataCollege.addAll(PractiseData.getFromLoyola('A'));
		slice(dataCollege);
		
		Optional<Double> a = dataCollege.stream().map(r -> r.getMarks()).reduce(Double::min)
				;
		System.out.println("a: " + a.orElse(0.1));
	}
	public static void slice(List<College> dataCollege) {
		
		dataCollege.stream().filter(d -> d.getGrade() == 'C' ? true:false)
		.forEach(System.out::println); 
	}
	
	
}

class College {
	private int rollNumber;
	private String name;
	private String course;
	private double marks;
	private char grade;

	public College(int rollNumber, String name,String course, double marks, char grade) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.course=course;
		this.marks = marks;
		this.grade = grade;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public String getName() {
		return name;
	}
	
	public String getCourse() {
		return course;
	}

	public double getMarks() {
		return marks;
	}

	public char getGrade() {
		return grade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rollNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		College other = (College) obj;
		return rollNumber == other.rollNumber;
	}

	@Override
	public String toString() {
		return "College [rollNumber=" + rollNumber + ", name=" + name + ", course=" + course + ", marks=" + marks + ", grade=" + grade + "]";
	}		
}
