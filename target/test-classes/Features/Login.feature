Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address as "<email>" into email field
And User enters valid password as "<password>" into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|email                     |password   |
|ssr8712@gmail.com         |123456     |
|amotooricap1@gmail.com    |12345      |
|amotooricap2@gmail.com    |12345      |

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password as "1234567890" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address as "ssr8712@gmail.com" into email field
And User enters invalid password as "1234567890" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address into email field
And User enters valid password as "123456" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch
