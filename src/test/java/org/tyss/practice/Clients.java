package org.tyss.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.trustinsurance.LISM.OR.Homepage;
import com.trustinsurance.genericutility.Baseclass;
import com.trustinsurance.genericutility.ExcelUtility;

public class Clients extends Baseclass {

	
	WebDriver driver;
	
@Test
	
	public void CreateClientInformation()
	{
		System.out.println("Client information successufully created");
	}
	
	/*ExcelUtility eLIB = new ExcelUtility();
	@Test(priority=2)
	
	public void CreateClientInformation()
	{
		System.out.println("Client information successufully created");
	}
	
	@Test(priority=3)
	
	public void AddClientPayemntTest()
	{
		System.out.println("Client payment successufully added");
	}
	
@Test(priority=1)
	
	public void SearchNomineeIDTest()
	{
	
		System.out.println("ClientID successufully added");
	}

/*@Test(invocationCount=2)

public void SearchNomineeIDTest()
{
	System.out.println("NomineeID successufully created");
}

@Test(dataProvider = "SearchNomineeIDDataProvider")

public void SearchClientIDTest() throws EncryptedDocumentException, IOException
{
	
	 String clientID = eLIB.getExcelData("Clients", 1, 0);
	 Homepage homePage = new Homepage(driver);
     homePage.searchTextFieldCID(clientID);
	 System.out.println("ClientID successufully created");
}

@DataProvider()

public Object[][] SearchNomineeIDDataProvider(String clientID)
{
	Object[][] objAry = new Object[1][1];
	objAry[0][0] = getExcelData("clientID");
	return objAry;
}

private Object getExcelData(String string) {
	// TODO Auto-generated method stub
	return null;
}
*/
}
