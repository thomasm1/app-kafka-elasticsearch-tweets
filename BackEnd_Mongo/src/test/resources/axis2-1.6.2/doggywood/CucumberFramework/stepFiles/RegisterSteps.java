package com.doggywood.CucumberFramework.stepFiles; 

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RegisterSteps {
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/driver/chromedriver.exe");
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

	@Given("^User clicks on the register button on homepage$")
	public void user_clicks_on_the_register_button_on_homepage() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Register']")).click();
//		driver.findElement(By.xpath("//html/body/header/div/ol[2]/li[2]/a[1]")).click();
	}

	@Given("^User provides a first name$")
	public void user_provides_a_first_name() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='fName']")).sendKeys("first_name");
//		driver.findElement(By.cssSelector("#fName")).sendKeys("first_name"); 
	}

	@Given("^User provides a last name$")
	public void user_provides_a_last_name() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='lName']")).sendKeys("last_name");
//		driver.findElement(By.cssSelector("#lName")).sendKeys("last_name"); 
	}
	@Given("^User provides a valid email$")
	public void user_provides_a_valid_email() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("customer5@gmail.com");
//		driver.findElement(By.cssSelector("#email")).sendKeys("customer5@gmail.com"); 
	}

	@Given("^User provides a valid password$")
	public void user_provides_a_valid_password() throws Throwable {
//		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("password");
		driver.findElement(By.cssSelector("#password")).sendKeys("password");
	}

	@Given("^User provides a phone number$")
	public void user_provides_a_phone_number() throws Throwable {
//		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("password");
		driver.findElement(By.cssSelector("#password")).sendKeys("password");
	}

	@Given("^User provides a photo url$")
	public void user_provides_a_photo_url() throws Throwable {
//		driver.findElement(By.xpath(".//*[@id='custUrl']")).sendKeys("https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg");
		driver.findElement(By.cssSelector("#custUrl")).sendKeys("https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg");
	}

	@When("^User clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
//		driver.findElement(By.xpath(".//*[@id='submit-button']")).click();
		driver.findElement(By.id("submit-button")).click();
	}

	@Then("^User should be taken to the client login page$")
	public void user_should_be_taken_to_the_client_login_page() throws Throwable {
		Thread.sleep(3000);
//		WebElement askQuestionButton = driver.findElement(By.xpath("//a[contains(text(), 'Ask Question')]"));
//		Assert.assertEquals(true, askQuestionButton.isDisplayed());
	}

}
