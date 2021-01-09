package com.orangeHRM.qa.Utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	private WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	private ArrayList<WebElement> getElements(By locator) {
		List<WebElement> eleList = driver.findElements(locator);
		ArrayList<WebElement> arrEleList = new ArrayList<WebElement>(eleList);
		return arrEleList;
	}

	private void WaitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	private void WaitForString(By locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public String getPgTitle() {
		return driver.getTitle();
	}

	public void enterKeys(By locator, String keys) {
		getElement(locator).sendKeys(keys);
	}

	public void enterClick(By locator) {
		getElement(locator).click();
	}

	public String getPgUrl() {
		return driver.getCurrentUrl();
	}

	public Boolean PresenceOfElements(By locator) {
		try {
			WaitForElement(locator);
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String verifyErrorMsg(By locator) {
		try {
			WaitForElement(locator);
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean verifyTitleInTable(By locator, String JbTitle) {
		try {
			WaitForString(locator, JbTitle);
		} catch (Exception e) {
			System.out.println("Element not present");
		}

		ArrayList<WebElement> eleList = new ArrayList<WebElement>();
		eleList = getElements(locator);
		for (int i = 0; i < eleList.size(); i++) {
			String txt = eleList.get(i).getText();
			if (txt.equalsIgnoreCase(JbTitle)) {
				return true;
			}

		}
		return false;
	}
}
