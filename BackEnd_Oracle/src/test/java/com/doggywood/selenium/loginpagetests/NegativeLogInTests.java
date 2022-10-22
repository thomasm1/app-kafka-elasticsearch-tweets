package com.doggywood.selenium.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.doggywood.selenium.base.TestUtilities;
import com.doggywood.selenium.pages.LoginPage;
import com.doggywood.selenium.pages.WelcomePage;

public class NegativeLogInTests extends TestUtilities {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
//		log.info("Starting negativeTest");
		SoftAssert softAssert = new SoftAssert();

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// execute negative login
		loginPage.negativeLogIn(username, password);

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		// Verification
		softAssert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
		
		softAssert.assertAll();
	}
}
