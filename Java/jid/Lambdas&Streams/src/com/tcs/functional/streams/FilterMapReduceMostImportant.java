package com.tcs.functional.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterMapReduceMostImportant {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		
		// sumWithMethodRef
		int sumWithMethodRef = numbers.stream().reduce(0, Integer::sum);
		System.out.println("sumWithMethodRef: " + sumWithMethodRef);
		
		// sumWithMethodRefWithOptional
		Optional<Integer> sumWithMethodRefWithOptional = numbers.stream().reduce(Integer::sum);
		System.out.println("sumWithMethodRefWithOptional: " + sumWithMethodRefWithOptional.get());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number..=");
		int n = sc.nextInt();
		List<Integer> num = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			num.add(i);
		}
		
		List<Integer> sum = num;
		// sum type 1
		Integer summingIntegers = numbers.stream().mapToInt(i->i).sum();
		System.out.println("Sum Type1 on number variable: " + summingIntegers);
		
		// Sum Type 2
		Integer summingIntegers1 = sum.stream().mapToInt(i->i).reduce(0,(a,b) -> a+b);
		System.out.println("Sum Type2 on sum variable: " + summingIntegers1);
		
		// Sum Type 3
		OptionalInt summingIntegers2 = numbers.stream().mapToInt(i->i).reduce((a,b) -> a+b);
		System.out.println("Sum Type3: " + summingIntegers2);
		
		//Sum Type 4
		Optional summingIntegers3 = Optional.empty();
		System.out.println("Sum Type4: " + summingIntegers3);
		
		// Sum Type 5
		Optional<Integer> summingIntegers4 = numbers.stream().map(i->i).reduce((a,b) -> a+b);
		System.out.println("Sum Type5: " + summingIntegers4);
		
		//  mul fact
		List<Integer> fact = num;
		int factorial = fact.stream().mapToInt(d -> d).reduce(1,(a,b) -> a*b);
		System.out.println("Factorial: " + factorial);
		
		// max 
		int minValue = numbers.stream().reduce(1, (a,b) -> a < b ? a:b);
		System.out.println("miValue: " + minValue);
		
		// max
		int maxValue = numbers.stream().reduce(1, (a,b) -> a > b ? a:b);
		System.out.println("maxalue: " + maxValue);

		
	}
	
	public static void primeOrNot(int n) {
		List<String> stringContainer = Arrays.asList("Ameer","Khan","Pathan");
		List<String> checkString = stringContainer.stream().collect(Collectors.toList());
		
	}

}
