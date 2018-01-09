package com.epam.automation.tests;

import com.epam.automation.model.HomePage;
import com.epam.automation.pages.SignInPage;
import com.epam.automation.pages.StartPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vitali_Shulha on 22-Oct-15.
 */
public class Test1 {

	// Username and passwords should not be fixed in the script.
	// Suggestion: Place all the credentials in an file and read the same in the script.
    private final String USERNAME = "testautomationuser";
    private final String PASSWORD = "Time4Death!";

    @Test
    public void testOneCanLoginGithub(){
    	// One test should do one job at a time
    	// Suggestion: The job can be split to multiple test cases
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        StartPage startPage = new StartPage(driver);
        startPage.open();
        SignInPage signInPage = startPage.invokeSignIn();
        HomePage homePage = signInPage.signIn(USERNAME, PASSWORD);
        String loggedInUserName = homePage.getLoggedInUserName();
        Assert.assertEquals(USERNAME, loggedInUserName);
        driver.quit();
    }
}
