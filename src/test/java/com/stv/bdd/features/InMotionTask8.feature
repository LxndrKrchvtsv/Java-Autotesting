@task8
Feature: InMotion Hosting Advanced Interactions

  Background:
    Given The user is on the InMotion Hosting main page

  Scenario: Contact Us navigation and browser back button
    When The user checks the tooltip of the Contact Us menu item
    And  The user clicks on the Contact Us menu item
    And The dropdown menu should be displayed
    And The user selects Contact Us from the dropdown
    Then The Contact Us page is displayed with the correct URL
    When The user navigates back using the browser button
    Then The Main page is displayed correctly

  Scenario: Talk With an Expert interaction
    When The user clicks "Talk With an Expert" on Main page
    Then The expert window should be displayed
    And The user tries to close it by clicking "Talk With an Expert" again
    And The user closes the expert window via browser close button