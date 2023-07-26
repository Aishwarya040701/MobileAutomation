@Login
Feature: To check login page functionality

  Background: 
    Given User is on login page

  @ValidLogin
  Scenario: To verify login with valid username and password
    When user enter valid username as "bob@example.com" and password as "10203040"
    Then user should be able to login and navigate to home page

  @ValidLoginwithLink
  Scenario: To enter login details using link present in the page
    When user click on the link present in login page
    Then the login field get filled automatically and user is logged in

  @InvalidLogin
  Scenario: To verify login with invalid username and password
    When user enter invalid username as "Arya" and password as "Arya@12"
    Then user should not be able to login and error message "Provided credentials do not match any user in this service." to be displayed
