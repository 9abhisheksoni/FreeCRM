package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LandingPage extends TestBase{
	
	@FindBy(xpath="//span[text()='Log In']")
	WebElement logInButton;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void logInClick() {
		logInButton.click();
	}
}
