Feature: To Sign in into The Washington Post Account
# Check password strength meter & the dynamic text

#  Scenario Outline: Existing User Sign In
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the "Home" Page
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>" in the "EmailId" field
#    And User clicks on the "Next" button
#    And User enters "<Password>" in the "Password" field
#    And User clicks on the "SignIn" button
#    Then User is signed in to The Washington Post "<EmailID>"
#    Examples:
#      | EmailID                               | Password    |
#      | the.washington.post.testing@gmail.com | UberP@ss123 |

#  Scenario Outline: New user Sign Up
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the "Home" Page
#    When User clicks on the "SignIn" button
#    And User clicks on the "SignUp" button
#    And User enters "<EmailID>" in the "EmailId" field
#    And User clicks on the "agreeT&C" checkbox
#    And User clicks on the "Next" button
#    And User enters "<Password>" in the "Password" field
#    And User clicks on the "SignUp" button
#    Then User should be on the Welcome Page
#    And User clicks on the "Continue" button
#    Then User is signed in to The Washington Post "<EmailID>"
#    Examples:
#      | EmailID                               | Password    |
#      | NEED_NEW_EMAIL_ID_EACH_TIME           | UberP@ss123 |
#
#  Scenario Outline: New user attempts to change Email ID during Sign-Up by clicking change hyperlink
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the "Home" Page
#    When User clicks on the "SignIn" button
#    And User clicks on the "SignUp" button
#    And User enters "<InitialEmail>" in the "EmailID" field
#    And User clicks on the "agreeT&C" checkbox
#    And User clicks on the "Next" button
#    Then User should be able to change the Email ID before Sign-Up
#    And User enters "<NewEmailID>" in the "EmailID" field
#    And User clicks on the "agreeT&C" checkbox
#    And User clicks on the "Next" button
#    And User enters "<Password>" in the "Password" field
#    And User clicks on the "SignUp" button
#    Then User should be on the Welcome Page
#    And User clicks on the "Continue" button
#    Then User is signed in to The Washington Post "<NewEmailID>"
#    Examples:
#      | InitialEmail                           | NewEmailID                            | Password     |
#      | the.washington.post.testing1@gmail.com | NEED_NEW_EMAIL_ID_EACH_TIME           | UberP@ss123  |
#
#  Scenario Outline: Existing User Sign In using link
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the "Home" Page
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>" in the "EmailID" field
#    And User clicks on the "Email a sign in link" button
#    Then User should be on the Link Verification Page
#    Then User should be able to access all links
#    Examples:
#      | EmailID                               |
#      | the.washington.post.testing@gmail.com |
#
#  Scenario Outline: Existing User Sign In using Google
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the "Home" Page
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>" in the "EmailID" field
#    And User clicks on the "Google" button
#    Then User should be on the Sign in with Google Page
#    And User enters "<EmailID>" in Google in the "EmailId" field
#    And User clicks on the "Google Next" button
#    Then User should be on the Sign in with Google Page
#    And User enters "<Password>" in Google in the "Password" field
#    And User clicks on the "Google Next" button
#    Then User is on the "Home" Page
#    Then User is signed in to The Washington Post "<EmailID>"
#    Examples:
#      | EmailID                               | Password    |
#      | the.washington.post.testing@gmail.com | UberP@ss123 |
#
#  Scenario Outline: Existing User Sign In using AppleID
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the "Home" Page
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>" in the "EmailId" field
#    And User clicks on the "Apple" button
#    Then User should be on the Sign in with Apple Page
#    And User enters "<EmailID>" in AppleID "EmailId" field
#    And User clicks on the "Apple Sign In Arrow" button
#    And User enters "<Password>" in AppleID "Password" field
#    And User clicks on the "Apple Sign In Arrow" button
#    Then User should be on the Sign in with Apple Page
#    Then User is on the "Apple Two Factor Authentication" Page
#    And User enters the "<AppleTwoFactorAuthenticationCode>"
#    And User clicks on the "Trust Browser" button
#    And User clicks on the "Apple Sign In Continue" button
#    Then User is signed in to The Washington Post "<EmailID>"
#    Examples:
#      | EmailID                               | Password    | AppleTwoFactorAuthenticationCode |
#      | the.washington.post.testing@gmail.com | UberP@ss123 | SIX_DIGIT_CODE              |
#
#  Scenario Outline: Existing User Sign In using Amazon
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the "Home" Page
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>"
#    And User clicks on the "Amazon" button
#    Then User should be on the Amazon signIn Page
#    And User enters "<EmailID>" in AmazonID
#    And User clicks on the "Continue" button
#    And User enters "<Password>" in AmazonID
#    When User clicks on the "SignIn" button
#    Then User is signed in to The Washington Post "<EmailID>"
#    Examples:
#      | EmailID                               | Password |
#      | the.washington.post.testing@gmail.com | UberP@ss123 |
#
#  Scenario Outline: Existing User Sign In using Facebook
#    Given the user navigates to "https://www.washingtonpost.com/"
#    Then User is on the "Home" Page
#    When User clicks on the "SignIn" button
#    And User enters "<EmailID>"
#    And User clicks on the "Facebook" button
#    Then User should be on the Facebook signIn Page
#    And User enters "<EmailID>" in FacebookID
#    And User enters "<Password>" in FacebookID
#    And User clicks on the "FacebookLogin" button
#    Then User should be on the six digit Verification Facebook Page
##    upload image
#    And User clicks on the "Continue" button
##    page : appeal submitted
#    Then User is signed in to The Washington Post "<EmailID>"
#    Examples:
#      | EmailID                               | Password    |
#      | the.washington.post.testing@gmail.com | UberP@ss123 |
#
