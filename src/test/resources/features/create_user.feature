Feature: Create user in dummyapi

  Background: setUp
    Given I have access to the service

  @CreateUserSuccesfull
  Scenario: create user successfully
    When I create a user with correct data
    Then I see the response code 200
    And I see that the answer is not empty
    And I see user data

  @CreateUserWithEmailIncorrect
  Scenario: create user with email incorrect
    When I create user without email incorrect
    Then I see the response code 400
    And I see the invalid email message

  @CreateUserWithEmailIncorrect
  Scenario: Create user without email
    When I create user without email
    Then I see the response code 400
    And I see the message email is required

  @CreateUserWithEmailUsed
  Scenario: Create user with email already used
    When I create user with email already used
    Then I see the response code 400
    And I see the message Email already use

