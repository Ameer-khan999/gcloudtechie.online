package com.tcs.frescoplay.streams;

import java.io.*;

import java.util.*;
import java.util.stream.Collectors;

class Candidates
{
    //Create the Constructor here
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
        return "Name = " + getName() + ", Locality=" + getLocality() + ", Age = " + getAge();
    }
    
}

class Interview_CandidatesClass
{
    boolean areNatives(ArrayList<Candidates> candidatesList)
    {
        //Enter your Code here
        boolean b = candidatesList.stream().
        allMatch( l -> l.getLocality() == "Native" );
        
        return b;
      /*  candidatesList.stream().anyMatch(a -> a.getAge() <= a.getAge());
        for(Candidates c:candidatesList)
         {
             String a = "Name = " + c.getName() + ", Locality = " + c.getLocality() + ", Age = " + c.getAge();
         }
         
        // return c;
        */
    }
    
    
    Candidates youngestCandidate(ArrayList<Candidates> candidatesList)
    {
        //Enter your Code here
        Candidates c = (Candidates) candidatesList.stream().
        filter(a -> a.getAge() > 20)
        .collect(Collectors.toList());
		return c;
        
    }
}

public class Interview_Candidates
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Candidates> candidatesList=new ArrayList<>();
				
		 int n=Integer.parseInt(br.readLine().trim());
		 
		 for(int i=0;i<n;i++)
		 {
			 String inp=br.readLine();
	         String inparr[]=inp.split("-");
	         
	         Candidates cnd=new Candidates( inparr[0], inparr[1], Integer.parseInt(inparr[2]) );
	         candidatesList.add(cnd);         
		 }
		 
		 
		 Interview_CandidatesClass ic=new Interview_CandidatesClass();
		 
		 boolean ans= ic.areNatives(candidatesList);
		 if(ans)
			  	System.out.println("All candidates are Natives");
		 else
				System.out.println("All candidates are not Natives");
		 
		 
		  Candidates youngest=ic.youngestCandidate(candidatesList);
        
		  System.out.println("Details of the Candidate with youngest age : Name = "+youngest.getName()+", Locality = "+youngest.getLocality()+", Age = "+youngest.getAge());
    }
}
