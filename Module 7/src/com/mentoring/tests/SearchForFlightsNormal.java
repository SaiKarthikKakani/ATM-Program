package com.mentoring.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.mentoring.pages.HomePage;

public class SearchForFlightsNormal {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		HomePage homePage;
		String LAUNCHURL = "http://www.vueling.com";
		String ORIGINCITY = "Barcelona";
		String DESTINATIONCITY = "Alicante";
		String FAMILYTYPE = "General Large Family";
		
		System.setProperty(
				"webdriver.chrome.driver",
				"F:\\Karthik\\Personal\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(LAUNCHURL);
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		
//		homePage = new HomePage(driver);
		homePage.selectLanguage();
		homePage.enterOriginAndDestination(ORIGINCITY, DESTINATIONCITY);
		homePage.enterStartAndEndDate();
		homePage.setNumberOfPassengers();
		homePage.selectFamilyType(FAMILYTYPE);
		homePage.searchFlights();

	}

}
