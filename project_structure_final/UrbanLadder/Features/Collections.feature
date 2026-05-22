Feature: Living Room Products from Collections

  @regression
  Scenario: Printing bestseller and new arrivals products
    Given the user is on the bookshelves page
    When clicks on living room
    Then the user should print all the bestseller and new arrivals products with their name and price