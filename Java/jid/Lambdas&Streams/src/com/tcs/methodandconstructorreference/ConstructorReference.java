package com.tcs.methodandconstructorreference;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
interface Hi<String,String1> {
	void c();
}
public class ConstructorReference {

	public static void main(String[] args) {
		Supplier<String> supplier= String::new; // new String(); returns empty object
		System.out.println("supplier.get: Note:-" +" \" It prints an empty string coz it does not have any value\""
				+ " " + supplier.get());
		
		Function<Integer,Integer> functionInt = Integer::new;// s -> new String(s);
		// takes input as int and returns input in int  Note:- both types must be same
		System.out.println("functionInt: " + functionInt.apply(3));
		
		Function<String,String> functionString = String::new; // s -> new String(s); 
		// takes input as string and returns input in string
		System.out.println("functionString: " + functionString.apply("Ameer"));
		// Here compiler knows to invoke which based on target type
		
		BiFunction<Integer,Float,HashMap<Integer,Float>> biFunction = HashMap<Integer,Float>::new;
		BiFunction<Integer,Float,HashMap> biFunction1 = HashMap::new;
		System.out.println("biFunction: " + biFunction.apply(100,0.75f)); //(c, lf) -> new HashMap(c, lf);
		System.out.println(biFunction);
		// here Integer and Float are input types and returns HashMap, compiler knows this thing and 
		// we know compiler is our best friend it helps us in every situation hehe
		
		Consumer<String> consumer = String::new;
	//	System.out.println("consumer: " + consumer.accept("java")); we cannot print for this argu
		consumer.accept("Java");
		//Note:- if there is nothing to return( if method is void ) than using constructor 
		// reference is waste and not recommended in that case.
		//Ex:-Consumer is void type it does not return anything,so above consumer is waste

		// Create own interface if existing functional interfaces are not useful!
		
		
	/*	ConstructorReference c= ConstructorReference::new;
		Hi<String,String> h=  */
		
	}

}


@FunctionalInterface
interface TriFunction<S, U, V, R> {
	S apply(S s, U u, V v); // remeber this catch u later
}
