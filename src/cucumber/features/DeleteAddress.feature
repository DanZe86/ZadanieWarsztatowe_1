Feature: Delete Address

  Scenario: delete created address
    Given I have log an user
    When I enter site to user page with Address
    Then I check page url
    When I delete created address
    Then I check if address was deleted