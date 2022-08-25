package org.tyss.practice.group;

import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.trustinsurance.genericutility.Baseclass;

@Listeners


public class screenshot extends Baseclass {

	public void add()
	{
		System.out.println("Take shot");
		Assert.assertEquals(false, true);
		System.out.println("Success shot");
	}
}
