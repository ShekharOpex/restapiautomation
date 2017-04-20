Feature: EAaaS Login

@RegressionTest

Scenario: Login to EAaaS as Admin succesfully
   Given I am logging as Default System Admin
   Then I Verify Dashboard Page
   
Scenario: Login to EAaaS with invalid username
   Given I am logging as Inavlid username   
   Then I should be on login screen with invalid credential error message
   
Scenario: Login to EAaaS with invalid password 
   Given I am logging as Invalid password   
   Then I should be on login screen with invalid credential error message
   
Scenario: Login to EAaaS with blank space user and pass 
   Given I am logging as blank space pass and username   
   Then I should be on login screen with invalid credential error message