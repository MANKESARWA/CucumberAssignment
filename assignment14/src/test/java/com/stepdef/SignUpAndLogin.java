package com.stepdef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpAndLogin {
	WebDriver driver;
	
	@Before
	public void init()
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
	}
	
	@Given("User is at the default page")
	public void user_is_at_the_default_page() {
		
		driver.get("https://www.shoppersstop.com/#");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@When("User navigate to Sign Up page")
	public void user_navigate_to_sign_up_page() {
		driver.findElement(By.className("wishlist")).click();
	}
	@When("user clicks on sign up")
	public void user_clicks_on_sign_up() {
		driver.findElement(By.xpath("//a[@class='main-signup']")).click();
	}
		
	@When("user enter the required input")
	public void user_enter_the_required_input() {
		driver.findElement(By.id("signupFullName")).sendKeys("Mayank Kesarwani");
		driver.findElement(By.id("signupEmail")).sendKeys("jesope8377@incoware.com");
		driver.findElement(By.id("signupMobileNumber")).sendKeys("7388920978");
		driver.findElement(By.id("signupPassword")).sendKeys("M@yank978");
		driver.findElement(By.id("men")).click();
		driver.findElement(By.xpath("//body/main[1]/div[13]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/button[1]")).click();
	}
	
	@When("user wait to enter otp")
	public void user_wait_to_enter_otp() throws InterruptedException {
	    Thread.sleep(360000);
	    //User enter the One time password (Not to be Automated with selenium.
	    driver.findElement(By.id("otpSubmitBtn")).click();
	}
	@Then("user is on Home page an logged in")
	public void user_is_on_home_page_an_logged_in() {
		driver.findElement(By.xpath("//a[@class ='user']")).click();
		String checkPage = driver.findElement(By.xpath("//p[contains(text(),'Mobile: 7388920978')]")).getText();
		Assert.assertNotNull(checkPage);
	}
	@Then("user is Signing out")
	public void user_is_signing_out() {
		driver.findElement(By.xpath("//a[@class ='user']")).click();
		driver.findElement(By.className("logout-tag")).click();
	}
	
	@When("user clicks on sign in with Email")
	public void user_clicks_on_sign_in_with_email() {
	    driver.findElement(By.xpath("//a[text()='Sign in with Email'][@class='signinwithemail']")).click();
	}
	@When("user enter Email and password")
	public void user_enter_email_and_password() {
	    driver.findElement(By.id("j_username")).sendKeys("jesope8377@incoware.com");
	    driver.findElement(By.id("j_password")).sendKeys("M@yank978");
	}
	@When("user clicks on SignIn")
	public void user_clicks_on_sign_in() {
		driver.findElement(By.xpath("//button[@id='loginajax']")).click();
	}


}
