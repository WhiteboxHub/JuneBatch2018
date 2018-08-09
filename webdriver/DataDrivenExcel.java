package com.wbl;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenExcel {
	
	public static void main(String args[]) throws AWTException, IOException, InterruptedException{
		//new DataDrivenExcel().excelWrite();
		//new DataDrivenExcel().excelRead();
		//new DataDrivenExcel().fileUploadWithRobot();
		//new DataDrivenExcel().useTables();
		new DataDrivenExcel().useFrames();
	}
	
	public void excelRead() throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\Preeti\\Desktop\\DataJune.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh1 = wb.getSheet("Employee");
		XSSFRow row1 = sh1.getRow(0);
		XSSFCell cell = row1.getCell(0);
		String s = cell.getStringCellValue();
		System.out.println("First cell value "+ s);
		System.out.println("No of rows:"+sh1.getLastRowNum());
		wb.close();
		//getLastRowNum()
		//getLastCellNum()
		// with testng dataprovider you can write the object[][] with the data read
	}
	
	public void excelWrite() throws IOException{
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet1 = wb.createSheet("Employee");
		XSSFRow sh1row = sheet1.createRow(0);
		XSSFCell sh1cell = sh1row.createCell(0);
		sh1cell.setCellValue("Enter Employee Details");
				
		
		XSSFSheet sheet2 = wb.createSheet("Department");
		XSSFRow sh2row = sheet2.createRow(0);
		XSSFCell sh2cell = sh2row.createCell(0);
		sh2cell.setCellValue("Enter Department Details");
		
		FileOutputStream file = new FileOutputStream("C:\\Users\\Preeti\\Desktop\\DataJune.xlsx");
		wb.write(file);
		
		System.out.println("successfully written file ");
			wb.close();
	}
	
	public void fileUploadWithRobot() throws AWTException{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://jpg2pdf.com/");
		StringSelection path = new StringSelection("C:\\Users\\WBL\\Documents\\webdriver8.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		driver.findElement(By.cssSelector("#pick-files > span.ui-button-text")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		System.out.println("..1");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("..2");
		
	}
	public void fileUploadWithAutoIT() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://jpg2pdf.com/");
		driver.findElement(By.cssSelector("#pick-files > span.ui-button-text")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"//resources//Test.exe");
		//Process pro = new ProcessBuilder(System.getProperty(System.getProperty("user.dir")+"//resources//Test.exe"),"", "Open").start();  
		
}
	
	public void useTables(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://www.nasdaq.com/");
		//((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 500)");
		//List<WebElement>  tab = driver.findElements(By.cssSelector("#indexTable > thead > tr > th"));
		//body > table > tbody > tr:nth-child(1)
		
		driver.get("file:///C://Users//Preeti//Desktop//Table.html");
		//List<WebElement>  tab = driver.findElements(By.cssSelector("body > table > tbody > tr:nth-child(1)"));
		System.out.println("in use tables... for columns......");
		List<WebElement>  tab = driver.findElements(By.xpath("/html/body/table/tbody/tr/td[1]"));
	for(WebElement e : tab)
	 System.out.println(e.getText());
	System.out.println("in use tables......2...");
		//  //*[@id="indexTable"]/tbody/tr/td[2]  xpath
		//  #indexTable>tbody>tr>td:nth-child(2)  CSS
		//  tab = driver.findElements(By.cssSelector("body > table > tbody > tr > td:nth-child(2)"));
		  tab = driver.findElements(By.xpath("/html/body/table/tbody/tr[2]/td"));
		  System.out.println("in use tables....3.. for rows...");
		for(WebElement e : tab)
			 System.out.println(e.getText());
		
		
		
		Select sel = new Select(driver.findElement(By.name("cars")));
		
		System.out.println("Multiple selection : "+ sel.isMultiple());
		
		sel.selectByIndex(0);
		sel.selectByVisibleText("Saab");
		sel.selectByValue("opel");
		//if(sel.isMultiple())
		tab = sel.getAllSelectedOptions();
		
		for(WebElement e : tab)
			 System.out.println(e.getText());
		
		System.out.println("in use tables......4...");
		///html/body/table/tbody/tr[2]/td[1]
	}
	
	
	public void useFrames() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/");
		WebElement frame1 = driver.findElement(By.name("packageListFrame"));
		WebElement frame2 = driver.findElement(By.name("packageFrame"));
		WebElement frame3 = driver.findElement(By.name("classFrame"));
		
		driver.switchTo().frame(frame1);
		//   /html/body/div[2]/ul/li[1]/a
		driver.findElement(By.xpath("/html/body/div[2]/ul/li[1]/a")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("/html/body/div/ul[1]/li[3]/a/span")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("/html/body/div[3]/div")).click();
     // contextClick --- right click ................
		//click and submit  ....click is for any clickable webelement  but submit is for form
		/*
		 * <form action="/action_page.php">
<select name="cars" multiple>
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
<input type="submit">
</form>
		 */
		
		
	}
	
	
	
}
