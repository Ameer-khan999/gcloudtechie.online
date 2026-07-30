//Arrays are used to store the multiple elements of same type
//conatiner objects that holds fixed values of single type.

//import java.util.lang.*;
class Arrays {
	//static int[] scores; This type of reference gives NullPointerException at Runtime
	static void Arraysmethod() {
		/*System.out.println("\nInside the Arrays of 1st Type: ");
		int[] scores=new int[4];
		scores[0]=90;
		scores[1]=80;
		scores[2]=70;
		scores[3]=100;*/
		
		System.out.println("\nInside the Arrays of 2nd Type: ");
		int[] scores=new int[] {90,70,80,100};  /*Do not specify size of an array*/
		
		//System.out.println("\nInside the Arrays of 3rd Type: ");
		//int[] scores={90,50,80,70}; //if object reference is not initialized then it gives NullpointerException 
		System.out.println("Mid-Term 1: " + scores[0]);
		System.out.println("Mid-Term 2: " + scores[1]);
		System.out.println("Final: " + scores[2]);
		System.out.println("Project: " + scores[3]);
		System.out.println("# Exams: " + scores.length); // we cannot use length() method for arrays.This method is used in String class
		
		//Varkind[] students=new Varkind[3];//1st type

		//Varkind[] students=new Varkind[] {new Varkind(),new Varkind(),new Varkind()}; //2ndtype
		Varkind[] students={new Varkind(),new Varkind(),new Varkind()}; //3rd type

		/*students[0]=new Varkind();
		students[1]=new Varkind();
		students[2]=new Varkind();*/
	    students[0].name="Ameer kha";
		students[1].name="Sameer khan";
		students[2].name="Anita";
		System.out.println("s1: " + students[0].name);
		System.out.println("s2: " + students[1].name);
		System.out.println("s3: " + students[2].name); //this gives null value because reference type is Varkind,if it is int it gives 0 
	}
	public static void main(String[] args) {
		Arraysmethod();
	}
}