
Feature: DarkSky Register Page Feature

  @register


    Scenario: Verify error message after logging in with invalid credentials

     Given I am on the darksky home page
     When  I select Dark Sky API option and Login button
     Then I am on Dark Sky Register page
     And  I enter abc@gmail.com into email text fields on login page
     And   I enter password1 into password text fields on login page
     And   I click submit button
     Then  I verify error message “password and username does not match”


