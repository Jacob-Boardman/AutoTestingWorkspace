package com.qa.cucumber.Demo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class MenuPage {

	@FindBys(@FindBy(tagName = "strong"))
	List<WebElement> list;

	public boolean isListPresent() {
		if (list.size() > 2) {
			return true;
		} else {

			return false;
		}

	}

}
