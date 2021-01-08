package com.orangeHRM.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.orangeHRM.qa.baseClass.BasePage;


public class BaseTest {
	
	BasePage bt;
	WebDriver driver;
	Properties prop;

	@BeforeTest
	public void setUp() {
		bt = new BasePage();
		prop = bt.initProp();
		driver = bt.initDriver(prop);
		bt.getURL(prop);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
