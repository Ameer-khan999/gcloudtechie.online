package com.tx.practise;

public class Address {
	
	private String address;

	public Address(String address) {
		this.address= address;
	}
	
	public String getAddress() {
		return address;
	}
	/*public static void main(String[] args) {
		Address address = new Address("10-244");
		//System.out.println(address.getAddress());
	} */
	
	public String toString() {
		return " " + getAddress();
	}

}
