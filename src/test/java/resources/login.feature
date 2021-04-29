Feature: Login Feature

  Scenario Outline: Login Test Scenario

    Given user is already on Return Order Request Page
    When the user enters the <order Id> in the order Id field and then enters Find order
    Then the product purchased details are displayed and validated
    Then the user clicks on Return This Product button
    And then a token will be generated with a <message>
    Then the token is stored in text file
    Then Close the browser


    Examples:
      | order Id  | message |
      | 1257945872  |     Return Order Placed    |