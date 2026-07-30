package com.tcs.hospitalmanagement;

public class Patient extends User {
	public Patient(long id, String firstName, String lastName, String gender, String email) {
		super(id, firstName, lastName, gender, email);
	}
	private long patientId;
    private boolean isInsured;
    
    public long getPatientId() {
        return patientId;
    }
    
    public void setPatientId() {
        this.patientId=patientId;
    }
    
    public boolean getIsInsured() {
        return true;
    }
    
    public void setIsInsured() {
        this.isInsured=isInsured;
    	
    }
    private HealthInsurancePlan insurancePlan;
	   
	   public HealthInsurancePlan getInsurancePlan() {
	       return insurancePlan;
	   }
	   
	   public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
	       this.insurancePlan=insurancePlan;
	   }

}
