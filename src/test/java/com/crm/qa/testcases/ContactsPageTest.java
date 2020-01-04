package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LogInPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LandingPage landingPg;
	LogInPage logIn;
	HomePage homePage;
	ContactsPage contactPage;
	;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initializtion();
		
		landingPg = new LandingPage();
		logIn = new LogInPage();
		landingPg.logInClick();
		homePage = logIn.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.clickOnContacsLink();
	}

	/*
	 * @Test public void verifyContactLabelTest() {
	 * contactPage.verifyNewContactLabel(); }
	 */

	@DataProvider
	public Object[][] getData() throws InvalidFormatException {
		Object data[][] = TestUtil.getData("contacts");
		return data;
	}

	@Test(dataProvider = "getData")
	public void createNewContactTest(String FirstName, String LastName, String Company, String Tag) {
		contactPage.createNewContact(FirstName, LastName, Company, Tag);
	}

	@AfterMethod
	public void terDown() {
		driver.quit();
	}

}
