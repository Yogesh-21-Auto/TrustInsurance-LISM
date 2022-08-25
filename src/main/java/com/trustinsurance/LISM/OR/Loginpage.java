package com.trustinsurance.LISM.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	//constructor
	public Loginpage (WebDriver driver)
	
	{
		
		PageFactory.initElements(driver, this);
	}
	
	//store the elements
	@FindBy(name="username")
	private WebElement userNameEdt;
	
	@FindBy(name="password")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//button[.='login']")
	private WebElement loginButton;

	
	//getter methods

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void loginToApp(String username, String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginButton.click();
	}
}


