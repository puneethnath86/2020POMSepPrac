package com.qa.prac1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.prac1.utils.BrowserUtils;

public class Drag_Drop 
{
	WebDriver driver;
	@Test
	public void dragNDropTest() throws InterruptedException {
		driver = BrowserUtils.launchBrowser("chrome");
		BrowserUtils.launchURL("https://jqueryui.com/droppable/");
		By dragEleLoc=By.xpath("//div[@id='draggable']");
		By dropEleLoc=By.xpath("//div[@id='droppable']");
		By droppedEleLoc=By.xpath("//p[contains(text(),'Dropped!')]");
		Thread.sleep(3000);
		BrowserUtils.doDragAndDrop(dragEleLoc, dropEleLoc, droppedEleLoc, driver);
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
