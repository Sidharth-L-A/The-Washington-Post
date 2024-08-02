Feature: To Sign in into The Washington Post Account

  Scenario Outline: Existing User Sign In with invalid Email ID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Next" button
    Then Error message is displayed
    Examples:
      | EmailID                                |
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
    Then Help for Sign-in is prompted "<EmailID>"
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | xUberP@ss123 |

  Scenario Outline: New user Sign Up with invalid Email ID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User clicks on the "SignUp" button
    And User enters "<EmailID>"
    And User clicks on the "agreeT&C" checkbox
    And User clicks on the "Next" button
    And User enters "<Password>"
    And User clicks on the "SignUp" button
    Then Error message is displayed
    Examples:
      | EmailID                                       | Password     |
      | invalid.the.washington.post.testing@gmail.com | xUberP@ss123 |

  Scenario Outline: New user attempts to change Email ID during Sign-Up using an invalid Email ID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User clicks on the "SignUp" button
    And User enters "<initialEmail>"
    And User clicks on the "agreeT&C" checkbox
    And User clicks on the "Next" button
    Then User should be able to change the Email ID before Sign-Up
    And User enters "<newEmail>"
    And User clicks on the "agreeT&C" checkbox
    And User clicks on the "Next" button
    And User enters "<password>"
    And User clicks on the "SignUp" button
    Then Error message is displayed
    Examples:
      | initialEmail                          | newEmail                                       | password         |
      | the.washington.post.testing@gmail.com | invalid.the.washington.post.testing@gmail.com  | invalidpassword. |

  Scenario Outline: Existing User Sign In using link with invalid Email ID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Email a sign in link" button
    Then Error message is displayed
    Examples:
      | EmailID                                       |
      | invalid.the.washington.post.testing@gmail.com |

  Scenario Outline: Existing User Sign In with invalid GoogleID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Google" button
    Then User should be on the Sign in with Google Page
    And User enters "<EmailID>"
    And User clicks on the "Next" button
    Then Error message is displayed
    Examples:
      | EmailID                                |
      | xthe.washington.post.testing@gmail.com |

  Scenario Outline: Existing User Sign In with valid EmailId & invalid GooglePassword
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
    Then Error message is displayed
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | xUberP@ss123 |

  Scenario Outline: Existing User Sign In with invalid AppleID
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Google" button
    Then User should be on the Sign in with Apple Page
    And User enters "<EmailID>"
    And User clicks on the "SignInArrow" button
    Then Error message is displayed
    Examples:
      | EmailID                                |
      | xthe.washington.post.testing@gmail.com |

  Scenario Outline: Existing User Sign In with valid EmailId & invalid AppleIDPasssword
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Google" button
    Then User should be on the Sign in with Apple Page
    And User enters "<EmailID>"
    And User clicks on the "SignInArrow" button
    And User enters "<Password>"
    And User clicks on the "PasswordArrow" button
    Then Error message is displayed
    Examples:
      | EmailID                                | Password    |
      | the.washington.post.testing@gmail.com | xUberP@ss123 |

