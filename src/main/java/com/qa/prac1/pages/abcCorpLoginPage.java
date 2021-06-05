package com.qa.prac1.pages;

import org.openqa.selenium.By;

import com.qa.prac1.utils.BrowserUtils;

public class abcCorpLoginPage 
{
//	WebDriver driver;
	BrowserUtils bu=new BrowserUtils();
	
	By usernameTxt = By.id("login");
	By passTxt = By.id("password");
	By loginBtn=By.xpath("//button[text()='Log in']"); 
	
	
	public void doLogin(String un, String pwd) {
		bu.getEle(usernameTxt).sendKeys(un);
		bu.getEle(passTxt).sendKeys(pwd);
		bu.getEle(loginBtn).click();
	}
	
	
	
}
