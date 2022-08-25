package com.trustinsurance.genericutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.trustinsurance.LISM.OR.Homepage;
import com.trustinsurance.LISM.OR.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public WebDriver driver;
	public static WebDriver sdriver;
	public ExcelUtility eLIB = new ExcelUtility();
	public WebDriverUtility wLIB = new WebDriverUtility();
	public FileUtility fLIB = new FileUtility();
	public JavaUtility jLIB = new JavaUtility();
	public JDBCUtility dbLIB = new JDBCUtility();

	@BeforeSuite(groups = { "SmokeTest", "FullRegressionTest", "RegionalRegressionTest" })
	public void configBS() throws SQLException {
		System.out.println("-----connect to DB-----");
		// dbLIB.toConnectDb();
	}

	//@Parameters("BROWSER")
	@BeforeClass(groups = { "SmokeTest", "FullRegressionTest", "RegionalRegressionTest" })
	public void configBC() throws IOException {
		System.out.println("Launch the Browser");

		String BROWSER = fLIB.getPropertyKeyValue("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {

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
		
		sdriver = driver;

		wLIB.windowMax(driver);
		wLIB.waitForElementInDOM(driver);

		String URL = fLIB.getPropertyKeyValue("url");
		driver.get(URL);
	}

	@BeforeMethod(groups = "SmokeTest, FullRegressionTest, RegionalRegressionTest")

	public void configBM() throws IOException {
		System.out.println("Login to APPLICATION");
		Loginpage loginPage = new Loginpage(driver);
		String USERNAME = fLIB.getPropertyKeyValue("username");
		String PASSWORD = fLIB.getPropertyKeyValue("password");
		loginPage.loginToApp(USERNAME, PASSWORD);

	}

	@AfterMethod(groups = { "SmokeTest", "FullRegressionTest", "RegionalRegressionTest" })
	public void configAM() {
		System.out.println("Logout from APPLICATION");
		Homepage homePage = new Homepage(driver);
		homePage.logOut();
	}

	@AfterClass(groups = { "SmokeTest", "FullRegressionTest", "RegionalRegressionTest" })
	public void configAC() {
		System.out.println("Close the Browser");
		driver.quit();
	}

	@AfterSuite(groups = { "SmokeTest", "FullRegressionTest", "RegionalRegressionTest" })
	public void configAS() {
		System.out.println("Close the DB");
	}

}
