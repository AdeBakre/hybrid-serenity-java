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

  @uitasktwo
  Scenario: Verify items that are added to watchlist in different tab
    And user added a random number of crypto-currencies to the watchlist
    When user clicks on the watchlist in a different tab
    Then user should see the items previously added on the watchlist page

    @uitaskthree
    Scenario: Verify comparisons of filters against full list option
      And user selects the Full list option
      When user applies the filter for Market Cap by Total Supply
      Then the result displayed on the page should be different from full list option


