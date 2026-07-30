package tcs.com.datastructures;




public class BookFlight {
	private String firstName;
	private String lastName;
	
	public void bookFlight(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		
		System.out.println(firstName);
		System.out.println(lastName);

	}
	
	public String getFirstName() {
		
		System.out.println("Hi " + firstName);
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
}

