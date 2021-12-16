Feature: Buy item

  Scenario: Buying item from mystore
    Given I log user from exercise one
    When I go to myStore page
    Then I check if page is correct
    When I choose product Hummingbird Printed Sweater
    Then I check if product was choosen with discount
    When "I pick <size> and <quantity> of the product"
    And I add item to a shopping cart
    Then I check if item was add it correctly
    When I go to tile checkout
    And confirme user address
    And I choose shipping method with PrestaShop
    And I pay by check
    And I click on Order with an obligation to pay with terms of service
    Then I check the order with price
    And I make printscreen