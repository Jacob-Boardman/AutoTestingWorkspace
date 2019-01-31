package com.qa.cucumber.Demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	WebElement menuBtn;

	public void clickMenu() {
		menuBtn.click();
	}
	
	public void clickCheckout() {
		//checkoutBtn
	}

}
