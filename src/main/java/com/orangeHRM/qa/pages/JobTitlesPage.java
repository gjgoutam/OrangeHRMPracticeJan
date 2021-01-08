package com.orangeHRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.qa.Utils.ElementUtil;
import com.orangeHRM.qa.Utils.JsUtil;
import com.orangeHRM.qa.baseClass.BasePage;

public class JobTitlesPage extends BasePage {

	WebDriver driver;
	ElementUtil eUtil;
	JsUtil js;

	/*
	 * Object repository (OR)
	 */
	By pgTitle = By.className("page-title");

	// Add job title popup locators
	By addJobTitleBtn = By.xpath("//a[@ng-click='jobTitlesCtrl.addJobTitles()']");
	By addJobTitle = By.id("jobTitleName");
	By addJobDescription = By.id("jobDescription");
	By addJobSpecFile = By.id("jobSpecification");
	By addNotes = By.id("note");
	By SaveBtn = By.xpath("//a[@form-name='jobTitlesModalForm']");
	
	By Pagination = By.className("page-size");

	public JobTitlesPage(WebDriver driver) {
		this.driver = driver;
		eUtil = new ElementUtil(driver);
		js = new JsUtil(driver);
	}

	public boolean verifyPgHeader() {
		return eUtil.PresenceOfElements(pgTitle);
	}

	public void VerifyAddUser(String JobTitle, String JobDescription, String FilePath, String Notes) {
			eUtil.PresenceOfElements(addJobTitleBtn);
			eUtil.enterClick(addJobTitleBtn);
			eUtil.PresenceOfElements(addJobTitle);
			eUtil.enterKeys(addJobTitle, JobTitle);
			eUtil.enterKeys(addJobDescription,JobDescription);
			eUtil.enterKeys(addJobSpecFile,FilePath);
			eUtil.enterKeys(addNotes,Notes);
			eUtil.enterClick(SaveBtn);
		}

	public void VerifyUserAdded() {
		js.jsScrollDown(Pagination);
		
		
	}
}
