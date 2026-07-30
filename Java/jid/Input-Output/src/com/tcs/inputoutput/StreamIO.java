package com.tcs.inputoutput;

/**
 * 
 * @author Ameer Khan


 * 02 june,2022
 * 
 * Stream -> Stream is a connection b/w java program and data source/sink (sink == destination)
 *			 Stream handles reading and writing.
 *
 * Based on operation streams are divided like FileInputStream and FileOutputStream
 * java <----- source(input)
 * java ------> Destination(Sink)(Output)
 * 
 * Stream IO Operations
 * 1.Open Stream
 * 2.Read/Write Stream
 * 3.Close Stream  -> Closes the unused resources to prevent future alloaction resource by using Finally block of exceptions
 * 
 * Streams Classification
 *                                     			Object
 *      1.InputStream 2.OutputStream							1.Reader	 2.Writer
 *     <----------------------------->                         <---------------------->
 *            Byte Streams                                        Character Streams
 *        (Images,videos and audio etc..)                        (Text and CSV files)
 *        --------------------------------------END-------------------------------------------------
 *        
 *        
 * A. Byte Streams lecture
 *     1.Read/Write raw bytes serially
 *     2.Character streams are built on it.
 *     
 *    -> InputStream
 *       1.Base abstract class for all byte input streams
 *       2.To read data in groups of 8-bit bytes
 *       
 *       -> Read Operation
 *          -> abstract int read() throws IOException
 *             1.Reads 1 byte & returns as int between ) & 255(2^8-1)
 *             2.returns -1 if end of stream detected
 *             3.'a' -> 97
 *             
 *             // Another method
 *          -> int read(byte[] b,int offset,int length) throws IoException
 *             1.Reads length # bytes into array starting at offset
 *             2.returns bytes read or -1 if end of stream detected
 *             3.Repeatedly invokes read
 *             
 *          -> int read(byte[] b) throws IOException -> read(b, 0,b.length)
 *          -> All read calls are blocking
 *          
 *          
 *   -> OutputStream
 *      1.Base abstract class for all byte input streams
 *      2.To write data in groups of 8-bit bytes
 *      
 *      -> Write Operation
 *          -> abstract void write() throws IOException
 *           1.Writes only least significant byte
 *           
 *          -> void write(byte[] b,int offset,int length) throws IoException
 *            1.write length # bytes from array starting at offset
 *            2.repeatedly invokes write
 *          -> void write(byte[] b) throws IOException -> write(b, 0,b.length)
 *          
 * Reasons for FileNotFoundException :-(FileInput & OutputStreams)
 *   -> Read/write bytes from/to files
 *       -> FileOutputStreams(String filename) throws FileNotFoundException
 *         1.file to read does not exist
 *         2.cannot be created for writing
 *         3.file is a directory
 *         4.cannot be opened for any other reason
 *        
 *    -> read()/write() is Expensive
 *      1.reading/writing single bytes is grossly inefficient
 *      2.Anology: Shopping without a cart
 *      3.read/write is used,when we have to read/write data from/to a single disk otherwise use Buffered
 *      
 * *) Buffering :- (uses when read/write data into chunks instead of single disk)
 *   ---------------
 *     1.Read/Write block of bytes into memory buffer
 *     2.BufferedInputStream & BufferedOutputStream
 *     3.FileInputStream & FileOutputStream
 *     4.Buffer ~ byte array
 *     5.Default buffer size ~ 8192 bytes
 *     
 *     a) Read Operation In Buffering:-
 *     			1.synchronized int read() throws IOException
 *     				if(buffer has unread data)
 *     					return first unread byte
 *              	else
 *                  	fill-buffer <- in.read()
 *     			2.remain read opeartion similar to above read operation
 *     
 *     b) Write Operation In Buffering:-
 *       		1.synchronized void write(int) throws IOException
 *       		2.Data is written to buffer
 *       		3.Flush buffer to underlying stream if no enough space
 *      
 *     c) decorator.close()
 *     		1.invokes close() on underlying decorated stream
 *     		2.BufferedOutputStream -> first flush()
 *      
 *     
 * -> Chained Streams
 *      java programs -> BufferedInputStream <chain links> FileInputStream
 *     1.decorator patterns
 *     2.the open-closed principle
 *      BufferedInputStream in = new BufferedInputStream(new FileInputStream("go.jpg"));
 *          								|						|
 *          								|						|
 *          							         <InputStream>
 *          
 * --> InputStream Hierarchy
 *                                     InputStream
 *                                    <----------->
 *     1.ByteArrayInputStream              2.FileInputStream                     3.PipedInputStream
 *                        4.FilterInputStream                        5.ObjectInputStream
 *                       <-------------------->
 *      4.1. BufferedInputStream                    4.2. DataInputStream
 *      
 *             ------------------------------------------------------------------------------------------------------
 *      
 *      
 *      
 * --> OutputStream Hierarchy
 *                                     InputStream
 *                                    <----------->
 *     1.ByteArrayOutputStream              2.FileOutputStream                     3.PipedOutputStream
 *                        4.FilterOutputStream                        5.ObjectOutputStream
 *                       <-------------------->
 *      4.1. BufferedOutputStream                    4.2. DataOutputStream      4.3. PrintStream
 *      
 *B.Character Streams lecture
 *
 *-> the only difference is 2^16(65536)
 *
 *
 *
 *                        
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamIO {
	static String inFileStr = "walden.png";
	static String outFileStr = "walden-out.png";
	
	public static void fileCopyNoBuffer() {
		System.out.println("\nInside fileCopyNoBuffer ...");
		
		long startTime, elapsedTime; // for speed benchmarking

		// Print file length
		File fileIn = new File(inFileStr);
		System.out.println("File size is " + fileIn.length() + " bytes");

		try (FileInputStream in = new FileInputStream(inFileStr);
				FileOutputStream out = new FileOutputStream(outFileStr)) {
			startTime = System.nanoTime();
			System.out.println("StartTime in FileInputStream : " + startTime);
			int byteRead;
			// Read a raw byte, returns an int of 0 to 255.
			while ((byteRead = in.read()) != -1) {
				// Write the least-significant byte of int, drop the upper 3
				// bytes
				out.write(byteRead);
			}
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("OOPS ! File is missing..");
		}
	}

	// Most common way to read byte streams from a file
	public static void fileCopyWithBufferAndArray() {
		System.out.println("\nInside fileCopyWithBufferAndArray ...");
		
		long startTime, elapsedTime; // for speed benchmarking
		startTime = System.nanoTime();
		System.out.println("StartTime in BufferedInputStream : " + startTime);
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {

			byte[] byteBuf = new byte[4000];
			System.out.println("byteBuf: " + byteBuf.length);
			int numBytesRead;
			while ((numBytesRead = in.read(byteBuf)) != -1) {
				out.write(byteBuf, 0, numBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("fileCopyWithBufferAndArray: " + (elapsedTime / 1000000.0) + " msec");
		
	}

	public static void main(String[] args) {
		fileCopyNoBuffer();
		fileCopyWithBufferAndArray();
		System.out.println(System.getProperty("file.encoding"));
		System.out.println(inFileStr);
		
	}
}
