Feature: Running tests with tag @negative only

  @negative
  Scenario: Tag negative
    Given Login page is opened
    When login credentials are entered
    And Login button is clicked
    Then error message appears