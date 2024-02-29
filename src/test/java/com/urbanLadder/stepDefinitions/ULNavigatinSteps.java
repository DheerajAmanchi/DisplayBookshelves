package com.urbanLadder.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.urbanLadder.pageObjects.*;
import com.urbanLadder.utils.baseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ULNavigatinSteps {

	static urbanLadderHomePage hp;
	static bookshelvesPage bp;
	static giftCardsPage gp;
	static searchResultsPage sp;
	static studyChairsPage scp;
	static studyRoomFurniturePage srp;
	static storageStudyRoomPage ssp;
	static clickCheckPage cp;
	@Given("user should naviagate to urbanladder website")
	public void user_should_naviagate_to_urbanladder_website() {
	    
		hp = new urbanLadderHomePage(baseClass.getDriver());
		bp = new bookshelvesPage(baseClass.getDriver());
	    
	}

	@When("user enters the search value as {string}")
	public void user_enters_the_search_value_as(String value) {
		
		hp.searchBookshelves(value);
	    
	}

	@When("user click on the search icon")
	public void user_click_on_the_search_icon() {
	    
	    hp.clickSearchButton();
	}
	
	@Then("user should navigate to search results page")
	public void user_should_navigate_to_search_results_page() {
		
		sp = new searchResultsPage(baseClass.getDriver());
		Assert.assertEquals(sp.searchResultsTitle.isDisplayed(), true);
	}
	
	@When("user clicks bookshelves menu item")
	public void user_clicks_bookshelves_menu_item(){
		
		hp.scrollForFurnitureMenu();
		
		hp.clickfBookshelves();
	}
	
	@Then("user should navigate to bookshelves page")
	public void user_should_navigate_to_bookshelves_page() {
		
		bp = new bookshelvesPage(baseClass.getDriver());
		
		try{
			bp.clickCloseButton();
		}
		catch(Exception e) {
			
		}
		
		Assert.assertEquals(bp.mBookshelvesTitle.isDisplayed(), true);
	}
	
	@When("user clicks on study")
	public void user_clicks_on_study() {
		
		hp.scrollForFurnitureMenu();
		
		hp.clickfStudy();
	}
	
	@Then("user should navigate to Study room furniture page")
	public void user_should_navigate_to_Study_room_furniture_page() {
		
		srp = new studyRoomFurniturePage(baseClass.getDriver());
		
		Assert.assertEquals(srp.studyRoomFurnitureTitle.isDisplayed(), true);
	}
	
	@When("user clicks on storage")
	public void user_clicks_on_storage() {
		
		srp.clickOnStorage();
	}
	
	@Then("user should navigate to storage page")
	public void user_should_navigate_to_storage_page() {
		
		ssp = new storageStudyRoomPage(baseClass.getDriver());
		
		Assert.assertEquals(ssp.storageTitle.isDisplayed(), true);
		
		
	}
	
	
	@When("user clicks on bookshelves")
	public void user_clicks_on_bookshelves() {
		
		ssp.clickOnBookshelf();
	}
	
	@When("user clicks on study chairs")
	public void user_clicks_on_study_chairs() {
		
		srp.clickOnStudyChairs();
		
		srp.clickOnStudyChair();
	}
	
	
	
	@Then("user should be navigated to bookshelves result page")
	public void user_should_be_navigated_to_bookshelves_result_page() {
		
		bp = new bookshelvesPage(baseClass.getDriver());
		try {
			bp.clickCloseButton();
		}
		catch(Exception e) {
			
		}
		
		String title = bp.getBookshelvesTitle();
		System.out.println(title);
		
		Assert.assertEquals(bp.bookshelvesTitle.isDisplayed(), true );
	}
	
	@When("user selects the price range of the bookshelves")
	public void user_selects_the_price_range_of_the_bookshelves() {
	    
		bp = new bookshelvesPage(baseClass.getDriver());
		bp.clickCloseButton();
		
	    bp.clickOnPrice();
	    bp.setPrice();
	}
	
	@When("user selects the category type of the bookshelves")
	public void user_selects_the_category_type_of_the_bookshelves() {
		
		bp.clickOnCategory();
		bp.selectCategory();
	}
	
	@When("user click on exclude out of stock")
	public void user_click_on_exclude_out_of_stock() {
	    
	    bp.clickExcludeOutOfStock();
	}
	@When("user selects the sort type {string}")
	public void user_selects_the_sort_type(String type) throws InterruptedException {
	    
		
		try{
			bp.clickCloseButton();
		}
		catch(Exception e) {
			
		}
	    bp.selectSortByType(type);
	}
	
	@Then("user should be able to view filterd bookshelves")
	public void user_should_be_able_to_view_filtered_bookshelves() {
		System.out.println(bp.appliedFilters.size());
		Assert.assertEquals(bp.appliedFilters.size(), 3);
	}
	
	@Then("user should able to view the top three items details")
	public void user_should_able_to_view_the_top_three_items_details() throws IOException {
	    
	    bp.displayBookshelves();
	}
	

	@When("user clicks on the Study menu item")
	public void user_clicks_on_the_Study_menu_item() {
		
		hp.clickOnStudy();
	}
	
	@When("user click on the Studychairs submenu item")
	public void user_click_on_the_Studychairs_submenu_item() {
		
		hp.clickOnStudyChairs();
	}
	
	@Then("user should be navigated to the Studychairs page")
	public void user_should_be_navigated_to_the_Studychairs_page() {
		
		scp = new studyChairsPage(baseClass.getDriver());
		
		String title = scp.getStudyChairsTitle();
		System.out.println(title);
		
		Assert.assertEquals(scp.studyChairsTitle.isDisplayed(), true);
	}
	
	@Then("user should able to view the top three study chair details")
	public void user_should_able_to_view_the_top_three_study_chair_details() throws IOException {
		
		scp = new studyChairsPage(baseClass.getDriver());
		
		scp.displayStudyChairs();
	}
	
	@When("user clicks on menu item {string}")
	public void user_clicks_on_menu_item(String menuItemName) {
		
		hp.clickMenuItem(menuItemName);
	}
	
	@Then("user should able to view all items under {string}")
	public void user_should_able_to_view_all_items_under(String subMenuItemName) throws IOException {
		hp.displayAllItems(subMenuItemName);
		System.out.println("==========================================");
	}
	
	@When("user clicks on Gift Cards")
	public void user_clicks_on_Gift_Cards() {
		
		hp.clickGiftCards();
	}
	
	@Then("user should be navigated to the Gift Cards page")
	public void user_should_be_navigated_to_the_Gift_Cards_page() {
		
		gp = new giftCardsPage(baseClass.getDriver());
		
		String gcTitle = gp.getGiftCardsTitle();
		System.out.println(gcTitle);
		
		Assert.assertEquals(gp.giftCardsTitle.isDisplayed(), true);
	}
	
	
	@When("user selects an occasion")
	public void user_selects_an_occasion() {
		
		gp = new giftCardsPage(baseClass.getDriver());
		gp.chooseOccasion();
	}
	
	@Then("verify the occasion is chosen or not")
	public void verify_the_occasion_is_chosen_or_not() {
		
		Assert.assertEquals(gp.customizeTitle.isDisplayed(), true);
	}
	
	@When("user enter the valid amount {string}")
	public void user_enter_the_valid_amount(String money) {
		
		gp.enterMoney(money);
	}
	
	@When("user selects the date")
	public void user_selects_the_date() {
		
		gp.setDate();
	}
	
	@When("user clicks on next button")
	public void user_clicks_on_next_button() {
		
		if(gp.next.isEnabled()) {
			
			gp.clickNextButton();
		}
		else {
			System.out.println("Enter amount in range of 1000 to 500000");
		}
	}
	
	@Then("user should be able to view Nice So who is this lucky person")
	public void user_should_be_able_to_view_Nice_So_who_is_this_lucky_person() {
		
		if(gp.next.isEnabled()) {
			
			Assert.assertEquals(gp.luckyPersonTitle.isDisplayed(), true);
		}
		
		else {
			
			Assert.assertEquals(gp.luckyPersonTitle.isDisplayed(), false);
		}
	}
	
	@When("user customizes the gift card with amount {string}")
	public void user_customizes_the_gift_card_with_amount(String money) {
		
		gp.enterMoney(money);
		gp.setDate();
		gp.clickNextButton();
	}

	
	@When("user enters name {string}")
	public void user_enters_name(String fName) {
		
		gp.fromName(fName);
	}
	
	@When("user enters email {string}")
	public void user_enters_email(String fEmail) {
		
		gp.fromEmail(fEmail);
	}
	
	@When("user enters mobile {string}")
	public void user_enters_mobile(String fMobile) {
		gp.fromMobile(fMobile);
		
	}
	
	@When("user enters address {string}")
	public void user_enters_address(String fAddress) {
		
		gp.fromAddress(fAddress);
	}
	
	@When("user enters pincode {string}")
	public void user_enters_pincode(String fPincode) {
		
		gp.fromPincode(fPincode);
	}
	
	@When("user enters recipient name {string}")
	public void user_enters_recipient_name(String reName) {
		
		gp.toName(reName);
	}
	
	@When("user enters recipient email {string}")
	public void user_enters_recipient_email(String reEmail) {
		
		gp.toEmail(reEmail);
	}
	
	@When("user enters recipient mobile {string}")
	public void user_enters_recipient_mobile(String reMobile) {
		
		gp.toMobile(reMobile);
	}
	
	@When("user clicks on confirm button")
	public void user_clicks_on_confirm_button() {
		
		gp.clickConfirm();
	}
	@Then("check the entered details are valid or not {string} {string}")
	public void check_the_entered_details_are_valid_or_not(String reEmail, String fEmail) {
		
		
		
		gp.displayMsg(reEmail, fEmail);
		
	}
	
	@When("user clicks on track order button")
	public void user_clicks_on_track_order_button() {
		
		hp.clickOnTrackOrder();
	}
	
	@Then("user should navigate to orders tracking page")
	public void user_should_navigate_to_orders_tracking_page() {
		
		cp = new clickCheckPage(baseClass.getDriver());
		Assert.assertEquals(cp.trackOrderTitle.isDisplayed(), true);
	}
	
	@When("user clicks on Wishlist button")
	public void user_clicks_on_Wishlist_button() {
		
		hp.clickOnWishlist();
	}
	
	@Then("user should navigate to create an account page")
	public void user_should_navigate_to_create_an_account_page() {
		
		cp = new clickCheckPage(baseClass.getDriver());
		Assert.assertEquals(cp.wishlistTitle.isDisplayed(), true);
	}
	
	@When("user clicks on cart button")
	public void user_clicks_on_cart_button() {
		
		hp.clickOnCart();
	}
	
	@Then("user should navigate to cart page")
	public void user_should_navigate_to_cart_page() {
		
		cp = new clickCheckPage(baseClass.getDriver());
		Assert.assertEquals(cp.cartMsg.isDisplayed(), true);
	}
	
	@When("user clicks on bookshelves submenu item")
	public void user_clicks_on_bookshelves_submenu_item() {
		
		hp.clickOnBookshelvesSMItem();
	}
	
	@When("user selects material type {string}")
	public void user_slects_material_type(String type) {
		
		bp = new bookshelvesPage(baseClass.getDriver());
		try {
			
			bp.clickCloseButton();
		}
		catch(Exception e) {
			
		}
		
		bp.clickOnMaterialButton();
		
		bp.selectMaterialType(type);
	}
	
	@Then("bookshelves made out of selected material should be displayed {string}")
	public void bookshelves_made_out_of_selected_material_should_be_displayed(String type) {
		
		Assert.assertEquals(bp.selectedType.getText(), type);
	}
	
	@When("user selects the brand {string}")
	public void user_selects_the_brand(String brand) {
		
		bp = new bookshelvesPage(baseClass.getDriver());
		try {
			
			bp.clickCloseButton();
		}
		catch(Exception e) {
			
		}
		
		bp.clickOnBrand();
		bp.selectBrandName(brand);
		
	}
	
	@Then("selected brand bookshelves should be displayed {string}")
	public void selected_brand_bookshelves_should_be_displayed(String brand) {
		
		Assert.assertEquals(bp.selectedType.getText(), brand);
	}
	
	@Then("verify if the sort is applied or not {string}")
	public void verify_if_the_sort_is_applied_or_not(String type) {
		
		Assert.assertEquals(type, bp.selectedSort.getText());
	}
	
}
