package com.qa.prac1.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author punath
 *	This is a browser Util class that holds all the methods used to perform browser actions
 *	Methods include
 *	1. Launch BROWSER
 *	2. Launch URL
 *	
 *	
 *	
 */

/**
 * @author punath
 *
 */
/**
 * @author punath
 *
 */
public class BrowserUtils 
{
	public static WebDriver driver;
	public static JavaScriptUtil js;
	
	
	/**
	 * @param browserName
	 * @return driver
	 * This method is used to launch browser with the passed browser name
	 */
	public static WebDriver launchBrowser(String browserName) 
	{
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("Please pass valid browser name");
		}		
		return driver;
	}
	
	
	/**
	 * @param browserName
	 * @return driver
	 * This method is used to launch the browser in headless mode
	 */
	public static WebDriver launchHeadLessBrowser(String browserName) {
		
		System.out.println("This is method for launching browser in HEADLESS mode");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.out.println("Launching chrome browser");
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--headless");
			driver=new ChromeDriver(co);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fo=new FirefoxOptions();
			fo.addArguments("--headless");
			driver=new FirefoxDriver(fo);
		}
		else {
			System.out.println("Please pass valid browser name");
		}
		return driver;
	}
	
	/**
	 * @param browserName
	 * @return driver
	 * This method is used to launch the browser in INCOGNITO mode
	 */
	public static WebDriver launchIncognitoBrowser(String browserName) {
		System.out.println("This is method for launching browser in incognito mode");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.out.println("Launching chrome browser");
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--incognito");
			driver=new ChromeDriver(co);
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fo=new FirefoxOptions();
			fo.addArguments("--incognito");
			driver=new FirefoxDriver(fo);
		}
		else {
			System.out.println("Please pass valid browser name");
		}
		return driver;
	}
	
	/**
	 * @param browserName
	 * @return driver
	 * This method is used to launch the browser after ignoring certificate errors
	 */
	public static WebDriver launchBrowserIgnoreCertificateErrors(String browserName) {
		
		System.out.println("This is method for launching browser in HEADLESS mode");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--ignore-certificate-errors");
			driver=new ChromeDriver(co);
		}
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fo=new FirefoxOptions();
			fo.addArguments("--ignore-certificate-errors");
			driver=new FirefoxDriver(fo);
		}
		else {
			System.out.println("Please pass valid browser name");
		}
		return driver;
	}
	
	
	/**
	 * @param url 
	 * This method is used to launch the URL
	 */
	public static void launchURL(String url) {
		driver.get(url);
	}
	
	
	/**
	 * @return pageTitle as String
	 * This is used to get title of the current page
	 */
	public static String getPageTitle() {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		return driver.getTitle();
	}
	
	/**
	 * @return page URL
	 * This method is used to get the current page URL
	 */
	public static String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	public static WebElement getEle(By loc) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement ele=driver.findElement(loc);
		js=new JavaScriptUtil(driver);
		js.flash(ele);
		return ele;
		
	}

	public static List<WebElement> getListEle(By loc){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver.findElements(loc);
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	
	//*********************** D R O P 	D O W N 		U T I L S *******************************
	public static void selectDropDownByVisibleText(By loc, String val) {
//		getEle(loc)
		Select s=new Select(getEle(loc));
	}
	
	/**
	 * This method will get all the options of the dropdown list and put it in an ArrayList
	 * Values of the text in each select options will be added to array list
	 * This array list will be returned to the calling method
	 * @param selectLoc(locator of the Select dropdown)
	 * @return - Array List
	 */
	public static List<String> getSelectOptionsText(By selectLoc) {
		List<String> valList = new ArrayList<String>();
		WebElement select=getEle(selectLoc);
		Select s=new Select(select);
		List<WebElement> options = s.getOptions();
//		options.stream().forEach(e -> System.out.println(e.getText()));
		for(WebElement ele : options) {
			valList.add(ele.getText());
		}		
		return valList;
	}
	
	public static void getDropdownValues(By loc, String val) {
		List<WebElement> dropdownOptions = getListEle(loc);
//		Get count of dropdown values
//		System.out.println(dropdownOptions.size());
//		Print the dropdown valuse
//		dropdownOptions.stream().forEach(e -> System.out.println(e.getText()));
//		Select a given value from dropdown
		for(WebElement e:dropdownOptions) {
			String txtValue = e.getText();
			if(txtValue.equals(val)) {
				e.click();
				break;
			}
		}
	}
	
	public static void getDropdownValues(By loc, int index) {
		List<WebElement> dropdownOptions = getListEle(loc);
//		Get count of dropdown values
//		System.out.println(dropdownOptions.size());
//		Print the dropdown valuse
//		dropdownOptions.stream().forEach(e -> System.out.println(e.getText()));
//		Select a given value from dropdown
		
		dropdownOptions.stream().forEach(e -> System.out.println(e.getText()));
		
		System.out.println(dropdownOptions.get(index).getText());
		dropdownOptions.get(index).click();
	}


	public static void doDragAndDrop(By srcLoc, By destLoc, By droppedTxtLoc, WebDriver driver)
	{
		driver.switchTo().frame(0);
		WebElement dragEle = BrowserUtils.getEle(srcLoc);
		WebElement dropEle = BrowserUtils.getEle(destLoc);
		Actions action=new Actions(driver);
		action.dragAndDrop(dragEle, dropEle).perform();
		if(driver.findElement(droppedTxtLoc).getText().equalsIgnoreCase("dropped!")) {
			System.out.println("Item is dropped successfully");
		}
		driver.switchTo().defaultContent();
	}
	
	public static void doMoveToElementAndClick(By loc1, By loc2, By loc3, WebDriver driver, String title) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(getEle(loc1)));
		Actions action=new Actions(driver);
//		action.moveToElement(getEle(loc1)).moveToElement(getEle(loc2)).moveToElement(getEle(loc3)).click().build().perform();
		action.moveToElement(getEle(loc1)).moveToElement(getEle(loc2)).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(getEle(loc1)));
		action.moveToElement(getEle(loc3)).click().build().perform();
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public static void doMoveToElementAndClick(By loc1, By loc2, WebDriver driver, String title) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(getEle(loc1)));
		Actions action=new Actions(driver);
//		action.moveToElement(getEle(loc1)).moveToElement(getEle(loc2)).moveToElement(getEle(loc3)).click().build().perform();
		action.moveToElement(getEle(loc1)).perform();
		wait.until(ExpectedConditions.elementToBeClickable(getEle(loc1)));
		action.moveToElement(getEle(loc2)).click().build().perform();
		wait.until(ExpectedConditions.titleContains(title));
	}


}
