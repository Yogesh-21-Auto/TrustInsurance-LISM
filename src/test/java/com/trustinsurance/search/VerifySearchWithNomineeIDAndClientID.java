package com.trustinsurance.search;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

import com.trustinsurance.genericutility.ExcelUtility;
import com.trustinsurance.genericutility.FileUtility;
import com.trustinsurance.genericutility.JavaUtility;
import com.trustinsurance.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySearchWithNomineeIDAndClientID {

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
		
		
		
		//get RandomNum and Date
		int ranNum = jLIB.getRandomNumber();
		String sysDate = jLIB.getSystemDateAndInIST();
		System.out.println(sysDate);
		
		//read test data from excel
		String clientID = eLIB.getExcelData("Clients", 1, 0) + ranNum;
		String nomiID = eLIB.getExcelData("Clients", 1, 11) + ranNum;	
		
		/*//load file input
		FileInputStream fp = new FileInputStream(".\\Data\\commondata.properties");
		
		//create properties object
		Properties prop = new Properties();
		prop.load(fp);
		
		//get the all properties from property file(common Data)
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		String BROWSER = prop.getProperty("browser");
		
		//Fetch the data from eternal file (Excel-TestData)
		FileInputStream fe = new FileInputStream(".\\Data\\testdata.xlsx");
		
		//to create workbook for excel
		Workbook book = WorkbookFactory.create(fe);
		
		//fetch the sheet
		Sheet sheet = book.getSheet("Clients");
		
		//fetch row and Cell
		Row row = sheet.getRow(1);
		
		//fetch each test data from respective cell
		String clientID = row.getCell(0).toString();	
		String nomiID = row.getCell(11).toString(); */
		
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
		
		/*//brows the url
		
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
		
		//to search the results by clientID
		//driver.findElement(By.name("key")).sendKeys(clientID);
		//driver.findElement(By.xpath("//input[@class='searchBtn']")).click();
		driver.findElement(By.xpath("//a[@href='client.php']")).click();
	    String cliText = driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText();
	    driver.findElement(By.xpath("//a[@href='index.php']")).click();
	    driver.findElement(By.name("key")).sendKeys(cliText);
		driver.findElement(By.xpath("//input[@class='searchBtn']")).click();
		List<WebElement> nomineeText = driver.findElements(By.xpath("//tbody"));
		System.out.println(nomineeText);
		int cliCount = nomineeText.size();
		System.out.println(cliCount);
		
		//to search the results by nomineeID
		driver.findElement(By.xpath("//a[@href='nominee.php']")).click();
	    String nomiText = driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText();
	    driver.findElement(By.xpath("//a[@href='index.php']")).click();
	    driver.findElement(By.name("key")).sendKeys(nomiText);
		driver.findElement(By.xpath("//input[@class='searchBtn']")).click();
		List<WebElement> clientText = driver.findElements(By.xpath("//tbody"));
		System.out.println(clientText);
		int nomiCount = clientText.size();
		System.out.println(nomiCount);
		
	/*	//Fetch the data from eternal file (Excel-TestData)
		FileInputStream fr = new FileInputStream(".\\Data\\testdata.xlsx");
		
		//to create workbook for excel
		Workbook wb = WorkbookFactory.create(fr);
		
		List<WebElement> clientText = driver.findElements(By.xpath("//table[1]"));
		System.out.println(clientText);
		int count = clientText.size();
		System.out.println(count);
		
	/*	//create a sheet
		Sheet sh = wb.createSheet("writedata");
	    List<WebElement> clientText = driver.findElements(By.xpath("//table[1]"));
		System.out.println(clientText);
		int count = clientText.size();
		System.out.println(count);
		
		Row r = sh.createRow(1);
		r.createCell(0).setCellValue("1.658567243E9");
		r.createCell(1).setCellValue("Yogi");
		r.createCell(2).setCellValue("01-Apr-1996");
		r.createCell(3).setCellValue("7.894561238E9");
		r.createCell(4).setCellValue("Bangalore");
		
		FileOutputStream fout=new FileOutputStream(".\\Data\\testdata.xlsx");
		book.write(fout);*/
		
		//logout from app
	  //  driver.findElement(By.xpath("//a[@title='Logout']")).click();
}
}
