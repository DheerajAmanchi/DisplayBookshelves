package com.urbanLadder.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchResultsPage extends basePage {

	public searchResultsPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[1]/h2/span")
	public WebElement searchResultsTitle;

}
