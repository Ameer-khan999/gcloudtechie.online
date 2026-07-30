package com.tcs.frescoplay.fp.lambda;

import java.io.*;

import java.util.*;

class Employee
{
    //Create the Constructor here
    String name;
    int  id;
    int age;
    
    public Employee(String name,int id,int age) {
        this.name=name;
        this.id=id;
        this.age=age;
    } 
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public int getAge() {
        return age;
    }
}

class SortEmployees 
{
    // our logic
    void sortEmployees(ArrayList<Employee> empList) 
    {
        empList.sort((o1,o2) -> o1.getName().compareTo(o2.getName()));
        for (Employee employee : empList) {
            System.out.println(employee.getName() +" " + employee.getId() + " " + employee.getAge());
        }
    }
}

public class SortEmployeesMain

{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Employee> empList=new ArrayList<>();
		
		 int n=Integer.parseInt(br.readLine().trim());
		 for(int i=0;i<n;i++)
		 {
			 String inp=br.readLine();
	         String inparr[]=inp.split(" ");
			 
			 Employee ws=new Employee(inparr[0],Integer.parseInt(inparr[1]), Integer.parseInt(inparr[2]));
			 empList.add(ws);
		 }
		
		SortEmployees s1=new SortEmployees();
		s1.sortEmployees(empList);
    }
}
