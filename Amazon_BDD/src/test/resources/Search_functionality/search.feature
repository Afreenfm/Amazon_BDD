
Feature: Test search functionalities
 1)enter alphanumeric value
 2)check search icon 

Background:
 Given i should open the browser 
 And navigate to home page of amazon.com and signup

@search_1
Scenario Outline: enter alphanumeric value
When enter searchtext as "<searchtext>"
Then i should c searchedtext as "<searchtext>" 

Examples:
|searchtext|
|a|

 @search_2   
 Scenario: enter product and click on search icon
 	When enter product in search text
 	And click on search icon
 	

   


