Feature: Login

    @simpletest
    Scenario: valid admin login
    When user enters valid admin username and password
    And user click on login button
    Then admin user is successfully logged in

    @regression
  Scenario: valid ess employee login
    When user enter valid ess username and password
    And user click on login button
    Then ess user is successfully logged in

  @smoke
  Scenario: login with valid username and invalid password
    When user enters valid username and invalid password
    And user click on login button
    Then user see invalid credentials text on login page


  @example
  Scenario Outline: login with multiple data
    When user enters "<username>" and "<password>"
    And user click on login button
    And "<firstname>" is successfully logged in

    Examples:
      |username         |password   |firstname|
      |Admin            |Hum@nhrm123|  Admin  |
      |william1236000000|Syntax12!!!!|William |




