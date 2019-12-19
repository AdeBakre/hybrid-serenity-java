Feature: Front end scenarios are here

  As a man that needs a job
  I want to pass these tests
  So I can provide for my family

  Background:
    Given user is on the main page


  @uitaskone
  Scenario: Verify the number of results displayed
    When user clicks on view all
    Then user should see results for '100' currencies

  @uitasktwo
  Scenario: Verify items that are added to watchlist in different tab
    And user added a number of cryptocurrencies to the watchlist
    When user clicks on the watchlist in a different tab
    Then user should see the items previously added on the watchlist page

    @uitaskthree
    Scenario : Verify comparisons of filters against full list option
      And user selects the Full list option
      When user applies the filter for Market Cap by Total Supply
      Then the result displayed on the page should be different from full list option


