Feature: Get List Resource
  @Task
  Scenario: Get list resource successfull
    Given Get list resource
    When When send request get list resource
    Then Status code get list resource should be 200
    And Validate get list resource json schema "ListResourceSchema.json"
