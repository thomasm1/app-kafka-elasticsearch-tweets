Feature: Spring REST feature api health,info,env,metrics,loggers,auditevents,httptrace

  Background: background
#    * url 'http://52.3.58.191:8083/api'
#    * url 'http://localhost:8083/api/'


    * url baseUrl



  Scenario Outline: Spring REST Framework
    Given path 'actuator/' + '<_PATH>'
    When method get
    Then status 200
    * json res = response
    * def payload = res.data
#    * print payload

#  health,info,env,metrics,loggers
    Examples:
      | _PATH       | VAR_1   | VAR_2   | VAR_3   | VAR_   |
      | health      | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | info        | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | env         | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | metrics     | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |
      | loggers     | "VAR_1" | "VAR_2" | "VAR_3" | "VAR_" |




