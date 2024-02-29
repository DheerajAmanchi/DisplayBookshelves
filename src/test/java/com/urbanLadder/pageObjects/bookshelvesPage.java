package com.urbanLadder.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.urbanLadder.utils.excelUtils;

public class bookshelvesPage extends basePage {
	
	static Actions act;
	static JavascriptExecutor js;
	static WebDriverWait wait;
	public static int beforeFilterCount;
	public static int afterFilterCount;
	

	public bookshelvesPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[1]/h2/span")
	public WebElement bookshelvesTitle;
	
	@FindBy(tagName="h1")
	public WebElement mBookshelvesTitle;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[2]/div[2]/div/ul/li")
	public List<WebElement> appliedFilters;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]")
	WebElement priceButton;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]")
	WebElement categoryButton;
	
	@FindBy(id="filters_primary_category_Bookshelves")
	WebElement bshelves;

	@FindBy(xpath="//*[@id=\"authentication_popup\"]/div/div/div[2]/a[1]")
	WebElement closeButton;
	
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-upper']")
	WebElement sliderupperHandle;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]")
	WebElement storageTypeButton;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[3]")
	WebElement materialButton;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[4]")
	WebElement brandButton;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[4]/div[2]/div/div/div/ul/li/input")
	List<WebElement> brandNames;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[3]/div[2]/div/div/div/ul/li[1]/input")
	WebElement engineeredWood;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[3]/div[2]/div/div/div/ul/li[2]/input")
	WebElement solidWood; 
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[3]/div[2]/div/div/div/ul/li[3]/input")
	WebElement bamboo;
	
	@FindBy(id="filters_storage_type_Open")
	WebElement open;
	
	@FindBy(id="filters_availability_In_Stock_Only")
	WebElement outOfStock;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]")
	WebElement searchSort;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li")
	List<WebElement> sortMenu;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span")
	public WebElement selectedSort;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/div/ul/li/span[1]")
	public WebElement selectedType;
	
	String filePath = System.getProperty("user.dir")+"/src/test/resources/bookShelvesData.xlsx";
	
	
	public String getBookshelvesTitle() {			//Method to get the title of the bookshleves page
		
		String bsTitle = bookshelvesTitle.getText();
		return bsTitle;
		
	}
	
	public void clickCloseButton() {				//Method to click on the close button 
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOf(closeButton));
		
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", closeButton); //Clicks the closeButton using Javascript Executor
	}
	
	public void clickOnCategory() {								//Method to click on category
		
		categoryButton.click();
		
	}
	
	public void selectCategory() {								//Method to select a category

		bshelves.click();
		
	}
	
	public void clickOnPrice() {								//Method to click on price button
		
		
		priceButton.click();
		
		
	}
	
	public void setPrice() {									//Method to set the price
		act = new Actions(driver);
		act.dragAndDropBy(sliderupperHandle, -211, 0).build().perform();
	}
	
	public void clickOnMaterialButton() {
		
		materialButton.click();
	}
	
	public void selectMaterialType(String type) {				//Method to select the type of material
		
		if(driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[3]/div[2]/div/div/div/ul/li[1]/label")).getText().equalsIgnoreCase(type)) {
			
			engineeredWood.click();
		}
		else if(driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[3]/div[2]/div/div/div/ul/li[2]/label")).getText().equalsIgnoreCase(type)) {
			
			solidWood.click();
		}
		else {
			
			bamboo.click();
		}
	}
	

	public void clickOnBrand() {									//Method to click on brand button
		
		brandButton.click();
		
	}
	
	public void selectBrandName(String brand) {						//Method to select the brand name
		
		for(WebElement i : brandNames) {
			
			if(i.getAttribute("value").equalsIgnoreCase(brand)) {
				i.click();
				break;
			}
		}
	}
	
	public void clickExcludeOutOfStock() {									//Method to click on out of stock button
		
		js.executeScript("arguments[0].click();", outOfStock);
	}
	
	public void selectSortByType(String type) throws InterruptedException { //Method to select the type of sort
		
		Thread.sleep(5000);
		act = new Actions(driver);
		act.moveToElement(searchSort).perform();
		wait.until(ExpectedConditions.visibilityOfAllElements(sortMenu));
		for(WebElement i : sortMenu) {
			if(i.getText().equalsIgnoreCase(type)) {
				js.executeScript("arguments[0].click();", i);
				break;
			}
		}

		
	}
	
	public void displayBookshelves() throws IOException {			//Method to display the bookshelves and store them in excel
		
		List<String> models= new ArrayList<>();
		List<String> brands= new ArrayList<>();
		List<String> prices = new ArrayList<>();
		for(int i=1; i<=3; i++) {
			System.out.println("========================================================================");
			WebElement modelName = driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/ul/li[" +i+ "]/div/div[5]/a/div[1]/span"));
			models.add(modelName.getText());
			System.out.println(modelName.getText());
			
			excelUtils.setCellData(filePath,"BookShelves",i,0,modelName.getText());
			
			WebElement brandName = driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/ul/li[" +i+ "]/div/div[5]/a/div[1]/div[2]/div"));
			brands.add(brandName.getText());
			System.out.println(brandName.getText());
			
			excelUtils.setCellData(filePath,"BookShelves",i,1,brandName.getText());
			
			WebElement price = driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]/ul/li[" +i+ "]/div/div[5]/a/div[2]/span"));
			prices.add(price.getText());
			System.out.println(price.getText());
			
			excelUtils.setCellData(filePath,"BookShelves",i,2,price.getText());
			
			System.out.println("========================================================================");
			
		}
	}

}
