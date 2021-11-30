@Login
Feature: Login features
@positiveLogin
Scenario: Positive Login
Given user is on default page
When user is navigate to sign in with email
And user enter the "neelamkesarwanink@gmail.com" and "Neel@m123"
And user click on the signinbtn
Then user check for profile details
@negativeLogin
Scenario Outline: negative Login
Given user is on default page
When user is navigate to sign in with email
And user enter the "<email>" and "<password>"
And user click on the signinbtn
Then locate the invalid id on same page.
 Examples:
|email|password|
|admin|adin12312|
|admin||