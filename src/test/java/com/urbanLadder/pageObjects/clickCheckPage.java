//This java file includes three webpages  track order page, wishlist page, cart page
package com.urbanLadder.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class clickCheckPage extends basePage {

	public clickCheckPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(tagName="h2")
	public WebElement trackOrderTitle;
	
	@FindBy(tagName="h1")
	public WebElement wishlistTitle;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/p[1]")
	public WebElement cartMsg;

}
