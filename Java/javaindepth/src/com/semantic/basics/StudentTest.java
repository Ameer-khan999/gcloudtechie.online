class StudentTest {
		public static void main(String... args) {
		Thisreference s=new Thisreference(10001,"Ameer",23,'M',7396_712_666L,7.8,true);
		Thisreference s1=new Thisreference(1002,"Sameer",27,'M',9985_491_126L,2.8,true);

		Thisreference s2=new Thisreference(1003,"Anita",22,'F',7396_721999L,3.8);
	
		/*System.out.println("Thisreference.computecount: " +Thisreference.computecount );
		
		System.out.println("id of Student 1: " + s.name );
		System.out.println("Name of Student 2: " + s1.name );
		System.out.println("age of Student 3: " + s2.age );
		
		s.updateprofile("Ameer khan");
		System.out.println("name of updated Student 1: " + s.name );
		
		Thisreference s3=s;
		System.out.println("\nStudent of s3 : " + s3.name );
		
		s3.updateprofile("Ameer khan Pathan");
		System.out.println("name of updated Student 1: " + s.name );*/
		
		
		/*s3=s1; // Dont use reference type Ex:Thisreference
		System.out.println("\nStudent of s : " + s.name );
		System.out.println("\nStudent of s1 : " + s1.name );
		System.out.println("\nStudent of s2 : " + s2.name );
		System.out.println("\nStudent of s3 : " + s3.name );
		
		
		s2=s; // Dont use reference type Ex:Thisreference
		System.out.println("\nStudent of s : " + s.name );
		System.out.println("\nStudent of s1 : " + s1.name );
		System.out.println("\nStudent of s2 : " + s2.name );
		System.out.println("\nStudent of s3 : " + s3.name );
		
		s3=new Thisreference();
		s3.updateprofile("Sameer khan");
		System.out.println("name of updated Student s3: " + s3.name );
		System.out.println("name of updated Student s2: " + s2.name );
		System.out.println("name of updated Student s1: " + s1.name );
		System.out.println("name of updated Student s: " + s.name );*/
		
		// The s3 is not storing Sameer no more it is storing sameer khan.in this case garbage collector comes into play
		
		Thisreference[] students={s,s1,s2};
		
		/* Thisreference temp=students[0];
		students[0]=students[2];
		students[2]=temp; */   // write a method indtead of this
		swap(students,0,1);
		
		System.out.println("\nStudent of s : " + students[0].name );
		System.out.println("\nStudent of s1 : " + students[1].name );
		System.out.println("\nStudent of s2 : " + students[2].name );
		
	
	}
	static void swap(Thisreference[] students,int firstindex,int secondIndex) {
		Thisreference temp=students[firstindex];
		students[firstindex]=students[secondIndex];
		students[secondIndex]=temp;
	}

			
	
}