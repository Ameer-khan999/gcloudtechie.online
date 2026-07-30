package com.tcs.nestedclasses;

public class ScopeOf_LocalVariables {
	public int count=0;
	
	public int scopeOfLocalVariable(int count) {
	//	private int count; Invalid
	//	this.count=count; // 10
	//	count = this.count; // 10
	//	return count; // 10
		return this.count; // 0
	}
	
	public static class Hi {
		private int count=0; // we can shadow local variables in nested classes
		public int h=0;
		public int x=0,z=0;
		/*
		 * if (x==0) { int x= count; x++; }
		 */
		
	}
	
	public static void main(String[] args) {
		ScopeOf_LocalVariables solv=new ScopeOf_LocalVariables();
		int a=solv.scopeOfLocalVariable(10);
		System.out.println(a);
	}
}
