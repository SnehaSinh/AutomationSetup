Feature: SelectorsHubPracticePage

  Background:
    Given user enters the url

  Scenario: User verifies the title of the page
    Then verifies the title of the page
    And the current tab as "practice-page"

  Scenario: User enters details on the practice page
    Given the user enters the login information
    Then clicks on submit
@Test
  Scenario Outline: User enter details of the customer in the practice page
    Then user enters "<UserName>" and "<PassWord>"
    And then enters "<CompanyName>" and <MobileNumber>
    Examples:
      | UserName | PassWord | CompanyName | MobileNumber |
      | Alex     | alexcc   | XYZ         | 10098        |
      | Lia      | sia      | ABC         | 23456        |
      | Tommy    | timtim   | QWERTY      | 234788889    |


  Scenario:Verify the dropdown items in the page
    Given the user clicks on car dropdown
    Then verify below options are present in the dropdown list
      | Volvo | Saab | Opel | Audi |
    Then user selects "Audi" and verifies the selection


  Scenario: Verify that there is Users Table in the page and user counts the number of entries
    Given the user verifies the table name is "Users Table"
    Then the user validates that the table contains below mentioned columns
      | Username | User Role | Employee Name | Status |
    And verifies the count of entries in the "Users Table" is 6


  Scenario: Verify user is able to click on the checkbox for User
    Then the user selects checkbox against "admin" user from the table
    And enters the name of the user in the user name field

  @Test
  Scenario: Verify the alerts present in the page
    When the user clicks on the "Window Alert" and verify the message of the alert is "Press a button!"
    Then user clicks on the "Window Prompt Alert" and enters the message "Accept or reject the alert"
    And then accepts the alert

  #Scenario:User determines the number of active links
   # Then user determines the number of active links in the page
    #And then detemines the number of active links in the page



