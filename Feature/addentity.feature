Feature: Add Entity Action

Scenario Outline: User should be able to add Entity
Given User is on Home Page
When User enters Username as "<username>"
And User enters Password as "<password>"
And User clicks Login Button
And User Clicks on Entity
And User Clicks on Add Entity
And User enters Entity name as "<entityname>"
And User enters phonenumber as "<phonenumber>"
And User enters email is as "<emailID>"
And User select country as "<country>"
And User enters address1 as "<address>"
And User enters city as "<city>"
And User select state as "<state>"
And User enters zipcode as "<zipcode>"
And User click on next step
And User enters regular user name as "<regUser>"
And User clicks on Next page
And User clicks on Done button 
And User enters admUser as "<admUser>"
And User click on Confirm button
And User select slider
And User clicks on Finish button
And User navigate to Paypalaccount
And User clicks on paypalID as "<paypalID>"
And User clicks on paypal password as "<paypalPassword>"
And User clicks on Submitlogin button
And User clicks on Agreepayment
Then Message dispayed Payment Successfull.
Examples:
|username|password|entityname|phonenumber|emailID|country|address|city|state|zipcode|regUser|admUser|paypalID|paypalPassword|
|reshmaaher@gmail.com|Iltarget3|abcdy|4089998777|dds@ff.com|United States|assfff|Santa Clara|California|9776|rere@d.com|dsdd@dff.com|reshmaaher@gmail.com|Ilviaan@3|


