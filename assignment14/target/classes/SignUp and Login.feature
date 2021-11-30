Feature: Register and Login 
Scenario: Registration 
Given User is at the default page
When User navigate to Sign Up page
And user clicks on sign up
And user enter the required input
And user wait to enter otp
Then user is on Home page an logged in
And user is Signing out

Scenario Outline: Positive login with new user
Given User is at the default page
When User navigate to Sign Up page
And user clicks on sign in with Email
And user enter Email and password
And user clicks on SignIn
Then user is on Home page an logged in
