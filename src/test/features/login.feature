Feature: Login on nopCommerce

  Scenario Outline: Successful Login with Valid Credentials
    Given User is on Login Page
    When User enters "<username>" and "<password>"
    And User click on Login Button
    Then The account option should be displayed
    Examples:
     | username  | password |
     | jgg0325+pa2@gmail.com | Pa5S321 |
     | admin | Admin321 |