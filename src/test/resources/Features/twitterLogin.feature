Feature: Feature to test twitter login

  @all @login
  Scenario: Verify user is able to Login to twitter successfully
    Given I login to twitter
      | username  | password   |
      | test_sonu | Twitter@89 |
    Then The page contains title Home / Twitter
