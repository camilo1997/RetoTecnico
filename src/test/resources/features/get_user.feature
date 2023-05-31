Feature: Get users

  Background: setUp
    Given I have access to the service


    @GetuserById
    Scenario: Get user by id
      When I get user by id
      Then I see the response code 200
      And I see that the response is not empty