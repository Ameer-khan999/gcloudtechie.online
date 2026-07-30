package com.tx.crud;

public interface StudentInterface {
	
	public void createStudent();
	
	public default Student readStudent() {
		return new Student();
	}
	
	public default Student updateStudent(int indexNo) {
		return new Student();
	}
	
	public void deleteStudent(int indexNo);
	
}
