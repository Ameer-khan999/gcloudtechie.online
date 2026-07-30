package com.tcs.functional.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MutableReductionsWithCollections {

	public static void main(String[] args) {
		mutableReduction();
		overloadedReductions();
	}
	
	// if accumulator mutates, use collect(). Otherwise, use reduce()
		private static void mutableReduction() {
			System.out.println("mutableReduction... ");
			String[] grades = {"A", "A", "B"};
			
			StringBuilder concat2 = Arrays.stream(grades).parallel()
					.collect(() -> new StringBuilder(), // supplier need to pass lamda
														// or method ref definitely.Note
							(sb, s) -> sb.append(s),
							(sb1, sb2) -> sb1.append(sb2));
			System.out.println("concat2: " + concat2);
			
			// Collectors is a class and it is going to useful in future too
			String concatWithJoining = Arrays.stream(grades).parallel()
					.collect(Collectors.joining());
			System.out.println("concatWithJoining: " + concatWithJoining);
		}
		
		static void overloadedReductions() {
			System.out.println("\noverloadedReductions... ");
			
			String[] grades = {"A", "A", "B"};
			
			String concat1 = Arrays.stream(grades)
				.reduce("", (s1, s2) -> s1 + s2);
			System.out.println("concat1: " + concat1);
			
			StringBuilder concat2 = Arrays.stream(grades).parallel()
			.reduce(new StringBuilder(), 
					(sb, s) -> sb.append(s),
					(sb1, sb2) -> sb1.append(sb2));
					//null); // never use null in both
			System.out.println("Testing with parallel concat2: " + concat2);
			
			
			// Not efficient: Each accumulation step creates a new StringBuilder
			StringBuilder concat3 = Arrays.stream(grades).parallel()
					.reduce(new StringBuilder(), 
							(sb, s) -> new StringBuilder().append(sb).append(s),
							(sb1, sb2) -> sb1.append(sb2));						
					System.out.println("concat3: " + concat3);
									
		}
}

/* Note Points:- 
  1.whenever you works on streams test with both sequential stream() and 
  parallel stream() coz output might vary with both, if another person in future made
  change and he will end up with an inefficeint results that why always check with both 
  streams and as we know parallel uses multi core means two segments and sequential uses 
  one
   
   2.dont use reduce if you have accumulator diff types of params recommended is collect..
   
   3.use collect methods and joining 
 */
