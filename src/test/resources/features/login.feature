# This feature
@authentication
Feature: User Authentication for the application

  #Common background for all scenarios
  Background: Element Locators from properties file has been loaded
    Given Data from properties file has been loaded
    And the browser has initiated

  #Scenario for valid login
  @login
  Scenario: Login test with valid credentials
    Given the user opens IT Learnner website
    When the user enters valid username and password
    Then the user should be logged in to the application successfully

  #Scenario outline for invalid scenarios
  @login @data-driver
  Scenario Outline: Login test with various invalid scenarios
    Given the user opens IT Learnner website
    When the user enters  "<username>" and  "<password>"
    Then the login "<outcome>"

    Examples: 
      | username  | password | outcome     |
      | username2 | 12345    | should fail |
      | username3 |          | Fail        |
