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
