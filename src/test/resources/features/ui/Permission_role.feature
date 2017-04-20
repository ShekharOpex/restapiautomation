Feature: Role CRUD operations

  @RegressionTest
  Scenario: Create new role and assign permission to role
    Given I click on add Role button
    Then I should get add role page
    When I fill all add role page mandatory details
    When I select permissions for role
    When I click on role save button
    Then I Should get role save success message
    Then I should get role listing page
    
 
  Scenario: Edit role.
    Given I click on edit role button
    Then I will edit role details
    When I click on update button
    Then I should get role update successfully message
    
#Scenario: Assign user for role
 	#Given I click on edit role button to assign user
 	#Then I type assign user name to role
 	#Then I click on Update 
 	#Then I should get role assign Successfully message

  Scenario: Delete Role
    Given I click on delete role button
    Then I Should get role delete success message
    And I verify role deleted from listing