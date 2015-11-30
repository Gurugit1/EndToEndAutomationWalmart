##Problem:

 Automate an end-to-end user e-commerce transaction flow using any open source tool for www.walmart.com with an existing customer on Chrome or Safari browser.

###Scenario to automate:

1. Login using existing account

2. Perform a search on home page from a pool of key words given below

3. Identify an item from the result set that you can add to cart

4. Add the item to cart

5. Validate that item added is present in the cart and is the only item in the cart 

###Test Data:

• Account details: create your own account

• Search terms: tv, socks, dvd, toys, iPhone

##Solution:

•	Open FireFox

•	Open www.walmart.com

•	Login as authenticated user and verify it

•	Search item from given pool and verify it

•	Identify an item to be added to the cart

•	Clear cart before adding item as only one item is required to be in cart 

•	Add item to the cart and verify that item added

•	Verify item added is the identified one and check that only one item is added


##Instructions for running the Project:

###Installation Requirement:
•	Java

•	Eclipse

•	Selenium Jars(included in the project)

•	Junit

•	Firefox Browser



###Setting up and running the project:

•	Download project

•	Open Eclipse 

•	Import Project to workspace

•	Open WalmartTest.java

•	Run as Junit Test


##Technical choices:

•	Used Selenium WebDriver for driving through the website 

•	Used Junit as already familiar with it


##Trade offs:

•	Used only firefox WebDriver as already present in WebDriver Package

•	Items with no additional conditions at time adding to cart could be added


##Additional Test Scenarios to be added if time permits:

•	Test on other browsers too

•	Test if item to added is present in the stock 

•	Test if item to be added is available at desired location of user

•	Test for special characters in the search query

•	Test for specific price range of product to be added to cart

•	Identifying specific item to be added to cart in case of vague search. For an instance (Search term = “iPhone” , Item to be identified = “iPhone 6S 64 GB”


