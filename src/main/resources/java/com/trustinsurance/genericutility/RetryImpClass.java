package com.trustinsurance.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer{

	int counter = 0;
	int retryLimit = 3;
	@Override
	public boolean retry(ITestResult result) {
		
		if (counter<retryLimit)
		{
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
