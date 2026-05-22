Feature: Gift Cards Purchase Flow

  Background:
    Given the user is on the home page
    And the user is on the giftcards page

  @regression
  Scenario Outline: Validate gift card purchase flow with different inputs
    When the user enters gift card details "<amount>" "<quantity>" "<firstname>" "<lastname>" "<email>" "<phone>"
    And clicks on Paynow
    Then the user gets directed to payment page
    And cancels the payment
    And validate the error message

    Examples:
      | amount | quantity | firstname | lastname | email              | phone      |
      | 1000   | 3        | Rahul     | Reddy    | abc@gmail.com      | 9087865478 |