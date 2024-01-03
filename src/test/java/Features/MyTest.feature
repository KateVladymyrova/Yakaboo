Feature: Desktop checkout for guest user
  As a customer
  I want to buy a book on the bookstore's website
  So I find a book and add it to the cart

  Scenario: Find a book and add it to the cart
    Given I am on the homepage
    When I click the specific element
    Then I am looking for a book
    When I am checking the search results
    Then I click on a product
    When I should be redirected to the product details page
    Then I enter my personal account
    When I enter the email and password
