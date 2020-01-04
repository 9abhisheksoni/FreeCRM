package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LogInPage;

public class LogInPageTest extends TestBase {

	LogInPage login;
	HomePage hm;
	LandingPage lndPage;

	public LogInPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initializtion();
		login = new LogInPage();
		lndPage = new LandingPage();
	}

	@Test(priority=1)
	public void validateTitleText() {
		lndPage.logInClick();
		String title = login.validatePageTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(title, prop.getProperty("logInTitle"));
	}

	@Test(priority=2)
	public void loginTest() throws InterruptedException {
		lndPage.logInClick();
		hm = login.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
