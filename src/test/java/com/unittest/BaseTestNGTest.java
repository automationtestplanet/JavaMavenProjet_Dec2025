package com.unittest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTestNGTest {
	@BeforeSuite(alwaysRun = true)
	public void beforeSuit() {
		System.out.println("Before Suit executed");
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("Before Test executed");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("Before Class executed");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("Before Method executed");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("After Method executed");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("After Class executed");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("After Test executed");
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuit() {
		System.out.println("After Suit executed");
	}
}
