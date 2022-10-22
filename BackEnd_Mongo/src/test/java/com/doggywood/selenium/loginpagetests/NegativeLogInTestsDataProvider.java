package com.doggywood.selenium.loginpagetests;

import java.util.Map;

import org.testng.Assert;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.doggywood.selenium.base.TestUtilities;
import com.doggywood.selenium.pages.LoginPage;
import com.doggywood.selenium.pages.WelcomePage;
import com.doggywood.selenium.base.CsvDataProviders;

public class NegativeLogInTestsDataProvider extends TestUtilities {

//	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1, dataProvider="csvReader", dataProviderClass = CsvDataProviders.class)
//	public void negativeTest(String username, String password, String expectedErrorMessage) {
	public void negativeLogInTest(Map<String, String> testData) { 
		
		// incoming data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");
		
		
		log.info("Starting negativeTest: " + no + " for " + description);
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
