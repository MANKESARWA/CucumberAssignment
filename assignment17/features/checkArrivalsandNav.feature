@CheckArrivalsandFunctionality
Feature: page element working verification
@CheckArrival
Scenario: checking the number of arrivals
Given user is on the default page
When user click on shop 
And user click on home 
Then user check home page have three arrivals
@checkArrivalsFunctionality
Scenario Outline: check the functionality is working for arrival
Given user is on the default page
When user click on shop 
And user click on home 
And user click on the image of new arrival
Then user is on next page
And user is able to add book to the basket