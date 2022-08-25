package com.trustinsurance.clients;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.trustinsurance.LISM.OR.Loginpage;
import com.trustinsurance.genericutility.ExcelUtility;
import com.trustinsurance.genericutility.FileUtility;
import com.trustinsurance.genericutility.JavaUtility;
import com.trustinsurance.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateClientIdPasswordLoginWithSame {

	
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;
		
		//to create objects for utility
		
		JavaUtility jLIB = new JavaUtility();
		FileUtility fLIB = new FileUtility();
		WebDriverUtility wLIB = new WebDriverUtility();
		//ExcelUtility eLIB = new ExcelUtility();
		
		//read common data from property file
		String URL = fLIB.getPropertyKeyValue("url");
		//String USERNAME = fLIB.getPropertyKeyValue("username");
		//String PASSWORD = fLIB.getPropertyKeyValue("password");
		String BROWSER = fLIB.getPropertyKeyValue("browser");
		//String AGENTID = fLIB.getPropertyKeyValue("agentID");
		
		
		//get RandomNum and Date
		
		int ranNum = JavaUtility.getRandomNumber();
		String sysDate = jLIB.getSystemDateAndInIST();
		System.out.println(sysDate);
		
		/*//read test data from excel
		String clientID = eLIB.getExcelData("Clients", 1, 0) + ranNum;
		String clientPass = eLIB.getExcelData("Clients", 1, 1) + ranNum;
		String clientName = eLIB.getExcelData("Clients", 1, 2) + ranNum;
		String clientGender = eLIB.getExcelData("Clients", 1, 3) + ranNum;
		String clientBirth = eLIB.getExcelData("Clients", 1, 4) + ranNum;
		String clientMarital = eLIB.getExcelData("Clients", 1, 5) + ranNum;
		String clientNatID = eLIB.getExcelData("Clients", 1, 6) + ranNum;
		String ClientPhone = eLIB.getExcelData("Clients", 1, 7) + ranNum;
		String clientAddr = eLIB.getExcelData("Clients", 1, 8) + ranNum;
		String ClientPolID = eLIB.getExcelData("Clients", 1, 9) + ranNum;
		String nomiID = eLIB.getExcelData("Clients", 1, 10) + ranNum;
		String nomiName = eLIB.getExcelData("Clients", 1, 11) + ranNum;
		String nomiGen = eLIB.getExcelData("Clients", 1, 12) + ranNum;
		String nomiBirth = eLIB.getExcelData("Clients", 1, 13) + ranNum;
		String nomiNatID = eLIB.getExcelData("Clients", 1, 14) + ranNum;
		String nomiRel = eLIB.getExcelData("Clients", 1, 15) + ranNum;
		String nomiPriority = eLIB.getExcelData("Clients", 1, 16) + ranNum;
		String nomiPhone  = eLIB.getExcelData("Clients", 1, 17) + ranNum;
		
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
		
		//fetch row and Cell
		Row row = sheet.getRow(1);
		
		//fetch each test data from respective cell
		String clientID = row.getCell(0).toString();
		String clientPass = row.getCell(1).toString();
		String clientName = row.getCell(2).toString();
		String clientGender = row.getCell(3).toString();
		String clientBirth = row.getCell(4).toString();
		String clientMarital = row.getCell(5).toString();
		String clientNatID = row.getCell(6).toString();
		String ClientPhone = row.getCell(7).toString();
		String clientAddr = row.getCell(8).toString();
		String ClientPolID = row.getCell(9).toString();
		
		String nomiID = row.getCell(11).toString();
		String nomiName = row.getCell(12).toString();
		String nomiGen = row.getCell(13).toString();
		String nomiBirth = row.getCell(14).toString();
		String nomiNatID = row.getCell(15).toString();
		String nomiRel = row.getCell(16).toString();
		String nomiPriority = row.getCell(17).toString();
		String nomiPhone = row.getCell(18).toString();*/
		
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
		
		wLIB.windowMax(driver);
		wLIB.waitForElementInDOM(driver);
		driver.get(URL);
		
		/*
		//brows the url
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		
	/*	//login to app
		//from common data
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		//to test data
		//click on clients link
		driver.findElement(By.xpath("//a[@href='client.php']")).click();
		
		//AddClientID
		driver.findElement(By.xpath("//a[text()='Add Client']")).click();
		driver.findElement(By.name("client_id")).clear();
		driver.findElement(By.name("client_id")).sendKeys(clientID);
		driver.findElement(By.name("client_password")).sendKeys(clientPass);
		driver.findElement(By.name("name")).sendKeys(clientName);
		
		//image upload
		driver.findElement(By.xpath("//input[@class='img']")).sendKeys("C:\\Users\\acer\\eclipse-workspace\\Trustinsurance_seleniumframework\\photos\\wp2024570.jpg");;
		
		
		driver.findElement(By.name("sex")).sendKeys(clientGender);
		driver.findElement(By.name("birth_date")).sendKeys(clientBirth);
		driver.findElement(By.name("maritial_status")).sendKeys(clientMarital);
		driver.findElement(By.name("nid")).sendKeys(clientNatID);
		driver.findElement(By.name("phone")).sendKeys(ClientPhone);
		driver.findElement(By.name("address")).sendKeys(clientAddr);
		driver.findElement(By.name("policy_id")).sendKeys(ClientPolID);
	
		driver.findElement(By.name("agent_id")).sendKeys(AGENTID);
		
		//Add Nominee information in Add client
		driver.findElement(By.name("nominee_id")).clear();
		driver.findElement(By.name("nominee_id")).sendKeys(nomiID);
		driver.findElement(By.name("nominee_name")).sendKeys(nomiName);
		driver.findElement(By.name("nominee_sex")).sendKeys(nomiGen);
		driver.findElement(By.name("nominee_birth_date")).sendKeys(nomiBirth);
		driver.findElement(By.name("nominee_nid")).sendKeys(nomiNatID);
		driver.findElement(By.name("nominee_relationship")).sendKeys(nomiRel);
		driver.findElement(By.name("priority")).sendKeys(nomiPriority);
		driver.findElement(By.name("nominee_phone")).sendKeys(nomiPhone);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	
		//logout from app
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
		
		//to Client Status page 
		//login with client
		driver.findElement(By.name("username")).sendKeys(clientID);
		driver.findElement(By.name("password")).sendKeys(clientPass);
		
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		//logout from app
	    driver.findElement(By.xpath("//a[@title='Logout']")).click();*/
		
		
		Loginpage loginPage = new Loginpage(driver);
		
		
	}

}
