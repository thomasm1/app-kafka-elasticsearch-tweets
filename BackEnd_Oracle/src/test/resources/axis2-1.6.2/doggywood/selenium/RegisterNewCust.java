package com.doggywood.selenium;

import java.io.File;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RegisterNewCust {

	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		File file = new File("drivers\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		ChromeDriver driver = new ChromeDriver();

		// OPEN PAGE
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.navigate().to("http://localhost:4200");
		 driver.get("http://doggywood.s3-website-us-east-1.amazonaws.com"); 
		// driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().window().getSize();
		String sizeWindow = driver.getWindowHandle();
		System.out.println("windowSize: " + sizeWindow);
		String title = driver.getTitle();
		System.out.println(title);

		if (title.equalsIgnoreCase("Doggywood"))
			System.out.println("Title Matches: " + title);
		else
			System.out.println("title " + title);

//		System.out.println(tagname);
//		driver.findElement(By.linkText("Fiction Books")).click();

		// CLICK REGISTER
		WebElement button = driver.findElement(By.tagName("button")); // first 1 @ top
		Actions action = new Actions(driver);
		action.moveToElement(button);
		String btnText = button.getText();
		System.out.println(btnText);
		action.click();
		action.perform();
		Thread.sleep(1000);

//		// LOCATE A firstName field ELEMENT
		String tagname = " ";
		tagname = driver.findElement(By.cssSelector("#firstName")).getTagName();
		System.out.println(tagname);

		// TYPING FIRST FIELD
		WebElement firstNameElement = driver.findElement(By.id("firstName"));
		firstNameElement.sendKeys("Clarice");
		Thread.sleep(1000);

		// TYPING 2ND FIELD
		WebElement lastNameElement = driver.findElement(By.name("lastName"));
		lastNameElement.sendKeys("Katz");
		Thread.sleep(1000);

		// TYPING 3RD FIELD - EMAIL
		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys("customer100@gmail.com");		
		Thread.sleep(1000); 
		String e = emailElement.getText();
		Thread.sleep(1000);
		System.out.println("just typed in email: " + e);

		
		// TYPING TEXT PW 
		WebElement pwElement = driver.findElement(By.id("password"));
		pwElement.sendKeys("password");
		String pword = pwElement.getText();
		Thread.sleep(1000);
		System.out.println("just typed in pword: " + pword);
		
//		WebElement pw = driver.findElement(By.name("password"));
//		WebElement pwElement = driver.findElement(By.id("password"));
//		pwElement.sendKeys("password");
//		String pword = pwElement.getText();
//		Thread.sleep(1000);
//		System.out.println(pword);

		// GET LANDING PAGE TITLE
//		String loggedIn = driver.getTitle();
//		System.out.println(loggedIn);

		// GET TEXT
//		String tagname1 = " ";
//		tagname1 = driver.findElement(By.cssSelector("h4")).getText();
//		System.out.println(tagname1);
//
//		if (tagname1.equalsIgnoreCase("Jan Levinson (no Gould)"))
//			System.out.println(":-) name Matches: " + tagname1);
//		else
//			System.out.println("title " + tagname1);

		// closes only the current browser
		driver.close();

		// action.moveToElement(books);
//		System.out.println(books);
//		action.click();
//		action.perform();
//		Thread.sleep(1000);

		// WebElement addPet = driver.findElement(By.name("q"));
//		WebElement myElement=driver.findElement(By.id("twotabsearchtextbox"));
//		myElement.sendKeys("John Grisham");

		// // DROPDOWN
//		WebElement category = driver.findElement(By.cssSelector("#nav-link-shopall > span.line-2 > span"));
//		Actions action = new Actions(driver);
//		action.moveToElement(category).perform();
//		System.out.println(category);
//		Thread.sleep(1000);
//		
//		System.out.println(tagname);
//		WebElement books = driver.findElement(By.cssSelector("#nav-flyout-shopAll > div.nav-2 > span")).findElement(null);
//		action.moveToElement(books);
//		System.out.println(books);
//		action.click();
//		action.perform();
//		Thread.sleep(1000);
//		
//		System.out.println(tagname);
//		driver.findElement(By.linkText("Fiction Books")).click();
//		Thread.sleep(1000);
//		
//		//TYPING TEXT
//			//WebElement searchbar = driver.findElement(By.name("q"));
//		WebElement myElement=driver.findElement(By.id("twotabsearchtextbox"));
//		myElement.sendKeys("John Grisham");
//		
//		driver.findElement(By.className("nav-input")).click();
//		Thread.sleep(1000);
//		
//		//SELECT THE BOOK
//		driver.findElement(By.partialLinkText("Firm")).click();
//		Thread.sleep(2000);
//		
//		//SHIFT THE TAB CONTROL
//		java.util.Set<String> handles = driver.getWindowHandles();
//		String winHandle1 = driver.getWindowHandle();
//		handles.remove(winHandle1);
//		
//		String winHandle=handles.iterator().next();
//		String winHandle2 = "";
//		if(winHandle != winHandle1)
//		{
//			//To retrieve handle of 2nd window, extracting the handle which does not ..
//			winHandle2 = winHandle;//Storing handle of 2nd window handle
//			//Switch contorl to new tab
//			driver.switchTo().window(winHandle2);
//			System.out.println(winHandle2); 
//		}
//		Thread.sleep(1000);
//		
//		//ADD TO CART
//		driver.findElement(By.cssSelector("#add-to-cart-button")).click();
//		Thread.sleep(5000);
//		
//		
//		//SCROLL THE WEB PAGE TILL END.
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		Thread.sleep(1000);
//		
//		//iframes
//		driver.get("http://demo.automationtesting.in/Frames.html");;
//		WebElement frame=driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
//		driver.switchTo().frame(frame);
//		Thread.sleep(1000);
//		
//		WebElement textbox=driver.findElement(By.xpath("//input[@type='text']"));
//		textbox.sendKeys("hey");
//		
//		
//		
//		
////		searchbar.sendKeys("Super Smash Characters");
//		//searchbar.sendKeys(Keys.ENTER);
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

//		WebElement googlesearch = driver.findElement(By.name("btnK"));
//		googlesearch.click();

		// closes all browsers and stops the ChromeDriver
		driver.quit();

		// closes only the current browser
//		driver.close();

		/*
		 * Waits Bad Way: (Use only if necessary) just use Thread.sleep(2000);
		 * 
		 * Okay Way: Implicit waits Will tell Selenium to wait (up to) a standard amount
		 * of time to find an element if it cannot find it immediately.
		 * 
		 * Good Way: Explicit waits Will tell Selenium to wait for a certain element to
		 * become visible before interacting with it.
		 * 
		 */
	}

}
