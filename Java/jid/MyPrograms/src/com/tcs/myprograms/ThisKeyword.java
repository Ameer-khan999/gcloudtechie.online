package com.tcs.myprograms;

public class ThisKeyword<T> {
	private T rate;
	
	public T getRate() {
		return rate;
	}
	
	public void setRate(T rate) {
		this.rate=rate;
	}
	public void thisKeyword(int rate,int amount) {
		System.out.println("Interest rate: " + getRate());
	}

	public static void main(String[] args) {
		ThisKeyword<Integer> thiskeyword=new ThisKeyword<>();
		thiskeyword.setRate(12);
		thiskeyword.thisKeyword(10,200);
		//thiskeyword.setRate(12);

	}

}
