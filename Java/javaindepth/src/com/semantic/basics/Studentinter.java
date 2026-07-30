class Studentinter {
	int id=1000;
	byte age=23;
	long phone=7396_712_666L;
	double gpa=7.1;
	char Degree='A';
	boolean international=true;
	double tutionfees = 12000.0;
	double internationalfees = 5000.0;
	
	void compute() {
		if(international) {
			tutionfees = tutionfees + internationalfees;
		}
		
		System.out.println("ID: " + id);
		System.out.println("age: " + age);
		System.out.println("phone: " + phone);
		System.out.println("gpa: " + gpa);
		System.out.println("Degree: " + Degree);
		System.out.println("tutionfees: " + tutionfees);
		
		
	}
	public static void main(String[] args) {
		Studentinter s=new Studentinter();
		s.compute();
	}
}
