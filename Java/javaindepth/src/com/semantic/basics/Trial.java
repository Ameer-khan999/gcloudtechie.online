import java.util.Scanner;
//import java.util.Date;

class Trial {
	//int id;
	static long AccountNo;
	static String name;
	static double Balance;
	static double Amount;
	static boolean Transaction;
	static boolean international;
	static String date;
	static double Amount1;
	
	Trial(long AccountNo, String name, double Balance, double Amount,boolean Transaction, boolean international) {
		//this.id=id;
		this.AccountNo=AccountNo;
	    this.name=name;
	    this.Balance=20000.0;
		this.Amount=Amount;
		this.Transaction=true;
	    this.international=international;
		
	}
	Trial(long AccountNo, String name, double Balance,double Amount,boolean Transaction) {
		this(AccountNo,name,Balance,Amount,Transaction,international);
		
		/*Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter Your AccountNo: ");
		int AccountNo1=sc.nextInt();                         Note: Dont write this here write in main method
		System.out.print("Enter Your Name: ");
		String name1=sc.next();
		System.out.print("Enter Amount: ");
		double Amount1=sc.nextDouble();
		System.out.print("Enter Your Transaction: ");
		System.out.print("Please Type true if international or Type false.");
		boolean international1=sc.nextBoolean();*/
		
	}
	static void foo() {
		//java.util.Date date=new java.util.Date();
		if(Transaction==international) {
			
			Amount1 = Amount * 0.02;
			//Balance=Balance-Amount1; Don't write here this type of logic
			//System.out.print("Remaining Blanace is: " + ((Balance-Amount)-Amount1));
		
		java.util.Date date=new java.util.Date();
		System.out.println("\nToday Date is: " + date);
		System.out.println(" ");
		System.out.println("Hi " + name);
		System.out.println(" ");
		System.out.println("Your Account balance is: " + Balance);
		System.out.println(" ");
		System.out.print("Remaining Blanace is: " + ((Balance-Amount)-Amount1));
		System.out.println(" ");
		}
		else {
			java.util.Date date=new java.util.Date();
		System.out.println("\nToday Date is: " + date);
		System.out.println(" ");
		System.out.println("Hi " + name);
		System.out.println(" ");
		System.out.println("Your Account balance is: " + Balance);
		System.out.println(" ");
		System.out.print("Remaining Blanace is: " + (Balance-Amount));
		System.out.println(" ");
	    }
			
	}
		
		
	public static void main(String... args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Your AccountNo: ");
		long AccountNo=sc.nextLong();
		System.out.println(" ");
		System.out.print("Enter Your Name: ");
		String name=sc.next();
		System.out.println(" ");
		System.out.print("Enter Amount: ");
		double Amount=sc.nextDouble();
		System.out.println(" ");
		System.out.print("Enter Your Transaction: ");
		System.out.println("Note: 2% Charge for international Transactions.:");
		System.out.println(" ");
		System.out.print("Please Type true if international or Type false= ");
		//System.out.println(" ");
		
		boolean international=sc.nextBoolean();
		
		
		Trial t=new Trial(AccountNo,name,Balance,Amount,Transaction,international);
	
		//t.Trial(AccountNo,name,Balance,Amount,Transaction,international);
		/*System.out.println("Today Date is: " + date);
		System.out.println("Hi " + name);                           Note: Dont write this here write in separate defined method 
		System.out.println("Your Account balance is: " + Balance);
		System.out.print("Remaining Blanace is" + (Balance - Amount));*/
		foo();
	}
}
		
		
	
