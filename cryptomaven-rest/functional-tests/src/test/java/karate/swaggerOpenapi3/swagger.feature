Feature: health and actuator endoints

  Background: background
#    * url 'http://52.3.58.191:8083/api'
#    * url 'http://localhost:8083/api/'

    * url baseUrl + '/api/'



  Scenario Outline:
    Given path '<_path>'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload


    Examples:
      | _path     | _meth | _stat | _var1 | _var2 | _var3 |

#      | /v3/api-docs | GET   | 200   |   |   |   |
#      |/swagger-ui.html| GET   | 200   |   |   |   |

