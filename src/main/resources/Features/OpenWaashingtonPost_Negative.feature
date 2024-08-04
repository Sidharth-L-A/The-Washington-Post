Feature: To verify negative outcomes of The Washington Post Website
  Scenario: Verify the behavior of The Washington Post site during a network interruption
    Given the user navigates to "https://www.washingtonpost.com/"
    Then The Washington Post homepage is opened
    Then User is on the "Home" Page