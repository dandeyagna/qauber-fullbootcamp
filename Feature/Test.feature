Feature: Wave Project tests with cucumber

  Scenario Outline: Successful Login with Valid Credentials
    Given User is on Home Page
    When User enters "<username>" and "<password>"
    Then Message displayed Login Successfully
    Examples:
      | username            | password |
      | buquxahu@cars2.club | kisulea  |

  Scenario: Update user name
    Given User is logged into application
    When Click on user's link
    And Click on editProfile button
    And Type name into Name textInput field
    And Click update Button
    Then Successful message is displayed

  Scenario:Update company information
    Given User is logged into application
    When Type all required fields
    Then Successfully updated company info

  Scenario Outline:Create new Entity
    #this test sometime fails.Need to add more thread.sleap(probably)
    Given User is logged into application
    When Type required fields "<name>", "<country>", "<address1>", "<city>", "<state>", "<zip>", "<phone>", "<email>", "<RUemail>", "<AUemail>" and pay subscription
    Then Successful paymant message is displayed
    Examples:
      | name      | country | address1     | city  | state | zip   | phone      | email           | RUemail          | AUemail        |
      | Entity981 | US      | 123 easy rd. | Tampa | NJ    | 56787 | 8789878988 | cosmo@gmail.com | seccer@gmail.com | Cuma@gmail.com |

  Scenario Outline:Change password
    Given User is logged into application
    When Change password positive "<currentPassword>","<newPassword>","<repeatNewPassword>"
    Then Password is updated message is displayed
    Examples:
      | currentPassword | newPassword | repeatNewPassword |
      | kisulea         | kisulea     | kisulea           |

  Scenario Outline: Search reports using id
    Given User is logged into application
    When Search report by "<id>"
    Then correct report is opened
    Examples:
      | id  |
      | 780 |


  Scenario Outline: Add report scenario
    Given User is logged into application
    When Click AddReportBtn, select entity and click nextBtn
    And Provide personal information and click nextBtn, Select identifiers and click next "<caseId>""<suspectType>""<lastName>""<firstName>""<middleName>""<nickname>""<dob>""<sex>""<race>""<height>""<weight>""<hairColor>""<hairLength>""<hairStyle>""<eyeColor>""<complexion>""<teeth>""<handPreference>""<language>""<streetAddress>""<country>""<city>""<state>""<zip>""<phone>""<email>"
    And Provide id, school and other information.Click nextBtn "<ssn>""<driverLicenseN>""<idState>""<otherId>""<otherCountry>""<otherIdState>""<otherIdType>""<schoolName>""<schoolAddress>""<schoolCity>""<schoolState>""<schoolZip>""<schoolPhone>""<parentName>""<parentAddress>""<parentCity>""<parentState>""<parentZip>""<parentPhone>""<occupation>""<employerName>""<employerAddress>""<employerCity>""<employerState>""<employerZip>""<employerPhone>"
    And Provide info about gangMembership.Click nextBtn "<reasonForStop>""<locationOfStop>""<dispositionOfStop>""<gangName>""<howLong>""<otherInformation>""<beat>"
    And Provide Vehicle information and click nextBtn "<vehicleLicense>""<vehicleMake>""<vehicleColor>"
    And Publish report
    Then Assert that report is published "<lastName>""<caseId>"
    Examples:
    #Paramethers for AddReport test
      | caseId | suspectType | lastName | firstName | middleName | nickname | dob      | sex | race    | height | weight | hairColor | hairLength | hairStyle | eyeColor | complexion | teeth   | handPreference | language | streetAddress | country | city  | state | zip   | phone      | email                 | ssn       | driverLicenseN    | idState | otherId  | otherCountry | otherIdState | otherIdType | schoolName | schoolAddress | schoolCity | schoolState | schoolZip | schoolPhone | parentName | parentAddress | parentCity | parentState | parentZip | parentPhone | occupation | employerName | employerAddress | employerCity | employerState | employerZip | employerPhone | reasonForStop | locationOfStop | dispositionOfStop | gangName  | howLong | otherInformation | beat            | vehicleLicense | vehicleMake | vehicleColor |
      | 199    | Suspect     | Christea | Marina    | I          | Mary     | 04271992 | F   | Unknown | 504    | 1000   | BLO       | Short      | Afro      | BLU      | Medium     | Missing | Right          | English  | 123 Main St.  | US      | Tampa | NJ    | 67878 | 6787877877 | marinaEmail@yahoo.com | 123456789 | F255-921-50-094-1 | CA      | RO 12356 | RO           | Kazak        | Passport    | Univers    | 123 mana Rd   | Kana       | CA          | 56776     | 8798879877  | Iurii      | 123 JHGJF St. | dhfahfj    | CA          | 89878     | 67876787666 | Teacher    | Engineer     | 345 main St.    | lara         | NJ            | 87898       | 78987899887   | drank         | Streat         | hdfjhgkj          | hfjhkdfhk | 5 years | hjhjghf          | hfdhgoiahdoijgo | dkjhkj45       | lada        | green        |









