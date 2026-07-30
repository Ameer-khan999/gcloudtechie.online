package com.tcs.hospitalmanagement;

public class Nurse extends Staff{
public Nurse(long staffId, int yearsOfExperience, String description, double salary) {
		super(staffId, yearsOfExperience, description, salary);
		// TODO Auto-generated constructor stub
	}

private long nurseId;
    
    public long getNurseId() {
        return nurseId;
    }
    
    public void setNurseId() {
        this.nurseId=nurseId;
    }
  
}
