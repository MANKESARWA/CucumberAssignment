package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue = "com.stepdef",
//		tags = "@positives"
		monochrome = true,
//		dryRun = true//to check the code execution flow (it will not hit in UI)
		plugin = {"pretty","html:target/index.html","json:target/index.json"}
		)
public class TestRunner {
	
	

}
