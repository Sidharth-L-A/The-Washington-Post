Feature: To Open The Washington Post Website
  Scenario: Open Washington Post
    Given User types "https://www.washingtonpost.com/" in the search bar
    When User hits enter key
    Then The Washington Post homepage is opened