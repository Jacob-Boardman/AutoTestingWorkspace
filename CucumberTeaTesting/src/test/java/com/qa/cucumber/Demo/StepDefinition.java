package com.qa.cucumber.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class StepDefinition {
	
	WebDriver driver;
	LandingPage landingPage;
	MenuPage menuPage;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", CONSTANTS.WEBDRIVERLOCATION);
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		driver.close();
	}

	@Given("^the correct web address$")
	public void the_correct_web_address() throws Throwable {
		driver.get(CONSTANTS.URL);
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws Throwable {
		landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.clickMenu();
		
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Throwable {
		menuPage = PageFactory.initElements(driver, MenuPage.class);
		assertEquals("List not Present", true, menuPage.isListPresent());
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
