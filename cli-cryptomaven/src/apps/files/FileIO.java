package apps.files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {
 
	public static void main(String[] files) throws IOException {
		 String[] fileArr =  {"earthSpaceDefense.jpg", "file.txt"};
		
		for (String file: fileArr) {
			 	File f = new File(file);
			 	System.out.println(new StringBuilder("############ ").append(file).append(" #########"));
				System.out.println("getAbsolutePath path : " + f.getAbsolutePath());
				System.out.println("getCanonicalPath path: " + f.getCanonicalPath());
				
				System.out.println("separator: " + f.separator);
				System.out.println("separatorChar: " + f.separatorChar);
				System.out.println("getParent(): " + f.getParent());
				System.out.println("lastModified(): " + f.lastModified());
				System.out.println("exists(): " + f.exists());
				System.out.println("isFile(): " + f.isFile());
				System.out.println("isDirectory(): " + f.isDirectory());
				System.out.println("length(): " + f.length()); 
				System.out.println("WORKING DIR : " + System.getProperty("user.dir"));
				
				System.out.println("new File(\"testdir\") :"+new File("testdir").mkdir());
				System.out.println("new File(\"sub-testdir\").mkdir() :"+new File("testdir\\subdir").mkdir());
				 
				File f2 = new File("temp.txt");
					f2.createNewFile(); // CREATE
					f2.renameTo(new File ("testdir\\temp.txt")); // MOVE
		}
		
	}
 
}
