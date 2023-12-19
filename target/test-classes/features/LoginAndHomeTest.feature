Feature: User can login and see the product from the product list

  As a user
  I want to login into SwagLabs application
  So that I can verify product from the product list

  Scenario: Login to SwagLabs Application with Correct credentials
    Given User launched SwagLabs application
    When User verify the Page title
    When User logged in the app using username "standard_user" and password "secret_sauce"
    Then User verify the product name "Sauce Labs Backpack"
    And User logout from the application

  Scenario: User can add product into cart and checkout
    Given User launched SwagLabs application
    And User verify the Page title
    And User logged in the app using username "standard_user" and password "secret_sauce"
    And User verify the product name "Sauce Labs Backpack"
    When User can add the product into cart
    And user click on shopping cart
#    Then assert user can view the product name "Sauce Labs Backpack" in the cart list
#    And User can checkout product from the shopping cart
