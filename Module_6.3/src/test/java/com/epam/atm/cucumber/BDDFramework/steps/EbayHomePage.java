package com.epam.atm.cucumber.BDDFramework.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.epam.atm.cucumber.BDDFramework.driver.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Unit test for simple App.
 */
public class EbayHomePage extends Driver{
	
	@Given("^I open Ebay application$")
	public void i_open_Ebay_application() throws Throwable {
	 driver.get("http://ebay.com");
	}

	@Given("^I set search request \"([^\"]*)\"$")
	public void i_set_search_request(String productName) {
		driver.findElement(By.id("gh-ac")).sendKeys(productName);
		
	}

	@Given("^I perform search$")
	public void i_perform_search() throws Throwable {
		 driver.findElement(By.id("gh-btn")).click();
		 driver.findElement(By.xpath("(//li[@r='1'])[1]//h3")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("^I perform AddToCart$")
	public void i_perform_AddToCart() throws Throwable {
		driver.findElement(By.id("isCartBtn_btn")).click();
	}
	
}
 