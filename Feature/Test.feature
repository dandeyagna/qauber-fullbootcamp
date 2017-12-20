Feature:Wave Project tests with cucumber

  Scenario Outline: Selecting Identifiers
    Given User is on the Home Page
    When Click AddReportBtn, select entity and Provide personal information and click nextBtn"<caseId>""<lastName>""<firstName>" and Select identifiers "<Tattoos>""<Scars>""<NeedleMarks>""<Tracks>""<Glasses>""<Mustache>""<Beard>" and Provide location of stop and Click nextBtn "<locationOfStop>" and Publish report
    Then Assert Identifier is saved is published report"<caseId>""<Tattoos>""<Scars>""<NeedleMarks>""<Tracks>""<Glasses>""<Mustache>""<Beard>"
  Examples:
| caseId | lastName | firstName | Tattoos | Scars      | NeedleMarks | Tracks  | Glasses | Mustache | Beard | locationOfStop |
| 111000 |sam       | jhon      | Dragon  |            |             |         |         |          |       | Santa clara    |
| 111001 |jhon      | nathin    |         | Black mark |             |         |         |          |       | Santa clara    |
| 111002 |sunny     | lion      |         |            |    on leg   |         |         |          |       | Santa clara    |
| 111003 |sam       | jhon      |         |            |             | on hand |         |          |       | Santa clara    |
| 111004 |jhon      | nathin    |         |            |             |         |  yes    |          |       | Santa clara    |
| 111005 |sunny     | lion      |         |            |             |         |         |   yes    |       | Santa clara    |
| 111006 |sunny     | lion      |         |            |             |         |         |          | yes   | Santa clara    |
| 111007 |lincon    | londan    | spider  | hello      | yes         |  yes    |  yes    |   yes    |  yes  | Santa clara    |
| 111008 |smitha    | raj       |         |            |             |         |         |          |       | Santa Jose     |
