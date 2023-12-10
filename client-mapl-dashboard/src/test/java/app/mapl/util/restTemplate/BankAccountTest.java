package app.mapl.util.restTemplate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.mapl.util.methods.BankAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankAccountTest {
    BankAccount account = new BankAccount("TestUser", "LastName", 1000.00, BankAccount.CHECKING);

    @BeforeEach
    public void setUpBalance() {

     }

    @Test
    public void deposit() throws Exception {
        assertEquals(1200.00, account.deposit(200.00, true), 0);
    }

    @Test
    public void withdraw() throws Exception {
        assertEquals(800.00, account.withdraw(200.00, true), 0);
    }

    @Test
    public void getBalance_deposit() throws Exception {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() throws Exception {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {
          assertTrue(account.isChecking(), "The account is a checking account");

    }

}