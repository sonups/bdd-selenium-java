Feature: Test to send tweets

  @all @send-tweet
  Scenario: As a user I should be able to send a tweet from twitter site
    Given I login to twitter
      | username  | password   |
      | Sonu2Test | Twitter@89 |
    When I click on home button in left navigation panel
    Then I send a tweet with text good test tweet with timestamp appended


