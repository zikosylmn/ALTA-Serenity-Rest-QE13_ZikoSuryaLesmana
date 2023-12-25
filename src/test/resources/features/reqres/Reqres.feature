Feature: Serenity Rest QE 13 ....
  @Latihan
  Scenario Outline: Get list user with valid param page
    Given Get list users with page <page>
    When Send request get list users
    Then Status code should be 200
    And Response body page should be <page>
    And Validate get list users json schema "ListUsersSchema.json"
    Examples:
    |page|
    |1   |
    |2   |

    @Latihan
    Scenario: Post create user with valid json
      Given Post create user with valid json "CreateUser.json"
      When Post request post create user
      Then Status code should be 201
      And Response body name was "ziko" and job was "manager"
      And Validate create user json schema "CreateUserSchema.json"

#      @Latihan
#      Scenario Outline: Update user with valid id and json
#        Given Update user with valid <id> and json "<json>"
#        When Send request update user
#        Then Status code should be 200
#        And Response body name was "<name>" and job was "<job>"
#        And Validate update user json schema "UpdateUserSchema.json"
#        Examples:
#        |id|json             |name          |job  |
#        |1 |UpdateUser.json  |lagi-lagi ziko|CEO  |
#        |2 |UpdateUser2.json |ziko lagi nih |Owner|

        @Latihan
        Scenario Outline: Delete user with valid id
          Given Delete user with valid id <id>
          When Send request delete user
          Then Status code should be 204
          Examples:
          |id|
          |1 |
          |2 |