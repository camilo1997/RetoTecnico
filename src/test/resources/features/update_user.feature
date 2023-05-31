Feature: Update User

  Background: setUp
    Given I have access to the service

  @UpdateUserSuccessfully
  Scenario: Update user that exist successfully
    When I update an existing user
    Then I see the response code 200
    And I see that the answer is not empty
    And I see new updated user data

  @UpdateUserNotExist
  Scenario: Update user that not exist
    When I update user not existing
    Then I see the response code 400
    And I see that message params not valid