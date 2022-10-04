package models;

public class UserAdminTest { 
	
	private UserAdmin userAdmin;
	
	@org.junit.BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class executing ...");
	}
	
	@org.junit.Before
	public void setup() {
		 System.out.println("Before executing ...");
// int userID, String userName, String password, String firstName, String lastName, boolean isOwner, int offerCount)
//		 userAdmin = new UserAdmin(3, "tmaestas", "password", "thom", "m-last", false, 0);
	   }

//    @org.junit.Test
//    public void setUserAdminID() {  
//    	userAdmin.setUserAdminID(4);  
//    	assertEquals(4, userAdmin.getUserAdminID());
//    }
// 
//    @org.junit.Test
//    public void getUserAdminID() { 
//    	int userId = userAdmin.getUserAdminID();   
//    	System.out.println("-getUserAdminID()-        "+ userId  );  
//    	userAdmin.setUserAdminID(4);  
//    	int userId2 = userAdmin.getUserAdminID();   
//    	System.out.println("-getUserAdminID()-        "+ userId2  );  
//    }

    @org.junit.Test
    public void setUserAdminName() {
//    	userAdmin.setUserAdminName("newUserAdminname");
//    	assertEquals("newUserAdminname", userAdmin.getUserAdminName());
    }

    @org.junit.Test
    public void getUserAdminName() { 
//    	String thomUserAdminName = userAdmin.getUserAdminName();
//    	System.out.println("-getUserAdminName()-  " + thomUserAdminName);
//    	userAdmin.setUserAdminName("newUserAdminname"); 
//    	String thomUserAdminName2 = userAdmin.getUserAdminName();
//    	System.out.println("-getUserAdminName()-  " + thomUserAdminName2);
    }

    @org.junit.Test
    public void setPassword() {
//       userAdmin.setPassword("newPassWord");
//   	assertEquals("newPassWord", userAdmin.getPassword());
    }
    
    @org.junit.Test
    public void getPassword() {
//    	String getpass = userAdmin.getPassword();
//        System.out.println("-getPassword() - " + getpass);
//        userAdmin.setPassword("newPassWord");
//    	String getpass2 = userAdmin.getPassword();
//        System.out.println("-getPassword() - " + getpass2);
    }  

    @org.junit.Test
    public void setOwner() {
//    	userAdmin.setOwner(true);
//       	assertEquals(true, userAdmin.isOwner());
    }
    
    @org.junit.Test
    public void setLastName() {
// 	    String oldLast = userAdmin.getLastName();
// 	    userAdmin.setLastName("m-custNEW-lastNameNEW"); 
//	   
// 	    String newLast = userAdmin.getLastName();
//	    System.out.println("Updated last name: " + newLast);
    }
    
//    @org.junit.Test
//    public void isOwner() {
//    	Boolean isOwnerr = userAdmin.isOwner();
//        System.out.println("-isOwner() - " + isOwnerr);
//    	userAdmin.setOwner(true);
//    	assertTrue("post-purchase", userAdmin.isOwner());
//    	
//    	Boolean isOwnerr2 = userAdmin.isOwner();
//        System.out.println("-isOwner() - " + isOwnerr2);
//    }
//    
//    @org.junit.Test
//	    public void getOfferCount() { 
//	    	int oldOffer = (int) userAdmin.getOfferCount();
//	    	System.out.println("get Offer Cound is: "+ oldOffer);
//	    	 System.out.println("Updated Offer Count is: "+ userAdmin.getOfferCount());
//	    }
//	   
    @org.junit.AfterClass
    public static void afterClass() {
		System.out.println("After Class executing ...");
    }
}