class Varkind {
	int id;
	String name;
	String gender;
	int age;
	double gpa;
	char degree;
	boolean international;
	double tutionfees=12000.0;
	double inernationalfees=5000.0;
	
	void compute() {
		int nextid=id+1;
		if (international) {
			tutionfees=tutionfees+internationalfees;
		}
		System.out.println("\nid" +id);
		System.out.println("name:" + name);
		System.out.println("gender: " + gender);
		System.out.println("age: " + age);
		System.out.println("gpa: " + gpa);
		System.out.println("degree: " + degree);
		System.out.println("tutionfees: " + tutionfees);
	}
	public static void main(String[] args) {
		Varkind s1=new Varkind();
		s1.id=1000;
		s1.name="Ameer khan";
		s1.gender="Male";
		s1.age=23;
		s1.gpa=7.2;
		s1.degree='A';
		s1.international=true;
		s1.compute();
		
	    Varkind s2=new Varkind();
		s2.id=1001;
		s2.name="Sameer khan";
		s2.gender="Male";
		s2.age=27;
		s2.gpa=8.0;
		s2.degree='A';
		s2.international=false;
		s2.compute();
		
		Varkind s3=new Varkind();
		s3.id=1002;
		s3.name="Anita";
		s3.gender="Female";
		s3.age=20;
		s3.gpa=4.0;
		s3.degree='c';
		s3.international=true;
		s3.compute();
	}
}
		