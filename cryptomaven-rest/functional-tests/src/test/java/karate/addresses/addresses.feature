Feature: chains feature api

  Background: background
#
#    * url 'http://34.199.129.2:8080/api'
    * url 'http://localhost:8080/api/'
#    * url baseUrl

  Scenario Outline:
    Given path '<_path>' + '<_var1>'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _path     | _meth | _stat | _var1 | _var2 | _var3 |
      | addresses | GET   | 200   |/10001    |   |   |
      | addresses | GET   | 200   |   |   |   |
#      | addresses | PUT   | 201   |/10000    |   |   |
#      | addresses | POST   | 201   |   |   |   |
#      | addresses | PATCH   | 201   |/10000    |   |   |
#      | addresses | DELETE   | 200   |/10000    |   |   |
