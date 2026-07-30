package tcs.com.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class ArrayClassDemo {
	private static void sequential() {
		// asList() ~ most commonly used
		// List<T> asList(T...)
		String[] strArray = new String[] {"John","Raj"};
		List<String> strings = Arrays.asList(strArray); // converts Array into List with fixed size.
		System.out.println("strings: " + strings);
	//	strings.add("Anita"); // we cannot add method to returned List, throws java.lang.UnsupportedOperationException
	//	strings.remove("John"); // we cannot add method to returned List, throws java.lang.UnsupportedOperationException
		
		// but we can do below operations
		
		strings.set(1, "Anita");
		System.out.println("Updated array is: " + strings);
		System.out.println("Updated Arrays.toString(strArray): " + Arrays.toString(strArray));
		
		// creating modifiable ArrayList from an Array 
		strings =  new ArrayList(Arrays.asList(strArray));
		
		// showing var-args
		strings = Arrays.asList("Raj","Anita");
//		System.out.println(strings);
		
		List<String> fixedList = Arrays.asList(new String[3]);
		// remember auto-boxing lecture taht Arrays are not auto-boxeable
	//	List<Integer> fixedList2 = Arrays.asList(new int[2]); // gets compilation problem cox int is not auto-boxeable
															  // so change int[2] to Integer or  Integer to int[]
		List<int[]> fixedList3 = Arrays.asList(new int[2]);
		System.out.println("\nfixedList3.size(): " + fixedList3.size());
		
		// Sorting: void sort(Object[]) - Uses Merge-sort with natural ordering
				// Partially sorted array: far fewer than nlog(n) comparisons 
				// Almost sorted array: approx. n comparisons, where n is array size
				Arrays.sort(strArray);  
				System.out.println("\nAfter sorting: " + Arrays.toString(strArray));
				// Additional Comments: Well-suited for merging 2 or more sorted arrays
				//                      Concatenate the arrays & sort the resulting array!!
				
		// Sorting: void sort(int[]) - Uses quick sort
		int[] iArray = {23, 4, 59};
		Arrays.sort(iArray);
		System.out.println("\nSorted iArray: " + Arrays.toString(iArray));
		
		// void sort(T[] a, Comparator<? super T> c)
		
		// Sorting: void sort(double[]) - Uses quick sort
		double[] dArray = {23.98, 4.6, 59.98,59.92};
		Arrays.sort(dArray);
		System.out.println("\nSorted dArray: " + Arrays.toString(dArray));	
				
		// void sort(T[] a, Comparator<? super T> c)
		
		// Binary Search: int binarySearch(int[], int); 
				//                returns index if element found
				//                otherwise returns -(insertion point) - 1
				//                input array must be sorted. Otherwise, behavior is undefined
				System.out.println("\nindex returned by binary search: " + Arrays.binarySearch(new int[] {4,  23, 59}, 23));
				System.out.println("\nindex returned by binary search: " + Arrays.binarySearch(new int[] {4,  23, 59}, 10));
				// type 1
				int[] newArray = Arrays.copyOf(iArray, 8);
				System.out.println("\nnewArray: " + Arrays.toString(newArray));
				
				// same as above and type 1 is recommended 
				// type 2
				int[] newArray1 = new int[6];
				System.arraycopy(iArray, 0, newArray1, 0, iArray.length);
				System.out.println("\nnewArray1: " + Arrays.toString(newArray1));
				
				Arrays.fill(newArray, 13);
				System.out.println("\nFill with 13: " + Arrays.toString(newArray));
				
				System.out.println("\nEquals? " + Arrays.equals(iArray, newArray));
				/*
				// Arrays.deepEquals(Object[], Object[]);
				//  Returns true if arrays are deeply equal to one another. 
				//  Appropriate for nested arrays
				//int[][][] deepArray1 = { { {1, 2, 3}, {4, 5, 6} } };
				//int[][][] deepArray2 = { { {1, 2, 3}, {4, 5, 6} } };
				//int[][] deepArray1 = {{1, 2, 3}};
				//int[][] deepArray2 = {{1, 2, 3}};
				//int[] deepArray1 = {1, 2, 3}; // Covariance: Does not work as int[] is not a subtype of Object[]
				//int[] deepArray2 = {1, 2, 3};
				//System.out.println("Deep Array Equals? " + Arrays.deepEquals(deepArray1, deepArray2));
				*/
				Object[] objArray = new int[][][] { { {1, 2, 3,4,5}}};
				int[][] ia = (int[][])objArray[0];
				System.out.println();
				System.out.println(ia[0][4]);
				
	}
	
	// Java 8 ~ Parallelized Operations
		private static void parallel() {
			// For large arrays on multi-core. Min size atleast 1 >> 13 = 8192
			int[] iArray = {23, 4, 59};
			Arrays.parallelSort(iArray); 
			System.out.println("iArray parallel sort: " +  Arrays.toString(iArray));
			
			IntBinaryOperatorImpl IntBinaryOperatorImpl = new IntBinaryOperatorImpl();
			Arrays.parallelPrefix(iArray, IntBinaryOperatorImpl);
			System.out.println("Parallel Prefix: " + Arrays.toString(iArray));
			
			IntUnaryOperatorImpl intUnaryOperatorImpl = new IntUnaryOperatorImpl();
			intUnaryOperatorImpl.setArray(iArray);
			Arrays.parallelSetAll(iArray, intUnaryOperatorImpl);
			System.out.println("Parallel Set All: " + Arrays.toString(iArray));
			
			IntUnaryOperatorImpl intUnaryOperatorImpl1 = new IntUnaryOperatorImpl();
			// intUnaryOperatorImpl.setArray(iArray);
			Arrays.parallelSetAll(iArray, intUnaryOperatorImpl1);
			System.out.println("Parallel Set All: " + Arrays.toString(iArray));
			// passes index number if Array is null.
		}
		
	
	
	public static void main(String[] args) {
		// sequential();
		parallel();
	}
}

class IntBinaryOperatorImpl implements IntBinaryOperator {
	@Override
	public int applyAsInt(int left, int right) {
		return left + right;
	}	
}

class IntUnaryOperatorImpl implements IntUnaryOperator {
	int[] iArray;
	
	public void setArray(int[] iArray) {
		this.iArray = iArray;
	}

	@Override
	public int applyAsInt(int i) {
		if (iArray != null) {
			return iArray[i]+5;
		} else {
			return i;
		}		
	}
	
}

