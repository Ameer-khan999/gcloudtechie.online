package com.tcs.jvminternals;

import java.lang.reflect.Method;
public class SimpleUnitTester {
    
    public int execute(Class clazz) throws Exception {
        int failedCount = 0;
        for (Method m : clazz.getDeclaredMethods()) {
			    //System.out.println("Method name: " + m.getName());
			    if (m.getReturnType() != boolean.class) {
			    	// System.out.println("Method's return type is void!!! ");
			    	failedCount += 1;
			    }
		}
		System.out.println(failedCount);
        
        // your code
        
        return failedCount;
    }
    
    public static void main(String[] args) {
    	SimpleUnitTester sut=new SimpleUnitTester();
    	// sut.execute(ExerciseReflection);
	}
    
}
