package com.tcs.oop.p2;

import com.tcs.oop.p1.A1;

public class C2 extends A1 {
	public static void main(String[] args) {
		 //System.out.println("privateMember: " + privateMember);
		 //System.out.println("defualtMember: " + defualtMember);
		//We cannot call default from another package
		 System.out.println("protectedMember: " + protectedMember);
		 System.out.println("publicMember: " + publicMember);
		 
	}
	
}
