package com.epam.atm.cucumber.BDDFramework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public static WebDriver driver;

	public static void init() {
		System.setProperty("webdriver.chrome.driver", "./libs/chromedriver.exe");
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}

	public static void close() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver = null;
		}
	}
}
