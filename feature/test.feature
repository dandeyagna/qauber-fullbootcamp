Feature: Login Action

Scenario Outline: Successful Login with Valid Credentials
Given User is on Home Page
When User enters Username as "<username>"
And User enters Password as "<password>"
And User clicks Login Button
Then Message displayed Login Successfully
Examples:
|username|password|
|reshmaaher@gmail.com|Iltarget3|


Scenario Outline: User should not login with invalid email ID
Given User is on Home Page
When User enters Username as "<username>"
Then Error message displayed  for Invalid email id
Examples:
|username|password|
|tdfghfh|Iltarget3|

Scenario Outline: User should not login with empty email ID
Given User is on Home Page
When User enters Username as "<username>"
And User clicks Login Button
Then Error message displayed for Empty email Id
Examples:
|username|password|
||Iltarget3|

Scenario Outline: User should not login with Invalid password
Given User is on Home Page
When User enters Username as "<username>"
And User enters Password as "<password>"
And User clicks Login Button
Then Error message displayed for Invalid password
Examples:
|username|password|
|reshmaaher@gmail.com|Iltarget|


