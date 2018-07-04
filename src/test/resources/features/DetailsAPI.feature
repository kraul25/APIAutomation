@DetailsJson
Feature: Verify Details.json service
  Verification points for the service are
  - Name = Carbon credits
  - CanRelist = true
  - The Promotions element with Name = "Gallery" has Description that contains the text "2X larger image"

  @Name @String
  Scenario: Verify Name to be equal to Carbon credits in Details Service
    Given I set the base URI to Categories
    And I call the Get service for details json
    And I verify the service response is 200
    And I verify Name should be equal to Carbon credits