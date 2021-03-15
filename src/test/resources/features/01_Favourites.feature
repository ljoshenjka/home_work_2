@testSuite
@favourites
Feature: Adding ad to memo as a favourite

  Background: Open Ad
    Given user opens website
    When user opens 'Cars' category from Transport page
    And user opens 'BMW' category from Cars page

  Scenario: Memo count after adding to favourites
    When user opens first ad from list
    And user adds Ad to favourites
    Then checks that Memo count in header is '(1)'

  Scenario: Add to Memo from ad details
    When user opens first ad from list
    And user adds Ad to favourites
    And user opens 'Memo' page
    Then checks that correct Ad is present in Favourites

  Scenario: Add to Memo from ad list
    When user select first ad from list
    And user clicks 'Add to favourites' button on Ad List page
    And user confirm dialog
    And user opens 'Memo' page
    Then checks that correct Ad is present in Favourites

  Scenario: 'Added to favourites' dialog from Ad Details
    When user opens first ad from list
    And user clicks 'Add to favourites' button on Ad Details page
    Then checks that 'Added to favourites' dialog shown

#    Scenario is just for demo purpose to show failing report
  Scenario: 'Added to favourites' dialog from Ad List
    When user select first ad from list
    And user clicks 'Add to favourites' button on Ad List page
    Then checks that 'Added to favourites' dialog shown