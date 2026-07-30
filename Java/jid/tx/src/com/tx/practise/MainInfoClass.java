package com.tx.practise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainInfoClass {

	public static void main(String[] args) {
		Employee employee1 = new Employee("Ameer","Khan",40000);
		Employee employee2 = new Employee("Sameer","Khan",50000);
		Employee employee3 = new Employee("Rafi","Khan",60000);
		Employee employee4 = new Employee("Karimulla","Khan",70000);
		Employee employee5 = new Employee("Irfan","Khan",80000);
		Employee employee6 = new Employee("Burhan","Khan",20000);
		Employee employee7 = new Employee("Raza","Khan",30000);
		
		Address address1 = new Address("10-244, Vuyyuru");
		Address address2 = new Address("1-23, Nidamanuru");
		Address address3 = new Address("34-56, Pedana");
		
		
		Map<Employee,Address> list = new LinkedHashMap<>();
		list.put(employee1,address1);
		list.put(employee2,address1);
		list.put(employee3,address2);
		list.put(employee4,address1);
		list.put(employee5,address3);
		list.put(employee6,address2);
		list.put(employee7,address3); 
		
	/*	List<Employee> list = new ArrayList<>();
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);
		list.add(employee4);
		list.add(employee5);
		list.add(employee6);
		list.add(employee7); */
		
	//	List<String> s = list.stream()
		//		.filter(f -> f.getSalary() >30000).map(f -> f.getFirstName()).collect(Collectors.toList());
		
		
		System.out.println(list);
	}

}
