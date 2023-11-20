package com.doggywood.selenium.loginpagetests;

import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import com.doggywood.selenium.base.TestUtilities;
import com.doggywood.selenium.pages.LoginPage;
import com.doggywood.selenium.pages.SecureAreaPage;
import com.doggywood.selenium.pages.WelcomePage;

public class PositiveLogInTests extends TestUtilities {

	@Test
	public void logInTest() {
//		log.info("Starting logIn test");
		SoftAssert softAssert = new SoftAssert();
		
		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
//		driver.findElement(By.id("username")).sendKeys("tom");
//		driver.findElement(By.id("password")).sendKeys("superSecret");
//		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		
		// execute log in
		SecureAreaPage secureAreaPage = loginPage.logIn("customer1@gmail.com", "password");
		
		sleep(1500);
		// Verifications
		// New page url is expected
		softAssert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// log out button is visible
		softAssert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "LogOut Button is not visible.");

		// Successful log in message
//		String expectedSuccessMessage = "You logged into a secure area!";
//		String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
//		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
//				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
//						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

		softAssert.assertAll();
	}
}
