package com.tcs.enums;
// Important
public class SpeicficTopicNestedClass {
	
	public enum EnumWithSpeicificConstantClassBody {
		BIOGRAPHY(12) { // genertaes SpeicficTopicNestedClass$EnumWithSpeicificConstantClassBody$1.class
			public boolean isKidFriendly(int age) {
				return age >= minAgeToRead;
			// we will get an error coz we discussed enum support only private but
			// in class body the variable needs to min default access and we can do in
			// this type of class body so please change private int minAgeToRead to public
				}
		}, // we can write in the body of enums and it is called as class body.
		HORROR(15) {
		public boolean isKidFriendly(int age) {
			return age >= minAgeToRead;
		}
		
		};
		
		public abstract boolean isKidFriendly(int age);
		// we need to add this to implement wherever we need otherwise will get an error
		// as isKidFriendly() method is not defined.
		
		private EnumWithSpeicificConstantClassBody(int minAgeToRead) {
			this.minAgeToRead=minAgeToRead;
		}
		
		protected int minAgeToRead; // we can use only public and protect and will get an
		// error if we use private and default
		public int getMinAgeToRead() {
			return minAgeToRead;
		}
	}

	public static void main(String[] args) {
		for(EnumWithSpeicificConstantClassBody bookGenre: EnumWithSpeicificConstantClassBody.values()) {
			System.out.print("name(): " + bookGenre.name().toString());
			System.out.println(",minAgeToRead: " + bookGenre.getMinAgeToRead());
			System.out.println(",isKidFriendly: " + bookGenre.isKidFriendly(14));
			// change isKidFriendly(14) value for better understanding
		}	
	}

}
