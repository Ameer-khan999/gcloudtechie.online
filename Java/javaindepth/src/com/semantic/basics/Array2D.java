/*2D Arrays
  0 1
0 1 2
1 2 3
2 3 4
3 4 5 it stores like this */

class Array2D {
	static int[][] Arrays2={{1,2},{2,3},{3,4},{4,5}};
	static void Arr2() {
		System.out.println("Arrays2D: " + Arrays2[0][0]);
		System.out.println("Arrays2D: " + Arrays2[1][0]);
		System.out.println("Arrays2D: " + Arrays2[2][0]);
		System.out.println("Arrays2D: " + Arrays2[3][0]);
	}
	static void threeDimensionalArrays() {
	   System.out.println("\nInside threeDimensionalArrays ...");
	   int[][][] unitsSold = new int[][][]{ 
										   { // New York
											 {0,0,0,0}, // Jan
											 {0,0,0,0}, // Feb
											 {0,0,0,0}, // Mar
											 {0,850,0,0}// Apr	
										   },
										   { // San Francisco
											 {0,0,0,0}, // Jan
											 {0,0,0,0}, // Feb
											 {0,0,0,0}, // Mar
											 {0,0,0,0}  // Apr
										   },
										   { 
											 {0,0,0,0},
											 {0,0,0,0},
											 {0,0,0,0},
											 {0,0,0,0}
										   },
										   {
											 {0,0,0,0},
											 {0,0,0,0},
											 {0,0,0,0},
											 {0,0,0,0}
										   }
										 };
		                    	 
		System.out.println("unitsSold[0][3][1]: " + unitsSold[0][3][1]);
	}	
  
  
	public static void main(String[] args) {
		Arr2();
		threeDimensionalArrays();
	}
}
		