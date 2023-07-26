@Home
Feature: To check Home page Functionality

  Background: 
    Given user is on home page

  @VerifyFilter
  Scenario Outline: To verify filter functionality
    When user select filter options "<options>"
    Then products on home page should be sorted "<product>"

    Examples: 
      | options            | product                     |
      | Name - Ascending   | Sauce Labs Backpack         |
      | Name - Descending  | Test.allTheThings() T-Shirt |
      | Price - Ascending  | Sauce Labs Onesie           |
      | Price - Descending | Sauce Labs Fleece Jacket    |

  @AddProducts
  Scenario Outline: Adding products to cart
    When user select products "<productName>"
    And click on add to cart
    Then product should be added to cart

    Examples: 
      | productName              |
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Fleece Jacket |
