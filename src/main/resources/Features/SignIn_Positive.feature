Feature: To Sign in into The Washington Post Account

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

  Scenario Outline: New user Sign Up
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User clicks on the "SignUp" button
    And User enters "<EmailID>"
    And User clicks on the "agreeT&C" checkbox
    And User clicks on the "Next" button
    And User enters "<Password>"
    And User clicks on the "SignUp" button
    Then User should be on the Welcome Page
    And User clicks on the "Continue" button
    Then User is signed in to The Washington Post "<EmailID>"
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | UberP@ss123 |

  Scenario Outline: New user attempts to change Email ID during Sign-Up
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User clicks on the "SignUp" button
    And User enters "<InitialEmail>"
    And User clicks on the "agreeT&C" checkbox
    And User clicks on the "Next" button
    Then User should be able to change the Email ID before Sign-Up
    And User enters "<NewEmailID>"
    And User clicks on the "agreeT&C" checkbox
    And User clicks on the "Next" button
    And User enters "<Password>"
    And User clicks on the "SignUp" button
    Then User should be on the Welcome Page
    And User clicks on the "Continue" button
    Then User is signed in to The Washington Post "<NewEmailID>"
    Examples:
      | InitialEmail                           | NewEmailID                            | Password     |
      | the.washington.post.testing1@gmail.com | the.washington.post.testing@gmail.com | UberP@ss123  |

  Scenario Outline: Existing User Sign In using link
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Email a sign in link" button
    Then User should be on the Link Verification Page
    Then User should be able to access all links
    Examples:
      | EmailID                               |
      | the.washington.post.testing@gmail.com |

  Scenario Outline: Existing User Sign In using Google
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Google" button
    Then User should be on the Sign in with Google Page
    And User enters "<EmailID>"
    And User clicks on the "Next" button
    Then User should be on the Sign in with Google Page
    And User enters "<Password>"
    And User clicks on the "Next" button
    Then User is on the "Home" Page
    Then User is signed in to The Washington Post "<EmailID>"
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | UberP@ss123 |

  Scenario Outline: Existing User Sign In using AppleID
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
    Then User should be on the Sign in with Apple Page
    And User clicks on the "Continue" button
    Then User is signed in to The Washington Post "<EmailID>"
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | UberP@ss123 |



