Feature: Back end scenarios are here
  As a user
  I want to run these tests
  So I can rest

  @api
  @price_conversion
  Scenario Outline: Should be able to convert the price of a retrieved cryptocurrency via id to a specified currency
    Given user makes map request to retrieve id for <cryptocurrency>
    When user converts the amount of 1000 to currency Bolivian Boliviano
    Then the conversion should be successful
    Examples:
    |cryptocurrency|
    |BTC           |
    |USDT          |
    |ETH           |

  @api
  @cryptocurrency_info
  Scenario: Verify items on currency
    Given user request the cryptocurrency ID of 1027 displayed
    Then the logo information should contain https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png
    And the urls.technical_doc information should contain https://github.com/ethereum/wiki/wiki/White-Paper
    And the symbol information should contain ETH
    And the date_added information should contain 2015-08-07T00:00:00.000Z
    And the platform information should be empty
    Then the tags information should contain mineable


