package tcs.khan.Package;


public class StudentUtil {
	static int k=5;

	public static void calculateGPA(/* int[] studentIdList, char[][] studentsGrades */) {
	
    	int[] studentIdList1= {1001,1002}; 
    	char[][] studentsGrades1= {{'A','A','A','B'},{'A','C','C'}};
    	for (int i = 0; i < studentsGrades1.length; i++) {
			char[] cs = studentsGrades1[i];
//			System.out.println(cs);
			for (int j = 0; j < cs.length; j++) {
				char c = cs[j];
//				System.out.println(c);
				
				if (c=='A') {
					int k=4;
				} else if (c=='B') {
					int k=3;
				} else if (c=='C') {
					int k=2;
				}
				
			}
			
		}
    	System.out.println(k);
    	
		
        // your code
    }
    public static void main(String[] args) {
		calculateGPA(/* studentIdList1,studentsGrades1 */);
	}
	/*
	 * public static int[] getStudentsByGPA(double lower, double higher, int[]
	 * studentIdList, char[][] studentsGrades) { // perform parameter validation.
	 * Return null if passed parameters are not valid
	 * 
	 * // invoke calculateGPA
	 * 
	 * // construct the result array and return it. You would need an extra for loop
	 * to compute the size of the resulting array }
	 */
    
}

	


