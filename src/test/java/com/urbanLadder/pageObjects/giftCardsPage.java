package com.urbanLadder.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.urbanLadder.utils.excelUtils;

public class giftCardsPage extends basePage {

	static Actions act;
	
	public giftCardsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/h1")
	public WebElement giftCardsTitle;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]")
	WebElement BirthdayAnniversary;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]/div/div/button")
	WebElement chooseThisButton;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/h2")
	public WebElement customizeTitle;
	
	@FindBy(id="ip_2251506436")
	WebElement amount;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button")
	public WebElement next;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[4]/select[1]")
	WebElement month;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[4]/select[2]")
	WebElement day;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[3]/h2")
	public WebElement luckyPersonTitle;
	
	@FindBy(name="customer_name")
	WebElement cName;
	
	@FindBy(name="customer_email")
	WebElement cEmail;
	
	@FindBy(name="customer_mobile_number")
	WebElement cMobile;
	
	@FindBy(name="customer_address")
	WebElement cAddress;
	
	@FindBy(name="zip")
	WebElement cZip;
	
	@FindBy(name="recipient_name")
	WebElement rName;
	
	@FindBy(name="recipient_email")
	WebElement rEmail;
	
	@FindBy(name="recipient_mobile_number")
	WebElement rMobile;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[3]/form/button")
	WebElement confirm;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[4]/div[2]/h2")
	WebElement success;
	
	String filePath = System.getProperty("user.dir")+"/src/test/resources/bookShelvesData.xlsx";
	
	public String getGiftCardsTitle() {			//Method to get the title of gift cards page
		
		String gcTitle = giftCardsTitle.getText();
		return gcTitle;
	}
	
	public void chooseOccasion() {				//Method to choose the occasion	
		
		act = new Actions(driver);
		act.moveToElement(BirthdayAnniversary).perform();
		
		chooseThisButton.click();
	}
	
	public void enterMoney(String money) {		//Method to send the money amount
		
		amount.sendKeys(money);
		
	}
	
	public void setDate() {						//Method to set the date
		
		Select sMonth = new Select(month);
		sMonth.selectByValue("3/2024");
		
		Select sDay = new Select(day);
		sDay.selectByValue("10");
	}
	
	public void clickNextButton() {				//Method to click the next button
		
		next.click();
	}
	

	
	public void fromName(String fName) {		//Method to send the name into the form
		
		cName.sendKeys(fName);
	}
	
	public void fromEmail(String fEmail) {		//Method to send the email into the form
		
		cEmail.sendKeys(fEmail);
	}
	
	public void fromMobile(String fMobile) {	//Method to send the mobile number into the form
		
		cMobile.sendKeys(fMobile);
	}
	
	public void fromAddress(String fAddress) {	//Method to send the address into the form
		
		cAddress.sendKeys(fAddress);
	}
	
	public void fromPincode(String fPincode) {	//Method to send the pincode into the form
		
		cZip.sendKeys(fPincode);
	}
	
	public void toName(String reName) {			//Method to send the recipient's name into the form
		
		rName.sendKeys(reName);
	}
	
	public void toEmail(String reEmail) {		//Method to send the recipient's email into the form
		
		rEmail.sendKeys(reEmail);
	}
	
	public void toMobile(String reMobile) {		//Method to send the recipient's mobile number into the form
		
		rMobile.sendKeys(reMobile);
	}
	
	public void clickConfirm() {				//Method to click on confirm button
		
		confirm.click();
	}
	
	public void displayMsg(String reEmail, String fEmail) {		//Method to display the output message
		
		try {
			
			if(success.isDisplayed()) {
				System.out.println(success.getText());
				excelUtils.setCellData(filePath, "Form", 3, 0, success.getText());
			}
			
			else if(!(reEmail.matches("^(.+).@(.+)$"))){
				JavascriptExecutor js=(JavascriptExecutor)driver;
			
				String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", rEmail);
				System.out.println(validationMessage);
				excelUtils.setCellData(filePath, "Form", 2, 0, validationMessage);
			
			}
			
			else if(!(fEmail.matches("^(.+).@(.+)$"))) {
				
				JavascriptExecutor js=(JavascriptExecutor)driver;
				String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", cEmail);
				System.out.println(validationMessage);
				excelUtils.setCellData(filePath, "Form", 1, 0, validationMessage);
			}
			
		}
		catch(Exception e) {
			
		}
	}



}
