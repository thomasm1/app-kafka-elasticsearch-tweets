package app.mapl.systemUserTests;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserRegisterTest {

	@BeforeEach
	public void setup() {
		String fileName = "data/scannertext.txt";
		System.out.println("Before executing ..." + fileName);
	}

	@Test // WelcomeScript Test
	public void WelcomeScriptTest() throws FileNotFoundException {
		String userScript = "data/userscript.txt";
		File textScript = new File(userScript);

		Scanner scan = new Scanner(textScript);
		int text = scan.nextInt();

		System.out.println("\nTESTS RUN COUNT: " + text + "\nText Script: " + textScript);
		scan.close();
	}

	@Test
	public void RegisterUsernameTest() throws FileNotFoundException {
		String userScript = "data/userscript.txt";
		File textScript = new File(userScript);

		Scanner scan = new Scanner(textScript);
		scan.nextLine();
		String un = scan.next();

		System.out.println("\nUSERNAME IS: " + un);
		scan.close();
	}

	@Test
	public void RegisterPasswordTest() throws FileNotFoundException {
		String userScript = "data/userscript.txt";
		File textScript = new File(userScript);

		Scanner scan = new Scanner(textScript);
		scan.nextLine();
		scan.nextLine();
		String pw = scan.next();
		System.out.println("\n\nPASSWORD IS: " + pw);
		scan.close();
	}

	@Test
	public void RegisterFullnameTest() throws FileNotFoundException {
		String userScript = "data/userscript.txt";
		File textScript = new File(userScript);

		Scanner scan = new Scanner(textScript);
		scan.nextLine();
		scan.nextLine();
		scan.nextLine();
		String fn = scan.next();

		System.out.println("\n\nFULL NAME: " + fn);

		scan.close();
	}

	@AfterEach
	public void teardown() {
		String fileName = "data/scannertext.txt";
		System.out.println("scan.close() After executing ..."  );
		Scanner scan = new Scanner(fileName);
		scan.close();
	}
}
