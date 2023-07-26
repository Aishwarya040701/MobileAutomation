@Cart
Feature: To verify cart page functionality

  Background: 
    Given user is on Homepage of DemoApp
    And add products to cart and move to cart page

  @VerifyCartValue
  Scenario Outline: To verify cart value
    Given user is on cart page
    When check cart value with actual and expected cart value as three products must be equal
    And remove Onesie product from cart
    When check cart value with actual and expected cart value as two products must be equal

  @VerifyProducts
  Scenario Outline: To verify products in cart
    Given user is on cart page
    When check products added are displayed in cart
    And check product added and product in cart are same
    Then product are verifed

  @VerifyTotalPrice
  Scenario: To verify Total price
    Given user is on cart page
    When check total price value
    And actual and expected total price of three must be equal
    And scroll up to remove button
    And remove Onesie product from cart
    And check total price value
    Then actual and expected total price of two must be equal
