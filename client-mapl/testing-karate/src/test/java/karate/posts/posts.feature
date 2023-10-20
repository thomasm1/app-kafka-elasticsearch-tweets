Feature: posts feature api

  Background: background
#
#    * url 'http://34.199.129.2:8888/api'
    * url 'http://localhost:8888/api/'
#    * url baseUrl

  Scenario Outline:
    Given path '<_path>' + '<_var1>'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _path | _meth | _stat | _var1  | _var2 | _var3 |
#      | posts | GET   | 200   | /10001 |       |       |
      | posts | GET   | 200   |        |       |       |
#      | posts | PUT   | 201   |/10000    |   |   |
#      | posts | POST   | 201   |   |   |   |
#      | posts | PATCH   | 201   |/10000    |   |   |
#      | posts | DELETE   | 200   |/10000    |   |   |

  Scenario Outline:
    Given path "posts/username/" + '<_USERNAME>'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _path | _meth | _stat | _var1  | _USERNAME | _var3 |
      | posts | GET   | 200   |  | thomasm1.maestas@gmail.com |       |
#      | posts | GET   | 200   |  | admin |       |
      | posts | GET   | 200   |        |           |       |
#      | posts | PUT   | 201   |/10000    |   |   |
#      | posts | POST   | 201   |   |   |   |
#      | posts | PATCH   | 201   |/10000    |   |   |
#      | posts | DELETE   | 200   |/10000    |   |   |


  Scenario Outline:
    Given path   "posts?pageNo=1&pageSize=3&sortBy=did&sortDir=DESC"
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _path | _meth | _stat | _var1 | _var2 | _var3 |
#      | posts | GET   | 200   | /129  |       |       |
      | posts | GET   | 200   |       |       |       |
#      | posts | PUT   | 201   |/129    |   |   |
#      | posts | POST   | 201   |   |   |   |
#      | posts | PATCH   | 201   |/129    |   |   |
#      | posts | DELETE   | 200   |/129    |   |   |
