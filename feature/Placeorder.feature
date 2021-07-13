Feature: Test Feature of pippintitle

Scenario Outline: The user be able to select product and place the Order and log out
 
Given user is on pippintitle login page and login with given <username> and <password>
When select the product and enter <Firstname> and <Address> and <clientrefernce> details
And then upload <docpath> pfd
And Delete pdf from list
And create the order
Then Read the order number and sent <message> and logout

Examples: 
|username|password|Firstname|Address|clientrefernce|docpath|message|
|pippintitle_demotest@mailinator.com|DemoTest#567#|Rakshitha|3485 Wineville |Rakshitha_03_09_1996|./PDF/p.pdf|got order|
