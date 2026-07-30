package com.tcs.nestedclasses;

interface KhanInterface {
	String age(int age);
	default void innerClass() {
		
	}
}

public class AmeerClass implements KhanInterface {
	
	public int ameer() {
		return 5;
	}
	
	public KhanInterface iterator() { // iteraror is the instance member
	//	return new AmeerClass(); // will get super class method
		return new PathanNestedClass(); // will get nestedclass method
		// always create instance to nested class like this
	}
	
	private class PathanNestedClass implements KhanInterface {

		@Override
		public String age(int age) {
			// TODO Auto-generated method stub
			return age > 18 ? "Instance of PathanNestedClassTrue":"Instance of PathanNestedClassFalse";
		}
		
		public void innerClass() {
			System.out.println("from innerClass: " + this.age(21));
		}
	}
	

	public static void main(String[] args) {
		AmeerClass a=new AmeerClass();
		// a is an enclosing Object 
		
	//	PathanNestedClass k=new PathanNestedClass(); 
		// we cannot create Object to nested class
		KhanInterface k1=a.iterator(); // why this type ?
		// Brief:- we cannot create an instance or object directly to nested classes like
		// above *) line thats why we created iterator() method in super class and iterator
		// has PathanNestedClass instance and we are assing that to k1, now a is superclass
		// object reference and k1 is for nestedclass Object reference
		// 
		System.out.println(a.iterator());
		System.out.println("Type 1: a.iterator().age(30):- " + a.iterator().age(30));
		System.out.println("Type 2: k1.age(20):- " + k1.age(20));
		
	//	System.out.println(k.age(12)); throws error and neglet this
		System.out.println("Type 3: a.new PathanNestedClass().age(4):- " + 
				a.new PathanNestedClass().age(4));
		// No enclosing instance of type AmeerClass is accessible. Must qualify the 
		//allocation with an enclosing instance of type AmeerClass .
		//(e.g. x.new A() where x is an instance of AmeerClass).
		
//		Pathan p=new Pathan();
		System.out.println(a.ameer());
	//	System.out.println(AmeerClass.ameer());
		
		System.out.println(a.age(23));
		
		k1.innerClass();
		
		a.innerClass();
	}

	@Override
	public String age(int age1) {
		return "Instance of AmeerClass";
	}
	
	public void innerClass() {
		System.out.println("from outerClass: " + this.age(21));
	}
}

/* Clear Cut Info:- 
 	we cannot create an object to nested class for that we have to create an instance of 
 	inner class like n iterator,later we need to invoke with enclosing object means outer 
 	class Object, in this case that is a.
 */

/* What is Non static member class ?
A) Inner Class Object needs access to enclosing Object(a),that it can access instance
 members,so it has something to do with instance of enclosing Class and the inner class 
 Object cannot be even created unless the enclosing object is alreday created.so enclosing
 Object created first, and then it is used to create the inner class object.
 
 Inner class Object is simply instance member of an enclosed Object, just like an any
 instance member and hence we refer to the inner class a s non static member class.That is
 an instance member class
 
 Outer class is not GC if inner class is alive.
 
 One example is to use Inner class object is adapter.
 
 Adapters are used to produce  diff views of Outer Class object
 
 Ex:- Collection view Methods in Map Interface i.e., keySet(),entrySet() and values().
 
   For best refernce see MapDemo Class in DS Depth project. 
*/
