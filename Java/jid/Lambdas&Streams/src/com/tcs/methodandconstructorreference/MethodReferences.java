package com.tcs.methodandconstructorreference;

 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferences{
	public static void main(String[] args) {
		
		String doc1 = "One of the most common uses of streams is to represent queries over data in collections";
		String doc2 = "Information integration systems provide valuable services to users by integrating information from a number of autonomous";
		String doc3 = "Solr is the popular, blazing fast open source enterprise search platform from the Apache Lucene";
		String doc4 = "Java 8 goes one more step ahead and has developed a streams API which lets us think about parallelism";
		
		List<String> documents = new ArrayList<>(Arrays.asList(doc1,doc2, doc3,doc4));
		
		List<String> targetDocuments = new ArrayList<>();
		
		for (String doc : documents) {
			boolean isTargetDoc = filter(doc, d -> d.contains("streams"));
			
			    
		    //BiFunction<String, String, Boolean> biFunction = (d, c) -> d.contains(c);
		    // (iii) Method References (ClassName::instanceMethod)
		    Function<String, Boolean> function = doc::contains;
		
		    BiFunction<String, String, Boolean> biFunction = String::contains;
		    if (function.apply("streams")) {
			//	System.out.println(documents);
			doc = transform(doc, Indexer1::removeStopwords);
			
		/*	Function<String, String> stopwordRemover = d -> Indexer1.removeStopwords(d);
			stopwordRemover.apply(doc); */
			// now incase of method ref we can pass like this below with delimiter ::
// Type:1	// Note:- in this case the method must be static Ex:- className::staticMethod
			Function<String, String> stopwordRemover1 = Indexer1::removeStopwords;
			stopwordRemover1.apply(doc);
		// 	System.out.println(doc);
			targetDocuments.add(doc);
		}
// Type:2	//targetDocuments.forEach(d -> System.out.println(d));
		targetDocuments.forEach(System.out::println);
		// here out is a refernec avriable and we can do method ref on this
		// Note:- in this case the method must be instance Ex:- className::instanceMethod
		
		for(String doc11: targetDocuments) {
			try {
				if (doc.length() > 80) {
					throw new Exception("Oversized Document!! ");
				}
				
			} catch (Exception e) {
				print(() -> e.getMessage() +  " ~ " + doc11 );
			}
		}
		}
	}

	
	static boolean filter(String doc, Predicate<String> filter) {
		return filter.test(doc);
	}
	
	static String transform(String doc, Function<String, String> transformer) {
		return transformer.apply(doc);
	}
	
	private static boolean errorFlag = true;
	public static void print(Supplier<String> supplier) {
		if(errorFlag) {
			System.out.println(supplier.get()); 
		}
	}
}

class Indexer1 {
	
	private static List<String> stopWords = Arrays.asList("of", "the", "a", "is", "to", "in", "and", "us");
	
	public static String removeStopwords(String doc) {
		
		StringBuilder sb = new StringBuilder();
		for (String word : doc.split(" ")) {
			if (!stopWords.contains(word))
				sb.append(word).append(" ");
		}
		
		return sb.toString();
	}	
	
}



