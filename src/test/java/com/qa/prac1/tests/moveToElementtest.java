package com.qa.prac1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.prac1.utils.BrowserUtils;

public class moveToElementtest 
{
	WebDriver driver;
	@Test
	public void moveToEleTestMethod() throws InterruptedException {
		driver = BrowserUtils.launchBrowser("chrome");
		BrowserUtils.launchURL("https://www.spicejet.com/");
		By ele1=By.xpath("//li[@class='li-login float-right tabres']//a[text()='Login / Signup']");
		By ele2=By.xpath("//a[text()='SpiceClub Members']");
		By ele3=By.xpath("(//li//a[text()='Member Login'])[2]");
//		BrowserUtils.doMoveToElementAndClick(ele1, ele2, ele3, driver, "Cheap Air");
		BrowserUtils.doMoveToElementAndClick(By.xpath("//a[text()='Add-Ons']"), By.xpath("//a[text()='International Connection Baggage']"), driver, "SpiceJet");
		Thread.sleep(3000);
		if(driver.getTitle().contains("SpiceJet")) {
			System.out.println("Test is pass");
		}
		driver.quit();
		
	}
	
	
}
