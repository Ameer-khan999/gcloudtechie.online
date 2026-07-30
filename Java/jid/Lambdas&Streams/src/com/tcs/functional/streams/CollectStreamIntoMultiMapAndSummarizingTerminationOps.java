package com.tcs.functional.streams;

import com.tcs.functional.streams.DataExtractionSlice;
import com.tcs.functional.streams.SlicingStream.Book;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.tcs.functional.streams.CollectStreamIntoMapGroupingByTerminationOps;

public class CollectStreamIntoMultiMapAndSummarizingTerminationOps {
	public static void main(String[] args) {
		List<Book> books= new ArrayList<>();
		books.addAll(DataExtractionSlice.getFromAmazon("Java"));
		books.addAll(DataExtractionSlice.getFromBarnesAndNoble("Java"));
		collectToMap(books);
	}

	private static void collectToMap(List<Book> books) {
		// toMap() is mainly useful to generate output in simple key,value pairs where we
		// are not expecting any collision with the keys.
		Map<Long,Book> mapSorted = books.stream()
		.collect(toMap(Book::getISBN,Function.identity(),
				(b1,b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2,
		() -> new TreeMap()));

		for(Entry<Long, Book> entry : mapSorted.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		// 1st version takes List default
		System.out.println("\nUsing List..");
		Map<Double, List<Book>> ratingsInList = mapSorted.values().stream()
				.collect(groupingBy(Book::getRating));
		for(Entry<Double, List<Book>> entry : ratingsInList.entrySet()) {
			System.out.println("Key: " + entry.getKey());
			System.out.println("Value: " + entry.getValue());
		}
		
		// 2nd version overloaded gropingBy( 3 params) we need to pass accumulator toSet(),
		// in order to get value in Set but not in asc.
		System.out.println("\nUsingSet..");
		Map<Double, Set<Book>> ratingsInSet = mapSorted.values().stream()
				.collect(groupingBy(Book::getPrice,toSet()));
		for(Entry<Double, Set<Book>> entry : ratingsInSet.entrySet()) {
			System.out.println("Key: " + entry.getKey());
			for ( Book b : entry.getValue()) {
				System.out.println(b);
			}
			// System.out.println("Value: " + "\n" + entry.getValue());
		}
		
		// 3rd version overloaded groupingBy( 3 params) and we need o/p in asc.
		System.out.println("\nUsingSet and TreeMap is USed in order to get value in asc..");
		Map<Double, Set<Book>> ratingsInTreeMap = mapSorted.values().stream()
				.collect(groupingBy(Book::getRating,TreeMap::new,toSet()));
		for(Entry<Double, Set<Book>> entry : ratingsInTreeMap.entrySet()) {
			System.out.println("Key: " + entry.getKey());
			System.out.println("Value: " + entry.getValue().size());
		}
		
		// 4th version of overloaded to do Multi-Level mapping( Map of Map)
		Map<Double,Map<Double,List<Object>>> multiLevelMap = mapSorted.values().stream()
				.collect(groupingBy(Book::getRating,groupingBy(Book::getPrice,toList())));
		System.out.println("\nmultiLevelMap: " + multiLevelMap);
		
		// Nowfocussing on summarizing values like avg,max,min and count etc..
		
		System.out.println("\nCounting..");
		Map<Double, Long> ratingsCount = mapSorted.values().stream()
				.collect(groupingBy(Book::getRating,TreeMap::new,Collectors.counting()));
		System.out.println("Counting By Rating..: " + ratingsCount);
		
		System.out.println("Counting Books: " 
				+ mapSorted.values().stream().collect(Collectors.counting()));
		// we counted directly 
		
		// average
		System.out.println("\nAveraging..");
		Map<Double, Double> ratingsAvgPrice = mapSorted.values().stream()
				.collect(groupingBy(Book::getRating,TreeMap::new,Collectors.averagingDouble(Book::getPrice)));
		System.out.println("ratingsAvgPrice..: " + ratingsAvgPrice);
		
		// minimum
		System.out.println("\nMinim Price of Book among rating..");
		Map<Double, Optional<Book>> ratingsMinPrice = mapSorted.values().stream()
				.collect(groupingBy(Book::getRating,TreeMap::new,Collectors.minBy(Comparator.comparingDouble(Book::getPrice))));
		System.out.println(" ratingsMinPrice ..: " + ratingsMinPrice );
		// it takes Optional
		
		// summarizing
		System.out.println("\nMinim Price of Book among rating..");
		Map<Double, DoubleSummaryStatistics> summarizingPrice = mapSorted.values().stream()
				.collect(groupingBy(Book::getRating,TreeMap::new,Collectors.summarizingDouble(Book::getPrice)));
		System.out.println(" DoubleSummaryStatistics ..: " + summarizingPrice );
		
	/*	System.out.println("\npartitioning with rating using predicate..");
		Map<Double, Map<Boolean, List<Book>>> PartitionedMap = mapSorted.values().stream()
				.collect(groupingBy(Book::getRating,TreeMap::new,Collectors.partitioningBy( b -> b.getRating() >= 4.5)));
		System.out.println("PartitionedMap..: " + PartitionedMap ); */
		
		// partitioning
		System.out.println("\npartitioning with rating using predicate..");
		Map<Boolean, List<Book>> PartitionedMap = mapSorted.values().stream()
				.collect(Collectors.partitioningBy( b -> b.getRating() >= 4.5));
		System.out.println("PartitionedMap..: " + PartitionedMap );
		
		// grouping by rating and collecting prices into List
		Map<Double, List<Double>> ratingTitlePrice = mapSorted.values().stream()
				.collect(groupingBy(Book::getRating,Collectors.mapping(Book::getPrice,toList())));
		System.out.println("\nratingTitlePrice: " + ratingTitlePrice );
	}
	
	
	
	
}
