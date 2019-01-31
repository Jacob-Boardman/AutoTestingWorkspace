package com.qa.para.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.para.cucumber.CONSTANTS;
import com.qa.para.cucumber.LandingPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	
	WebDriver driver;
	LandingPage landingPage;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", CONSTANTS.WEBDRIVERLOCATION);
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		driver.close();
	}

	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) throws Throwable {
	   driver.get(arg1);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
		landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.search(arg1);    
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
