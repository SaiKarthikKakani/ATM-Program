package com.mentoring.pages;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;

	@FindBy(id = "languageDropDownButton")
	private WebElement selectLanguage;

	@FindBy(id = "AvailabilitySearchInputXmlSearchView_TextBoxMarketOrigin1")
	private WebElement originCityName;

	@FindBy(id = "AvailabilitySearchInputXmlSearchView_TextBoxMarketDestination1")
	private WebElement destinationCityName;

	@FindBy(id = "marketDate1_lab")
	private WebElement tripStartDate;

	@FindBy(id = "DropDownListPassengerType_ADT_2")
	private WebElement numOfAdultPassengers;

	@FindBy(id = "AvailabilitySearchInputXmlSearchView_DropDownListPassengerType_CHD")
	private WebElement numOfChildPassengers;

	@FindBy(id = "AvailabilitySearchInputXmlSearchView_DropDownListPassengerType_INFANT")
	private WebElement numOfBabyPassengers;

	@FindBy(className = "mv_button size-sm btSmall_pad")
	private WebElement travellingWithBaby;

	@FindBy(id = "isResident")
	private WebElement residentOption;

	@FindBy(id = "AvailabilitySearchInputXmlSearchView_residentFamNumSelector")
	private WebElement typeOfResident;

	@FindBy(id = "AvailabilitySearchInputXmlSearchView_btnClickToSearchNormal")
	private WebElement searchFlights;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectLanguage() {
		Actions mouseHover = new Actions(driver);
		mouseHover.moveToElement(selectLanguage).perform();

		driver.findElement(By.xpath(".//a[text() = 'English']")).click();
	}

	public void enterOriginAndDestination(String origin, String destination)
			throws Exception {
		originCityName.click();
		originCityName.sendKeys(origin);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By
				.xpath(".//div[@id='stationsList']"))));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//div[@id='stationsList']")).click();

		destinationCityName.sendKeys(destination);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By
				.xpath(".//div[@id='stationsList']"))));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//div[@id='stationsList']")).click();
	}

	@SuppressWarnings("static-access")
	public void enterStartAndEndDate() throws Exception {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 10);

		String startDate = Integer.toString(c.DATE);
		System.out.println("Start date is " + startDate);

		Thread.sleep(5000);
		driver.findElement(
				By.xpath("(.//td[@data-handler = 'selectDay']//font[text() = "
						+ startDate + "])[1]")).click();

		c.add(Calendar.DATE, 20);
		int endDate = c.DATE;
		System.out.println("End date is " + endDate);
		driver.findElement(
				By.xpath("(.//td[@data-handler = 'selectDay']//font[text() = "
						+ endDate + "])[1]")).click();
	}

	public void setNumberOfPassengers() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.id("datePickerTitleCloseButton")).click();
		numOfAdultPassengers.click();

		Select childDropdown = new Select(numOfChildPassengers);
		childDropdown.selectByValue("2");

		Select babyDropdown = new Select(numOfBabyPassengers);
		babyDropdown.selectByValue("2");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//div[@id='travelWithBabies']//a[@title='To accept']")).click();
	}

	public void selectFamilyType(String familyType) {
		residentOption.click();

		Select residentDropdown = new Select(typeOfResident);
		residentDropdown.selectByVisibleText(familyType);
	}

	public void searchFlights() {
		searchFlights.click();
	}

}
