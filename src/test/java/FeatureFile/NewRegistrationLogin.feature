
Feature: Feature to test new student login
@smoke
Scenario: Student Successfully login with new user 

Given  Student enter "1234567890" mobile number
When  Student enter OTP
Then Student Click on Signin button
Then Student filled their details
Then Student clicks on Register button

#@smoke2
#Scenario: Student Successfully login with new user and delete the account using api
#Given Admin trying to get all student ids
#When Delete Student using by id
