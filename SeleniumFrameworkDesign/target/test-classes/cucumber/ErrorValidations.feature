@Regression
Feature: Error Validation
  I want to use this template for my feature file

  @Regression
  Scenario Outline: Login with incorrect password
    Given I landed on Ecommerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name  								| password |
      | ewaldostehr@gmail.com | Paul35   |