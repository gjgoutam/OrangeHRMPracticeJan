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

		try {
		bt = new BasePage();
		prop = bt.initProp();
		driver = bt.initDriver(prop);
		}catch (Exception e) {
			e.printStackTrace();
		}
		bt.getURL(prop);
		
		System.out.println("Base Test setup");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
