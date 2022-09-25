package com.revature.selenium.loginpagetests;
 
import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.revature.selenium.base.TestUtilities;
import com.revature.selenium.pages.LoginPage;
import com.revature.selenium.pages.SecureAreaPage;
import com.revature.selenium.pages.WelcomePage;

public class PositiveLogInTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting logIn test");

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
//		driver.findElement(By.id("username")).sendKeys("gpichmann0");
//		driver.findElement(By.id("password")).sendKeys("password");
//		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		
		// execute log in
		SecureAreaPage secureAreaPage = loginPage.logIn("gpichmann0", "password");

		sleep(1000);
		// Verifications
		// New page url is expected
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());
		log.info("OK, got the url!");
		
		// Secure "Landing Page" loginTag is visible
		Assert.assertTrue(secureAreaPage.isNameTagVisible(), " Name Tag is not visible.");
		log.info("OK, got the landing page URL!");
		
		// log out button is visible
//		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "LogOut Button is not visible.");

		// Successful log in message
//		String expectedSuccessMessage = "You logged into a secure area!";
//		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
//		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
//				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
//						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
}
