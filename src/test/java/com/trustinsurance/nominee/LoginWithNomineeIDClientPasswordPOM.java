package com.trustinsurance.nominee;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trustinsurance.LISM.OR.Loginpage;
import com.trustinsurance.genericutility.ExcelUtility;
import com.trustinsurance.genericutility.FileUtility;
import com.trustinsurance.genericutility.JavaUtility;
import com.trustinsurance.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithNomineeIDClientPasswordPOM {

	public static void main(String[] args) throws IOException {
	
		WebDriver driver = null;
		
		//to create objects for utility
		
        ExcelUtility eLIB = new ExcelUtility();
		FileUtility fLIB = new FileUtility();
		WebDriverUtility wLIB = new WebDriverUtility();
		JavaUtility jLIB = new JavaUtility();
		
		//common data
		String URL = fLIB.getPropertyKeyValue("url");
		
		String BROWSER = fLIB.getPropertyKeyValue("browser");
		
		//get RandomNum and Date

		int ranNum = JavaUtility.getRandomNumber();
		String sysDate = jLIB.getSystemDateAndInIST();
		System.out.println(sysDate);
		
		//Fetch the data from eternal file (Excel-TestData)
		
		String nomiID = eLIB.getExcelData("Clients", 1, 11) + ranNum;
		String clientPass = eLIB.getExcelData("Clients", 1, 1) + ranNum;

        WebDriverManager.chromedriver().setup();
		
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
		
        Loginpage loginPage = new Loginpage(driver);
		loginPage.loginToApp(nomiID, clientPass);
	
        }		
		 
}
