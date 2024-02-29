package com.urbanLadder.testRunner;
//import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.urbanLadder.utils.baseClass;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/featureFiles/"}, 
		glue = "com.urbanLadder.stepDefinitions", 
		plugin = {"pretty","html:reports/report.html","rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false,
		monochrome=false,
		publish=true
		)

@Test
public class testNGRunner extends AbstractTestNGCucumberTests{
	
	static WebDriver driver;
//	static String browser;
	static Properties p;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setup(String browser) throws IOException{
		
		
		
		driver = baseClass.initilizeBrowser(browser);		//calling the initializeBrowser method of baseClass to get the driver
		
		p = baseClass.getProperties();				//calling the getProperties method of baseClass
		driver.manage().window().maximize();		//Maximizing the browser window 
		driver.get(p.getProperty("appUrl"));//navigating to the appUrl
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();	//closing the browser
		}
	}
}
