Feature: Login Section

  @Regression @Complete @UI  @Automated
  Scenario Outline: Successfully Login with valid credential
    Given user navigates to the HOMEPAGE
    When user clicks element Login
    And user enters the user <email> in the email input field
    And user enters the user <password> in the password input field
    And user clicks element Login button
    Then user is on the homepage

    Examples:
      | email         | password         |
      | PATIENT_EMAIL | PATIENT_PASSWORD |