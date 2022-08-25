package com.trustinsurance.LISM.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insertpaymentpage {

	//constructor
			public Insertpaymentpage (WebDriver driver)
			
			{
				PageFactory.initElements(driver, this);
			}
		
			@FindBy(xpath="//div[@class='row']/descendant::h1")
			private WebElement paymentAdd;
			
			public void paymentAddMag()
			{
				String payAddText = paymentAdd.getText();
				System.out.println(payAddText);
			}
			
			@FindAll({@FindBy(xpath="//a[@href='addClient.php']"), @FindBy(xpath="//a[text()='Add Client']")})
			private WebElement addClientButton;
			
			public void addClientButton()
			{
				addClientButton.click();
			}
}
