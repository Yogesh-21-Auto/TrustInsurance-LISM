package com.trustinsurance.payment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trustinsurance.genericutility.ExcelUtility;
import com.trustinsurance.genericutility.FileUtility;
import com.trustinsurance.genericutility.JavaUtility;
import com.trustinsurance.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePaymentInformationUsingClientStatusLink {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;
		
		//to create objects for utility
		JavaUtility jLIB = new JavaUtility();
		FileUtility fLIB = new FileUtility();
		WebDriverUtility wLIB = new WebDriverUtility();
		ExcelUtility eLIB = new ExcelUtility();
		
		//read common data from property file
		String URL = fLIB.getPropertyKeyValue("url");
		String USERNAME = fLIB.getPropertyKeyValue("username");
		String PASSWORD = fLIB.getPropertyKeyValue("password");
		String BROWSER = fLIB.getPropertyKeyValue("browser");
		String AGENTID = fLIB.getPropertyKeyValue("agentID");
		
		
		//get RandomNum and Date
		
		int ranNum = jLIB.getRandomNumber();
		String sysDate = jLIB.getSystemDateAndInIST();
		System.out.println(sysDate);
		
		//read test data from excel
		String recipt_no = eLIB.getExcelData("Clients", 4, 0) + ranNum;
		String clientID = eLIB.getExcelData("Clients", 1, 1) + ranNum;
		String month = eLIB.getExcelData("Clients", 4, 1) + ranNum;
		String amount = eLIB.getExcelData("Clients", 4, 2) + ranNum;
		String due = eLIB.getExcelData("Clients", 4, 3) + ranNum;
		String fine = eLIB.getExcelData("Clients", 4, 4) + ranNum;
				
	/*	//load file input
		FileInputStream fp = new FileInputStream(".\\Data\\commondata.properties");
		
		//create properties object
		Properties prop = new Properties();
		prop.load(fp);
		
		//get the all properties from property file(common Data)
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		String BROWSER = prop.getProperty("browser");
		String AGENTID = prop.getProperty("agentID");

        //Fetch the data from eternal file (Excel-TestData)
		FileInputStream fe = new FileInputStream(".\\Data\\testdata.xlsx");
		
		//to create workbook for excel
		Workbook book = WorkbookFactory.create(fe);
		
		//fetch a sheet
		Sheet sheet = book.getSheet("Clients");
		
		//fetch each test data from respective cell
		String recipt_no = sheet.getRow(4).getCell(0).toString();
		String clientID = sheet.getRow(1).getCell(1).toString();	
		String month = sheet.getRow(4).getCell(1).toString();
		String amount = sheet.getRow(4).getCell(2).toString();
		String due = sheet.getRow(4).getCell(3).toString();
		String fine = sheet.getRow(4).getCell(4).toString();*/
		
		//launch browser
		//to achieve RTP
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			//based on the property file our script is getting changed during RTP
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else 
		{
			System.out.println("INCORRECT BROWSER");
		}
		
	/*	//brows the url
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);*/
		
		wLIB.windowMax(driver);
		wLIB.waitForElementInDOM(driver);
		driver.get(URL);
		
		//login to app
		//from common data
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		//click on clients link
		driver.findElement(By.xpath("//a[@href='client.php']")).click();
		
		//click on client status
		driver.findElement(By.xpath("//a[@href='clientStatus.php?client_id=1.658567243E9']")).click();
		
		//scroll and click on add payment link
		WebElement pay = driver.findElement(By.xpath("//a[.='Add Payment']"));
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		Point loc = pay.getLocation();
		
		int Y = loc.getY();
		js.executeScript("Window.scrollBy("+Y+")");*/
		pay.click();
		
		//to fill payment
		driver.findElement(By.name("recipt_no")).sendKeys(recipt_no);
		driver.findElement(By.name("client_id")).sendKeys(clientID);
		driver.findElement(By.name("month")).sendKeys(month);
		driver.findElement(By.name("amount")).sendKeys(amount);
		driver.findElement(By.name("due")).sendKeys(due);
		driver.findElement(By.name("fine")).sendKeys(fine);

		driver.findElement(By.name("agent_id")).sendKeys(AGENTID);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//click on clients link
	    driver.findElement(By.xpath("//a[@href='payment.php']")).click(); 
		String payText = driver.findElement(By.xpath("//table//tr[58]")).getText();
		System.out.println(payText);
		
		//logout from app
	    driver.findElement(By.xpath("//a[@title='Logout']")).click();
	}

}
