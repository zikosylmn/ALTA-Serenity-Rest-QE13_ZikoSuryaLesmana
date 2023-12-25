Feature: Get Single User
  @Task
  Scenario Outline: Get single user with valid id and body response and json schema
    Given Get single user with id <id>
    When Send request get single user
    Then Status code get single user should be 200
    And Response body data should be <id>
    And Validate get single user json schema "SingleUserSchema.json"
    Examples:
    |id|
    |2 |

    @Task
    Scenario: Get single user with invalid id using character
      Given Get single user with invalid id "0satu"
      When Send request get single user
      Then Status code get single user should be 404

      @Task
      Scenario: Get single user using special character
        Given Get single user with invalid id "0satu@**"
        When Send request get single user
        Then Status code get single user should be 404