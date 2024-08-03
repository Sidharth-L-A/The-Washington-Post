Feature: To Open The Washington Post Website
  Scenario: Open Washington Post
   Given the user navigates to "https://www.washingtonpost.com/"
    Then User is on the "Home" Page

  Scenario: Open Washington Post post login
    Given the user navigates to "https://www.washingtonpost.com/"
   When User hits "enter" key
    Then User is on the "Home" Page
    Then User is signed in to The Washington Post