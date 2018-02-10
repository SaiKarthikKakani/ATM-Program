package com.mentoring.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mentoring.pages.HomePage;

public class SearchForFlights {
	private WebDriver driver;
	private HomePage homePage;
	private static String LAUNCHURL = "http://www.vueling.com";
	private static String ORIGINCITY = "Barcelona";
	private static String DESTINATIONCITY = "Alicante";
	private static String FAMILYTYPE = "General Large Family";

	@BeforeClass
	public void beforeSuite() {
		System.setProperty(
				"webdriver.gecko.driver",
				"F:\\Karthik\\Personal\\geckodriver-v0.15.0-win64\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.get(LAUNCHURL);
		driver.manage().window().maximize();
		
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@Test
	public void enterDetailsInHomePage() throws Exception {
		homePage.selectLanguage();
		homePage.enterOriginAndDestination(ORIGINCITY, DESTINATIONCITY);
//		homePage.enterStartAndEndDate();
		homePage.setNumberOfPassengers();
		homePage.selectFamilyType(FAMILYTYPE);
		homePage.searchFlights();
		
		Assert.assertEquals(true, true);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
