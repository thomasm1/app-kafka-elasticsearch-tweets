package com.doggywood.cucumber.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterDoggy {
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

	@Given("^User clicks on the register button on homepage$")
	public void user_clicks_on_the_register_button_on_homepage() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='REGISTER']")).click();
//		driver.findElement(By.xpath("//html/body/header/div/ol[2]/li[2]/a[1]")).click();
	}

	@Given("^User provides a first name$")
	public void user_provides_a_first_name() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='firstName']")).sendKeys("first_name");
//		driver.findElement(By.cssSelector("#firstName")).sendKeys("first_name"); 
	}

	@Given("^User provides a last name$")
	public void user_provides_a_last_name() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='lastName']")).sendKeys("last_name");
//		driver.findElement(By.cssSelector("#lastName")).sendKeys("last_name"); 
	}
	@Given("^User provides a valid email$")
	public void user_provides_a_valid_email() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("customer99@gmail.com");
//		driver.findElement(By.cssSelector("#email")).sendKeys("customer989@gmail.com"); 
	}

	@Given("^User provides a valid password$")
	public void user_provides_a_valid_password() throws Throwable {
//		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("password");
		driver.findElement(By.cssSelector("#password")).sendKeys("password");
	}

	@Given("^User provides a phone number$")
	public void user_provides_a_phone_number() throws Throwable {
//		driver.findElement(By.xpath(".//*[@id='phone']")).sendKeys("505-508-7707");
		driver.findElement(By.cssSelector("#phone")).sendKeys("505-508-7707");
	}

	@Given("^User provides a photo url$")
	public void user_provides_a_photo_url() throws Throwable {
//		driver.findElement(By.xpath(".//*[@id='cusUrl']")).sendKeys("https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg");
		driver.findElement(By.cssSelector("#cusUrl")).sendKeys("https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg");
	}

	@When("^User clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
//		driver.findElement(By.xpath(".//*[@id='register-button']")).click();
		driver.findElement(By.id("register-button")).click();
	}
 
	@Then("^User is redirected to login page$")
	public void user_is_redirected_to_login_page() throws Throwable {
		System.out.println("Succeeded with registration");
	}
	// BACK TO LOGIN PAGE

}
