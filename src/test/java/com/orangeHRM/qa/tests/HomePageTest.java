package com.orangeHRM.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangeHRM.qa.pages.HomePage;
import com.orangeHRM.qa.pages.LoginPage;

public class HomePageTest extends BaseTest {
	
	LoginPage lp;
	HomePage hp;
	
	@BeforeClass
	public void ClassSetUp() {
		lp = new LoginPage(driver);
		hp = lp.doLogin("admin", "Shashu1@");
	}
	
	@Test
	public void dasboardPage() {
		Assert.assertEquals(true, hp.PresenceOfDashboard());
	}
}
