package org.tyss.practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Calendar {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.xpath("//div[@class='sc-hiCibw dGZLZw']/descendant::p[text()='Enter city or airport']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//p[text()='Bengaluru International Airport']")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//p[text()='Chhatrapati Shivaji International Airport']")).click();
		driver.findElement(By.xpath("//p[text()='Wednesday']")).click();
		
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'September')]/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12']")).click();
		driver.findElement(By.xpath("//p[text()='Click to add a return flight for better discounts']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'December')]/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='25']")).click();
		driver.findElement(By.xpath("//p[@class='sc-hGPBjI bACBrS' and text()='economy']")).click();
		driver.findElement(By.xpath("//p[text()='Adults']/parent::div[@class='sc-ehCJOs kXqgMf']/descendant::*[@height='15']")).click();
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
	}

}
