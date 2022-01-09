
Feature: Search sidebar feature
 
Background:
 Given i should open the browser 
 And navigate to home page of amazon.com and signup

@Searchsidebar_1
  Scenario: Verify that does the search page categorize more options to filter product search
    When I Enter search text in search field
    And click on search icon
    Then Click on All Categories
@Searchsidebar_2
Scenario: Verify that does the search page offer price sort from low to high
    When I Enter search text in search field and click on search icon
    Then click on Sort by and select low to high

