package com.qa.prac1.tests;

import java.util.List;

import org.openqa.selenium.By;

import com.qa.prac1.utils.BrowserUtils;

public class selectAndOptions {
	public static BrowserUtils bu;
	public static void main(String[] args) {
		bu=new BrowserUtils();
		bu.launchBrowser("chrome");
//		bu.launchURL("https://www.orangehrm.com/orangehrm-30-day-trial/");
		bu.launchURL("https://www.google.com");
		By countryLoc=By.id("Form_submitForm_Country");
		By industryLoc=By.xpath("//select[@name='Industry']");
		By countryLocOptions = By.xpath("//select[@id='Form_submitForm_Country']/option");
		By industryLocOptions = By.xpath("//select[@name='Industry']/option");
		By googleSearchTxtBox = By.xpath("//input[@title='Search']");
		By googleAutoSuggestion = By.xpath(" //ul[@role='listbox']/li");
		//Goole autosuggestions - //ul[@role='listbox']/li
		//Using Select class
//		getDropdownValuesWithSelect(googleAutoSuggestion);
		//Without using select class
		bu.getEle(googleSearchTxtBox).sendKeys("Test");
//		bu.getDropdownValues(googleAutoSuggestion, "testosterone");
		bu.getDropdownValues(googleAutoSuggestion, 6);

	}
	
	/**
	 * getSelectOptionsText() will take locator as arg and then return the values in form of an array list
	 * @param loc
	 */
	public static void getDropdownValuesWithSelect(By loc) {
		List<String> dropDownValues = bu.getSelectOptionsText(loc);
		System.out.println(dropDownValues);
	}
	

}
