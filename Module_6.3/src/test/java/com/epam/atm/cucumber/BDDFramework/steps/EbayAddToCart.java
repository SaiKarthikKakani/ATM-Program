package com.epam.atm.cucumber.BDDFramework.steps;


import org.junit.Assert;

import com.epam.atm.cucumber.BDDFramework.driver.Driver;

import cucumber.api.java.en.Then;

public class EbayAddToCart extends Driver{
	
	@Then("^the product list is shown as \"([^\"]*)\"$")
	public void the_product_list_is_shown_as(String productName)  {		
		Assert.assertTrue(driver.getPageSource().contains(productName));
		
	}

}
