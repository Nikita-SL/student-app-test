@SMOKE
Feature: Create student feature
  Scenario Outline: Create student (happy path)
    Given user is on the app page
    And user click on add student button
    And user enters name in name field
    And user enter email in email field
    And user selects '<gender>' in gender field
    When user click on submit button
    Then user is created with success message "Student successfully added"
    Examples:
      | gender |
      | MALE   |
      | FEMALE |
      | OTHER  |