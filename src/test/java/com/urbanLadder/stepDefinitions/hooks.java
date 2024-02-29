package com.urbanLadder.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.urbanLadder.utils.baseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {

	static WebDriver driver;
	static Properties p;
	
//	@Before
//	public void setup() throws IOException{
//		driver = baseClass.initilizeBrowser();		//calling the initializeBrowser method of baseClass to get the driver
//		
//		p = baseClass.getProperties();				//calling the getProperties method of baseClass
//		driver.manage().window().maximize();		//Maximizing the browser window 
//		driver.get(p.getProperty("appUrl"));		//navigating to the appUrl
//		
//		
//	}
//	
//	@After
//	public void tearDown(Scenario scenario) {
//		
//		driver.quit();								//closing the browser
//	}
	

	
	@AfterStep
	public void addScreenshot(Scenario scenario) {   //Method to take screenshot after every step in the scenario
		
		driver=baseClass.getDriver();
		TakesScreenshot ts=(TakesScreenshot) driver;
    	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
    	scenario.attach(screenshot, "image/png",scenario.getName());
	}
}
