Feature: To Land on The Washington Post Home Page

  Scenario: Open Washington Post
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page

##  Scenario Outline: Open Washington Post post Sign in to verify Account Name Displayed
##    Given the user navigates to "https://www.washingtonpost.com/"
##    Then User is on the "Home" Page
##    When User clicks on the "SignIn" button
##    And User enters "<EmailID>"
##    And User clicks on the "Next" button
##    And User enters "<Password>"
##    And User clicks on the "SignIn" button
##    Then User is signed in to The Washington Post "<EmailID>"
##    Then User can see account name "<EmailID>" on the reopened homepage
##    Examples:
##      | EmailID                               | Password    |
##      | the.washington.post.testing@gmail.com | UberP@ss123 |
#
#

  Scenario: New user is on home page and not signed in
    Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page
#gbm
    When User clicks on the "SearchMore" button
    Then User is on the "SearchMore" Page
#    Add Steps if necessary
    When User clicks on the "NewsAlerts" button
    Then User is on the "NewsAlerts" Page
#    Add Steps if necessary
    When User clicks on the "Politics" button
    Then User is on the "Politics" Page
    When User clicks on the "Back" button
    Then User is on the "Home" Page
    When User clicks on the "Opinions" button
    Then User is on the "Opinions" Page
    When User clicks on the "Back" button
    Then User is on the "Home" Page
    When User clicks on the "Style" button
    Then User is on the "Style" Page
    When User clicks on the "Back" button
    Then User is on the "Home" Page
##alka
#    When User clicks on the "Investigations" button
#    Then User is on the "Investigations" Page
#    When User clicks on the "Back" button
#    Then User is on the "Home" Page
#    When User clicks on the "Climate" button
#    Then User is on the "Climate" Page
#    When User clicks on the "Back" button
#    Then User is on the "Home" Page
##gbm
#    When User clicks on the "Search & More" button
#    Then User is on the "Search & More" Page
##    Add Steps if necessary
#    When User clicks on the "News Alerts" button
#    Then User is on the "News Alerts" Page
##    Add Steps if necessary
#    When User clicks on the "Politics" button
#    Then User is on the "Politics" Page
#    When User clicks on the "Back" button
#    Then User is on the "Home" Page
#    When User clicks on the "Opinions" button
#    Then User is on the "Opinions" Page
#    When User clicks on the "Back" button
#    Then User is on the "Home" Page
#    When User clicks on the "Style" button
#    Then User is on the "Style" Page
#    When User clicks on the "Back" button
#    Then User is on the "Home" Page
## alka
    When User clicks on the "Investigations" button
    Then User is on the "Investigations" Page
    When User clicks on the "Back" button
    Then User is on the "Home" Page
    When User clicks on the "Climate" button
    Then User is on the "Climate" Page
    When User clicks on the "Back" button
    Then User is on the "Home" Page
    When User clicks on the "Well+Being" button
    Then User is on the "Well+Being" Page
    When User clicks on the "Back" button
    Then User is on the "Home" Page
    When User clicks on the "Tech" button
    Then User is on the "Tech" Page
    When User clicks on the "Back" button
    Then User is on the "Home" Page
    When User clicks on the "World" button
    Then User is on the "World" Page
    When User clicks on the "Back" button
    Then User is on the "Home" Page
    When User clicks on the "D.C., Md. & Va." button
    Then User is on the "D.C., Md. & Va." Page
    When User clicks on the "Back" button
    Then User is on the "Home" Page
    When User clicks on the "Sports" button
    Then User is on the "Sports" Page
    When User clicks on the "Back" button
    Then User is on the "Home" Page
##sla
#    When User clicks on the "Subscribe" button
#    Then User is on the "Subscribe" Page
#    When User clicks on the "Back" button
#    Then User is on the "Home" Page
#    When User clicks on the "Sign in" button
#    Then User is on the "Sign in" Page
#    When User clicks on the "Back" button
#    Then User is on the "Home" Page
#
#
