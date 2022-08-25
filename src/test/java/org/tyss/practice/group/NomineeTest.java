package org.tyss.practice.group;

import org.testng.annotations.Test;

public class NomineeTest {

	@Test(groups = {"SmokeTest"})

	public void createNomineeTest() {
		System.out.println("Created Successfully");
	}

	@Test(groups = {"FullRegressionTest"})

	public void editNomineeTest() {
		System.out.println("Updated Successfully");
	}

	@Test(groups = {"RegionalRegressionTest"})

	public void deleteNomineeTest() {
		System.out.println("deleted Successfully");
	}
}
