Feature: living room products from Collections
  Scenario: printing the bestseller and new arrivals
    Given the user is on the bookshelves page
    When clicks on living room
    Then the user should print all the bestseller and new arrivals products with their name and price