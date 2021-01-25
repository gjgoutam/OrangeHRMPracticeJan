package com.orangeHRM.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.Utils.Constants;
import com.orangeHRM.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest {

	LoginPage lp;

	@BeforeClass
	public void beforeClassSetup(){
		try {
		lp = new LoginPage(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Before Class");
	}
	

	@Test(enabled = true)
	public void titleTest() {
		String title = lp.getPgTitle();
		Assert.assertEquals(title, Constants.CONSTANTS_LOGINPG_TITLE);
	}


	@Test(enabled = true)
	public void footerlinkTest() {
		Assert.assertEquals(lp.verifyVersion(), Constants.CONSTANTS_VERSION);
	}

	@Test(enabled = true)
	public void LoginErrMsgTest() {
		Assert.assertEquals(lp.blankUsrName(), Constants.CONSTANTS_USRNAME_MSG,
				"Blank user name error message not displayed");
	}
	
	@Test(enabled = true)
	public void incorrectUsrPwdTest() {
		Assert.assertEquals(lp.incorrectUsrNameCorrPwd("admin"),"https://goutamjo-trials6518.orangehrmlive.com/securityAuthentication/retryLogin");
	}
}
