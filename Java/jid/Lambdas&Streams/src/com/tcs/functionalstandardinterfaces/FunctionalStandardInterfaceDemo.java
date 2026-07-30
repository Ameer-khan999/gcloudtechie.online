package com.tcs.functionalstandardinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalStandardInterfaceDemo {
	public static void main(String[] args) {
		
		String doc1 = "One of the most common uses of streams is to represent queries over data in collections";
		String doc2 = "Information integration systems provide valuable services to users by integrating information from a number of autonomous";
		String doc3 = "Solr is the popular, blazing fast open source enterprise search platform from the Apache Lucene";
		String doc4 = "Java 8 goes one more step ahead and has developed a streams API which lets us think about parallelism";
		
		List<String> documents = new ArrayList<>(Arrays.asList(doc1,doc2, doc3,doc4));
		
		List<String> targetDocuments = new ArrayList<>();
		
		for (String doc : documents) {
			boolean isTargetDoc = filter(doc, d -> d.contains("streams"));
			//	System.out.println(documents);
			doc = transform(doc, d -> Indexer1.removeStopwords(d));
			
			Function<String, String> stopwordRemover = d -> Indexer.removeStopwords(d);
			stopwordRemover.apply(doc);
		// 	System.out.println(doc);
			targetDocuments.add(doc);
		}
		targetDocuments.forEach(d -> System.out.println(d));
	// we know that Collection interface extends Iterator interface, in that we discussed
	// about forEach and forEach takes Consumer and it is calling action and action is going
	// to be perform on each of the elements in the list and we are passed lamda at the place 
	// of action as argument, so it would be the document
	// thats all about consumer and it has a single method called accept() and that logic is 
	//being provide here d -> System.out.println(d)
		
		for(String doc: targetDocuments) {
			System.out.println(doc.length());
			try {
				if (doc.length() > 100  ) {
					throw new Exception("Oversized Document!! ");
				} else if (doc.length() >= 80){
					throw new Exception("Not Oversized Document!!");
				} else {
					throw new Exception("Hm Got it..");
				}
				
			} catch (Exception e) {
				print(() -> e.getMessage() +  " ~ " + doc );
				// e.getMessage() prints the thrown Exception value as Oversized Document
				// In professional environment we have logging frameworks and we have to
				// learn logging frameworks too.
			}
		}
	}
	
		
		
	// Predicate<T> CoreStandardFunctional Interface and it has only single test() method
	// used to filter and returns value
	static boolean filter(String doc, Predicate<String> filter) {
		return filter.test(doc);
	}
	
	// Function<T> CoreStandardFunctional Interface and it has only single apply() method
	// used to remove something and returns value
	static String transform(String doc, Function<String, String> transformer) {
		return transformer.apply(doc);
	}
	
	private static boolean errorFlag = true;
	// Supplier<T> supplies something as output
	public static void print(Supplier<String> supplier) {
		if(errorFlag) {
			System.out.println(supplier.get()); // this prints the output
		}
	}
}

class Indexer1 {
	
	private static List<String> stopWords = Arrays.asList("of", "the", "a", "is", "to", "in", "and", "us");
	
	static String removeStopwords(String doc) {
		
		StringBuilder sb = new StringBuilder();
		for (String word : doc.split(" ")) {
			if (!stopWords.contains(word))
				sb.append(word).append(" ");
		}
		
		return sb.toString();
	}	
	
}
