package com.automationtesting.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.automationtesting.page.BasePage;

public class WorkingPage extends BasePage {
	//data member : all UI web element on the current page
	@FindBy(xpath="//a[text()='Shop']")
	WebElement shopLink;
	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeLink;
	@FindBys(@FindBy(xpath = "//div[@class='n2-ss-slide-background']"))
	List<WebElement> sliders;
	
	public WorkingPage()
	{
		super();
		init();// load the page
		PageFactory.initElements(driver, this);
	}
	
	//Member functions: design the functionality of the data members.
	public void clickOnShop()
	{
		shopLink.click();
	}
	
	public void clickOnHome() {
		homeLink.click();
	}
	
	public boolean sliderCheck() {
		int count = sliders.size();
		if(count == 3)
		{
			return true;
		}
		return false;
	}
	
}

