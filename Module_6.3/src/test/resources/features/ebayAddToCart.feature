@ebay
Feature: ebay

@test
  Scenario: Add To Cart
	Given I open Ebay application  
    And I set search request "parker"
    And I perform search
    When I perform AddToCart   
    Then the product list is shown as "parker" 

@test
  Scenario Outline: Add To Cart data driven
    Given I open Ebay application  
    And I set search request "<product>"
    And I perform search
    When I perform AddToCart    
    Then the product list is shown as "<product>"
    
    Examples:
      | product  | 
      | Alchemist| 
      | Diary    |