package xyz.climongoapp.methods.files;

import xyz.climongoapp.methods.DateSingleton;

import java.io.*;
import java.util.Arrays;

public class SerializeTest implements java.io.Serializable {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		String pathname = "dateUtil.ser";
		DateSingleton dateSingleton = DateSingleton.getInstance();
		DateSingleton dateSingleton_2 = null;

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(pathname)))) {

			oos.writeObject(dateSingleton);
			System.out.println(dateSingleton);

			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(pathname)))) {
				dateSingleton_2 = (DateSingleton) ois.readObject();
				System.out.println(dateSingleton_2);
			} finally {
				System.out.println(" write done");
			}
		} finally {
			System.out.println("read/write done");
			System.out.println(dateSingleton_2 == dateSingleton); // false not singleton unless readResolve
		}

	}

	public static void encodeThis(String symbol) throws UnsupportedEncodingException {
		System.out.println("ENCODING: ..." + symbol);

		System.out.println(Arrays.toString(symbol.getBytes("US-ASCII")));
		System.out.println(Arrays.toString(symbol.getBytes("US-ASCII")));
		System.out.println(Arrays.toString(symbol.getBytes("ISO-8859-1"))); // ASCII +
		System.out.println(Arrays.toString(symbol.getBytes("ISO-8859-1"))); // ASCII +
		System.out.println("UTF-8");
		System.out.println(Arrays.toString(symbol.getBytes("UTF-8")));
		System.out.println("UTF-16");
		System.out.println(Arrays.toString(symbol.getBytes("UTF-16"))); // includes Byte-Order-Mark BE "FEFF"
		System.out.println("UTF-16BE"); // big endian
		System.out.println(Arrays.toString(symbol.getBytes("UTF-16BE"))); // big endian
		System.out.println("UTF-16LE"); // little Endian
		System.out.println(Arrays.toString(symbol.getBytes("UTF-16LE"))); // little Endian
	}

	public int a;
	public String b;

	// Default constructor
	public SerializeTest(int a, String b) {
		this.a = a;
		this.b = b;
	}

	public static void serialTest(int i, String fileString) // "file.txt"
															// Line 1
															// line 2
															// line 3
	{
		SerializeTest object = new SerializeTest(1, fileString);
		String filename = fileString;

		// Serialization
		try {
			// ....Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(object);
			out.close();
			file.close();
			System.out.println("Object has been serialized");
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		SerializeTest object1 = null;
		// Deserialization
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			object1 = (SerializeTest) in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized ");
			System.out.println("a = " + object1.a);
			System.out.println("b = " + object1.b);
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

	}
}