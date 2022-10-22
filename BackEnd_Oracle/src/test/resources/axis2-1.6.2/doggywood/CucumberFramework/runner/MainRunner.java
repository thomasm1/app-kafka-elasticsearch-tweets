package com.doggywood.CucumberFramework.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)

@CucumberOptions (
	features = {"C:\\w\\www\\git\\java-devops\\project2\\src\\test\\java\\com\\doggywood\\CucumberFramework\\featureFiles"},
	glue = {"C:\\w\\www\\git\\java-devops\\project2\\src\\test\\java\\com\\doggywood\\CucumberFramework\\stepFiles"},
	monochrome = true,
	plugin = {"pretty", "html:target/cucumber", 
			"json:target/cucumber.json", 
			"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"
	}
)

public class MainRunner {

}
