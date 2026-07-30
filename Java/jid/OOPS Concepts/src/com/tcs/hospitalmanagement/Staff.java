package com.tcs.hospitalmanagement;

public class Staff /* extends User */ {

	private long staffId;
    private int yearsOfExperience;
    private String description;
    private double salary;
    
    public Staff(long staffId,int yearsOfExperience, String description, double salary) {
		this.staffId = staffId;
		this.yearsOfExperience = yearsOfExperience;
		this.description = description;
		this.salary = salary;
	}

	public long getStaffId() {
        return staffId;
    }
    
    public void setStaffId() {
        this.staffId=staffId;
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience() {
        this.yearsOfExperience=yearsOfExperience;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription() {
        this.description=description;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary() {
        this.salary=salary;
    }
    
    public static void main(String[] args) {
		
	}

}
