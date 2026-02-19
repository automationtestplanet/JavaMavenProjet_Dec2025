package com.unittest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.calculator.Calculator;
import com.calculator.UseCalculator;

public class TestNGUnitTest5 {

	Calculator calc = new UseCalculator();

	@Test()
	@Parameters("Name")
	public void test1(String name) {
		int result = calc.addition(10, 20);
		Assert.assertEquals(30, result);
		System.out.println("Addition:" + result);
		System.out.println("Name: " + name);
	}

	@Test()
	@Parameters("Job")
	public void test2(String job) {
		int result = calc.multiplication(10, 3);
		Assert.assertEquals(30, result);
		System.out.println("Multiplication:" + result);
		System.out.println("Job: " + job);
	}

	@Test()
	@Parameters({ "Name", "Job" })
	public void test3(String name, String job) {
		int result = calc.subtraction(10, 3);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(result, 7);
		System.out.println("Subtraction:" + result);
		System.out.println("Name: " + name + " Job: " + job);
		softAssert.assertAll();
	}
}
