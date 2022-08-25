package com.trustinsurance.nominee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trustinsurance.genericutility.ExcelUtility;
import com.trustinsurance.genericutility.FileUtility;
import com.trustinsurance.genericutility.JavaUtility;
import com.trustinsurance.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithNomineeIDClientPassword {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		WebDriver driver = null;
		
		//to create objects for utility
		JavaUtility jLIB = new JavaUtility();
		FileUtility fLIB = new FileUtility();
		WebDriverUtility wLIB = new WebDriverUtility();
		ExcelUtility eLIB = new ExcelUtility();
		
		//read common data from property file
		String URL = fLIB.getPropertyKeyValue("url");
		
		String BROWSER = fLIB.getPropertyKeyValue("browser");
		
		
		
		//get RandomNum and Date
		int ranNum = jLIB.getRandomNumber();
		String sysDate = jLIB.getSystemDateAndInIST();
		System.out.println(sysDate);
		
		//Fetch the data from eternal file (Excel-TestData)
		String nomiID = eLIB.getExcelData("Clients", 1, 11) + ranNum;
		String clientPass = eLIB.getExcelData("Clients", 1, 1) + ranNum;
				
	/*	//load file input
		FileInputStream fp = new FileInputStream(".\\Data\\commondata.properties");
		
		//create properties object
		Properties prop = new Properties();
		prop.load(fp);
		
		//get the all properties from property file(common Data)
		String URL = prop.getProperty("url");
		
		String BROWSER = prop.getProperty("browser");		
		
		//Fetch the data from eternal file (Excel-TestData)
		FileInputStream fe = new FileInputStream(".\\Data\\testdata.xlsx");
		
		//to create workbook for excel
		Workbook book = WorkbookFactory.create(fe);
		
		//fetch a sheet
		Sheet sheet = book.getSheet("Clients");
		
		//fetch row and Cell
		Row row = sheet.getRow(1);
		
		//fetch each test data from respective cell
		String nomiID = row.getCell(11).toString();
		String clientPass = row.getCell(1).toString();		*/
		
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
		
		//brows the URL
		wLIB.windowMax(driver);
		wLIB.waitForElementInDOM(driver);
		driver.get(URL);
		
		
		//login to app with nominee(negative)
		
		driver.findElement(By.name("username")).sendKeys(nomiID);
		driver.findElement(By.name("password")).sendKeys(clientPass);
		
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		//logout from app
	    driver.findElement(By.xpath("//a[@title='Logout']")).click();		

	}

}
