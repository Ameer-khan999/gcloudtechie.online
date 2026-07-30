package com.tcs.abstractclasses;

class X extends Xerox {
	
	String name;
	public X(String name) {
		super(name);
		//this.name=name;
	}
	@Override
	void c() {
		System.out.println("we");
		
	}
	
	public static void main(String[] args) {
		Xerox x = new X("Ameer");
		System.out.println(x.name);
		x.c();
	}

}
