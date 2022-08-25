package com.trustinsurance.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LisImpClass implements ITestListener {
	JavaUtility jLIB = new JavaUtility();
	@Override
	public void onTestFailure(ITestResult result) {
	
		{
			String date = jLIB.getSystemDateAndInIST();
			String testName = result.getMethod().getMethodName();
			System.out.println(testName + "Execute Iam Listening Here");
			
			EventFiringWebDriver eDriver = new EventFiringWebDriver(Baseclass.sDriver);
			
			File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
			
			File dstFile = new File("./photos/"+testName+date+".png");
			
			try {
				FileUtils.copyFile(srcFile, dstFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
