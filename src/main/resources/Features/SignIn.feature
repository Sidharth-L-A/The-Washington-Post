Feature: To Sign in into The Washington Post Account
  Scenario: Initial Sign In
    Given User is in Homepage
    When User Clicks on "SignIn" button
    And User enters "Personal Email ID"
    And User Clicks on "Next" button
    And User enters "Password"
    And User Clicks on "SignIn" button
    Then User Signed in into The Washington Post