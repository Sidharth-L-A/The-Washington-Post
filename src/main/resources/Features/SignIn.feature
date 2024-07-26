Feature: To Sign in into The Washington Post Account

#  To Do :
#  Create Negative Scenarios through different Feature Files
#  Implement Scenario Outlines for Email Password

  Scenario: Existing User Sign In Negative

  Scenario: New User Sign Up Negative

  Scenario: Existing User Sign In
    Given User is on the Homepage
    When User clicks on the "SignIn" button
    And User enters "Personal Email ID"
    And User clicks on the "Next" button
    And User enters "Password"
    And User clicks on the "SignIn" button
    Then User is signed in to The Washington Post

  Scenario: New user Sign Up
    Given User is on the Homepage
    When User clicks on the "SignIn" button
    And User clicks on the "SignUp" button
    And User enters "Personal Email ID"
    And User clicks on the "agreeT&C" checkbox
    # Refer above statement while validating 'Disagree T&C' for negative test cases
    And User clicks on the "Next" button
    And User enters "Password"
    And User clicks on the "SignUp" button
    Then User should be on the Welcome Page
    And User clicks on the "Continue" button
    Then User is signed in to The Washington Post

  Scenario: New user attempts to change Email ID during Sign-Up
    Given User is on the Homepage
    When User clicks on the "SignIn" button
    And User clicks on the "SignUp" button
    And User enters "Personal Email ID"
    And User clicks on the "agreeT&C" checkbox
    And User clicks on the "Next" button
    Then User should be able to change the Email ID before Sign-Up
    And User enters "Personal Email ID"
    And User clicks on the "agreeT&C" checkbox
    And User clicks on the "Next" button
    And User enters "Password"
    And User clicks on the "SignUp" button
    Then User should be on the Welcome Page
    And User clicks on the "Continue" button
    Then User is signed in to The Washington Post
