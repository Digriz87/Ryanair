# qa-web-challenge
## Requirements
- Please automate a booking up to a declined payment on https://www.ryanair.com/ie/en/
- Use any card number and verify the error message.
- Use any one of the following languages:
  - JavaScript (Protractor)
  - Java
  - Python
- Use Page Object Pattern
- Give some documentation on why you chose what you did and documentation on how to run these tests
- Show reporting for your results
- We are fans of BDD and Cucumber in Ryanair, use these if you can
- Use all your skills to prove your knowledge & ability

## Example test input
```
Given I make a booking from "DUB" to "SXF" on 12/01/2022 for 2 adults and 1 child
When I pay for booking with card details "5555 5555 5555 5557", "10/25" and "265"
Then I should get payment declined message
```
