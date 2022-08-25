package com.trustinsurance.LISM.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Clientsstatuspage {

	//constructor
	public Clientsstatuspage (WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.='Add Payment']")
	private WebElement clientAddPaymentLink;
	
	public void clientAddPayment()
	{
		clientAddPaymentLink.click();
	}
}
