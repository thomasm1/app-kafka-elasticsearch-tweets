Feature: Spring REST feature api

  Background: background
#
#    * url 'http://34.199.129.2:8080/'
    * url 'http://localhost:8080/'
#    * url baseUrl

  Scenario Outline: Spring REST Framework
    Given path 'rest/' + '<_PATH>'
    When method get
    Then status 200
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _PATH        | VAR_1   | VAR_2   | VAR_3   | VAR_   |
      | user_account | "VAR_1" | "VAR_2" | "VA>R_3" | "VAR_" |


