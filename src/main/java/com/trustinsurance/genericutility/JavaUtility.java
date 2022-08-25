package com.trustinsurance.genericutility;

import java.util.Date;
import java.util.Random;


////****JAVA UTILITY****////
/**
 * Its contains java specific libraries like getRandomdata & getSystemDate etc
 * 
 * @author acer
 */

public class JavaUtility implements Iconstants {

	/**
	 * its used to generate the random number with in the range of 1000
	 * 
	 * @return
	 */

	public static int getRandomNumber() {

		Random ran = new Random();
		int ranDomNum = ran.nextInt(Iconstants.randomNumbers);
		return ranDomNum;
	}

	/**
	 * its used to get the current system date and time based on the DD-MM-YYYY
	 * format
	 * 
	 * @return
	 */

	public String getSystemDateAndInIST() {

		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		String YYYY = arr[2];
		String DD = arr[2];
		int MM = date.getMonth() + 1;

		String finalFormate = DD + "-" + MM + "-" + YYYY;
		System.out.println(finalFormate);
		return finalFormate;
	}
}


