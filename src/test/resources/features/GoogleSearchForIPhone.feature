Feature: Search for Iphone and assert results
As an end user I need to be able to search for a keyword in google
So that I can see the desired results and act accordingly




Scenario Outline: Search for Iphone
Given I have launched google homepage
When I search based on a "<keyword>" and navigate to search results page
Then in the search results I look for a specific "<link>" and click on it
And I verify the link details




Examples:
|keyword          |link             |
|Iphone           |Amazon           |



