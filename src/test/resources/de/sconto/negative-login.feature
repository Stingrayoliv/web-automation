@login
Feature: Sconto login

  Scenario Outline: Negative Login
    Given I am on the Loginpage
    When I insert email <email>
    And I insert password <password>
    And I click on Login button
    Then I see message:
 """
 <error>
 """
    Examples:
      | email         | password | error                                             |
      | test@test.com | 66666    | Benutzername nicht gefunden oder Passwort falsch. |
      |               | 77777    | Bitte geben Sie Ihre E-Mail-Adresse ein           |

