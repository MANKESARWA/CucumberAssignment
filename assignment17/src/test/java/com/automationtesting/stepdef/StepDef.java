package com.automationtesting.stepdef;

import java.util.concurrent.TimeUnit;

import com.automationtesting.pages.WorkingPage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	
	WorkingPage wp;
	@Given("user is on the default page")
	public void user_is_on_the_default_page() {
	    wp = new WorkingPage();
	}
	@When("user click on shop")
	public void user_click_on_shop() {
		wp.clickShop();
		wp.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@When("user click on home")
	public void user_click_on_home() {
		wp.clickHome();
		wp.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Then("user check home page have three arrivals")
	public void user_check_home_page_have_three_arrivals() {
		wp.newArrivalCheck();
	}
	@When("user click on the image of new arrival")
	public void user_click_on_the_image_of_new_arrival() {
		wp.checkFunctionality();
	}
	@Then("user is on next page")
	public void user_is_on_next_page() {
		wp.nextPageCheck();
	}
	@Then("user is able to add book to the basket")
	public void user_is_able_to_add_book_to_the_basket() {
		wp.addToCart();
	}
	
	@After
	public void init()
	{
		wp.driver.close();
	}

}
