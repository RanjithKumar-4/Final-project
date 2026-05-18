Feature:giftcards
  Scenario: printing giftcards
    Given the user is on the giftcards  page
    When the user enters all the inputs
    And clicks on Paynow
    Then the user gets directed to payment page
    And cancels the payment
    Then validate the error message