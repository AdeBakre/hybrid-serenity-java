Feature: Front end scenarios are here

  As a developer
  I want to run these tests
  So I can verify results

  Background:
    Given user is on the main page


  @view_all
  Scenario: Verify the number of results displayed
    When user clicks on view all
    Then user should see results for at least 100 currencies

  @add_to_watchlist
  Scenario: Verify items that are added to watchlist in different tab
    And user added a random number of crypto-currencies to the watchlist
    When user clicks on the Watchlist in a different tab
    Then user should see the items previously added on the watchlist page

    @filter_match_full_list
    Scenario: Verify comparisons of filters against full list option
      And user selects the Full list option from Cryptocurrencies tab
      When user applies the filter for Price
      And user applies the filter for Volume (24h)
      Then the result displayed on the page should be different from full list option


