package com.tcs.lambdas;

/**
 * Well, the good news is: you do not need to go through anonymous classes to
 * understand how to write a lambda expression. Moreover, in many cases, thanks
 * to the addition of lambdas to the Java language, you do not need anonymous
 * classes anymore.
 * 
 * Writing a lambda expression breaks down to understanding three steps:
 * 
 * 1.identifying the type of the lambda expression you want to write 2.finding
 * the right method to implement 3.implementing this method.
 * 
 * This is really all there is to it. Let us see these three steps in detail.
 * 
 * ) Identifying the Type of a Lambda Expression
 * 
 * -> Everything has a type in the Java language, and this type is known at
 * compile time. So it is always possible to find the type of a lambda
 * expression. It may be the type of a variable, of a field, of a method
 * parameter, or the returned type of a method.
 * 
 * There is a restriction on the type of a lambda expression: it has to be a
 * functional interface. So an anonymous class that does not implement a
 * functional interface cannot be written as a lambda expression.
 * 
 * The complete definition of what functional interfaces are is a little
 * complex. All you need to know at this point is that a functional interface is
 * an interface that has only one abstract method.
 * 
 * You should be aware that, starting with Java SE 8, concrete methods are
 * allowed in interfaces. They can be instance methods, in that case, they are
 * called default methods, and they can be static methods. These methods do not
 * count, since they are not abstract methods.
 * 
 * Note 1:- Do I need to add the annotation @FunctionalInterface on an interface
 * to make it functional?
 * 
 * No you don't. This annotation is here to help you to make sure that your
 * interface is indeed functional. If you put this annotation on a type that is
 * not a functional interface, then the compiler will raise an error.
 * 
 * 
 * 
 * @author Java.com
 */

public class LambdaFromJavaSite<T> implements Predicate<T>,Consumer<T>,Runnable {
	public static void main(String[] args) {
		//Predicate<String> p=new LambdaFromJavaSite<>();
		Runnable l=new LambdaFromJavaSite<>();
		l.run();
		/*
		 * Predicate<String> predicate = (String s) -> { return s.length() == 3; };
		 */
	    
	}

	@Override
	public boolean test(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Runnable runnable = () -> System.out.println("I am running");
	}

	@Override
	public void accept(T t) {
		// TODO Auto-generated method stub
		
	}
}

//Examples of Functional Interface
	// Ex 1:-
	@FunctionalInterface
	interface Runnable {
		public abstract void run(); // you cannot keep body to abstract methods but we can
									// put body to static and default methods (concrete)
		/*
		 * The Runnable interface is indeed functional, because it has only one abstract
		 * method. The @FunctionalInterface annotation has been added as a helper, but
		 * it is not needed.
		 */
	}

	// Ex 2:-
	@FunctionalInterface
	interface Consumer<T> {
		void accept(T t); // Functional Interface need to contain atleast one abstract
						  // no matter how may defaults and concrete methods have, but
						 // if it is not contain abstract than it not works.

		default Consumer<T> andThen(Consumer<? super T> after) {
			return null;
		}

		/*
		 * The Consumer<T> interface is also functional: it has one abstract method and
		 * one default, concrete method that does not count. Once again,
		 * the @FunctionalInterface annotation is not needed.
		 */
	}
	
	// Ex 3:-
	@FunctionalInterface
	interface Predicate<T> {

	    boolean test(T t); // if we comment this we will get an error

	    default Predicate<T> and(Predicate<? super T> other) {
			return null;
	    }

	    default Predicate<T> negate() {
			return null;
	    }

	    default Predicate<T> or(Predicate<? super T> other) {
			return null;
	    }

	    static <T> Predicate<T> isEqual(Object targetRef) {
			return null;
	    }

	    static <T> Predicate<T> not(Predicate<? super T> target) {
			return null;
	    }
	/*
	 The Predicate<T> interface is a little more complex, but it is still a functional 
	 interface coz of abstract method test().

	 1.it has one abstract method
	 2.it has three default methods that do not count
	 3.and it has two static methods that do not count neither.
	*/
	}
	
	/* 
	 *) Finding the Right Method to Implement from above Examples !!
	 
		At this point you have identified the type of the lambda expression you need to 
		write, and the good news is: you have done the hardest part: the rest is very 
		mechanical and easier to do.

		A lambda expression is an implementation of the only abstract method in this 
		functional interface. So finding the right method to implement is just a matter 
		of finding this method.

		You can take a minute to look for it in the three examples of the previous 
		paragraph.

		1.For the Runnable interface it is:

			public abstract void run();
		
					
		2.And for the Consumer<T> interface it is:

			void accept(T t);
			
		2.For the Predicate interface it is:

			boolean test(T t);
	 */
	


