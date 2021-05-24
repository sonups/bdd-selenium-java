Feature: Twitter to test twitter profile page

  Background:
    Given I login to twitter
      | username  | password   |
      | test_sonu | Twitter@89 |

  @all @user-profile
  Scenario: Verify the user description field in profile page of the user test_sonu
    When I click on profile button in left navigation panel
    Then Verify the Biography field in profile contains text automatically updated biography - time stamp

  @all @user-profile
  Scenario: Verify the tweet count text in profile page of the user test_sonu
    When I click on profile button in left navigation panel
    Then Verify the tweet count in profile is 7 Tweets

  @all @user-profile
  Scenario: As a user I edit the user description and I verify it is updated successfully
    When I click on profile button in left navigation panel
    And I click edit profile button
    Then I update & verify the updated biography with text automatically updated biography - time stamp - appended with timestamp

