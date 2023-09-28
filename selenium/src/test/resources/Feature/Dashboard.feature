Feature: Dashboard

  @DA001 @Regression @Automated @Dashboard @Patient @MYD-76
  Scenario Outline: Checking the visibility of UI element
    Given user navigates to <Page_Type> page
    And the corresponding page appears with the expected elements: <Item>

  Examples:
  | Page_Type | Item                           |
  | Homepage  | 20+ Specialities, 280+ Doctors |

#  @DA002 @Regression @Sanity @Automated @Dashboard @SpecialitiesCard @Patient @MYD-76
#  Scenario Outline: Check the functionality of Specialities Card
#    Given user navigates to <Page Type> page
#    When user clicks on the <Speciality_Card> card
#    Then the corresponding page appear with expected elements: <Item>
#
#  Examples:
#  | Page Type | Speciality_Card                | Item                                       |
#  | Homepage  | Cardiac Surgery                | Showing results for : 'Cardiac Surgery'    |
#  | Homepage  | Clinical Nutrition & Dietetics | Showing results for : 'Clinical Nutrition '|


#  @DA003 @Regression @Automated @Dashboard @SpecialitiesCard @Patient @MYD-76
#  Scenario Outline: Check the functionality of View all specialities link
#    Given user navigates to <Page Type> page
#    When user clicks on view all specialities link
#    Then the corresponding page appears with the expected elements: <Item>
#
#  Examples:
#  | Page Type | Item                                                         |
#  | Homepage  | Dermatology, Dental, Bone Marrow, Cardiac Surgery, Audiology |

#  @DA004 @Regression @Sanity @Automated @Dashboard @DoctorCard @Patient @MYD-76
#  Scenario Outline: Check the functionality of Doctor card
#    Given user navigates to <Page_Type> page
#    When user clicks on the <Doctor Card> card
#    Then the corresponding page appears with the expected elements: <Item>
#
#  Examples:
#  | Page_Type | Doctor Card | Item                                                                    |
#  | Homepage  | Dr. Dusty Huel       | Consultation Fee: Rs. 3022, Specialities, Experience, Languages|


#  @DA005 @Regression @Automated @Dashboard @Pagination @Patient @MYD-31
#  Scenario Outline: Check the functionality of pagination on Doctor cards by clicking on number
#    Given user navigates to <Page Type> page
#    And user can view list of doctor cards
#    And user is on <Page> page
#    When user clicks on the <Button> button
#    Then user is on <Value> page
#
#    Examples:
#      | Page Type | Page | Button | Value |
#      | Homepage  | 1    | 2      | 2     |