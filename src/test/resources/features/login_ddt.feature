
@smoke
Feature: User login to the app

  As a user I should be to login

  Background:
    Given I am at sauce demo login page

  Scenario Outline: User Should be able to login with user credential

        When I provide credentials for "<User Type>" user
        Then I should see product page

    Examples:
      | User Type  |
      | standard   |
      | problem   |
      |locked_out |



#  @US-001
#  Scenario: User Should be able to login with valid credential
#
##    Given I am at sauce demo login page
#    When I provide credentials for "standard" user
#    Then I should see product page
#
#  @US-002
#  Scenario: User Should be able to login with problem user credential
#
##    Given I am at sauce demo login page
#    When I provide credentials for "problem" user
#    Then I should see product page