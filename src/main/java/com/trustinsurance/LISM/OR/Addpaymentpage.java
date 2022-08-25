package com.trustinsurance.LISM.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addpaymentpage {

	//constructor
		public Addpaymentpage (WebDriver driver)
		
		{
			PageFactory.initElements(driver, this);
		}
		

		@FindBy(name="recipt_no")
		private WebElement reciptNum;
		
		public void reciptNumber(String reciptNO)
		{
			reciptNum.sendKeys(reciptNO);
		}
		
		@FindBy(name="client_id")
		private WebElement clientID;
		
		public void clientID(String CID)
		{
			clientID.sendKeys(CID);
		}
		
		@FindBy(name="month")
		private WebElement payMonth;
		
		public void payMonth(String payMon)
		{
			payMonth.sendKeys(payMon);
		}
		
		@FindBy(name="amount")
		private WebElement payAmount;
		
		public void payAmount(String payAmt)
		{
			payAmount.sendKeys(payAmt);
		}
		
		@FindBy(name="due")
		private WebElement payDue;
		
		public void payDue(String paydue)
		{
			payDue.sendKeys(paydue);
		}
		
		@FindBy(name="fine")
		private WebElement payFine;
		
		public void payFine(String payfine)
		{
			payFine.sendKeys(payfine);
		}
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement subBtn;
		
		public void subBtn()
		{
			subBtn.click();
		}
}
