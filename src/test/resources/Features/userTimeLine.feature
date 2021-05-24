Feature: Twitter to test twitter user timeline

  @all @user-timeline
  Scenario: Verify the user timeline of the user test_sonu
    Given I login to twitter
      | username  | password   |
      | test_sonu | Twitter@89 |
    And I navigate to the uri /test_sonu in the current site
    Then The page contains title Test Sonu (@test_sonu) / Twitter
    Then Verify the number of tweets in the user time line to be 7

    Then Verify the tweet contents at index 0
      | account-name | account-id | tweet-text |
      | Test Sonu    | @test_sonu | ZXCzX      |

    Then Verify the tweet contents at index 1
      | account-name | account-id | tweet-text |
      | Test Sonu    | @test_sonu | tweet      |

    Then Verify the tweet contents at index 2
      | account-name | account-id | tweet-text     |
      | Test Sonu    | @test_sonu | sample tweet 3 |

    Then Verify the tweet contents at index 3
      | account-name | account-id | tweet-text     |
      | Test Sonu    | @test_sonu | sample tweet 2 |

    Then Verify the tweet contents at index 4
      | account-name | account-id | tweet-text     |
      | Test Sonu    | @test_sonu | sample tweet 1 |

    Then Verify the tweet contents at index 5
      | account-name | account-id | tweet-text   |
      | Test Sonu    | @test_sonu | test twitter |

    Then Verify the tweet contents at index 6
      | account-name | account-id | tweet-text |
      | Test Sonu    | @test_sonu | asdasd     |


