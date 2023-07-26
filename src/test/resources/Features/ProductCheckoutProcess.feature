@ProductCheckout
Feature: To verify complete product checkout process with assertions

  Scenario: To verify product checkout functionality
    Given user is on Homepage of MyDemoApp
    When user select product Sauce Labs Backpack
    And user navigate back to home page
    And user will scroll down
    And select another product Sauce Labs Onesie
    And will click on cartIcon
    And remove Sauce Labs Onesie product from cart
    And check the total price
    And click on Proceed To Checkout
    And login with valid details
    And will compelete the registration with valid details
    And will click on payment button
    And add payment details
    And click on Review order button
    And click on Place order button
    Then order should be placed
    And logout from the website
