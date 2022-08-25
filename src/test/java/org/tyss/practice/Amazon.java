package org.tyss.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/s?k=redmi&crid=1OK7S69KW2GK4&sprefix=redmi%2Caps%2C317&ref=nb_sb_noss_1");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//li[@aria-label='product']/descendant::i[@class='a-icon a-icon-checkbox']"));
		

	}

}
