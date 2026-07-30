/**
 * TryWithResources is only for auto closables resource, if you are not using resources then you can go with try-catch block.
 * this is cleaner syntax than old try-catch block
 */
package com.tcs.exceptionhandlings;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResourcesDemo {
	static String inFileStr ="OL.jpg";
	static String outFileStr ="Khan.jpg";
	
	public static void fileCopyWithArm() throws IOException {
		System.out.println("\nInside FileCopyWitthArm..");
		try (Test t=new Test();Test1 t1=new Test1(); BufferedInputStream in=new BufferedInputStream(new FileInputStream(inFileStr));
				BufferedOutputStream out= new BufferedOutputStream(new FileOutputStream(outFileStr))) {
			byte[] byteBuf= new byte[4000];
			int numBytesRead;
			while ((numBytesRead = in.read(byteBuf)) != -1) {
				out.write(byteBuf,0,numBytesRead);
		    }
			throw new IOException("Important Exception..!!");
	    }
	}
	public static void main(String[] args) {
		try {
			fileCopyWithArm();
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("\nWe ran into problem, unable to find " + inFileStr);
			Throwable[] throwables=e.getSuppressed();
			System.out.println("\n"+throwables[0].getMessage());
			System.out.println("\n"+throwables[1].getMessage());
		}
	}

}

class Test implements AutoCloseable {
	@Override
	public void close() throws IOException {
		throw new IOException("Trivial Exception");
	}
}

class Test1 implements AutoCloseable {
	@Override
	public void close() throws IOException {
		throw new IOException("Trivial Exception1");
	}
}
