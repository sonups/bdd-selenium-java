Feature: To test search functionality in twitter

  @all @search-page
  Scenario: As a user I should be able to search user pages by a keyword and select specifc
    Given I login to twitter
      | username  | password   |
      | Sonu2Test | Twitter@89 |
    When I click on home button in left navigation panel
    Then I enter the text sachin tendulkar in search field
    Then I select the page with text @sachin_rt from search results
    Then The page contains title Sachin Tendulkar (@sachin_rt) / Twitter


