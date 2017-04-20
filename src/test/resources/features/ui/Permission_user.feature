Feature: User CRUD operations

  @RegressionTest
  Scenario: Create new user and assign role to user
    Given I click on add user button
    Then I should get add user page
    When I fill all add user page mandatory details
    When I select roles for user
    When I click on save button
    Then I Should get user save success message
    Then I should get users listing page

  Scenario: Edit User
    Given I click on edit user button
    Then I will edit user details
    When I click on update user button
    Then I should get user update successfully message

  Scenario: Delete Users
    Given I click on delete user button
    Then I Should get user delete success message
