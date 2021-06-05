package com.qa.prac1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.prac1.utils.BrowserUtils;
import com.qa.prac1.utils.JavaScriptUtil;

public class JavaScriptsUsageTest 
{
	WebDriver driver;
	@Test
	public void javaScriptTest() throws InterruptedException {
		driver = BrowserUtils.launchBrowser("chrome");
		BrowserUtils.launchURL("https://www.spicejet.com/");
		JavaScriptUtil jsUtil=new JavaScriptUtil(driver);
		By flashEle = By.xpath("//a[text()='Add-Ons']");
		
		
		
		//Code to flash an element
//		jsUtil.flash(BrowserUtils.getEle(flashEle));
//		Thread.sleep(2000);
		
		//Code to draw border for an element
//		jsUtil.drawBorder(BrowserUtils.getEle(flashEle));
//		Thread.sleep(2000);
		
		//Code to click on ele using JSUtil
//		jsUtil.clickEleByJS(BrowserUtils.getEle(flashEle));
//		Thread.sleep(2000);
		
		//Refresh the page
//		jsUtil.refreshBrowserByJS();

		// To get browser info and print it on the console
//		System.out.println(jsUtil.getPageInnerText());
		
		//to highlight the element using java script and then click on the element
		BrowserUtils.getEle(flashEle).click();
		
		
		
		
		
		
		
		Thread.sleep(6000);
		driver.quit();
	}
}
