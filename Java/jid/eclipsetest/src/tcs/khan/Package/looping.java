package tcs.khan.Package;
import java.util.Scanner;

public class looping {
	public static void main(String... args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Input Value: ");
		int input=sc.nextInt();
		String[] m= {"jan","feb","mar"};
		//loop1
		System.out.println("Type 1 loop foreach:");
		for(String s:m) {
			System.out.println(s);
			//System.out.println(" ");
		}
		
		String[] oper= {"+","-","*"};
		System.out.println("\nType 2 loop forloop:");
		for(int i=0;i<=oper.length-1;i++) {
			System.out.println(oper[i]);
		}
		
		System.out.println("Type 3 loop whileloop:");
		String[] a;
		int i=0;
		while(i<input) {
			i++;
			String str=sc.nextLine();
			StringBuilder s=new StringBuilder(str);
			s.append(str).append(", ").append(str);
			System.out.println(s);
			
		}
	}

}
