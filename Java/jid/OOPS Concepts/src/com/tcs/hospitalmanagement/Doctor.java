package com.tcs.hospitalmanagement;

public class Doctor extends Staff {
	public Doctor(long staffId, int yearsOfExperience, String description, double salary) {
		super(staffId, yearsOfExperience, description, salary);
		// TODO Auto-generated constructor stub
	}

	private long doctorId;
    private String specialization;
    
    public long getDoctorId() {
        return doctorId;
    }
    
    public void setDoctorId() {
        this.doctorId=doctorId;
    }
    
    public String getSpecialization() {
        return specialization; 
    }
    
    public void setSpecialization() {
        this.specialization=specialization;
    }

}
