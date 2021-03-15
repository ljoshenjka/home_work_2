@testSuite
@favourites
Feature: Adding ad to memo as a favorite

  Scenario: Add ad to favourites
    Given user opens website
    When user opens 'Cars' category from Transport page
    And user opens 'BMW' category from Cars page
    And user opens first ad from list