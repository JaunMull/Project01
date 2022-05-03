Feature: Login Action

  #Scenario: Successful Login with Valid Credentials
  Scenario Outline: Successful login Valid Creditials using Scenario
    Given User is on Home Page
    When User Navigate to LogIn Page
    Then User enters "<Username>" and "<Password>"
    And User clicks form
    Then User files reimbursement "<Id>" and "<Name>" and "<Amount>" and "<Reason>"
    And User clicks cancel
    And User clicks form2
    Then check submitted forms
    Then Message displayed Login Successfully
    Examples:
      |Username     |Password |Id     |Name                 |Amount   |Reason                                 |FormId   |
      |JaunMull     |Jau3422  |1      |Jaunzel Mullins      |100      |For I have fallen and cannot get up    |1        |
      |Dagoat       |goncon   |2      |Deagon Deacon        |350      |Its my money and I need it now         |2        |
      |Joward       |Squidward|3      |Josh Edwards         |50       |Business Dinner                        |3        |