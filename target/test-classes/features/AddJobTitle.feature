Feature: Add Job Title
  @db2
  Scenario: Adding job titles
    Given user is logged in with valid admin credentials
    When user navigages to the admin tab
    And user clicks on job titles under the job dd
    And user clicks on ‘add’ button
    When user enters job title "Pool Party" within textbox
    And user enters job description "fake desc" within textbox
    And user enters note "fake note" within textbox
    And user clicks ’Save’ button
    And query hrms database for jobtitle
    Then job title specified will display on front and backend
