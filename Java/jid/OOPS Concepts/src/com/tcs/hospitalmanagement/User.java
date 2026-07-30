package com.tcs.hospitalmanagement;

public class User {
    
	private long id;
	private String firstName,lastName,gender,email;
	// add rest of the variables
	
	public User(long id, String firstName, String lastName, String gender , String email) {
		this.id=id;
	    this.firstName=firstName;
	    this.lastName=lastName;
	    this.gender=gender;
	    this.email=email;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
	    return firstName;
	}
	
	public void setFirstName() {
	    this.firstName=firstName;
	}
	
	public String getLastName() {
	    return lastName;
	}
	
	public void setLastName() {
	    this.lastName=lastName;
	}
	
	public String getGender() {
	    return gender;
	}
	
	public void setGender() {
	    this.gender=gender;
	}
	
	public String getEmail() {
	    return email;
	}
	
	public void setEmail() {
	    this.email=email;
	}
	
	
	
	
	// add rest of the getters & setters
	
}