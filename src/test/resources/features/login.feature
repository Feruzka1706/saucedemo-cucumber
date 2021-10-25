Feature: User login to the app

  As a user I should be to login

  Scenario: User Should be able to login with valid credential

    Given I am at sauce demo login page
    When I provide credentials for "standard" user
    Then I should see product page