package myprograms1;

import java.util.Scanner;

public class Keyword<T> { // this is a class
	private T am;
	private T rate;
	
	public T getRate() {
		return rate;
	}
	
	public void setRate(T rate) {
		this.rate=rate;
	} // Encapsulation = combining of method + variable
	// it is Information hiding principle, by wrappering up date by creating settrrs and getters
	
	
	public void keyword(int rate,int amount) { // parameterized method
		System.out.println("Interest rate: "+ getRate());
	}
	
	public static void main(String[] args) {
		Keyword<Object> k=new Keyword<>();
		k.setRate("Hi");
		k.keyword(10,10000);
		
	}
}
