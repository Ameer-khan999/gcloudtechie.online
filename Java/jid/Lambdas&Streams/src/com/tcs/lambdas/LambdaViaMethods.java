package com.tcs.lambdas;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Testing {
	abstract void apply();
}


public class LambdaViaMethods {
	
	static int globalVariable=0;
	public void go(Testing test) {
		test.apply(); // 
		// Capturing Of Variables(int count=0;)
		// before 8 ~ it needs to be final
		// after 8 ~ it needs to be effectively final or final(no problem)
		int count=0; // we cannot increment anywhere, whether it is anonymous or lambda
		// Note:- we saw this lecture in anonumous class to
	 	// count++; remove comment u'll get an error at this System.out.println(count));
		
		 for(int i=0;i<count;i++) {
			new Thread(() -> System.out.println(count)).start();// Closure
		// work :- () -> System.out.println(count)  Note:- run() from Runnable interface
		//	new Thread(() -> System.out.println(count++)).start(); // u cannot do count++
		//	count++; // u cannot do this too
			new Thread(() -> System.out.println(globalVariable++)).start();
			// u can doglobalVariable++ but not Thread Safe coz threads shares some mutable data
			// and not recommended too
	
		}
		 // In order to increment count, we can do one trick but not recommended as it
		 // is not thread safe due to unpredictable outcomes, note that we cannot reassign trick
		 // to other and it must be effectively final like primitive int as we know that trick
		 // is obj ref and obj ref must be effectively final too like a primitive int's.
		 List<Integer> trick=new ArrayList<>(); 
		 new Thread(() -> {
			 trick.add(count);
			 int temp=trick.get(0);
			 trick.set(0, temp++);
		 }).start(); // this is a trick to increment count but you shouldn't be doing that
		 
		 // Some other thing is we cannot redecalre local variables coz we cannot shadow it
		 // applies to lambda expressions too
		// int count=0; // we cannot redeclare local variables
		// EX:-  Consumer<Integer> consumer= count -> {} ; // we cannot shadow int count =0;
		// Consumer<Integer> consumer= c -> {int count=0}; // we cannot do this too
		 
		 // we can shadow varaibles in nested classes but not in methods example,
		/* new Thread(
			 (java.lang.Runnable) new Runnable() {
				 public void run() {
					 int count=2;
					 count++; 
				 }
			 }
		 ).start(); */ // throws compilation error thats why commented this, remove if u wnt 
		 // so we can shadow variables in local and anonymous classes
		 
		 // final thing we can use this refrence in lambdas to accept enclosed variable
		 new Thread(() -> System.out.println(this.globalVariable++)).start();
		 // Note:- we can do this only if method is non static means instance 
		 // Thats all about it please cross check one more time
	}

	public static void main(String[] args) {
		LambdaViaMethods l = new LambdaViaMethods();
		new LambdaViaMethods().go(() ->  System.out.println("Lamda Via Methods with Instance"));
	 //   LambdaViaMethods.go(() ->  System.out.println("Lamda Via Methods with static ref"));
					// or we can
		l.go(() -> System.out.println("Lamda Via Methods with Obj Ref"));
		
		// Now we can see that we can aslo pass lamdas via methods	
	}

}
