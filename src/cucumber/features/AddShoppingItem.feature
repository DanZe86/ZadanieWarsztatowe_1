Feature: Buy item

  Scenario Outline: Buying item from mystore
    Given I log user from exercise one
    When I go to myStore page
    Then I check if page is correct
    When I choose product Hummingbird Printed Sweater
    Then I check if product was chosen with discount
    When I pick "<size>" and "<quantity>" of the product
    And I add item to a shopping cart
    Then I check if item was add it correctly
    When I go to tile checkout
    And confirm user address
    And I choose shipping method with PrestaShop
    And I pay by check and click on terms of service
    And I click on Order with an obligation to pay
    Then I make printscreen
    Examples:
      | size | quantity |
      | M    | 5        |