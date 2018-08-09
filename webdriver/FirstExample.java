package com.wbl;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. load the driver into the environment
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Preeti\\eclipse-workspace\\JuneBatch2018\\Resources\\chromedriver.exe");
	   //2. Create the instance of the driver 
	    WebDriver driver = new ChromeDriver();
	    
	    //3. Load the given URL in the browser. it should be complete URL
	    driver.get("https://www.walmart.com/account/signup");
	    
	    // click on login
	    
//	    WebElement login=driver.findElement(By.xpath("//*[@id=\"loginButton\"]"));
//	    login.click();
//	    
    WebElement un=driver.findElement(By.xpath("//*[@id=\"username\"]"));
    un.sendKeys("training.wbl@gmail.com");
//    
    
    
    
	    WebElement fn=driver.findElement(By.xpath("//*[@id='signUpContainer']/form/div[3]/label/div[2]/div/input"));
	    fn.sendKeys("sdsjj");


	    
	    System.out.println("Title page:- "+driver.getTitle());
	    
	    //driver.close();
	    //driver.quit();
	}
//	public static void usePhantomJSDriver() {
//		   System.setProperty("phantomjs.binary.path", System.getProperty("user.dir")+"\\resource\\phantomjs.exe");	
//		   WebDriver driver = new PhantomJSDriver();
//		   driver.get("http://www.google.com");
//		   System.out.println(driver.getCurrentUrl());
//			System.out.println(driver.getTitle());
//			System.out.println(driver.getWindowHandle());
//
//		}
		
		
//		public static void htmlUnitDriver() {
//			WebDriver driver = new HtmlUnitDriver();
//			//driver.get("https://walmart.com");
//			driver.get("http://www.nasdaq.com/");
//			//((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 500)");
//			List<WebElement>  tab = driver.findElements(By.cssSelector("#indexTable > thead > tr > th"));
//			for(WebElement e : tab)
//				 System.out.println(e.getText());
//			
//			System.out.println(driver.getCurrentUrl());
//			System.out.println(driver.getTitle());
//			System.out.println(driver.getWindowHandle());
//
//		}
//		public static void desiredCapabilities() {
//			
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments("--disable-notifications");
//			WebDriver driver = new ChromeDriver(chromeOptions);
//			DesiredCapabilities dc = DesiredCapabilities.chrome();
//			dc.setCapability("javascriptEnabled", false);
//			System.out.println(dc.getCapability("javascriptEnabled"));
//			driver.get("http://www.google.com");
//			
//			
//		}
//		

}
