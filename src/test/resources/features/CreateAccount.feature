Feature: Create Account

  Scenario: Create Account
    Given User on authentication page
    When User fills all data required to register
    Then User sees panel after login