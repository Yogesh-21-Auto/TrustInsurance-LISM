package com.trustinsurance.LISM.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addclientpage {

	//constructor
		public Addclientpage (WebDriver driver)
		
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="client_password")
		private WebElement clientPassword;
		
		public void clientPass(String clientPass)
		{
			clientPassword.sendKeys(clientPass);
		}
		
		@FindBy(name="name")
		private WebElement clientName;
		
		public void clientName(String clientNam)
		{
			clientName.sendKeys(clientNam);
		}
		
		@FindBy(xpath="//input[@class='img']")
		private WebElement imgUpLoad;
		
		public void imgUpload()
		{
			imgUpLoad.sendKeys("C:\\Users\\acer\\eclipse-workspace\\Trustinsurance_seleniumframework\\photos\\wp2024570.jpg");
		}
		
		@FindBy(name="sex")
		private WebElement clientGender;
		
		public void clientGender(String clientGen)
		{
			clientGender.sendKeys(clientGen);	
		}
		
		@FindBy(name="birth_date")
		private WebElement clientBirth;
		
		public void clientBirth(String clientBir)
		{
			clientBirth.sendKeys(clientBir);
		}
		
		@FindBy(name="maritial_status")
		private WebElement clientMaritialStatus;
		
		public void clientMaritialStatus(String clientMarSta)
		{
			clientMaritialStatus.sendKeys(clientMarSta);
		}
		
		@FindBy(name="nid")
		private WebElement clientNid;
		
		public void clientNid(String clientNat)
		{
			clientNid.sendKeys(clientNat);
		}
		
		@FindBy(name="phone")
		private WebElement clientPhone;
		
		public void clientPhone(String clientPhn)
		{
			clientPhone.sendKeys(clientPhn);
		}
		
		@FindBy(name="address")
		private WebElement clientAddress;
		
		public void clientAddress(String clientAddr)
		{
			clientAddress.sendKeys(clientAddr);
		}
		
		@FindBy(name="policy_id")
		private WebElement clientPolicyID;
		
		public void clientPolicyID(String clientPID)
		{
			clientPolicyID.sendKeys(clientPID);
		}
		
		@FindBy(name="agent_id")
		private WebElement clientAgentID;
		
		public void clientAgentID(String clientAID)
		{
			clientAgentID.sendKeys(clientAID);
		}
		
		//Nominee Information
		
		@FindBy(name="nominee_id")
		private WebElement nomineeIdClr;
		
		public void nomineeID()
		{
			nomineeID.clear();
		}
		
		@FindBy(name="nominee_id")
		private WebElement nomineeID;
		
		public void nomineeID(String nomiID)
		{
			nomineeID.sendKeys(nomiID);
		}
		
		@FindBy(name="nominee_name")
		private WebElement nomineeName;
		
		public void nomineeName(String nomiName)
		{
			nomineeName.sendKeys(nomiName);
		}
		
		@FindBy(name="nominee_sex")
		private WebElement nomineeSex;
		
		public void nomineeSex(String nomiSex)
		{
			nomineeSex.sendKeys(nomiSex);
		}
		
		@FindBy(name="nominee_birth_date")
		private WebElement nomineeBirthDate;
		
		public void nomineeBirthDate(String nomiBirth)
		{
			nomineeBirthDate.sendKeys(nomiBirth);
		}
		
		@FindBy(name="nominee_nid")
		private WebElement nomineeNid;
		
		public void nomineeNid(String nomiNid)
		{
			nomineeNid.sendKeys(nomiNid);
		}
		
		@FindBy(name="nominee_relationship")
		private WebElement nomineeRel;
		
		public void nomineeRel(String nomiRel)
		{
			nomineeRel.sendKeys(nomiRel);
		}
		
		@FindBy(name="priority")
		private WebElement nomineePriority;
		
		public void nomineePriority(String nomiPriority)
		{
			nomineePriority.sendKeys(nomiPriority);
		}
		
		@FindBy(name="nominee_phone")
		private WebElement nomineePhone;
		
		public void nomineePhone(String nomiPhone)
		{
			nomineePhone.sendKeys(nomiPhone);
		}
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement submitButton;
		
		public void submitButton()
		{
			submitButton.click();
		}
		
}
