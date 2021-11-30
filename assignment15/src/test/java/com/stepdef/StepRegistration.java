package com.stepdef;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepRegistration {
	
	WebDriver driver;
	
	
	@Given("user is at default page")
	public void user_is_at_default_page() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
	    driver.get("https://www.shoppersstop.com/#");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@When("user navigate to sign up page")
	public void user_navigate_to_sign_up_page() {
		driver.findElement(By.className("wishlist")).click();
			    
	}
	@When("user clicks on sign up")
	public void user_clicks_on_sign_up() {
		driver.findElement(By.xpath("//a[@class='main-signup']")).click();
	}
	@When("user enter the required details")
	public void user_enter_the_required_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> map= dataTable.asMap(String.class, String.class);
	    driver.findElement(By.id("signupFullName")).sendKeys(map.get("name"));
	    driver.findElement(By.id("signupEmail")).sendKeys(map.get("email"));
		driver.findElement(By.id("signupMobileNumber")).sendKeys(map.get("mobile"));
		driver.findElement(By.id("signupPassword")).sendKeys(map.get("password"));
		if(map.get("gender").equalsIgnoreCase("male"))
			driver.findElement(By.id("men")).click();
		else
			driver.findElement(By.id("women")).click();
		driver.findElement(By.xpath("//body/main[1]/div[13]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/button[1]")).click();
	}
	@When("user wait to enter OTP")
	public void user_wait_to_enter_otp() throws InterruptedException {
		Thread.sleep(360000);
	    //User enter the One time password (Not to be Automated with selenium.
	    driver.findElement(By.id("otpSubmitBtn")).click();
	}
	@Then("user is on home page as logged in.")
	public void user_is_on_home_page_as_logged_in() {
		driver.findElement(By.xpath("//a[@class ='user']")).click();
		String checkPage = driver.findElement(By.xpath("//p[contains(text(),'Mobile: 7388920978')]")).getText();
		Assert.assertNotNull(checkPage);
	}

	

}
