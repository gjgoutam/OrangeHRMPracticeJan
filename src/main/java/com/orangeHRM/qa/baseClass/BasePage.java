package com.orangeHRM.qa.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}	
	WebDriver driver;
	Properties prop;

	public WebDriver initDriver(Properties prop) {

		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());


		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}

		getDriver().manage().window().maximize();
		return getDriver();
	}

	public void getURL(Properties prop) {
		getDriver().get(prop.getProperty("url"));
	}

	public Properties initProp() {
		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Sharmita Bose\\eclipse-workspace\\OrangeHRMPractice\\src\\main\\java\\com\\orangeHRM\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (Exception e) {
			System.out.println(e + "Was the exception for the input file not found");
			e.printStackTrace();
		}
		return prop;
	}

	public void closeBwsr() {
		getDriver().quit();
	}
	
	/*
	 * Screenshot method
	 */
	
	public String getScreenshot() {
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+"png"; //Creating file name
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
}
