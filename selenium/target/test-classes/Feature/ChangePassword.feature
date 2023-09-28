Feature: Change password

  @CHPA001 @MYD-197 @Regression @Sanity @Patient @ChangePassword
  Scenario Outline: Checking the functionality of change password page with satisfied rules
    Given user logs in with <Role> credentials
    And user navigates to <Page_Type>
    When user enters value <Current_Password> in the current password input field
    And user enters value <New_Password> in the new password input field
    And user enters value <Confirm_Password> in confirm_password input field
#    And user clicks on submit button
#    Then user can view <Message>
    Examples:
      | Role    | Page_Type       | Current_Password | New_Password | Confirm_Password | Message                       |
      | Patient | Change Password | Asdx@34v         | Asdx@34vs     | Asdx@34vs       | Password changes successfully |

  @CHPA002 @MYD-197 @Regression @Patient @ChangePassword
  Scenario Outline: Checking the functionality of change password page with unsatisfied rules
    Given user logs in with <Role> credentials
    And user navigates to <Page Type>
    And user enters value <Current Password> in the current password input field
    And user enters value <New Password> in the new password input field
    And user enters value <Confirm_Password> in confirm_password input field
    Then user can view the message <Error_Message>
    Examples:
      | Role    | Page Type       | Current Password | New Password | Confirm_Password | Error_Message                  |
      | Patient | Change Password | Aaravsh#123      | Alp@1        | Alp@1            | At least six characters        |
      | Patient | Change Password | Aaravsh#123      | Alpha123     | Alpha123         | At least one special character |
      | Patient | Change Password | Aaravsh#123      | ALPHA@12     | ALPHA@12         | A lowercase letter             |
      | Patient | Change Password | Aaravsh#123      | alpha@123    | alpha@123        | An uppercase letter            |
      | Patient | Change Password | Aaravsh#123      | Alpha@12     | Aarav@123        | Passwords must match           |
      | Patient | Change Password | Aaravsh#123      | Alpha@#$     | Aarav@#$         | At least one number            |


  @CHPA003 @MYD-197 @Regression @Patient @ChangePassword
  Scenario Outline: Checking the functionality of change password page with invalid data
    Given user logs in with <Role> credentials
    And user navigates to <Page Type>
    And user enters value <Current Password> in the current password input field
    And user enters value <New Password> in the new password input field
    And user enters value <Confirm_Password> in confirm_password input field
    Then user can view the message <Error Message>
    Examples:
      | Role    | Page Type       | Current Password | New Password | Confirm_Password | Error Message                                  |
      | Patient | Change Password | aaravsh#123      | Aarav@123    | Aarav@123        | Failed to change password                      |
      | Patient | Change Password | Aaravsh#123      | Aaravsh#123  | Aaravsh#123      | Current Password can't be same as New Password |

