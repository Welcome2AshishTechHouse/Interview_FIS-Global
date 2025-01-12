@AllTestCases
Feature: Verify eBay UI functionalities

  @ui_eBay_VerifyAddToCart
  Scenario: Verify add book to the cart on eBay
    Given Open browser navigate to "ebay.url"
    When Search for "book"
    And Click on the first book in results
    And Add the book to the cart from the item listing page
    Then Validate cart updated with the correct number of items
