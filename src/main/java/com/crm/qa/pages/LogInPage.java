package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LogInPage extends TestBase {

	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement submit;

	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signup;

	@FindBy(xpath = "//a[text()='Classic CRM']")
	WebElement classicCRM;
	
	//Initializing the Page Objects :
	public LogInPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions : 
	public String validatePageTitle() {
		return driver.getTitle();
	}

	public boolean signUpbtn() {
		return signup.isDisplayed();
	}

	public HomePage login(String un, String pw) throws InterruptedException {
		username.sendKeys(un);
		Thread.sleep(3000);
		password.sendKeys(pw);
		Thread.sleep(3000);
		submit.click();
		Thread.sleep(3000);
		return new HomePage();
	}

}
