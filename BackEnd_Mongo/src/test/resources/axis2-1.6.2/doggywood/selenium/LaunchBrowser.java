package com.doggywood.selenium;
 
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		File file = new File("drivers/driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		WebElement searchbar = driver.findElement(By.name("q"));
		
		searchbar.sendKeys("Super Smash Characters");
		//searchbar.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		WebElement googlesearch = driver.findElement(By.name("btnK"));
		googlesearch.click();
		
		
		//closes all browsers and stops the ChromeDriver
		driver.quit();
		
		driver.close(); //closes only the current browser
	
		/*
		 * Waits
		 * 
		 * 
		 * Bad Way: (Use only if necessary) just use Thread.sleep(2000);
		 * 
		 * Okay Way: Implicit waits
		 * Will tell Selenium to wait (up to) a standard amount of time
		 * to find an element if it cannot find it immediately.
		 * 
		 * Good Way: Explicit waits
		 * Will tell Selenium to wait for a certain element to become visible
		 * before interacting with it.
		 * 
		 */
	}
	
}
