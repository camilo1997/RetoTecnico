Feature: Get users

  Background: setUp
    Given I have access to the service


  @GetuserById
  Scenario: Get user by id
    When I get user by id
    Then I see the response code 200
    And I see that the response is not empty

  @GetAllUsers
  Scenario: Get all users
    When I get all users
    Then I see the response code 200
    And I see that the response is not empty

  @GetUserByIdIncorrect
  Scenario: Get user by id incorrect
    When I get user by id incorrect
    Then I see the response code 400
    And I see that message params not valid