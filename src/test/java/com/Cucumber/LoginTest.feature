Feature: Login Functionality Test

  Scenario: Verify login with valid Credentials

    Given Open Browser and Navigate to login Page
    When Enter valid Email and Password
    When Login success
    Then Close Test