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

  @api
  @first_currency_info
    Scenario Outline:
    Given user request the cryptocurrency ID of <CurrencyId> displayed
    Then the displayed data should show tags that contain mineable
    And the displayed name of the currency should be <CurrencyName>
    Examples:
    |CurrencyId|CurrencyName|
    |1         |Bitcoin     |
    |2         |Litecoin    |
    |3         |Namecoin    |
    |4         |Terracoin   |
    |5         |Peercoin    |
    |6         |Novacoin    |
    |7         |Devcoin     |
    |8         |Feathercoin |
    |9         |Mincoin     |
    |10        |Freicoin    |


