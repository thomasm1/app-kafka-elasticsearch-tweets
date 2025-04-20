Feature: chains feature api

  Background: background

#    * url 'http://52.3.58.191:8083/api'
#    * url 'http://localhost:8083/api/'
#
    * url baseUrl + '/api/'



  Scenario Outline: '<_path>'
    Given path '<_path>' + '<_var1>'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _path     | _meth | _stat | _var1 | _var2 | _var3 |
      | addresses | GET   | 200   |       |       |       |
      | addresses | GET   | 200   | /20   |       |       |

      | chains    | GET   | 200   |       |       |       |
      | chains    | GET   | 200   | /30   |       |       |

      | users     | GET   | 200   |       |       |       |
      | users     | GET   | 200   | /11   |       |       |

      | coins     | GET   | 200   |       |       |       |
      | coins     | GET   | 200   | /40   |       |       |

      | nftCoins  | GET   | 200   |       |       |       |
      | nftCoins  | GET   | 200   | /70   |       |       |