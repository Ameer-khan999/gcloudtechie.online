package com.tx.practise;

import java.util.ArrayList;
import java.util.List;

public class Employee{
	private String firstName;
	private String lastName;
	private long salary;
	
	public Employee(String firstName, String lastName, long salary) {
		this.firstName =firstName;
		this.lastName = lastName;
		this.salary=salary;
	}
	
	public Employee() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public long getSalary() {
		return salary;
	}
	
	
/*	public static void main(String[] args) {
		Employee employeeAmeer = new Employee("Ameer","Khan");
		
		List<Employee> l = new ArrayList<>();
		l.add(employeeAmeer);
		//System.out.println(employeeAmeer.getFirstName() + " " + employeeAmeer.getLastName());
	} */
	
	public String toString() {
		return getFirstName()+ " "+ getLastName() + ", "+ getSalary() +", ";
	}
}
