package com.revature.selenium.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

//	private String pageUrl = "http://commuter.link/";
	private String pageUrl = "http://localhost:4200/";
	
	//*[@id="login"]/app-login/a
	private By formLoginLinkLocator = By.linkText("Login");
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

	/** Open CheckboxesPage by clicking on Checkboxes Link */
	
//	public CheckboxesPage clickCheckboxesLink() {
//		log.info("Clicking Checkboxes link on Welcome Page");
//		click(checkboxesLinkLocator);
//		return new CheckboxesPage(driver, log);
//	}
//
//	public DropdownPage clickDropdownLink() {
//		log.info("Clicking Dropdown link on Welcome Page");
//		click(dropdownLinkLocator);
//		return new DropdownPage(driver, log);
//	}
//
//	public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
//		log.info("Clicking JavaScript Alerts link on Welcome Page");
//		click(javaScriptAlertsLinkLocator);
//		return new JavaScriptAlertsPage(driver, log);
//	}
//
//	public WindowsPage clickMultipleWindowsLink() {
//		log.info("Clicking Multiple Windows link on Welcome Page");
//		click(multipleWindowsLinkLocator);
//		return new WindowsPage(driver, log);
//	}
//
//	public EditorPage clickWYSIWYGEditorLink() {
//		log.info("Clicking WYSIWYG Editor link on Welcome Page");
//		click(editorLinkLocator);
//		return new EditorPage(driver, log);
//	}

}
