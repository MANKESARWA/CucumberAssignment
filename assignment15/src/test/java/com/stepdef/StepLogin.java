package com.stepdef;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import com.utils.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepLogin {
	
	public static WebDriver driver;
	
	@Given("user is on default page")
	public void user_is_on_default_page() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.shoppersstop.com/#");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@When("user is navigate to sign in with email")
	public void user_is_navigate_to_sign_in_with_email() {
		driver.findElement(By.className("wishlist")).click();
		driver.findElement(By.className("signinwithemail")).click();	    
	}
	@When("user enter the {string} and {string}")
	public void user_enter_the_and(String userEmail, String password) {
		driver.findElement(By.id("j_username")).sendKeys(userEmail);
		driver.findElement(By.id("j_password")).sendKeys(password);
	}
	@When("user click on the signinbtn")
	public void user_click_on_the_signinbtn() {
		
		  WebDriverWait wait = new WebDriverWait(driver, 30);
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("loginajax")))).click();
	}
	@Then("user check for profile details")
	public void user_check_for_profile_details() {;
		Assert.assertTrue(driver.getTitle().contains("Wishlist"));
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.close();
	}
	@Then("locate the invalid id on same page.")
	public void locate_the_invalid_id_on_same_page() {
		String element = driver.findElement(By.className("login-account-not-found")).getText();
		if(!element.isEmpty())
			Assert.assertTrue(element.contains("incorrect"));
	}
	@After
	public void tearDown(Scenario sc)
	{
		if(!sc.isFailed())
		{
			try {
				CaptureScreenshot.captureScreen();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.close();
	}
}
