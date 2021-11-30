@SignIn
Feature: Successfull registration
@PositiveSignInWithTable
Scenario: Positive registration with Datatable
Given user is at default page
When user navigate to sign up page 
And user clicks on sign up
And user enter the required details
|name|Mayank kesarwani|
|email|mayankkesarwani@gmail.com|
|mobile|7388920978|
|password|M@yank123|
|gender|male|
And user wait to enter OTP
Then user is on home page as logged in.