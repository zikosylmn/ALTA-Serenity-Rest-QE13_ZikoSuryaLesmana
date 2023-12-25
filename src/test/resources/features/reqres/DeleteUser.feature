Feature: Delete User
    @Task
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204
    Examples:
      | id |
      | 1  |
      | 2  |

  @Task
  Scenario Outline: Delete user with id more than data have
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 404
    Examples:
      | id |
      | 20 |
      | 30 |

  @Task
  Scenario Outline: Delete user with id using chara
    Given Delete user with id "<id>" using chara
    When Send request delete user
    Then Status code should be 400
    Examples:
      | id       |
      | tengteng   |
      | tungtung |