package com.trustinsurance.LISM.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class Clientsinformationpage {

	public Clientsinformationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//heading
	@FindBy(xpath="//h1[@class='page-head-line']")
	private WebElement clientsInformationPage;
	
	public void clientInformation()
	{
		String cliInform = clientsInformationPage.getText();
		System.out.println(cliInform);
	}
	
	//table
	@FindBy(xpath="//table")
	private WebElement clientInformationtable;
	
	public void clientInformationtable()
	{
		String cliInfTab = clientInformationtable.getText();
		System.out.println(cliInfTab);
	}
	
	//client Information
	
	@FindAll({@FindBy(xpath="//a[@href='addClient.php']"), @FindBy(xpath="//a[text()='Add Client']")})
	private WebElement addClientButton;
	
	public void addClientButton()
	{
		addClientButton.click();
	}
	
	
	@FindBy(xpath="//a[@href='clientStatus.php?client_id=1.658567243E9']")
	private WebElement clientStatusLink;
	
	public void clientStatusLink()
	{
		clientStatusLink.click();
	}
	
	
	@FindBy(xpath="//a[@href='payment.php']")
	private WebElement paymentLink;
	
	public void paymentLinkInClientStatus()
	{
		paymentLink.click();
	}
	
	@FindBy(xpath="//table//tr[58]")
	private WebElement paymentTable;
	
	public void paymentTableInClientStatus()
	{
		String payTable = paymentTable.getText();
		System.out.println(payTable);
	}
}
