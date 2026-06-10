Feature: SauceDemo Checkout Functionality

  Background:
    Given User launches SauceDemo website

  @smoke
  Scenario Outline: Successful checkout with multiple products
    When User logs in with username "<username>" and password "<password>"
    And User adds "<product1>" to the cart
    And User adds "<product2>" to the cart
    And User adds "<product3>" to the cart
    And User proceeds to the cart
    Then The cart should contain "<cartCount>" products
    When User proceeds to checkout
    And User enters checkout information with first name "<firstName>" and last name "<lastName>" and postal code "<postalCode>"
    And User completes the purchase
    Then Order confirmation message should be "<confirmationMessage>"

    Examples:
      | username      | password     | product1            | product2                 | product3                | cartCount | firstName | lastName | postalCode | confirmationMessage       |
      | standard_user | secret_sauce | Sauce Labs Backpack | Sauce Labs Bike Light    | Sauce Labs Bolt T-Shirt | 3         | John      | Doe      | 12345      | Thank you for your order! |
      | standard_user | secret_sauce | Sauce Labs Onesie   | Sauce Labs Fleece Jacket | Sauce Labs Backpack     | 3         | Jane      | Smith    | SW1A1AA    | Thank you for your order! |

  @regression
  Scenario Outline: Login validation for all user types
    When User logs in with username "<username>" and password "<password>"
    Then Login outcome should be "<outcome>"
    And Expected message should be "<message>"

    Examples:
      | username                | password      | outcome | message                                                                	  |
      | standard_user           | secret_sauce  | SUCCESS | inventory                                                              	  |
      | problem_user            | secret_sauce  | SUCCESS | inventory                                                              	  |
      | performance_glitch_user | secret_sauce  | SUCCESS | inventory                                                              	  |
      | error_user              | secret_sauce  | SUCCESS | inventory                                                              	  |
      | visual_user             | secret_sauce  | SUCCESS | inventory                                                              	  |
      | locked_out_user         | secret_sauce  | FAILURE | Epic sadface: Sorry, this user has been locked out.                    	  |
      | standard_user           | wrongpassword | FAILURE | Epic sadface: Username and password do not match any user in this service |