Feature: chains feature api

  Background: background
#
#    * url 'http://34.199.129.2:8080/api'
    * url 'http://localhost:8080/api/'
#    * url baseUrl

  Scenario Outline: '<_path>'
    Given path '<_path>' + '<_var1>'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _path     | _meth | _stat | _var1 | _var2 | _var3 |

      | chains | GET   | 200   |   |   |   |
      | chains | GET   | 200   | /11501    |   |   |


