package com.crm.qa.base;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.util.TestUtil;

public class Travel {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\\\RealTimeProject\\\\Transections\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='search-input-location']")).sendKeys("lon");
		Thread.sleep(3000);
		List<WebElement> suggestions = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		for (WebElement suggest : suggestions) {
			if(suggest.getText().equalsIgnoreCase("London")) {
				suggest.click();
			}
		}
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='results_sort']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Highest price");
		Thread.sleep(3000);
		/*driver.findElement(By.xpath("//button[text()='Filter results']")).click();*/
		List<WebElement> priceListing = driver.findElements(By.xpath("//a[@class='listing-results-price text-price' and contains(@href,'search_identifier=')]"));
		System.out.println("Top 5 price of House to rent in London from High to Low --->");
		for(int i=0; i<5; i++) {
			String price = priceListing.get(i).getText();
			System.out.println(price);
		}
		
		
		
		
	}

}
