Feature: To Sign in into The Washington Post Account

##  Test Passed
  Scenario Outline: Existing User Sign In
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Next" button
    And User enters "<Password>"
    And User clicks on the "SignIn" button
    Then User is signed in to The Washington Post "<EmailID>"
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | UberP@ss123 |

#  Need New Account creds
#  Scenario Outline: New user Sign Up
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the "Home" Page
#    When User clicks on the "SignIn" button
#    And User clicks on the "SignUpHyperLink" button
#    And User enters "<Email ID>"
#    And User clicks on the "agreeT&C" checkbox
#    # Refer above statement while validating 'Disagree T&C' for negative test cases
#    And User clicks on the "Next" button
#    And User enters "<Password>"
#    And User clicks on the "SignUp" button
#    Then User should be on the Welcome Page
#    And User clicks on the "Continue" button
#    Then User is signed in to The Washington Post
#    Examples:
#      | Email ID                               | Password   |
#      | the.washington.post.testing1@gmail.com | UberPss456 |

#  Need 2 New user Creds
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

#  Test Passed
#  Scenario Outline: Existing User Sign In using link
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the "Home" Page
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>"
#    And User clicks on the "Email a sign in link" button
#    Then User should be on the Link Verification Page
#    Then User should be able to access all links
#    Examples:
#      | EmailID                               |
#      | the.washington.post.testing@gmail.com |
#  Scripts written for all the elements present in the Link Verification Page
