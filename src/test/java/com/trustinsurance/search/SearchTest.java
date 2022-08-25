package com.trustinsurance.search;

import java.io.IOException;

import org.testng.annotations.Test;

import com.trustinsurance.LISM.OR.Homepage;
import com.trustinsurance.genericutility.Baseclass;
import com.trustinsurance.genericutility.ExcelUtility;
import com.trustinsurance.genericutility.FileUtility;
import com.trustinsurance.genericutility.JavaUtility;

public class SearchTest extends Baseclass {

	ExcelUtility eLIB = new ExcelUtility();
	FileUtility fLIB = new FileUtility();
	JavaUtility jLIB = new JavaUtility();

	int ranNum = JavaUtility.getRandomNumber();
	String sysDate = jLIB.getSystemDateAndInIST();


	@Test
	public void CreateClientIdPasswordLoginWithSameTest() throws IOException

	{
		System.out.println(sysDate);

		String clientID = eLIB.getExcelData("Clients", 1, 0) + ranNum;
		String nomiID = eLIB.getExcelData("Clients", 1, 10) + ranNum;

		Homepage homePage = new Homepage(driver);
		homePage.searchTextFieldCID(clientID);
		homePage.searchButton();
		homePage.clientInformationtable();
		homePage.logoClick();
		homePage.searchTextFieldNID(nomiID);
		homePage.searchButton();
		homePage.nomineeInformationtable();
	}

}
