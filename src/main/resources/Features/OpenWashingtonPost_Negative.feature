Feature: To verify negative outcomes of The Washington Post Website
  Scenario: Verify the behavior of The Washington Post site during a network interruption
    Given the user navigates to "https://www.washingtonpost.com/"
    When User hits "enter" key
    Then The Washington Post homepage is opened
    And Internet Connection is "Disabled"
    Then The Site is Reloaded
    And Error message is displayed