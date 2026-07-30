package com;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Khan {

	public static void main(String[] args) {
		try {
			FileReader fR = new FileReader("‪D:\\X\\names.txt");
		} catch(FileNotFoundException e) {
			System.out.println("Not");
		}
	}

}
