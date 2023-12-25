Feature: Register User
  @Task
  Scenario: Post register user successful
    Given Post register with valid data on json "RegisterUser.json"
    When Send request register user
    Then Status code register user should be 200

    @Task
    Scenario: Register user without email
      Given Post register with invalid data on json "RegisterUserInvalid.json"
      When Send request register user
      Then Status code should be 400

  @Task
  Scenario: Register user without password
    Given Post register with invalid data on json "RegisterUserInvalid1.json"
    When Send request register user
    Then Status code should be 400