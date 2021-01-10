package com.orangeHRM.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangeHRM.qa.Utils.Constants;
import com.orangeHRM.qa.Utils.ExcelUtil;
import com.orangeHRM.qa.pages.HomePage;
import com.orangeHRM.qa.pages.JobTitlesPage;
import com.orangeHRM.qa.pages.LoginPage;

public class JobTitlesPageTest extends BaseTest {

	JobTitlesPage jp;

	@BeforeTest
	public void testSetup() {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		jp = hp.navigateToJobTitles();
	}

	@Test
	public void jobPageTitleTest() {
		Assert.assertEquals(jp.verifyPgHeader(), true);
	}
	
	@DataProvider
	public Object[][] getDataForJobTitle() {
		Object ExcelData[][] = 	ExcelUtil.SheetData(Constants.CONSTANTS_JOBTITLEDATA_SHEETNAME);
		return ExcelData;
	}
	
	@Test(enabled = true, dataProvider ="getDataForJobTitle")
	public void addJobTitleTest(String JobTitle, String JobDescription, String FilePath, String Notes){
		jp.AddUser(JobTitle,JobDescription,FilePath,Notes);
		Assert.assertEquals(jp.VerifyUserJbTitle(JobTitle), true);	
	}
	
}
