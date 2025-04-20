Feature: Login with invalid credentials

  Scenario Outline: Invalid login should show correct error
    Given User is on login page
    When User enters username "<username>" and password "<password>"
    Then Error message "<errorMessage>" should be displayed

    Examples:
      | username        | password     | errorMessage                                                              |
      | standard_user   | wrongpass    | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | wrongpass    | Epic sadface: Sorry, this user has been locked out.                       |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user   |              | Epic sadface: Password is required                                         |

