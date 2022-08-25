package org.tyss.practice.group;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.trustinsurance.LISM.OR.Addclientpage;
import com.trustinsurance.genericutility.ExcelUtility;
import com.trustinsurance.genericutility.FileUtility;
import com.trustinsurance.genericutility.JavaUtility;

public class ClientsTest {
	
	public WebDriver driver;
	
	ExcelUtility eLIB = new ExcelUtility();
	FileUtility fLIB = new FileUtility();
	JavaUtility jLIB = new JavaUtility();

	@Test(groups = {"SmokeTest"})

	public void createClientTest() {
		System.out.println("Created Successfully");
	}

	@Test(groups = {"FullRegressionTest"})

	public void editClientTest() {
		System.out.println("Updated Successfully");
	}

	@Test(groups = {"RegionalRegressionTest"})

	public void deleteClientTest() {
		System.out.println("deleted Successfully");
	}
	
	@Test(dataProvider = "createClientDataProvider")

	public void ClientTest(String clientPass, String clientName, String clientGender) {
		System.out.println("create Successfully");
		Addclientpage addClientPage = new Addclientpage(driver);
		addClientPage.clientPass(clientPass);
		addClientPage.clientName(clientName);
		addClientPage.clientGender(clientGender);
	}
	
	@DataProvider
	public void createClientDataProvider() throws EncryptedDocumentException, IOException
	{
		Object[][] objArr = new Object[2][3];
		objArr[0][0] = eLIB.getExcelData("Clients", 1, 1);
		objArr[0][1] = eLIB.getExcelData("Clients", 1, 2);
		objArr[0][2] = eLIB.getExcelData("Clients", 1, 3);
	}
}
