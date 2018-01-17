package com.mentoring.tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import com.epam.tat.module4.Calculator;

public class TestCalculator {
	private static Calculator calc;

	@Test(dataProvider = "dp")
	public void addition(Integer firstNum, Integer secondNum) {
		int sumFromCalc = (int) calc.sum(firstNum, secondNum);
		Assert.assertEquals(firstNum + secondNum, sumFromCalc);
	}

	@Test(dataProvider = "dp")
	public void subtract(Integer firstNum, Integer secondNum) {
		int sumFromCalc = (int) calc.sub(firstNum, secondNum);
		Assert.assertEquals(firstNum - secondNum, sumFromCalc);
	}

	@Test(dataProvider = "dp")
	public void multiplication(Integer firstNum, Integer secondNum) {
		int sumFromCalc = (int) calc.mult(firstNum, secondNum);
		Assert.assertEquals(firstNum * secondNum, sumFromCalc);
	}

	@Test(dataProvider = "dp")
	public void division(Integer firstNum, Integer secondNum) {
		int sumFromCalc = (int) calc.div(firstNum, secondNum);
		Assert.assertEquals(firstNum / secondNum, sumFromCalc);
	}

	@Parameters({ "sqrtValue" })
	@Test()
	public void squareRoot(@Optional("49") String sqrtNum) {
		int sqrt = (int) calc.sqrt(Integer.parseInt(sqrtNum));
		Assert.assertEquals(sqrt, 7);
	}

	@Test(expectedExceptions = NumberFormatException.class, expectedExceptionsMessageRegExp = "Attempt to divide by zero")
	public void divisionByZero() {
		calc.div(20, 0);
	}

	@BeforeMethod
	public void beforeMethod() {
		calc = new Calculator();
	}

	@AfterMethod
	public void afterMethod() {

	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 10, 2 }, new Object[] { 20, 3 }, };
	}
}
