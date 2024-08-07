Feature: To Sign in into The Washington Post Account

  Scenario Outline: Existing User Sign In with invalid Email ID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    Examples:
      | EmailID |
      | xthe.washington.post.testing@gmail.com |

  Scenario Outline: Existing User Sign In with valid Email ID & invalid password
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Next" button
    And User enters "<Password>"
    And User clicks on the "SignIn" button
    Then Error message is displayed
#    Then Help for Sign-in is prompted "<EmailID>"
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | xUberP@ss123 |

  Scenario Outline: New user Sign Up with invalid EmailID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User clicks on the "SignUpHyperlink" button
    And User enters "<EmailID>"
    And User clicks on the "agreeT&C" checkbox
    And User clicks on the "Next" button
    Then Error message is displayed
    Examples:
      | EmailID                                |
      | xthe.washington.post.testing@gmail.com |

  Scenario Outline: New user Sign Up with valid Email ID & invalid Password
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User clicks on the "SignUp" button
    And User enters "<EmailID>"
    And User clicks on the "agreeT&C" checkbox
    And User clicks on the "Next" button
    And User enters "<Password>"
#    And User should not be able to click "SignUp" button
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | Abc123#     |

  Scenario Outline: New User Sign In using link from Invalid Email Id
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Email a sign in link" button
    Then Error message is displayed
    Examples:
      | EmailID                     |
      | xthe.washington.post.testing@gmail.com |

  Scenario Outline: Existing User Sign In using Google with Invalid EmailId
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Google" button
    Then User should be on the Sign in with Google Page
    And User enters "<EmailID>"
    And User clicks on the "Next" button
    And Error message is displayed
    Examples:
      | EmailID                               |
      | xthe.washington.post.testing@gmail.com |

  Scenario Outline: Existing User Sign In using Google with valid mail Id & Invalid Pwd
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Google" button
    Then User should be on the Sign in with Google Page
    And User enters "<EmailID>"
    And User clicks on the "Next" button
    And User enters "<Password>"
    And User clicks on the "Next" button
    And Error message is displayed
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | xUberP@ss123 |

  Scenario Outline: Existing User Sign In using AppleID with invalid Mail ID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Apple" button
    Then User should be on the Sign in with Apple Page
    And User enters "<EmailID>"
    And User clicks on the "SignInArrow" button
    And Error message is displayed
    Examples:
      | EmailID                               |
      | xthe.washington.post.testing@gmail.com |

  Scenario Outline: Existing User Sign In using AppleID with valid mail Id & Invalid Pwd
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Apple" button
    Then User should be on the Sign in with Apple Page
    And User enters "<EmailID>"
    And User clicks on the "SignInArrow" button
    And User enters "<Password>"
    And User clicks on the "PasswordArrow" button
    And Error message is displayed
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | xUberP@ss123 |


  Scenario Outline: Existing User Sign In with invalid AmazonID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Amazon" button
    Then User should be on the Amazon signIn Page
    And User enters "<EmailID>" in AmazonID
    And User clicks on the "Continue" button
    Then Error message is displayed
    Examples:
      | EmailID                                |
      | xthe.washington.post.testing@gmail.com |

  Scenario Outline: Existing User Sign In with valid EmailId & invalid AmazonID Password
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Amazon" button
    Then User should be on the Amazon signIn Page
    And User enters "<EmailID>" in AmazonID
    And User clicks on the "Continue" button
    And User enters "<Password>" in AmazonID
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
    And User enters "<EmailID>" in FacebookID
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
    And User enters "<EmailID>" in FacebookID
    And User enters "<Password>" in FacebookID
    And User clicks on the "FacebookLogin" button
    Then Error message is displayed
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | xUberP@ss123 |