package com.tcs.abstractclasses;

public class AbstractSubClassConstructor extends AbstractSuperClassConstructor {


	public AbstractSubClassConstructor(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	//	AbstractSuperClassConstructor a= new AbstractSubClassConstructor(); // we cannot
		AbstractSuperClassConstructor a= new AbstractSubClassConstructor(name);
		System.out.println("SubClassConstructor: " +a.name);
	}

}

/**
 * Reference from java in depth. Note on Abstract Classes & Constructors:-
 * A minor detail that was missed in the previous lecture was that an abstract class 
 * can also have a constructor, i.e., you can add a constructor. However, this 
 * constructor will ONLY be accessible from a subclass constructor as it is not possible 
 * to instantiate an abstract class. You cannot even instantiate an abstract class from 
 * within that same class. Also, note that if we do not include a constructor in an 
 * abstract class (which is the typical case), then compiler inserts a no-arg 
 * constructor implicitly just like in the case of a normal class. And this implicitly 
 * created constructor will also be invoked from the subclass as part of constructor 
 * chaining process and this constructor will in turn invoke the super class constructor,
 *  i.e., includes a super(). So, nothing is different from the regular super class & 
 *  subclass scenario. Only thing is you cannot directly instantiate abstract class. 
 *  Thanks.
 */
