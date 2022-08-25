package com.trustinsurance.payment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trustinsurance.LISM.OR.Addclientpage;
import com.trustinsurance.LISM.OR.Addpaymentpage;
import com.trustinsurance.LISM.OR.Clientsinformationpage;
import com.trustinsurance.LISM.OR.Clientsstatuspage;
import com.trustinsurance.LISM.OR.Homepage;
import com.trustinsurance.LISM.OR.Insertpaymentpage;
import com.trustinsurance.LISM.OR.Loginpage;
import com.trustinsurance.genericutility.ExcelUtility;
import com.trustinsurance.genericutility.FileUtility;
import com.trustinsurance.genericutility.JavaUtility;
import com.trustinsurance.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePaymentInformationUsingClientStatusLinkPOM {

	public static void main(String[] args) throws IOException {

		WebDriver driver = null;

		// to create objects for utility

		ExcelUtility eLIB = new ExcelUtility();
		FileUtility fLIB = new FileUtility();
		WebDriverUtility wLIB = new WebDriverUtility();
		JavaUtility jLIB = new JavaUtility();

		// common data
		String URL = fLIB.getPropertyKeyValue("url");
		String USERNAME = fLIB.getPropertyKeyValue("username");
		String PASSWORD = fLIB.getPropertyKeyValue("password");
		String BROWSER = fLIB.getPropertyKeyValue("browser");
		String AGENTID = fLIB.getPropertyKeyValue("agentID");

		// get RandomNum and Date

		int ranNum = JavaUtility.getRandomNumber();
		String sysDate = jLIB.getSystemDateAndInIST();
		System.out.println(sysDate);

		//read test data from excel
		String recipt_no = eLIB.getExcelData("Clients", 4, 0) + ranNum;
		String clientID = eLIB.getExcelData("Clients", 1, 1) + ranNum;
		String month = eLIB.getExcelData("Clients", 4, 1) + ranNum;
		String amount = eLIB.getExcelData("Clients", 4, 2) + ranNum;
		String due = eLIB.getExcelData("Clients", 4, 3) + ranNum;
		String fine = eLIB.getExcelData("Clients", 4, 4) + ranNum;	
		
		//launch Browser
		WebDriverManager.chromedriver().setup();

		if (BROWSER.equalsIgnoreCase("chrome")) {
			// based on the property file our script is getting changed during RTP
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else {
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
        clientInform.clientStatusLink();
        
        Clientsstatuspage cliStaPage = new Clientsstatuspage(driver);
        cliStaPage.clientAddPayment();
        
        Addpaymentpage addPayPage = new Addpaymentpage(driver);
        addPayPage.reciptNumber(recipt_no);
        addPayPage.clientID(clientID);
        addPayPage.payMonth(month);
        addPayPage.payAmount(amount);
        addPayPage.payDue(due);
        addPayPage.payFine(fine);
        
        Addclientpage addClientPage = new Addclientpage(driver);
        addClientPage.clientAgentID(AGENTID);
        addPayPage.subBtn();
        
        Insertpaymentpage insPayPage = new Insertpaymentpage(driver);
        insPayPage.paymentAddMag();
        
        homePage.logOut();
	}

}
