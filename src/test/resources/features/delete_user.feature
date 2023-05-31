Feature: Delete user

  Background: setUp
    Given I have access to the service


  @DeleteUserSuccessfully
  Scenario: Delete user existing successfully
    When I delete user existing
    Then I see the response code 200
    And I see that id user

  @DeleteUserThatNotExist
  Scenario: Delete user that not exist in
    When I delete user that not exist
    Then I see the response code 400
    And I see that message params not valid



