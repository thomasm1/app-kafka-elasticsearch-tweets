package app.mapl.util.methods.files;

import java.io.*;
import java.util.Scanner;

public class StreamReader {
    static String inFileStr = "earthSpaceDefense.jpg";
    static String outFileStr = "earthSpaceDefense-out.jpg";

    public static void fileCopyNoBuffer() {
        System.out.println("\nInside fileCopyNoBuffer ...");

        long startTime, elapsedTime; // for speed benchmarking

        // Print file length
        File fileIn = new File(inFileStr);
        System.out.println("File size is " + fileIn.length() + " bytes");

        try (FileInputStream in = new FileInputStream(inFileStr);
             FileOutputStream out = new FileOutputStream(outFileStr)) {
            startTime = System.nanoTime();
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
            e.printStackTrace();
        }
    }

    // Most common way to read byte streams from a file
    public static void fileCopyWithBufferAndArray() {
        System.out.println("\nInside fileCopyWithBufferAndArray ...");

        long startTime, elapsedTime; // for speed benchmarking
        startTime = System.nanoTime();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {

            byte[] byteBuf = new byte[4000];
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

    private static void readFromStandardInput() {
        System.out.println("\nInside readFromStandardInput ...");
        String data;
		/*
		System.out.print("Enter \"start\" to continue (Using BufferedReader): ");

		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))){
			while ((data = in.readLine()) != null && !data.equals("start")) {
				System.out.print("\nDid not enter \"start\". Try again: ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Correct!!");
		*/


        System.out.print("\nEnter \"start\" to continue (Using java.util.Scanner): ");
        Scanner scanner = new Scanner(System.in);

        while(!(data = scanner.nextLine()).equals("start")) {
            System.out.print("\nDid not enter \"start\". Try again: ");
        }
        System.out.println("Correct!!");


        System.out.println("Now, enter the start code: ");
        int code = scanner.nextInt(); // other methods: nextLong, nextDouble, etc
        System.out.println("Thanks. You entered code: " + code);



//         * Scanner  parsing primitives & string breaks its input into tokens using a delimited pattern (default: whitespace)
//         *   when System.in is used, Constructor uses  an InputStreamReader to read from it
        Scanner s1 = new Scanner("Hello, Cryptomaven?");
        while(s1.hasNext()) {
            System.out.println(s1.next());
        }
    }

    public static void main(String[] args) {
        fileCopyNoBuffer();
        fileCopyWithBufferAndArray();
        readFromStandardInput();
        System.out.println(System.getProperty("user.dir"));
    }
}