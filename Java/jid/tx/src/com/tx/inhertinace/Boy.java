package com.tx.inhertinace;

public class Boy implements Mother {

	@Override
	public void mother() {
		System.out.println("we need to impment mother from Boy class");
	}

	@Override
	public void c() {
		System.out.println("we need to impment c from Boy class");
	}

}
