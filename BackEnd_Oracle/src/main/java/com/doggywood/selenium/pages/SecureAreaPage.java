package com.doggywood.selenium.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

	private String pageUrl = "http://localhost:4200/clients/1";
	
	private String basePageUrl = "http://localhost:4200/clients/";
	
//	private String pageUrl = "http://localhost:4200/login";
 
//	private By logOutButton = By.xpath("//a[@class='logout']");
	private By logOutButton = By.id("logout");
	private By message = By.id("flash-messages");

	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Get URL variable from PageObject */
	public String getPageUrl() {
		return pageUrl;
	}
	/** Get URL variable from PageObject */
	public String getBasePageUrl() {
		return basePageUrl;
	}
	/** Verification if logOutButton is visible on the page */
	public boolean isLogOutButtonVisible() {
		return find(logOutButton).isDisplayed();
	}

	/** Return text from success message */
	public String getSuccessMessageText() {
		return find(message).getText();
	}

}
