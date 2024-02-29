package com.urbanLadder.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class basePage {

WebDriver driver;
	
	public basePage(WebDriver driver) {                                     //Constructor for the page class
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver windowHandling() {										//Method for handling the multiple windows
		//find current window handle
		        List<String> winHandles = new ArrayList<String>(driver.getWindowHandles());
		        
		        String resultWinHandle = "";
		        // Iterate over the handles to find the child window
		        for (String handle : winHandles) 
		        {
		            
		        	resultWinHandle = handle;
		        }
		        driver.switchTo().window(resultWinHandle);
		        return driver;
	}
}
