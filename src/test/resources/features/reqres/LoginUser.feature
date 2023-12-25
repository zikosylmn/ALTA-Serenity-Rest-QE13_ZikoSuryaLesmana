Feature: Login User
  @Task
  Scenario: Login user successful
    Given Post login with valid data on json "LoginUser.json"
    When Send request login user
    Then Status code should be 200

  @Task
  Scenario: Login without password
    Given Post login with invalid data on json "LoginUserInvalid.json"
    When Send request login user
    Then Status code should be 400
    And Validate error login json schema "LoginUserErrorSchema.json"