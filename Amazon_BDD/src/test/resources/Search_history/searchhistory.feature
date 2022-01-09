
Feature: Search history feature

Background:
 Given i should open the browser 
 And navigate to home page of amazon.com and signup
 @searchhistory_1
 Scenario: Verify that does the search history page keeps a history of your previously searched products on Amazon
 	When click on Accounts&lists and then on Account
 	And click Browsing history
 @searchhistory_2
 Scenario: Verify that the search history page offer you the option to hide the history of previously searched products
 	When Go to user Account
 	And click Browsing history
 	And Click on Turn recently viewed items(Browsing History)to OFF
