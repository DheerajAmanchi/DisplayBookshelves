package com.urbanLadder.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class storageStudyRoomPage extends basePage {

	public storageStudyRoomPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(tagName="h1")
	public WebElement storageTitle;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[2]/div/div[1]/div/a[1]")
	WebElement bookshelf;
	
	public void clickOnBookshelf() {			//Method to click on Bookshelf link
		
		bookshelf.click();
		driver = windowHandling();
	}

}
