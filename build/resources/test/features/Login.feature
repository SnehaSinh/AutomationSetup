Feature: Login
  Background:
    Given user enters the url

  Scenario: User verifies the title of the page
    Then verifies the title of the page
    And the current tab as "practice-page"

  Scenario: User enters details on the practice page
    Given the user enters the login information
    Then clicks on submit
