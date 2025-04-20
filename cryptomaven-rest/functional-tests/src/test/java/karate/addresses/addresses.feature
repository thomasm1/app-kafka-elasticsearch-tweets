Feature: chains feature api

  Background: background
#    * url 'http://52.3.58.191:8083/api'
#    * url 'http://localhost:8083/api/'
#    Given def baseUrl =  config.baseUrl
#
    * url baseUrl + '/api/'


  Scenario Outline:
    Given path '<_path>' + '<_var1>'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _path     | _meth | _stat | _var1      | _var2 | _var3 |
      | addresses | GET   | 200   | /20        |       |       |
      | addresses | GET   | 200   |            |       |       |
      | addresses | GET   | 200   | /20/chains |       |       |
#      | addresses | PUT   | 201   |/10000    |   |   |
#      | addresses | POST   | 201   |   |   |   |
#      | addresses | PATCH   | 201   |/10000    |   |   |
#      | addresses | DELETE   | 200   |/10000    |   |   |
