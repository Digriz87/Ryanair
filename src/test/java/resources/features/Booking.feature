Feature: Booking on Ryanair website
  Scenario: Checkout using an invalid credit card
    Given I make a booking
    When I pay for booking with card details
    Then I should get payment message