# Created by tony at 25/05/2023
Feature: Create a capability
  Create a capability and associate the capability with general skill sets

  Scenario: Create a new capability along with a description
    Given I am provided with a new capability that the team needs to address
    When I am provided with a name and description
    Then I should check if the capability exists before I add a new entry in the database

