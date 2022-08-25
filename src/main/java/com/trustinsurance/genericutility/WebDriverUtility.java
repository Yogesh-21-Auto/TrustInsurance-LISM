package com.trustinsurance.genericutility;



import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

////****WEBDRIVER UTILITY****////

/**
 * Its contains java specific libraries like
 * waitForPageToLoad(),waitForElement() etc..
 * 
 * @author acer
 */

public class WebDriverUtility implements Iconstants {

	/**
	 * its an implicitly wait always wait for the element in DOM document and
	 * release control if element is available
	 */
	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Iconstants.Implicitly_TIMEOUT, TimeUnit.SECONDS);
	}

	/**
	 * its an explicitly wait always wait for page to be loaded and available in GUI
	 * 
	 * @param driver
	 * @param partailPageURL
	 */

	public void waitForPage(WebDriver driver, String partialPageURL) {
		WebDriverWait wait = new WebDriverWait(driver, Iconstants.Explicitly_TIMEOUT);
		wait.until(ExpectedConditions.urlContains(partialPageURL));
	}

	/**
	 * its an explicitly wait always wait for page to be loaded and available in GUI
	 * 
	 * @param driver
	 * @param partailPageURL
	 */

	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Iconstants.Explicitly_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * its used switch to any window based on window title
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */

	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> allBrw = driver.getWindowHandles();
		for (String wid : allBrw) {
			driver.switchTo().window(wid);
			String currentWindowTitel = driver.getTitle();

			if (currentWindowTitel.contains(partialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * its used switch to any window based on window title
	 * 
	 * @param driver
	 * @param Accpect
	 */

	public void switchToAlertWindowAndAccept(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		// String actualMsg = alt.getText();
		if (alt.getText().trim().equalsIgnoreCase(expectedMsg)) {
			System.out.println("Alert Message is verified");
		} else {
			System.out.println("Alert Message is not verified");
		}

		alt.accept();
	}

	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * 
	 * @param driver
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		if (alt.getText().equals(expectedMsg)) {
			System.out.println("Alert Message is verified");
		} else {
			System.out.println("Alert Message is not verified");
		}
		alt.dismiss();
	}

	/**
	 * used to Switch to Frame Window based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * 
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * used to select the value from the dropDwon based on index
	 * 
	 * @param driver
	 * @param index
	 */

	public void select(WebElement element, int Index) {
		Select sel = new Select(element);
		sel.selectByIndex(Index);
	}

	/**
	 * used to select the value from the dropDwon based on value / option available
	 * in GUI
	 * 
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * 
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}

	/**
	 * used to right click on specified element
	 * 
	 * @param driver
	 * @param elemnet
	 */

	public void rightClickOnElement(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}

	/**
	 * pass enter Key appertain in to Browser
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public void windowMax(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void windowScrollBar(WebDriver driver, String javaScript)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	   }

}
