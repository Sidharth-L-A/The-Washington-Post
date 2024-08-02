Feature: To Sign in into The Washington Post Account


  Scenario Outline: Existing User Sign In using Amazon
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
    Then User is signed in to The Washington Post
    Examples:
      | EmailID                               | Password |
      | the.washington.post.testing@gmail.com | UberP@ss123 |

  Scenario Outline: Existing User Sign In using Facebook
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
    When User clicks on the "SignIn" button
    And User enters "<EmailID>"
    And User clicks on the "Facebook" button
    Then User should be on the Facebook signIn Page
    And User enters "<EmailID>"
    And User enters "<Password>"
    And User clicks on the "FacebookLogin" button
    Then User should be on the six digit Verification Facebook Page
#    upload image
    And User clicks on the "Continue" button
#    page : appeal submitted
    Then User is signed in to The Washington Post
    Examples:
      | EmailID                               | Password    |
      | the.washington.post.testing@gmail.com | UberP@ss123 |
