package org.TrustInsurance.Clients;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Property;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateClientInformation {

	public static void main(String[] args) throws IOException 
	
	{
		WebDriver driver = null;
		//Step 1: use file input stream to load the property file
		
		FileInputStream fis = new FileInputStream(".\\Data\\commondata.properties");
		
		//create properties object
		
		Properties prop = new Properties();
		prop.load(fis);
		
		//step 3: provide the key to read the value
		
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		String BROWSER = prop.getProperty("browser");
				
		//create excel and fetch the data
		
		//step1: read the file using file input stream
		
				FileInputStream fis1 = new FileInputStream(".\\Data\\testdata.xlsx");
				
				//step 2: create workbook
				Workbook workbook = WorkbookFactory.create(fis1);
				
				//step 3: load the sheet
				Sheet sheet = workbook.getSheet("Sheet3");
				Row row = sheet.getRow(1); 
				
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
				String ClientAgentID = row.getCell(10).toString();
				String nomiID = row.getCell(11).toString();
				String nomiName = row.getCell(12).toString();
				String nomiGen = row.getCell(13).toString();
				String nomiBirth = row.getCell(14).toString();
				String nomiNatID = row.getCell(15).toString();
				String nomiRel = row.getCell(16).toString();
				String nomiPriority = row.getCell(17).toString();
				String nomiPhone = row.getCell(18).toString();
				
				/*int last = sheet.getLastRowNum();
				
				for(int i=0; i<=last; i++)
				{
					
					String wh = sheet.getRow(i).getCell(0).toString();
				
				String wh1 = sheet.getRow(i).getCell(1).toString();
				System.out.println(wh+"="+wh1);
					
				}*/
					
				//step5: navigate to cell
				 //String wh = sheet.getRow(1).getCell(2).getStringCellValue();
				
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
		
		//brows the url
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		//login to app
		//common data
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
		//driver.findElement(By.xpath("//a[@href='client.php']")).click();
		driver.findElement(By.partialLinkText("CLIENTS")).click();
		driver.findElement(By.xpath("//a[.='Add Client']")).click();
		
		//test data
		driver.findElement(By.name("client_id")).sendKeys(clientID);
		driver.findElement(By.name("client_password")).sendKeys(clientPass);
		driver.findElement(By.name("name")).sendKeys(clientName);
		driver.findElement(By.name("fileToUpload")).sendKeys("C:\\Users\\acer\\Documents\\TYprj\\ddt38.png");
		driver.findElement(By.name("sex")).sendKeys(clientGender);
		driver.findElement(By.name("birth_date")).sendKeys(clientBirth);
		driver.findElement(By.name("maritial_status")).sendKeys(clientMarital);
		driver.findElement(By.name("nid")).sendKeys(clientNatID);
		driver.findElement(By.name("phone")).sendKeys(ClientPhone);
		driver.findElement(By.name("address")).sendKeys(clientAddr);
		driver.findElement(By.name("policy_id")).sendKeys(ClientPolID);
		driver.findElement(By.name("agent_id")).sendKeys(ClientAgentID);
		
		//nominee information
		driver.findElement(By.name("nominee_id")).sendKeys(nomiID);
		driver.findElement(By.name("nominee_name")).sendKeys(nomiName);
		driver.findElement(By.name("nominee_sex")).sendKeys(nomiGen);
		driver.findElement(By.name("nominee_birth_date")).sendKeys(nomiBirth);
		driver.findElement(By.name("nominee_nid")).sendKeys(nomiNatID);
		driver.findElement(By.name("nominee_relationship")).sendKeys(nomiRel);
		driver.findElement(By.name("priority")).sendKeys(nomiPriority);
		driver.findElement(By.name("nominee_phone")).sendKeys(nomiPhone);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[@title='Logout']")).click();
		
		//login to client
	}

}
