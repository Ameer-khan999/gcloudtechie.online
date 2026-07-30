package com.tcs.pra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Fresco {
	static class Candidates {
		private String name;
	    private String locality;
	    private int age;
	    
	    public Candidates(String name,String locality,int age) {
	        this.name=name;
	        this.locality=locality;
	        this.age=age;
	    }
	    
	    public String getName() {
	        return name;
	    }
	    
	    public String getLocality() {
	       return locality; 
	    }
	    
	    public int getAge() {
	        return age;
	    }
	    
	    @Override
	    public String toString() {
	    	return " Name = " + getName() + ",Locality = " + getLocality() + ",Age = " +
	    				getAge();
	    }

	}
	
	boolean areNatives(ArrayList<Candidates> candidatesList)
    {
        //Enter your Code here
        boolean b = candidatesList.stream().
        allMatch( l -> l.getLocality() == "Native" );
  
        System.out.println(b);
        return b;
                
    }
    
    
	Candidates youngestCandidate(ArrayList<Candidates> candidatesList) {
	/* Set<String> c = candidatesList.stream().filter(a -> a.getAge() >= 20)
			  .map( d -> d.getName()).
			  collect(Collectors.toSet());

	   System.out.println(c); */
		final Comparator<Candidates> SORT_BYAGE =( (o1, o2) -> 
		{return  (new Integer(o1.getAge()).compareTo(new Integer(o2.getAge())));});
		
		final Comparator<Candidates> SORT_BYNAME =
				((o1,o2) -> o1.getName().compareTo(o2.getName()));
	
	   Set<Candidates> c = candidatesList.stream().filter(a -> a.getAge() <= 65)
			   .collect(Collectors.toSet());
	   
		Set<Candidates> sortt = new TreeSet<>(/* SORT_BYAGE */SORT_BYNAME);
	   sortt.addAll(c);
	   
	 //  List<Candidates> sortt1 = new ArrayList<>(SORT_BYAGE); we cannot on ArrayList
	   
	   
	   for(Candidates cn : sortt) {
		   System.out.println(cn);
	   }
	   return null;
			  
			   
	   //System.out.println(c);
	   
	  // return null;
   } 
    
    public static void main(String[] args) {
		Candidates c1 = new Candidates("Ameer","Native",23);
		Candidates c2 = new Candidates("Sameer","Native",28);
		Candidates c3 = new Candidates("Shakira","Native",45);
		Candidates c4 = new Candidates("Karimulla","Native",50);
		
		List<Candidates> ca = new ArrayList<>(Arrays.asList(c1,c2,c3,c4));
		
		Fresco f = new Fresco();
		f.areNatives(new ArrayList(ca));
		f.youngestCandidate(new ArrayList(ca));
		
		
		
	}


}
