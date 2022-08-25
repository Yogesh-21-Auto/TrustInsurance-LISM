package com.flipkart.iphone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchIphone {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		
		
		/*FileInputStream fis = new FileInputStream(".\\Data\\testdata.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.createSheet("Sheet4");*/
		System.setProperty("webdriver.gecko.driver","./softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	     
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone 11");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
		ArrayList<String> l = new ArrayList<String>();
		l.add("Apple iPhone 11 (128GB) - Yellow");
		l.add("Apple iPhone 11 (128GB) - Purple");
		l.add("Apple iPhone 11 (64GB) - White");
		l.add("Apple iPhone 11 (64GB) - (Product) RED");
		
		for(String product:l)
		{
			String x = "//span[text()='"+product+"']/../../../..//descendent::span[@class='a-price']";
			String price = driver.findElement(By.xpath(x)).getText();
			System.out.println(product + "==>"+price);
		}
		
		/*List<WebElement> ele = driver.findElements(By.xpath("//a"));
		int count = ele.size();
		
		for(int i=0; i<count; i++)
		{
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue((Date) ele.get(i));
		}
		
		FileOutputStream fout = FileOutputStream(".\\Data\\testdata.xlsx");
        book.write(fout);
        
	}
	private static FileOutputStream FileOutputStream(String string) {
		// TODO Auto-generated method stub
		return null;*/
	
	}
	
	

}
