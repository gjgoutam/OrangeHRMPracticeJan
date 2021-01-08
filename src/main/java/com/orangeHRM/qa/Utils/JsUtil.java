package com.orangeHRM.qa.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsUtil {
	
	WebDriver driver;
	
	public JsUtil(WebDriver driver) {
	this.driver=driver;	
	}

	public void jsScrollDown(By pagination) {
		WebElement element = driver.findElement(pagination);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	public void jsRefreshPage() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
}
