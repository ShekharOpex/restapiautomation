Feature:Onboard Customer

@RegressionTest
   
Scenario: Click on add customer button 
	Given I click on add customer button
	Then I should get On-board Customer page
	When I fill all the mandatory details
	When I click on submit button  
	Then I should get Customer listing page  

Scenario: check available customer in list
	Given I search created customer in list
	Then I will get true or false according    
   
Scenario: check customer on-boarding status 
	Given I search customer on-boarding status
  Then I will get on-boarding status  
      
Scenario: Deploy Application 
	Given I get on boarding status is success
	When I click on deploy icon
	Then I should get solutions page
	When I click to select application
	When I click deploy on solution 
	Then I will get input parameter page
	When I fill required input parameter
	Then I should get deployment lunch successful pop up message box
	
#Scenario: #check solution deploy status 
	#Given I search solution deployment status for specific customer
    #Then I will get success or failed status
    
#Scenario: #edit CCU details 
	#Given I will click on edit ccu details
    #Then I will get edit ccu detail page
    
#Scenario: #edit customer details 
	#Given I edit customer details for specific customer
    #Then I will get edit customer details success message	   
	

	

