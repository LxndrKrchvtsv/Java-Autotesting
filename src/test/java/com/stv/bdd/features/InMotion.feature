Feature: InMotion Hosting UI Tests

  Background:
    Given The user is on the InMotion Hosting main page
    And The user accepts cookies if they appear

  Scenario: Verify Contact Us dropdown visibility
    When The user clicks on the Contact Us menu item
    Then The dropdown menu should be displayed

  Scenario Outline: Verify navigation to different hosting pages
    When The user clicks on the "<hosting_type>" link
    Then The page title should contain "<expected_title>"

    Examples:
      | hosting_type      | expected_title    |
      | Blog              | Blog              |
      | VPS Hosting       | VPS               |
      | Dedicated Servers | Dedicated Servers |