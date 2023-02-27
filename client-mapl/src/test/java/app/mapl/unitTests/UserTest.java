package app.mapl.unitTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.mapl.models.User;

public class UserTest { 
	
	private User custOne;
	
	@BeforeAll
	public static void beforeClass() {
		System.out.println("Before Class executing ...");
	}
	
	@BeforeEach
	public void setup() {
		 System.out.println("Before executing ...");
// int userID, String userName, String password, String firstName, String lastName, boolean isOwner, int offerCount)
//		 custOne = new User(3, "tmaestas", "password", "thom", "m-last", false, 0);
	   }

//    @Test
//    public void setUserID() {  
//    	custOne.setUserID(4);  
//    	assertEquals(4, custOne.getUserID());
//    }
// 
//    @Test
//    public void getUserID() { 
//    	int userId = custOne.getUserID();   
//    	System.out.println("-getUserID()-        "+ userId  );  
//    	custOne.setUserID(4);  
//    	int userId2 = custOne.getUserID();   
//    	System.out.println("-getUserID()-        "+ userId2  );  
//    }

    @Test
    public void setUserName() {
//    	custOne.setUserName("newUsername");
//    	assertEquals("newUsername", custOne.getUserName());
    }

    @Test
    public void getUserName() { 
//    	String thomUserName = custOne.getUserName();
//    	System.out.println("-getUserName()-  " + thomUserName);
//    	custOne.setUserName("newUsername"); 
//    	String thomUserName2 = custOne.getUserName();
//    	System.out.println("-getUserName()-  " + thomUserName2);
    }

    @Test
    public void setPassword() {
//       custOne.setPassword("newPassWord");
//   	assertEquals("newPassWord", custOne.getPassword());
    }
    
    @Test
    public void getPassword() {
//    	String getpass = custOne.getPassword();
//        System.out.println("-getPassword() - " + getpass);
//        custOne.setPassword("newPassWord");
//    	String getpass2 = custOne.getPassword();
//        System.out.println("-getPassword() - " + getpass2);
    }  

    @Test
    public void setOwner() {
//    	custOne.setOwner(true);
//       	assertEquals(true, custOne.isOwner());
    }
    
    @Test
    public void setLastName() {
// 	    String oldLast = custOne.getLastName();
// 	    custOne.setLastName("m-custNEW-lastNameNEW"); 
//	   
// 	    String newLast = custOne.getLastName();
//	    System.out.println("Updated last name: " + newLast);
    }
    
//    @Test
//    public void isOwner() {
//    	Boolean isOwnerr = custOne.isOwner();
//        System.out.println("-isOwner() - " + isOwnerr);
//    	custOne.setOwner(true);
//    	assertTrue("post-purchase", custOne.isOwner());
//    	
//    	Boolean isOwnerr2 = custOne.isOwner();
//        System.out.println("-isOwner() - " + isOwnerr2);
//    }
//    
//    @Test
//	    public void getOfferCount() { 
//	    	int oldOffer = (int) custOne.getOfferCount();
//	    	System.out.println("get Offer Cound is: "+ oldOffer);
//	    	 System.out.println("Updated Offer Count is: "+ custOne.getOfferCount());
//	    }
//	   
    @AfterAll
    public static void afterClass() {
		System.out.println("After Class executing ...");
    }
}