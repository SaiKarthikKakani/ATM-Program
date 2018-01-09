package com.epam.automation.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vitali_Shulha on 22-Oct-15.
 */
public class HomePage {

    public static final String GITHUB_BASE_URL = "http://www.github.com";

    @FindBy(xpath = "//button[@aria-label='Switch account context']/span")
    private WebElement linkLoggedInUser;

    private final WebDriver driver;

    /*
    Constructor
     */
    // No need to have this comment as it implicitly mentions that the below one is a constructor.
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(GITHUB_BASE_URL);
    }

    public String getLoggedInUserName() {
        return linkLoggedInUser.getText();
    }

    public Integer hasUserLoggedIn(){
        if (linkLoggedInUser.getText() != ""){
        	// Should not return the numbers, because the does not interpret the output based on them.
        	// Suggestion: Return either true or false
            return 1;
        }
        else{
        	// Should not return the numbers, because the does not interpret the output based on them
        	// Suggestion: Return either true or false
            return -1;
        }
    }
}
