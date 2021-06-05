package com.qa.prac1.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil 
{
	WebDriver driver;
	
	/*
	 * Public constructor to initialize the driver instance
	 */
	public JavaScriptUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public void alert(String alertTxt) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("alert('" + alertTxt + "')");
	}
	
	
	public void flash(WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String bgcolor = ele.getCssValue("backgroundColour");
//		Flash 10 times
		for(int i=0;i<=10;i++) {
			changeColor("rgb(200,0,0)", ele);
			changeColor(bgcolor, ele);
		}
	}
	
	public void changeColor(String color, WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", ele);
		try {
			Thread.sleep(40);
		}	catch(Exception e) {}
	}
	
	public void drawBorder(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='5px solid green'", ele);
	}
	
	public void clickEleByJS(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ele);
	}
	
	public void refreshBrowserByJS() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	/*
	 * This method is used to get entire text present in the displayed page
	 * No other image/elements will be returned
	 * Only the text present on the webpage
	 * JSCode - document.documentElement.innerText;
	 */
	public String getPageInnerText() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String innerText = js.executeScript("return document.documentElement.innerText;").toString();
		return innerText;
	}
	
	
	public String getBrowserInfo() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String browserInfo = js.executeScript("return navigator.userAgent;").toString();
		return browserInfo;
	}
	
	public void sendKeysByJSWithId(String eleID, String txt) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(" document.getElementById(' " + eleID + " ').value= ' "+txt+" '  ");
	}
	
	public void sendKeysByJSWithName(String eleName, String txt) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(" document.getElementByName(' " + eleName + " ').value= ' "+txt+" '  ");
	}
	
	public void sendKeysByJSWithClassName(String eleClassName, String txt) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(" document.getElementByClassName(' " + eleClassName + " ').value= ' " + txt + "'  ");
	}
	
	// To scroll to bottom of the page
	public void scrollPageDown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	
	// To scroll to a particular element on the webpage
		public void scrollInToView(WebElement ele) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("argument[0].scrollIntoView(true);", ele);
		}
	
		// To scroll to TOP of the page
		public void scrollPageUp() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		}




}
