package com.qa.cucumber.Demo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\qa\\cucumber\\Demo\\TeaTesting.feature")
public class TestRunner {

}
