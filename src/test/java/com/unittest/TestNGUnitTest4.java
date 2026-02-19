package com.unittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.calculator.Calculator;
import com.calculator.UseCalculator;

public class TestNGUnitTest4 extends BaseTestNGTest {

	Calculator calc = new UseCalculator();

	@Test()
	public void test1() {
		int result = calc.addition(10, 20);
		Assert.assertEquals(30, result);
		System.out.println("Addition:" + result);
	}

	@Test()
	public void test2() {
		int result = calc.multiplication(10, 3);
		Assert.assertEquals(30, result);
		System.out.println("Multiplication:" + result);
	}

	@Test()
	public void test3() {
		int result = calc.subtraction(10, 3);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(result, 7);
		System.out.println("Subtraction:" + result);
		softAssert.assertAll();
	}
}
