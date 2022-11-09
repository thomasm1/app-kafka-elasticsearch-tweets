package xyz.cryptomaven.app.system;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.cryptomaven.app.systemAdmin.AdministrateAcct;


public class AdministrateAcctTest {

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void deposit() throws Exception {
    			//    	int carID, int userID,  int offerID, double balance, int offerStatus, int offerCount
        AdministrateAcct account = new AdministrateAcct(1005, 7, 207, 30301, 1, 2);
//        double carCount = offer.make(2000.00, true);
//        assertEquals(1200.00, carCount, 0);
    }

    @Test
    public void newBal() throws Exception {
        fail("This test has yet to be implemented");
    }

    @Test
    public void getBalance_user() throws Exception {
//        AdministrateAcct account = new AdministrateAcct("Tom", "Maestas", 1000.00, AdministrateAcct.PENDING);
//        account.deposit(200.00, true);
//        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_newBal() throws Exception {
//        AdministrateAcct account = new AdministrateAcct("Tom", "Maestas", 1000.00, AdministrateAcct.PENDING);
//        account.newBal(200.00, true);
//        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void isOwner_true() {
//        AdministrateAcct account = new AdministrateAcct("Tom", "Maestas", 1000.00, AdministrateAcct.PENDING);
//        assertTrue("The account is not pending", account.Pending());

    }

    @Test
    public void getCarID() {
    }
 

    @Test
    public void getUserID() {
    } 

    @Test
    public void getOfferID() {
    } 
    
    @Test
    public void getOfferCount() {
    }

    @Test
    public void setOfferCount() {
    }
}