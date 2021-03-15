Feature: Glovo sing up

  Scenario: Positive sign up test
    Given I am on the SingUpPage page
    When I accept cookies
    And I insert user credentials:
      | name | email          | password |
      | Lora5 | lora@gmail.com | London1. |
    And I click on button Signup
    Then I see PrivacyPage
    When I click on checkbox
    And I click on button Continue
    Then I see account creation message


