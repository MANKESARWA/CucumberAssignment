package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue="com.stepdef",
		tags = "@negativeLogin",
		monochrome = true,
		plugin = {"pretty","rerun:target/failedcase.txt"}
		)
public class TestRunner {

}