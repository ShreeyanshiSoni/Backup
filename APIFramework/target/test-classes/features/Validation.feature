

Feature: Validation Place API

  Scenario: Verify if place is being successfully added using AddPlace API
    Given Add Place Payload
    When when user calls AddPlaceAPI with Post http Request	
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
		 


