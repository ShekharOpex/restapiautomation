@API
Feature:  REST API Validation

  Scenario: API - GET_REST_POD
    Given I putted the details for GET POD on REST API
    Then I Verify Response Code and Response Body
    
    
