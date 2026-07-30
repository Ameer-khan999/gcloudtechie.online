package com.tcs.frescoplay.fp.functionalinterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class PrimeComposite_Factorial
{   
    static int sum=1;
  //  int num=1;
   
    private static boolean errorFlag = true;
    // Supplier<T> supplies something as output
    public static void print(Supplier<? extends Object> supplier) {
        if(errorFlag) {
           System.out.println(supplier.get()); // this prints the output
        }
		
    }
   
    void primeOrComposite(int n)
    {
    	int i,m=0,flag=0;
    	m=n/2;
       try {
            if ( n==0 || n==1 ) {
                throw new Exception("Prime Nor Composite");
            } else {
                for(i=2;i<=m;i++) {
                   if( n % i==0) {
                       throw new Exception("Composite");
                   }
                }
                if (flag == 0) {
                    throw new Exception("Prime");
                }
            }
            
            
        } catch ( Exception e) {
           print(() -> e.getMessage());
        	//System.out.println(e.getMessage());
           
        } 
    	 
    /*	if ( n==0 || n==1 ) {
    		System.out.println("Prime Nor Composite");
    	} else {
            for(i=2;i<=m;i++) {
                if( n % i==0) {
                	System.out.println("Composite");
                	flag=1;
                	break;
                }
             }
            if (flag == 0) {
           	 System.out.println("Prime");
            }
         } */
         
         
    }
    
    void findFactorial(int n)
    {
        //Enter your Code here
    	/*long f;
    	long sum = 1;
    	Predicate<Long> p = t -> t < n;
    	p.test(n);
    	
    	for(f=1;f <=n;f++) {
    		sum = sum* f;
    		Consumer<Long> c = a -> a.longValue();
    		c.accept(sum);
    		//System.out.println(c.accept(sum)); 
    	} */
    	
    	List<Integer> num = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			num.add(i);
		}
		
		List<Integer> fact = num;
		
		Integer factorial = fact.stream().mapToInt(d -> d).reduce(1, (a,b) -> a*b);
		System.out.println(factorial);

    }
}

public class PrimeComposite_FactorialMain
{
    public static void main(String[] args) throws Exception
	{
    	System.out.print("Enter a number..=");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine().trim());
				
		 PrimeComposite_Factorial xyz=new PrimeComposite_Factorial();
		 
		 xyz.primeOrComposite(n);
		 xyz.findFactorial(n);
		 
		
	}
}


/**
 * int f;
        long sum=1;
        for ( f=1;f<=n;f++) {
            sum = sum*f;
        }
        
        System.out.println(sum);
        */
