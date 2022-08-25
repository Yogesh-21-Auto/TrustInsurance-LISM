package org.tyss.practice;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olampics {


	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://olympics.com/en/");
		driver.findElement(By.xpath("//button[text()='No, manage settings']")).click();
		
		driver.findElement(By.xpath("//button[text()='Reject All']")).click();
		driver.findElement(By.xpath("//button[@class='button-no-styles icon-close-button pvp-modal__close']")).click();
		
		ArrayList<String> l = new ArrayList<String>();
		l.add("Eliud KIPCHOGE");
		l.add("Rayssa LEAL");
		l.add("Carolina MARIN");
		l.add("Kaylee MCKEOWN");
		
		for(String all:l)
		{
			
			String y = "//span[text()='"+all+"']/ancestor::li[@class='b2p-list__item position-relative']/descendant::span[text()='G']/preceding-sibling::span";
			Thread.sleep(2000);
			String we = driver.findElement(By.xpath(y)).getText();
			System.out.println(we);
			
		/*	
			if(all.equalsIgnoreCase(we)) {
				
			System.out.println("present gold");	
				
			}*/
		}
		
	}

}
