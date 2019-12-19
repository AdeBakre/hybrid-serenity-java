Feature: Back end scenarios are here


  @backend
  @taskone
  Scenario: User converts currencies to bolivian boliviano
    Given user makes request to get all currency maps
    And user retrieves id for following currencies
    |Currency|
    |bitcoin(BTC)|
    |usd tether(USDT)|
    |Ethereum(ETH)   |
    When user converts each currency to Bolivian Boliviano
    Then the conversion should be successful

  @backend
  @tasktwo
  Scenario: Verify items on currency
    Given user makes request to get currency info for 'ID 1027'
    Then the user should confirm the following
   |Logo_url|technical_doc_uri|symbol|date_added|platform|tag|
   |logo    |https://github.com/ethereum/wiki/wiki/White-Paper|ETH|2015-08-2015-08-07T00:00:00.000Z|null|mineable|

  @backend @taskthree
  Scenario: Verify the tags for the first ten currencies on info call
    Given user makes request for info call
    When user checks the currencies with mineable tags
    Then the correct currencies should be printed out