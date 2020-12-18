Feature: Validating Place API's

  Scenario: Verify if Place is being Successfully adding using AddPlaceAPI
    Given Add Place Payload
    When user calls "AddPlaceAPI" with POST http request
    Then the API call got success with status case 200
    And "Status" in response body is "OK"
    And "Scope" in response body is "APP"


