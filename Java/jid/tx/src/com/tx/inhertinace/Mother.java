package com.tx.inhertinace;

public interface Mother {
	public void mother(); 
	
	public void c();
	
	default void d() {
		System.out.println("Default from Mother Interface");
	}
}
