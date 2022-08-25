package com.trustinsurance.LISM.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insertclientpage {

	// constructor
	public Insertclientpage(WebDriver driver)

	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='col-md-12']")
	private WebElement insertClientPage;

	public void insertClientPage() {
		String insertClientPageText = insertClientPage.getText();
		System.out.println(insertClientPageText);
	}

	@FindAll({ @FindBy(xpath = "//a[@href='addClient.php']"), @FindBy(xpath = "//a[text()='Add Client']") })
	private WebElement addClientButton;

	public void addClientButton() {
		addClientButton.click();
	}

}
