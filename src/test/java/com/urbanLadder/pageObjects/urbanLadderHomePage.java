package com.urbanLadder.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.urbanLadder.utils.excelUtils;

public class urbanLadderHomePage extends basePage {
	static JavascriptExecutor js;
	
	public urbanLadderHomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//div[@id=\"credential_picker_container\"]/iframe")
	WebElement iframe;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div")
	WebElement furnitureMenu;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div[3]/a[5]")
	WebElement bookshelvesIcon;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div[3]/a[4]")
	WebElement studyIcon;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li/span")
	List<WebElement> menuItems;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]/div/div/ul/li/div/a")
	List<WebElement> subMenuItems;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]/div/div/ul/li[1]/ul/li/a/span")
	List<WebElement> SC;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]/div/div/ul/li[3]/ul/li/a/span")
	List<WebElement> LS;
	
	@FindBy(id="close")
	WebElement googleClose;
	
	@FindBy(id="search")
	WebElement search;
	
	@FindBy(id="search_button")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[7]/span")
	WebElement study;

	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[7]/div/div/ul/li[3]/ul/li[1]/a")
	WebElement bookshelveslink;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[7]/div/div/ul/li[2]/ul/li[1]/a")
	WebElement studyChairslink;
	
	@FindBy(id="header-icon-track-order")
	WebElement trackOrder;
	
	@FindBy(id="header-icon-wishlist")
	WebElement wishlist;
	
	@FindBy(id="header-icon-cart")
	WebElement cart;
	
	@FindBy(xpath="//header[@id=\"header\"]/section/div/ul[2]/li[3]/a")
	WebElement giftCardsButton;
	
	String filePath = System.getProperty("user.dir")+"/src/test/resources/bookShelvesData.xlsx";
	
	public void clickGoogleClose() {		//Method to click on close 
		js = (JavascriptExecutor) driver;
		try {
			driver.switchTo().frame(iframe);
			js.executeScript("arguments[0].click();", googleClose);
			driver.switchTo().defaultContent();
		}
		catch(Exception e) {
			
		}
	}
	
	public void scrollForFurnitureMenu() {			//Method to scroll for the visibility of furniture menu
		
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", furnitureMenu);
		
	}
	
	public void clickfBookshelves() {			//Method to click on Bookshelves
		
		bookshelvesIcon.click();
	}
	
	public void clickfStudy() {					//Method to click on study
		
		studyIcon.click();
	}
	
	public void searchBookshelves(String value) {	//Method to search for bookshelves
		
		search.sendKeys(value);
		
	}
	
	public void clickSearchButton() {				//Method to click on search
		
		searchButton.click();
	}
	
	public void clickOnStudy() {					//Method to click on Study

		study.click();
	}
	
	public void clickOnStudyChairs() {				//Method to click on study chairs
		
		studyChairslink.click();
	}
	
	public void clickMenuItem(String menuItemName) {	//Method to click on the menu item
		
		for(WebElement i : menuItems) {
			if(i.getText().equalsIgnoreCase(menuItemName)) {
				i.click();
				break;
			}
		}
	}
	
	public void clickSubMenuItem(String subMenuItemName) {			//Method to click on submenu item
		
		for(WebElement i : subMenuItems) {
			if(i.getText().equalsIgnoreCase(subMenuItemName)) {
				i.click();
			}
		}
	}
	
	public void displayAllItems(String subMenuItemName) throws IOException {		//Method to display all the items under the submenu item and store in the excel
		
		if(subMenuItemName.equalsIgnoreCase("Seating & Chairs")) {
			int r=1;
			for(WebElement i : SC) {
				System.out.println(i.getText());
				excelUtils.setCellData(filePath, "submenuItems",r, 0, i.getText());
				r++;
				
			}
		}
		
		else if(subMenuItemName.equalsIgnoreCase("Living Storage")) {
			int r=1;
			for(WebElement i : LS) {
				System.out.println(i.getText());
				excelUtils.setCellData(filePath, "submenuItems",r, 1, i.getText());
				r++;
			}
		}
	}
	
	public void clickGiftCards() {				//Method to click on gift cards 
		
		giftCardsButton.click();
	}
	
	public void clickOnTrackOrder() {			//Method to click on track order
		
		trackOrder.click();
	}
	
	public void clickOnWishlist() {				//Method to click on wishlist
		
		wishlist.click();
	}
	
	public void clickOnCart() {					//Method to click on cart
		
		cart.click();
	}
	
	public void clickOnBookshelvesSMItem() {	//Method to click on bookshelves submenu item
		
		bookshelveslink.click();
	}
	
}
