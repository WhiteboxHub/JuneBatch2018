package com.wbl;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Example {
	
	public static WebDriver driver; 
	
	public static void main(String args[]) throws AWTException, IOException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//chromedriver.exe");
		driver = new ChromeDriver();
		useScrolling();
	}


	
	public static void mouseHoverDepartment() {
		WebElement dept = driver.findElement(By.id("header-GlobalLefthandNav-toggle-1"));
		Actions action = new Actions(driver);
		action.moveToElement(dept).perform();//mouse hover  build().perform()
		dept = driver.findElement(By.id("superDeptId-0"));
		//WebDriverWait wait = new WebDriverWait(driver,10);
		// dept = wait.until(ExpectedConditions.visibilityOfElementLocated(dept));
		action.moveToElement(dept).perform();
	}
	
	public static void useScrolling() {
		// javascript code to check if the page is completely loaded
		driver.get("https://www.walmart.com/");
		((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		System.out.println("Document loaded............");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 1200)");
		System.out.println("scrolling down...............");
		
	}
	
	public static void learnCookie() {
		    Set <Cookie> set = driver.manage().getCookies();
		    System.out.println("set size "+set.size());
		    for(Cookie e : set)
		    	System.out.println("name="+e.getName() + "#" + e.getExpiry());
		    Cookie cookie = new Cookie("key","value");
		    driver.manage().addCookie(cookie);
		     set = driver.manage().getCookies();
		    System.out.println("set size after adding "+set.size());
		    
		    driver.manage().deleteCookieNamed("key");
		    set = driver.manage().getCookies();
		    System.out.println("set size after deletion "+set.size());
		    
	}
}
