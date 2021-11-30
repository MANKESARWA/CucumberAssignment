package com.automationtesting.page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automationtesting.customexception.CustomException;

public class BasePage {
	public WebDriver driver;
	Properties prop;
	String browserName;
	
	//Initializing the driver as per the configuration properties and making a handshake between constructor and properties.
	public BasePage() {
		try {
			prop = new Properties();
			prop.load(new FileInputStream("config/config.properties"));
			browserName = prop.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.geckdriver.driver", "driver/geckdriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("Edge"))
			{
				System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
				driver = new EdgeDriver();
			}
			else {
				throw new CustomException("Browser not supported for testing this page");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (CustomException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//Maximizing the browser and loading the page
	public void init() {
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
