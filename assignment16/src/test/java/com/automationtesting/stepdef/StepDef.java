package com.automationtesting.stepdef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.automationtesting.pages.WorkingPage;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	
	WorkingPage wp;
	
	@Given("user is at default page")
	public void user_is_at_default_page() {
	   wp = new WorkingPage();
	}
	@When("user clicks on shop")
	public void user_clicks_on_shop() {
	    wp.clickOnShop();
	    wp.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@When("user clicks on home")
	public void user_clicks_on_home() {
	    wp.clickOnHome();
	    wp.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Then("user checks for three slider")
	public void user_checks_for_three_slider() {
	    Assert.assertTrue(wp.sliderCheck());
	}
	@After
	public void tearDown(Scenario sc)
	{
		wp.driver.close();
	}



	
}
