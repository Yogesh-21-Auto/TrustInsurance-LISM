package org.tyss.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vtiger {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://rmgtestingserver:8888/index.php?action=index&module=Home");
		Thread.sleep(2000);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index' and text()='Organizations']")).click();
		driver.findElement(By.xpath("//table[@class='lvtBg']/tbody//tr[3]/td/input")).click();
		driver.findElement(By.xpath("//table[@class='lvtBg']/tbody//tr[3]/td/a[text()='edit']")).click();

	}

}
