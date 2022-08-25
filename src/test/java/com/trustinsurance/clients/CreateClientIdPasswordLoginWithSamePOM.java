package com.trustinsurance.clients;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trustinsurance.LISM.OR.Addclientpage;
import com.trustinsurance.LISM.OR.Clientsinformationpage;
import com.trustinsurance.LISM.OR.Homepage;
import com.trustinsurance.LISM.OR.Insertclientpage;
import com.trustinsurance.LISM.OR.Loginpage;
import com.trustinsurance.genericutility.ExcelUtility;
import com.trustinsurance.genericutility.FileUtility;
import com.trustinsurance.genericutility.JavaUtility;
import com.trustinsurance.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;



public class CreateClientIdPasswordLoginWithSamePOM {

	
	public static void main(String[] args) throws IOException {
		
        WebDriver driver = null;
		
		//to create objects for utility
		
        ExcelUtility eLIB = new ExcelUtility();
		FileUtility fLIB = new FileUtility();
		WebDriverUtility wLIB = new WebDriverUtility();
		JavaUtility jLIB = new JavaUtility();
		
		//common data
		String URL = fLIB.getPropertyKeyValue("url");
		String USERNAME = fLIB.getPropertyKeyValue("username");
		String PASSWORD = fLIB.getPropertyKeyValue("password");
		String BROWSER = fLIB.getPropertyKeyValue("browser");
		String AGENTID = fLIB.getPropertyKeyValue("agentID");
		
		//get RandomNum and Date

		int ranNum = JavaUtility.getRandomNumber();
		String sysDate = jLIB.getSystemDateAndInIST();
		System.out.println(sysDate);
		
		//read test data from excel
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
		loginPage.loginToApp(USERNAME, PASSWORD);
		
        Homepage homePage = new Homepage(driver);
        homePage.clientsLink();
        
        Clientsinformationpage clientInform = new Clientsinformationpage(driver);
        clientInform.addClientButton();
        
        Addclientpage addClientPage = new Addclientpage(driver);
        addClientPage.clientPass(clientPass);
        addClientPage.clientName(clientName);
        addClientPage.imgUpload();
        addClientPage.clientGender(clientGender);
        addClientPage.clientBirth(clientBirth);
        addClientPage.clientMaritialStatus(clientMarital);
        addClientPage.clientNid(clientNatID);
        addClientPage.clientPhone(ClientPhone);
        addClientPage.clientAddress(clientAddr);
        addClientPage.clientPolicyID(ClientPolID);
        addClientPage.clientAgentID(AGENTID);
        addClientPage.nomineeID();
        addClientPage.nomineeID(nomiID);
        addClientPage.nomineeName(nomiName);
        addClientPage.nomineeSex(nomiGen);
        addClientPage.nomineeBirthDate(nomiBirth);
        addClientPage.nomineeNid(nomiNatID);
        addClientPage.nomineeRel(nomiRel);
        addClientPage.nomineePriority(nomiPriority);
        addClientPage.nomineePhone(nomiPhone);
        addClientPage.submitButton();
        
        Insertclientpage insCliPage = new Insertclientpage(driver);
        insCliPage.insertClientPage();
        homePage.logOut();
        loginPage.loginToApp(clientID, clientPass);
        homePage.logOut();
	}

}
