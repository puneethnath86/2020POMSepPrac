package com.qa.prac1.pages;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.qa.prac1.utils.BrowserUtils;

public class abcCorpHomePage 
{
	BrowserUtils bu=new BrowserUtils();
	By userName = By.xpath("//span[text()='Puneeth Nath']");
	By crmLink = By.xpath("//div[text()='CRM']");
	
	public void checkLoginUserName(String expectedUsrName) {
		if (bu.getEle(userName).getText().equals(expectedUsrName)) {
			Reporter.log("UserLogin is successful");
		}
		else {
			System.out.println("User not logged in");
		}
	}
	
	public void clickCRMLink() {
		bu.getEle(crmLink).click();
	}
}
