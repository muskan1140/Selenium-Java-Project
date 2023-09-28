#Feature: Doctor Registration

#  @DORE001 @Sanity @Automated @Regression @DoctorRegistration @Doctor
#  Scenario Outline:User navigates to the Doctor Registration and signs up
#    Given user navigates to the <Page Type> page
#    When user enters value <Name> in the full name input field
#    And user selects checkbox with value <Gender_Type>
#    And user enters value <Email> in the email input field
#    And user enters value <Mobile_Number> in the mobile number input field
#    And user enters value <Password> in the create password input field
#    And user enters value <Password> in the confirm password input field
#    When user clicks on the register button
#    Then user can view message <Registration_Message>
#    Examples:
#      | Name         | Email                 | Mobile_Number | Password    | Gender_Type | Page Type           | Registration_Message    |
#      | Hunter Brown | hunterbrows@gmail.com | 9041508299    | 9797@Qwerty | Male        | Doctor Registration | Signed up successfully! |

#  @DORE002 @DoctorRegistration @Regression @Automated @Doctor
#  Scenario Outline:User navigates to the Doctor Registration and signs up with invalid data
#    Given user navigates to the <Page Type> page
#    When user enters value <Name> in the full name input field
#    And user selects checkbox with value <Gender_Type>
#    And user enters value <Email> in the email input field
#    And user enters value <Mobile_Number> in the mobile number input field
#    And user enters value <Password> in the create password input field
#    Then user can view message the <Error_Message>
#    Examples:
#      | Name  | Email       | Mobile_Number| Page Type           | Error_Message                                | Password | Gender_Type |
#      | sam.1 | abc@abc.com | 9541108298   | Doctor Registration | Please enter a valid name!                   | Alp@1    | Male        |
#      | sam+- | abc@abc.com | 9876543211   | Doctor Registration | Please enter a valid name!                   | Alp@1    | Male        |
#      | sam   | ab.com      | 9541108297   | Doctor Registration | Please enter a valid e-mail address!         | Alp@1    | Male        |
#      | sam   | .com        | 9876543211   | Doctor Registration | Please enter a valid e-mail address!         | Alp@1    | Male        |
#      | sam   | abc@abc.com | 954110829    | Doctor Registration | Please enter a valid 10-digit mobile number! | Alp@1    | Male        |
#      | sam   | abc@abc.com | 987654315    | Doctor Registration | Please enter a valid 10-digit mobile number! | Alp@1    | Male        |

#  @DORE003 @DoctorRegistration @Regression @Automated @Doctor
#  Scenario Outline:User is not able to register with invalid password
#    Given user navigates to the <Page Type> page
#    When user enters value <Name> in the full name input field
#    And user selects checkbox with value <GenderType>
#    And user enters value <Email> in the email input field
#    And user enters value <Mobile Number> in the mobile number input field
#    And user enters value <Password> in the create password input field
#    And user enters value <Password> in the confirm password input field
#    Then user can view message the <Rule>
#    Examples:
#      | Name      | Mobile Number | GenderType | Email       | Password       | Rule                                         | Page Type           |
#      | Test User | 9076043211    | Male       | abc@abc.com | Alp@1          |Must contain at least 6 characters.           | Doctor Registration |
#      | Test User | 9076043211    | Male       | abc@abc.com | Alpha123       | Must contain at least one special character. | Doctor Registration |
#      | Test User | 9076043211    | Male       | abc@abc.com | alpha@123      | Must contain uppercase letter.               | Doctor Registration |
#      | Test User | 9076043211    | Male       | abc@abc.com | ALPHA@12       | Must contain lowercase letter.               | Doctor Registration |
#      | Test User | 9076043211    | Male       | abc@abc.com | Alphaitsystems | Must contain at least one number.            | Doctor Registration |
#      | Test User | 9076043211    | Male       | abc@abc.com | Alpha@12       | Passwords must match.                        | Doctor Registration |


#  @DORE004 @DoctorRegistration @Regression @Automated @Doctor
#  Scenario Outline:User is not able to register with existing mobile number & email
#    Given user navigates to the <Page Type> page
#    When user enters value <Name> in the full name input field
#    And user selects checkbox with value <Gender Type>
#    And user enters value <Email> in the email input field
#    And user enters value <Mobile Number> in the mobile number input field
#    And user enters value <Password> in the create password input field
#    And user enters value <Password> in the confirm password input field
#    When user clicks on the register button
#    Then user can view message Signed up successfully!
#    And user enters value <Mobile Number> in the mobile number input field
#    And user enters value <Email> in the email input field
#    Then user can view message the <Error Message>
#    Examples:
#      | Name         | Email                   | Mobile Number | Password    | Gender Type | Email              | Mobile Number | Page Type           | Error Message                 |
#      | Hunter Brown | hunterbrowness@gmail.com| 9592308298    | 9797@Qwerty | Male        | test@testuser1.com | 9541308298    | Doctor Registration | Mobile number already exists! |
#      | Hunter Brown | test@testuser.com       | 9541108299    | 9797@Qwerty | Male        | test@testuser.com  | 9541308295    | Doctor Registration | Email already exists!         |