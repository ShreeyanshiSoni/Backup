

Feature: Validation Place API
@AddPlaceAPI @Regression
  Scenario Outline: Verify if place is being successfully added using AddPlace API
    Given Add Place Payload "<Name>" "<Address>" "<Language>"
    When when user calls "AddPlaceAPI" with "POST" http Request	
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Validate "<Name>" after user calls "GetPlaceAPI" http Request is correct. 
		
		Examples:
		|Name  |Address |Language |
		|Shree |Jabalpur|Udhami   |
#		|Anurag|Sagar   |Love			|

@DeletePlaceAPI @Regression
Scenario: verify place is deleted successfully using DeletePlace using API
    Given delete Place Payload DeletePlaceAPI
    When when user calls "DeletePlaceAPI" with "POST" http Request	
    Then the API call is success with status code 200
  

