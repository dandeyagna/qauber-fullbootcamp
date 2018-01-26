Feature: User Action

Scenario Outline: Successful Invite user with valid email id
Given User is on Home Page
When User enters Username as "<username>"
And User enters Password as "<password>"
And User clicks Login Button
And User clicks user list
And User click Send Invite button
And User enters email id as "<emailID>"
And User click on InviteButton
Then Username "<emailID>" displayed in User list
Examples:
|username|password|emailID|
|reshmaaher@gmail.com|Iltarget3|ahhh9@mailinator.com|


Scenario Outline: Invite user with Invalid email id
Given User is on Home Page
When User enters Username as "<username>"
And User enters Password as "<password>"
And User clicks Login Button
And User clicks user list
And User click Send Invite button
And User enters email id as "<emailID>"
Then Error message displayed for Invalid email "<emailID>"
Examples:
|username|password|emailID|
|reshmaaher@gmail.com|Iltarget3|dasdsd_sss|
								

Scenario Outline: Invite user with empty email id
Given User is on Home Page
When User enters Username as "<username>"
And User enters Password as "<password>"
And User clicks Login Button
And User clicks user list
And User click Send Invite button
And User enters email id as "<emailID>"
And User click on InviteButton
Then Error message displayed for empty email "<emailID>"
Examples:
|username|password|emailID|
|reshmaaher@gmail.com|Iltarget3||