Feature: Update User
  @Task
  Scenario Outline: Update user with valid id and json
    Given Update user with valid <id> and json "<json>"
    When Send request update user
    Then Status code should be 200
    And Response body name was "<name>" and job was "<job>"
    And Validate update user json schema "UpdateUserSchema.json"
    Examples:
      |id|json             |name          |job  |
      |1 |UpdateUser.json  |lagi-lagi ziko|CEO  |
      |2 |UpdateUser2.json |ziko lagi nih |Owner|