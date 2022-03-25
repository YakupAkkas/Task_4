Feature: Summer Dresses

  @wip
  Scenario: verify that summer dresses can be added to the cart and it’s possible to to proceed to the Sign in section
    Given User is on the Summer Dresses page
    When User clicks on the product that wants to purchase and add it to the cart
    And User Proceed To Checkout
    Then verify that summer dresses can be added to the cart
    And verify that it’s possible to proceed to the Sign in section