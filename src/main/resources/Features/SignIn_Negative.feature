Feature: To Sign in into The Washington Post Account

##  Test Passed
#  Scenario Outline: Existing User Sign In with invalid Email ID
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>"
#    And User clicks on the "Next" button
#    Then Error message is displayed
#    Examples:
#      | EmailID                                |
#      | xthe.washington.post.testing@gmail.com |

#  Requires continuous testing to dodge captcha, to skin error and move to
#  Scenario Outline: Existing User Sign In with valid Email ID & invalid password
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>"
#    And User clicks on the "Next" button
#    And User enters "<Password>"
#    And User clicks on the "SignIn" button
#    Then Error message is displayed
#    Then Help for Sign-in is prompted "<EmailID>"
#    Examples:
#      | EmailID                               | Password    |
#      | the.washington.post.testing@gmail.com | xUberP@ss123 |

##  Need New Account creds
#  Scenario: New user Sign Up
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User clicks on the "SignUp" button
#    And User enters "Personal Email ID"
#    And User clicks on the "agreeT&C" checkbox
#    # Refer above statement while validating 'Disagree T&C' for negative test cases
#    And User clicks on the "Next" button
#    And User enters "Password"
#    And User clicks on the "SignUp" button
#    Then User should be on the Welcome Page
#    And User clicks on the "Continue" button
#    Then User is signed in to The Washington Post
#
##  Need 2 New user Creds
#  Scenario Outline: New user attempts to change Email ID during Sign-Up
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User clicks on the "SignUp" button
#    And User enters "<initialEmail>"
#    And User clicks on the "agreeT&C" checkbox
#    And User clicks on the "Next" button
#    Then User should be able to change the Email ID before Sign-Up
#    And User enters "<newEmail>"
#    And User clicks on the "agreeT&C" checkbox
#    And User clicks on the "Next" button
#    And User enters "<password>"
#    And User clicks on the "SignUp" button
#    Then User should be on the Welcome Page
#    And User clicks on the "Continue" button
#    Then User is signed in to The Washington Post
#    Examples:
#      | initialEmail                       | newEmail                              | password     |
#      | sidharthdecember3@gmail.com        | abc123@yahoo.com                      | Password#123 |
#
##  Test Passed
#  Scenario Outline: Existing User Sign In using link
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>"
#    And User clicks on the "Email a sign in link" button
#    Then User should be on the Link Verification Page
#    Then User should be able to access all links
#    Examples:
#      | EmailID                               |
#      | the.washington.post.testing@gmail.com |
#  Scripts written for all the elements present in the Link Verification Page

##    Alka
#  Scenario: Existing User Sign In using Amazon
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>"
#    And User clicks on the "Email a sign in link" button
#    Then User should be on the Link Verification Page
#
##    Alka
#  Scenario: Existing User Sign In using Facebook
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>"
#    And User clicks on the "Continue with Facebook" button
#    Then User should be on the Link Verification Page
#
##    Goutham
#  Scenario: Existing User Sign In using Google
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>"
#    And User clicks on the "Email a sign in link" button
#    Then User should be on the Link Verification Page
#
##    Goutham
#  Scenario: Existing User Sign In using AppleID
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>"
#    And User clicks on the "Email a sign in link" button
#    Then User should be on the Link Verification Page