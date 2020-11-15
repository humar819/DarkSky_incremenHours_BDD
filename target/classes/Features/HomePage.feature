@web
Feature: Dark Sky Home Page Feature

  @homepage

  Scenario: Verify timeline is displayed in correct format
      Given I am on the Dark Sky home page
      When I enter city into search text field on home screen
      And I verify city’s time zone
      Then I verify timeline is displayed with two hours incremented

