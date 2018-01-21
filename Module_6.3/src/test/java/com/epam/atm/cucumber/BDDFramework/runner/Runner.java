package com.epam.atm.cucumber.BDDFramework.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.epam.atm.cucumber.BDDFramework.driver.Driver;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "com.github.kirlionik.cucumberallure.AllureReporter",
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        },tags = {"@ebay"}

)
public class Runner {
	@BeforeClass
    public static void initSelenium(){Driver.init();}

    @AfterClass
    public static void closeSelenium(){Driver.close();}

}
