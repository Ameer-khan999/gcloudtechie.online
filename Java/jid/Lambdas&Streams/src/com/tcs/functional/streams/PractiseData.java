package com.tcs.functional.streams;

import java.util.Arrays;
import java.util.List;

public class PractiseData {
public static List<College> getFromSiddhartha(char keyword) {
		
		College c1=new College(19301,"Vaishnavi","CS",970,'A');
		College c2=new College(19316,"Sirisha","CS",950,'A');
		College c3=new College(19317,"Gowtham","CS",850,'C');
		College c4=new College(19323,"Ameer","CS",899,'B');
		College c5=new College(19326,"Divya","CS",980,'A');
		return Arrays.asList(c1,c2,c3,c4,c5);
	}
	
	public static List<College> getFromLoyola(char keyword) {
		
		College c1=new College(1301,"Vahini","Commerce",870,'C');
		College c2=new College(1302,"SiriChandana","Commerce",950,'A');
		College c3=new College(1303,"Gowthami","Commerce",850,'C');
		College c4=new College(1304,"Sameer","Commerce",896,'B');
		College c5=new College(1305,"Jasmine","Commerce",981,'A');
		return Arrays.asList(c1,c2,c3,c4,c5);
	}
	
}
