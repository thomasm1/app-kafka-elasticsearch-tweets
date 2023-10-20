Feature: categories feature api

  Background: background
#
#    * url 'http://34.199.129.2:8888/api'
    * url 'http://localhost:8888/api/'
#    * url baseUrl

  Scenario Outline: 'posts/category/367'
    Given path 'categories/367'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _path     | _meth | _stat | _var1 | _var2 | _var3 |

      | categories | GET   | 200   |   |   |   |
#      | categories | GET   | 200   | /11501    |   |   |

#  Scenario Outline: 'categories/367'
#    Given path 'category/367'
#    When method <_meth>
#    Then status <_stat>
#    * json res = response
#    * def payload = res.data
#    * print payload
#
#    Examples:
#      | _path     | _meth | _stat | _var1 | _var2 | _var3 |
#
#      | categories | GET   | 200   |   |   |   |
#      | categories | GET   | 200   | /11501    |   |   |

