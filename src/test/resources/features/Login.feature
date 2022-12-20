Feature: Login feature

  Scenario: Basic negative Login scenario
    Given Login page is opened
    When login credentials are entered
    And Login button is clicked
    Then error message appears
