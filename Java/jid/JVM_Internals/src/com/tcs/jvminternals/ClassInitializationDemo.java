/*
 * package com.tcs.jvminternals;
 * 
 * class Superclass { Superclass() {
 * System.out.println("Superclass: constructor"); } }
 * 
 * class Subclass extends Superclass { static final int STATIC_FINAL = 47; //
 * compile-time constant static final int STATIC_FINAL2 = (int) (Math.random() *
 * 5); static { System.out.println("Subclass: static initializer"); } Subclass()
 * { System.out.println("Subclass: constructor"); } }
 * 
 * public class ClassInitializationDemo { static {
 * System.out.println("ClassInitializationDemo: static initializer"); } {
 * System.out.println("ClassInitializationDemo: instance initializer"); } public
 * static void main(String[] args) { System.out.println("Subclass.STATIC_FINAL:"
 * + Subclass.STATIC_FINAL); System.out.println("Subclass.STATIC_FINAL2:" +
 * Subclass.STATIC_FINAL2); // new Superclass(); new Subclass(); } }
 */