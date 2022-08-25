package com.trustinsurance.LISM.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Aegon Life']")
	private WebElement logoLink;
	
	public void logoClick()
	{
		logoLink.click();
	}
	
	@FindBy(xpath="//h1[@class='page-head-line']")
	private WebElement header;
	
	public void headerText()
	{
		String headerText = header.getText();
		System.out.println(headerText);
	}
	
	@FindBy(name="key")
	private WebElement searchTextFieldCID;
	
	public void searchTextFieldCID(String clientID)
	{
		searchTextFieldCID.sendKeys(clientID);
	}
	
	@FindBy(name="key")
	private WebElement searchTextFieldNID;
	
	public void searchTextFieldNID(String nomineeID)
	{
		searchTextFieldNID.sendKeys(nomineeID);
	}
	
	@FindAll({ @FindBy(xpath="//input[@type='submit']"), @FindBy(xpath="//input[@class='searchBtn']") })
	private WebElement searchButton;
	
	public void searchButton()
	{
		searchButton.click();
	}
	
	@FindBy(xpath="//table")
	private WebElement clientInformationtable;
	
	public void clientInformationtable()
	{
		String cliInfTab = clientInformationtable.getText();
		System.out.println(cliInfTab);
	}
	
	@FindBy(xpath="//table")
	private WebElement nomineeInformationtable;
	
	public void nomineeInformationtable()
	{
		String nomiInfTab = nomineeInformationtable.getText();
		System.out.println(nomiInfTab);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user fa-5x']")
	private WebElement totalClients;
	
	public void totalClients()
	{
		String totCli = totalClients.getText();
		System.out.println(totCli);
	}
	
	@FindBy(xpath="//i[@class='fa fa-dollar fa-5x']")
	private WebElement paymentRecords;
	
	public void paymentRecords()
	{
		String payRec = paymentRecords.getText();
		System.out.println(payRec);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user-md fa-5x']")
	private WebElement totalAgents;
	
	public void totalAgents()
	{
		String totAgent = totalAgents.getText();
		System.out.println(totAgent);
	}
	
	@FindBy(xpath="//a[@href='client.php']")
	private WebElement clientsLink;
	
	public void clientsLink()
	{
		clientsLink.click();
	}
	
	@FindBy(xpath="//a[@href='agent.php']")
	private WebElement agentLink;
	
	public void agentLink()
	{
		agentLink.click();
	}
	
	@FindBy(xpath="//a[@href='policy.php']")
	private WebElement policyLink;
	
	public void policyLink()
	{
		policyLink.click();
	}
	
	@FindBy(xpath="//a[@href='nominee.php']")
	private WebElement nomineeLink;
	
	public void nomineeLink()
	{
		nomineeLink.click();
	}
	
	@FindBy(xpath="//a[@href='payment.php']")
	private WebElement paymentLink;
	
	public void paymentLink()
	{
		paymentLink.click();
	}
	
	//@FindAll({ @FindBy(xpath="//input[@href='logout.php']"), @FindBy(xpath="//input[@title='Logout']") })
	
	//@FindBy(xpath="//input[@title='Logout']") 
	@FindBy(xpath="//i[@class='fa fa-exclamation-circle fa-2x']")
	private WebElement logoutButton;
	
	public void logOut()
	{
		logoutButton.click();
	}
}
