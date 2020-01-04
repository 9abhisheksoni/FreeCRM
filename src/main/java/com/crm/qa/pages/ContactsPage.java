package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsTextLabel;

	@FindBy(xpath = "//span[text()='Abhishek Soni']")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[@href='/contacts/new']")
	WebElement createNewContactBtn;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//div[@name='company']")
	WebElement company;

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement createNewContacttext;

	@FindBy(xpath = "//div[@class='ui fluid multiple search selection dropdown']")
	WebElement tag;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectContact(String name) {

		driver.findElement(
				By.xpath("//td[text()='" + name + "']//parent::tr//child::div[@class='ui fitted read-only checkbox']"))
				.click();
	}

	public void verifyNewContactLabel() {
		createNewContacttext.isDisplayed();
	}
	
	public void createNewContact(String fn, String ln, String cmp, String role) {
		createNewContactBtn.click();
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		company.sendKeys(cmp);
		tag.sendKeys(role);
		saveBtn.click();
	}

}
