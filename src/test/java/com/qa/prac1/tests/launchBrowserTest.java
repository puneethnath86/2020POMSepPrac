package com.qa.prac1.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.prac1.pages.abcCorpLoginPage;
import com.qa.prac1.utils.BrowserUtils;

public class launchBrowserTest 

{
	WebDriver driver;
	abcCorpLoginPage obj=new abcCorpLoginPage();
	@Test(priority=1)
	public void openBrowser() {
		driver=BrowserUtils.launchBrowser("chrome");
		BrowserUtils.launchURL("https://abc-corp1.odoo.com/web/login");
		System.out.println("Title of the page is--> "+BrowserUtils.getPageTitle());
		System.out.println("URL of the page is--> "+BrowserUtils.getPageURL());
//		BrowserUtils.quitBrowser();
	}
	
	@Test(priority=2)
	public void loginToApplication() {
		obj.doLogin("puneeth297@gmail.com", "Selenium@jun2020");
		
	}
}
