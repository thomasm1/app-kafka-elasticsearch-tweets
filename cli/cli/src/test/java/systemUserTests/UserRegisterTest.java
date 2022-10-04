//package systemUserTests;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class UserRegisterTest {
//
//	@Before
//	
//	public void setup() {
//		String fileName = "C:/w/www/git/java-dev/project0/src/main/java/systemUser/scannertext.txt";
//		System.out.println("Before executing ..." + fileName);
//	}
//
//	@Test // WelcomeScript Test
//	public void WelcomeScriptTest() throws FileNotFoundException {
//		String userScript = "C:/w/www/git/java-dev/project0/src/main/java/systemUser/userscript.txt";
//		File textScript = new File(userScript);
//
//		Scanner scan = new Scanner(textScript);
//		int text = scan.nextInt();
//
//		System.out.println("\nTESTS RUN COUNT: " + text + "\nText Script: " + textScript);
//		scan.close();
//	}
//
//	@Test
//	public void RegisterUsernameTest() throws FileNotFoundException {
//		String userScript = "C:/w/www/git/java-dev/project0/src/main/java/systemUser/userscript.txt";
//		File textScript = new File(userScript);
//
//		Scanner scan = new Scanner(textScript);
//		scan.nextLine();
//		String un = scan.next();
//
//		System.out.println("\nUSERNAME IS: " + un);
//		scan.close();
//	}
//
//	@Test
//	public void RegisterPasswordTest() throws FileNotFoundException {
//		String userScript = "C:/w/www/git/java-dev/project0/src/main/java/systemUser/userscript.txt";
//		File textScript = new File(userScript);
//
//		Scanner scan = new Scanner(textScript);
//		scan.nextLine();
//		scan.nextLine();
//		String pw = scan.next();
//		System.out.println("\n\nPASSWORD IS: " + pw);
//		scan.close();
//	}
//
//	@Test
//	public void RegisterFullnameTest() throws FileNotFoundException {
//		String userScript = "C:/w/www/git/java-dev/project0/src/main/java/systemUser/userscript.txt";
//		File textScript = new File(userScript);
//
//		Scanner scan = new Scanner(textScript);
//		scan.nextLine();
//		scan.nextLine();
//		scan.nextLine();
//		String fn = scan.next();
//
//		System.out.println("\n\nFULL NAME: " + fn);
//
//		scan.close();
//	}
//
//	@After
//	public void teardown() {
//		String fileName = "C:/w/www/git/java-dev/project0/src/main/java/systemUser/scannertext.txt";
//		System.out.println("scan.close() After executing ..."  );
//		Scanner scan = new Scanner(fileName);
//		scan.close();
//	}
//}
