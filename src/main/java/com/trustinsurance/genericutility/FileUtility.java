package com.trustinsurance.genericutility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

/**
 *  its contains External File specific libraries
 * @author acer
 *
 */

public class FileUtility implements Iconstants{

	/**
	 * its used return the value from the property file based on key
	 * @param key
	 * @return value
	 * @throws IOException 
	 * @throws Throwable
	 */

	public String getPropertyKeyValue(String Key) throws IOException
	{
		FileInputStream fis = new FileInputStream(Iconstants.propertyFilePath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(Key);
		return value;
	}
	
	
}
