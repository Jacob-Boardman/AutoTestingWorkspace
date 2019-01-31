package com.qa.para.cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	@FindBy(id = "sb_form_q")
	WebElement searchBar;
	
	public void search(String arg1) {
		searchBar.sendKeys(arg1);
		searchBar.submit();
	}
}
