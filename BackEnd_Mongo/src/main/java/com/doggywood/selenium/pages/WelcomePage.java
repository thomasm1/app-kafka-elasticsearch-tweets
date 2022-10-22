package com.doggywood.selenium.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

	private String pageUrl = "http://localhost:4200/";
//	private String pageUrl = "http://doggywood.s3-website-us-east-1.amazonaws.com/";
 

	//*[@id="login"]/app-login/a
	private By formLoginLinkLocator = By.id("login");
//	private By checkboxesLinkLocator = By.linkText("Checkboxes");
//	private By dropdownLinkLocator = By.linkText("Dropdown");
//	private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
//	private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
//	private By editorLinkLocator = By.linkText("WYSIWYG Editor");
	
	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open WelcomePage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		
//		driver.get(url);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** Open LoginPage by clicking on Login Link */
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Login link on Front Page");
		click(formLoginLinkLocator);
		return new LoginPage(driver, log);
	}
	
	 

}
