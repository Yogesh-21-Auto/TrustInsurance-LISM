package org.tyss.practice.group;

import org.testng.annotations.Test;

public class PaymentTest {

	@Test(groups = {"SmokeTest"})

	public void createPaymentTest() {
		System.out.println("Created Successfully");
	}

	@Test(groups = {"FullRegressionTest"})

	public void editPaymentTest() {
		System.out.println("Updated Successfully");
	}

	@Test(groups = {"RegionalRegressionTest"})

	public void deletePaymentTest() {
		System.out.println("deleted Successfully");
	}
}
