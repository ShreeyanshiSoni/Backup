package com.cucumber.BDD.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
features = "src/test/resources/Features/MyHoliday.feature",
tags = "@BookOneWayFlight")
 
public class CucumberRunnerTest {
	

}
