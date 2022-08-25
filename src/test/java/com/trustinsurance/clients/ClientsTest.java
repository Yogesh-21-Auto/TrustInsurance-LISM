package com.trustinsurance.clients;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.trustinsurance.LISM.OR.Addclientpage;
import com.trustinsurance.LISM.OR.Addpaymentpage;
import com.trustinsurance.LISM.OR.Clientsinformationpage;
import com.trustinsurance.LISM.OR.Clientsstatuspage;
import com.trustinsurance.LISM.OR.Homepage;
import com.trustinsurance.LISM.OR.Insertclientpage;
import com.trustinsurance.LISM.OR.Insertpaymentpage;
import com.trustinsurance.LISM.OR.Loginpage;
import com.trustinsurance.genericutility.Baseclass;
import com.trustinsurance.genericutility.ExcelUtility;
import com.trustinsurance.genericutility.FileUtility;
import com.trustinsurance.genericutility.JavaUtility;
@Listeners
public class ClientsTest extends Baseclass

{
	ExcelUtility eLIB = new ExcelUtility();
	FileUtility fLIB = new FileUtility();
	JavaUtility jLIB = new JavaUtility();

	int ranNum = JavaUtility.getRandomNumber();
	String sysDate = jLIB.getSystemDateAndInIST();


	@Test//(retryAnalyzer = com.trustinsurance.genericutility.RetryImpClass.class)
	public void CreateClientIdPasswordLoginWithSameTest() throws IOException

	{

		System.out.println(sysDate);
		// fetch the data from eternal file

		String clientPass = eLIB.getExcelData("Clients", 1, 1)+ ranNum;
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
		String nomiPhone = eLIB.getExcelData("Clients", 1, 17) + ranNum;

		// fetch client ID from file
		String AGENTID = fLIB.getPropertyKeyValue("agentID");
		System.out.println("createClientInformation");

		Homepage homePage = new Homepage(driver);
		homePage.clientsLink();

		Clientsinformationpage clientInform = new Clientsinformationpage(driver);
		clientInform.addClientButton();

		Addclientpage addClientPage = new Addclientpage(driver);
		addClientPage.clientPass(clientPass);
		addClientPage.clientName(clientName);
		addClientPage.imgUpload();
		addClientPage.clientGender(clientGender);
		Assert.fail();
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
	
		homePage.clientsLink();
		
		String cliIDActData = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
		String cliIDexpData = "Yogi";
		
		Assert.assertEquals(cliIDActData, cliIDexpData);
	}

	@Test
	public void LoginWithNomineeIDClientPasswordTest() throws Throwable

	{
		System.out.println(sysDate);
		// Fetch the data from eternal file (Excel-TestData)

		String nomiID = eLIB.getExcelData("Clients", 1, 11) + ranNum;
		String clientPass = eLIB.getExcelData("Clients", 1, 1) + ranNum;
		Loginpage loginPage = new Loginpage(driver);
		loginPage.loginToApp(nomiID, clientPass);
		System.out.println("Unsuccesfully logged in");
	}

	@Test
	public void CreatePaymentInformationUsingClientStatusLinkTest() throws Throwable{
		System.out.println(sysDate);

		// read test data from excel
		String recipt_no = eLIB.getExcelData("Clients", 4, 0) + ranNum;
		String clientID = eLIB.getExcelData("Clients", 1, 1) + ranNum;
		String month = eLIB.getExcelData("Clients", 4, 1) + ranNum;
		String amount = eLIB.getExcelData("Clients", 4, 2) + ranNum;
		String due = eLIB.getExcelData("Clients", 4, 3) + ranNum;
		String fine = eLIB.getExcelData("Clients", 4, 4) + ranNum;

		String AGENTID = fLIB.getPropertyKeyValue("agentID");

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
	}

}
