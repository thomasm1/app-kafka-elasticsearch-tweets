Feature: comments feature api

  Background: background
#
#    * url 'http://34.199.129.2:8888/api'
    * url 'http://localhost:8888/api/'
#    * url baseUrl

  Scenario Outline: 'posts/129/comments'
    Given path 'posts/129/comments'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _path     | _meth | _stat | _var1 | _var2 | _var3 |

      | comments | GET   | 200   |   |   |   |
#      | comments | GET   | 200   | /11501    |   |   |



#  Scenario Outline: 'posts/129/comments'
#    Given path 'posts/129/comments'
#    When method <_meth>
#    * request """  {
#  "name":"thomas name129"  ,
#  "email":"thomas@thomas.com",
#  "body": "Wrong set of ideas"
#  } """
#    Then status <_stat>
#    * json res = response
#    * def payload = res.data
#    * print payload
#
#    Examples:
#      | _path     | _meth | _stat | _var1 | _var2 | _var3 |
#
#      | comments | POST   | 200   |   |   |   |
##      | comments | POST   | 200   | /11501    |   |   |
