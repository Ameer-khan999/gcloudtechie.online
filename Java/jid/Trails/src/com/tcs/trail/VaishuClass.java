package com.tcs.trail;

public class VaishuClass extends DivyaClass implements AmeerInterface,SiriInterface  {
	 
	public static void main(String[] args) {
		DivyaClass dd= new VaishuClass();
		dd.divyaClass();
		((VaishuClass) dd).ameerInterface();
	}

	public void ameerInterface() {
		// TODO Auto-generated method stub
		System.out.println("ameerinterface");
	}
	
	
 
}
