Feature: Display Bookshelves
  Scenario: printing first three bookshelves
    Given the user is on the home page
    And clicks on Bookshelves
    And the user sorts by price from low to high
    And puts the storage type as open storage
    Then the user should print the first three bookshelves names and prices