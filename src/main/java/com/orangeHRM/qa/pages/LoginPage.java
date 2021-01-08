package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.qa.Utils.ElementUtil;
import com.orangeHRM.qa.baseClass.BasePage;

public class LoginPage extends BasePage{

	WebDriver driver;
	ElementUtil eUtil;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eUtil = new ElementUtil(this.driver);
	}	

	/*
	 * Object Repository
	 * 
	 */
	
	By userName = By.id("txtUsername");
	By password = By.xpath("//input[@id='txtPassword']");
	By loginBtn = By.name("Submit");
	By footerTxt = By.xpath("//div[@id='footer']");
	By errorMsg = By.xpath("//span[@id='spanMessage']");
	
	/*
	 * Page Actions
	 */
	
	public String getPgTitle() {
		return eUtil.getPgTitle();
	}

	public String verifyVersion() {
		String text = driver.findElement(footerTxt).getText();
		text = text.substring(10,16);
		return text;
	}
	
	public void incorrectPwd() {
		eUtil.enterKeys(userName, getPgTitle());
	}
	
	public String blankUsrName() {
		eUtil.enterClick(loginBtn);
		return eUtil.verifyErrorMsg(errorMsg);
	}
	
	public String blankPwd() {
		eUtil.enterKeys(userName, "Text");
		eUtil.enterClick(loginBtn);
		return eUtil.verifyErrorMsg(errorMsg);
	}
	
	public String incorrectUsrNameCorrPwd(String usn) {
		eUtil.enterKeys(userName,usn);
		eUtil.enterKeys(password, "Test");
		eUtil.enterClick(loginBtn);
		return eUtil.getPgUrl();
	}
	
	
	public HomePage doLogin(String usn, String pwd) {
		eUtil.enterKeys(userName, usn);
		eUtil.enterKeys(password, pwd);
		eUtil.enterClick(loginBtn);
		return new HomePage(driver);
	}
	
}
