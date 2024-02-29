Feature: Smoke suite of UrbanLadder Automation
	
	@smoke
	Scenario Outline: navigate to Bookshelves page from the UrbanLadder homepage
		Given user should naviagate to urbanladder website
		When user enters the search value as "<value>"
		And user click on the search icon
		Then user should be navigated to bookshelves result page
		
		Examples: 
		| value       |
		| Bookshelves |
	
	@smoke	
	Scenario Outline: Apply the filters on bookshelves in the bookshelves page
    Given user should naviagate to urbanladder website
		When user enters the search value as "<value>"
		And user click on the search icon
		And user selects the price range of the bookshelves
		And user selects the category type of the bookshelves
		And user click on exclude out of stock
		And user selects the sort type "<type>"
		Then user should be able to view filterd bookshelves
		
		Examples: 
		| value       | type               |
		| Bookshelves | Price: High to Low |
		
 @smoke   
 Scenario: Navigate to Studychairs Page from UrbanLadder homepage
    Given user should naviagate to urbanladder website
    When user clicks on the Study menu item
    And user click on the Studychairs submenu item
    Then user should be navigated to the Studychairs page
    
  @smoke  
	Scenario Outline: validate and retrieve all items under any one of sub-menu items of Living menu item in the UrbanLadder homepage
		Given user should naviagate to urbanladder website
		When user clicks on menu item "<menuItemName>"
		Then user should able to view all items under "<subMenuItemName>"
		
		Examples:
		| menuItemName | subMenuItemName   |
		| Living       | Seating & Chairs  |
		| Living       | Living Storage    |
	
	@smoke			
	Scenario: Navigate to Giftcards page from urbanLadder homepage
		Given user should naviagate to urbanladder website
		When user clicks on Gift Cards
		Then user should be navigated to the Gift Cards page
	
	@smoke	
	Scenario: Choose an occasion on the GiftCards page
		Given user should naviagate to urbanladder website
		When user clicks on Gift Cards
		When user selects an occasion
		Then verify the occasion is chosen or not
	
	@smoke	
	Scenario Outline: Customize the gift card with valid amount
		Given user should naviagate to urbanladder website
		When user clicks on Gift Cards
		When user selects an occasion
		When user enter the valid amount "<money>"
		And user selects the date
		And user clicks on next button
		Then user should be able to view Nice So who is this lucky person
		
		Examples:
		| money |
		| 999   |
		| 5000  |
		| 10001 |
	
	@smoke	
	Scenario Outline: Filling the form with from and to details in the GiftCards page
		Given user should naviagate to urbanladder website
		When user clicks on Gift Cards
		And user selects an occasion
		And user customizes the gift card with amount "<money>"
		And user enters name "<fName>"
		And user enters email "<fEmail>"
		And user enters mobile "<fMobile>"
		And user enters address "<fAddress>"
		And user enters pincode "<fPincode>"
		And user enters recipient name "<reName>"
		And user enters recipient email "<reEmail>"
		And user enters recipient mobile "<reMobile>"
		And user clicks on confirm button
		Then check the entered details are valid or not "<reEmail>" "<fEmail>"
		
		Examples:
		| money | fName   | fEmail                | fMobile    | fAddress        | fPincode | reName | reEmail              | reMobile    |
	  | 1000  | dheeraj | asd@gmail.com         | 9878564534 | AR palli, Vskp  | 530003   | kumar  | kar.com              | 7609876456  |
		| 5000  | nani    | asdgmail.com          | 6112334455 | RA palli, Vskp  | 530001   | raj    | raj098@gmail.com     | 6363636436  |
		| 10000 | raj     | 121910318034@gitam.in | 8688004639 | endada, Vskp    | 530006   | kumar  | kumar12333@gmail.com | 7337464639  |