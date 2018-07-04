@DetailsJson
Feature: Verify Details.json service
  Verification points for the service are
  - Name = Carbon credits
  - CanRelist = true
  - The Promotions element with Name = "Gallery" has Description that contains the text "2X larger image"

  Background:
    Given I set the base URI to Categories
    And I call the Get service for details json
    And I verify the service response is 200

  @Name @StringEquals
  Scenario Outline: Verify Name to be equal to Carbon credits in Details Service
    And I verify <Element> should be equal to <Expected result>
    Examples:
      | Element | Expected result |
      | Name    | Carbon credits  |

  @CanRelist @Boolean
  Scenario Outline: Verify CanRelist to be equal to true in Details Service
    And Verify <Element> should be <Expected result>
    Examples:
      | Element   | Expected result |
      | CanRelist | true            |

  @Description @StringContains
  Scenario Outline: Verify Promotions element with Name = "Gallery" has Description that contains the text "2X larger image"
    And I verify <Element> should contain <Expected result>
  Examples:
  | Element   | Expected result |
  | Promotions.find {it.Name=='Gallery'}.Description | 2x larger image            |