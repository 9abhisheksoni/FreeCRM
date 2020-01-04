package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LogInPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase {

	LogInPage logInPage;
	LandingPage lndpg;
	HomePage homePage;
	ContactsPage contactspage;
	TasksPage taskPage;
	DealsPage dealPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initializtion();
		lndpg = new LandingPage();
		logInPage = new LogInPage();
		lndpg.logInClick();
		homePage = logInPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyUserNameLabelTest() {
		Assert.assertTrue(homePage.verifyUserNameLabel()); 
	}
	
	@Test(priority=2)
	public void contactsLinkClickTest() {
		contactspage = homePage.clickOnContacsLink();
	}
	
	@Test(priority=3)
	public void taskLinkClickTtest() {
		taskPage = homePage.clicOnTasksLink();
	}
	
	@Test(priority=4)
	public void dealLinkClickTest() {
		dealPage = homePage.clickOnDealsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
