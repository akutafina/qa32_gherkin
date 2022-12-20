Feature: Scenario Outline example

  @scenarioOutline
  Scenario Outline: Login with invalid credentials (Scenario Outline): <login>, <password>
    Given Login page is opened
    When specific login credentials are entered
      | current_login | current_password |
      | <login>       | <password>       |
    And Login button is clicked
    Then error message appears
    Examples:
      | login        | password   |
      | test_login_1 | test_pwd_1 |
      | test_login_2 | test_pwd_2 |
      | test_login_3 | test_pwd_3 |