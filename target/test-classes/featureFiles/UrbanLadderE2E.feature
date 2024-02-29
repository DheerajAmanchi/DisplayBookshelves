Feature: End to End of UrbanLadder Automation

	Scenario Outline: User validate and retrieve the name and price of first three Bookshelves on the Booksheleves page
		Given user should naviagate to urbanladder website
		When user enters the search value as "<value>"
		And user click on the search icon
		And user selects the price range of the bookshelves
		And user selects the category type of the bookshelves
		And user click on exclude out of stock
		And user selects the sort type "<type>"
		Then user should able to view the top three items details
		
		Examples: 
		| value       | type               |
		| Bookshelves | Price: High to Low |
		
	Scenario: User validate and retrieve the name and price of first three StudyChairs on StudyChairs page
		Given user should naviagate to urbanladder website
		When user clicks on the Study menu item
    And user click on the Studychairs submenu item
    Then user should able to view the top three study chair details
	
	Scenario Outline: User validate and retrieve all items under any one of sub-menu items of Living menu item
		Given user should naviagate to urbanladder website
		When user clicks on menu item "<menuItemName>"
		Then user should able to view all items under "<subMenuItemName>"
		
		Examples:
		| menuItemName | subMenuItemName   |
		| Living       | Seating & Chairs  |
		| Living       | Living Storage    |
		
	Scenario Outline: User validates Gift Cards page in UrbanLadder web application
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
	  | 1000  | dheeraj | asdgmail.com          | 9878564534 | AR palli, Vskp  | 530003   | kumar  | kar@gmail.com.com    | 7609876456  |
		| 5000  | nani    | asd@gmail.com         | 6112334455 | RA palli, Vskp  | 530001   | raj    | raj098gmail.com     | 6363636436  |
  	| 10000 | raj     | 121910318034@gitam.in | 8688004639 | endada, Vskp    | 530006   | kumar  | kumar12333@gmail.com | 7337464639  |
