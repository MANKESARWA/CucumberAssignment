package com.automationtesting.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue = "com.automationtesting.stepdef",
		monochrome = true,
		plugin = {"pretty","html:target/index.html"}
		)
public class TestRunner {

}
