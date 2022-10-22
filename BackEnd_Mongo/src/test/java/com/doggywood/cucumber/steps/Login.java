package com.doggywood.cucumber.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	WebDriver driver;
	
	 
	@Before
	public void setup() { 
		System.setProperty("webdriver.chrome.driver", "C:\\w\\www\\git\\java-devops\\project2\\src\\test\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}
	 
	
//	@Before
//	public void setup_firefox() {
//		System.setProperty("webdriver.gecko.driver", "src/test/java/CucumberFramework/resources/geckodriver.exe");
//		FirefoxOptions firefoxOptions = new FirefoxOptions();
//		firefoxOptions.setCapability("marionette", true);
//		this.driver = new FirefoxDriver(firefoxOptions);
//		this.driver.manage().window().maximize();
//		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
//	}
	
	@After
	public void tearDown() throws InterruptedException {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	}
	
	@Given("^User navigates to doggywood website$")
	public void user_navigates_to_doggywood_website() throws Throwable {
		driver.get("http://localhost:4200"); 
//		http://doggywood.s3-website-us-east-1.amazonaws.com
	}
 
	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("customer5@gmail.com");
//		driver.findElement(By.cssSelector("#email")).sendKeys("customer5@gmail.com");
	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("password");
//		driver.findElement(By.cssSelector("#password")).sendKeys("password");
	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='submit-button']")).click();
//		driver.findElement(By.id("submit-button")).click();
	}

	@Then("^User should be taken to the successful client landing page$")
	public void user_should_be_taken_to_the_successful_client_landing_page() throws Throwable {
		Thread.sleep(5000); 
		WebElement viewRecordsButton = driver.findElement(By.xpath("//a[contains(text(), 'View Records')]"));
		Assert.assertEquals(true, viewRecordsButton.isDisplayed());
	}     
}
 