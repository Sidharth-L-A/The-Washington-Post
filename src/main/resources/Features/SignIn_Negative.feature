Feature: To Sign in into The Washington Post Account

  Scenario Outline: Existing User Sign In with invalid Email ID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    Examples:
      | EmailID |
      | xthe.washington.post.testing@gmail.com |

  Scenario Outline: Existing User Sign In with invalid AmazonID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Amazon" button
    Then User should be on the Amazon signIn Page
    And User enters "<EmailID>"
    And User clicks on the "Continue" button
    Then Error message is displayed
    Examples:
      | EmailID                                |
      | xthe.washington.post.testing@gmail.com |
      
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
#
###  Need New Account creds
#  Scenario Outline: New user Sign Up with invalid EmailID
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User clicks on the "SignUp" button
#    And User enters "<EmailID>"
#    And User clicks on the "agreeT&C" checkbox
#    # Refer above statement while validating 'Disagree T&C' for negative test cases
#    And User clicks on the "Next" button
#    Then Error message is displayed
#    Examples:
#      | EmailID                                |
#      | xthe.washington.post.testing@gmail.com |

#  Scenario Outline: New user Sign Up with valid Email ID & invalid Password
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User clicks on the "SignUp" button
#    And User enters "<EmailID>"
#    And User clicks on the "agreeT&C" checkbox
#    # Refer above statement while validating 'Disagree T&C' for negative test cases
#    And User clicks on the "Next" button
#    And User enters "<Password>"
#    And User should not be able to click "SignUp" button
#    Examples:
#      | EmailID                               | Password    |
#      | the.washington.post.testing@gmail.com | Abc123#     |

##  Test Passed
#  Scenario Outline: New User Sign In using link from Email
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the Homepage
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>"
#    And User clicks on the "Email a sign in link" button
#    Then Error message is displayed
#    Examples:
#      | EmailID                     |
#      | sidharthdecember3@gmail.com |

  Scenario Outline: Existing User Sign In with valid EmailId & invalid AmazonID Password
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Amazon" button
    Then User should be on the Amazon signIn Page
    And User enters "<EmailID>"
    And User clicks on the "Continue" button
    And User enters "<Password>"
    When User clicks on the "SignIn" button
    Then Error message is displayed
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | xUberP@ss123 |

  Scenario Outline: Existing User Sign In with invalid FacebookID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Facebook" button
    Then User should be on the Facebook signIn Page
    And User enters "<EmailID>"
    And User clicks on the "FacebookLogin" button
    Then Error message is displayed
    Examples:
      | EmailID                               |
      | xthe.washington.post.testing@gmail.com |

  Scenario Outline: Existing User Sign In with  valid EmailId & invalid FacebookID Password
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Facebook" button
    Then User should be on the Facebook signIn Page
    And User enters "<EmailID>"
    And User enters "<Password>"
    And User clicks on the "FacebookLogin" button
    Then Error message is displayed
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | xUberP@ss123 |
