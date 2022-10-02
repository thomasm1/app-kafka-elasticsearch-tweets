package systemUser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserRegisterTest {
 
 	@Before
 	public void setup() {
 		 System.out.println("Before executing ...");
 		 String fileName = "C:/w/www/git/java-dev/project0/src/main/java/systemUser/scannertext.txt";
 		 String userScript = "C:/w/www/git/java-dev/project0/src/main/java/systemUser/userscript.txt";
 	        } 
//	
    @Test
    public void UserRegister() throws FileNotFoundException {
    //	Scanner custLogin = new Scanner(System.in); 
        String userScript = "C:/w/www/git/java-dev/project0/src/main/java/systemUser/userscript.txt";
        File textScript = new File(userScript);
        
        Scanner custLogin = new Scanner(textScript); 
 	    int val = custLogin.nextInt();  
 	    								 // NEEDS >=    <=
 	    custLogin.nextLine();
 	    assertNotNull(custLogin.nextLine());
 	    
 	    Scanner username = new Scanner(textScript); 
 	    username.nextLine();
 	    String un = username.next(); 
 	    
 	    Scanner password = new Scanner(textScript); 
 	    password.nextLine();  
 	    password.nextLine();  
        String pw = password.next();
   	
        Scanner firstname = new Scanner(textScript); 
        firstname.nextLine();
        firstname.nextLine();
        firstname.nextLine();
    	String fn = firstname.next();
     	
    	Scanner lastname = new Scanner(textScript); 
    	lastname.nextLine();
    	lastname.nextLine();
    	lastname.nextLine();
    	lastname.nextLine();
    	String ln = lastname.next();
    	
    	System.out.println("Thanks for choosing option #"+val+", "+ fn +" "+ ln +", your USERNAME IS: "+un+" and PASSWORD IS: "+pw);
    	
    	username.close();
        custLogin.close();
    } 
}
