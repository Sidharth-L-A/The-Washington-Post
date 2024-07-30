#Feature: To verify negative outcomes of The Washington Post Website
#  Scenario: Verify the behavior of The Washington Post site during a network interruption
#    Given User types "https://www.washingtonpost.com/" in the browser's search bar
#    When User hits "enter" key
#    Then The Washington Post homepage is opened
#    And Internet Connection is "Disabled"
#    Then The Site is Reloaded
#    And Error message is displayed