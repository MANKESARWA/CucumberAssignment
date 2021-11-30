package com.automationtesting.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.automationtesting.page.BasePage;

public class WorkingPage extends BasePage{
	
	//data element of the web page.
	@FindBy(linkText = "Shop")
	WebElement shopLink;
	@FindBy(linkText = "Home")
	WebElement homeLink;
	@FindBys(@FindBy(xpath = "//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']"))
	List<WebElement> newArrival;
	@FindBy(xpath = "//img[@title='Selenium Ruby']")
	WebElement bookImage;
	@FindBy(xpath = "//button[text()='Add to basket']")
	WebElement addToCartBtn;
	@FindBy(xpath = "//div[@class='woocommerce-message']")
	WebElement confMsg;
	@FindBy(xpath = "//span[@class='cartcontents']")
	WebElement item;
	
	public WorkingPage() {
		super();
		init();// loading the web page
		PageFactory.initElements(driver, this);
	}
	
	public void clickShop() {
		shopLink.click();
	}
	public void clickHome() {
		homeLink.click();
	}
	public void newArrivalCheck() {
		int n =newArrival.size();
		
		System.out.println("Total number of books "+n);
		
		Assert.assertTrue(newArrival.size()==3);
	}
	
	public void checkFunctionality() {
		newArrival.get(0).click();
	}
	
	public void nextPageCheck() {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Selenium Ruby – Automation Practice Site"));
	}
	
	public void addToCart() {
		addToCartBtn.click();
		Assert.assertTrue(confMsg.getText().contains("Selenium Ruby"));
	}
	public void checkItem() {
		Assert.assertFalse(item.getText().equalsIgnoreCase("0 items"));
	}

}
