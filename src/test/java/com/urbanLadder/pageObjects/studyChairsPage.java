package com.urbanLadder.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.urbanLadder.utils.excelUtils;

public class studyChairsPage extends basePage {
	
	static JavascriptExecutor js;
	static WebDriverWait wait;

	public studyChairsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(tagName="h1")
	public WebElement studyChairsTitle;
	
	@FindBy(xpath="//*[@id=\"authentication_popup\"]/div/div/div[2]/a[1]")
	WebElement closeButton;
	
	String filePath = System.getProperty("user.dir")+"/src/test/resources/bookShelvesData.xlsx";
	
	public String getStudyChairsTitle() {
		
		String scTitle = studyChairsTitle.getText();
		return scTitle;
		
	}
	
	public void displayStudyChairs() throws IOException {		//Method to display the study chairs and store them in excel
		
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(closeButton));
			
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", closeButton);
		}
		catch(Exception e) {
			
		}
		
		List<String> models= new ArrayList<>();
		List<String> brands= new ArrayList<>();
		List<String> prices = new ArrayList<>();
		
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/ul/li[1]/div/div[5]/a/div[1]/span")));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/ul/li[1]/div/div[5]/a/div[1]/span"))));
		
		for(int i=1; i<=3; i++) {
			System.out.println("========================================================================");
			WebElement modelName = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/ul/li[" +i+ "]/div/div[5]/a/div[1]/span"));
			models.add(modelName.getText());
			System.out.println(modelName.getText());
			
			excelUtils.setCellData(filePath,"StudyChairs",i,0,modelName.getText());
			
			WebElement brandName = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/ul/li[" +i+ "]/div/div[5]/a/div[1]/div[2]/div"));
			brands.add(brandName.getText());
			System.out.println(brandName.getText());
			
			excelUtils.setCellData(filePath,"StudyChairs",i,1,brandName.getText());
			
			WebElement price = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/ul/li[" +i+ "]/div/div[5]/a/div[2]/span"));
			prices.add(price.getText());
			System.out.println(price.getText());
			
			excelUtils.setCellData(filePath,"StudyChairs",i,2,price.getText());
			
			System.out.println("========================================================================");
			
		}
	}

}
