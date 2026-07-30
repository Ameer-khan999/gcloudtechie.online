package com.tcs.enums;

public enum EnumWithSpeicificConstant {
	BIOGRAPHY(12),
	HORROR(15),
	ADULT(26);
	
	private EnumWithSpeicificConstant(int minAgeToRead) {
		this.minAgeToRead=minAgeToRead;
	}
	
	private int minAgeToRead;
	public int getMinAgeToRead() {
		return minAgeToRead;
	}
	
	public String isKidFriendly(int age) {
		switch(this) {
			case BIOGRAPHY : return age >= minAgeToRead ? "Yes" : "No";
			case HORROR : return age >= minAgeToRead ? "Yes" : "No";
			// we added ADULT constant than compulsorily we have to add ADULT case block 
			// here, remember otherwise will get null value	
		}
		
		return null;
		// throw new AssertionError(" Unknown operation: " + this);
	}
	
	public static void main(String[] args) {
		for(EnumWithSpeicificConstant bookGenre: EnumWithSpeicificConstant.values()) {
			System.out.print("name(): " + bookGenre.name().toString());
			System.out.println(",minAgeToRead: " + bookGenre.getMinAgeToRead());
			System.out.println(",isKidFriendly: " + bookGenre.isKidFriendly(16));
		}	
	}
}
