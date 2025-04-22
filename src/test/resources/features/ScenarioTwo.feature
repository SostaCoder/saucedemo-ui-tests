Feature: SauceDemo End-to-End Order Flow

  Scenario: User places an order for the two most expensive products
    Given I navigate to the website
    When I login with username "standard_user" and password "secret_sauce"
    Then I should be navigated to the products page
    When I add the two most expensive products to the cart
    And I click on the cart button
    Then I should be on the Cart page with the selected products
    When I click on the Checkout button
    Then I should be on the Checkout page
    When I fill in the checkout form with first name "John", last name "Doe", and postal code "12345"
    And I click the Continue button
    Then I should be on the Overview page
    And I should see the correct item total before tax
    And the URL should be "https://www.saucedemo.com/checkout-step-two.html"
    When I click the Finish button
    Then I should see the "Thank you for your order!" message
    And I should see the message "order has been dispatched"