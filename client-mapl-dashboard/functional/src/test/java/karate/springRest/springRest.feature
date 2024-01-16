Feature: Spring REST feature api

  Background: background
#
#    * url 'http://34.199.129.2:8888/'
    * url 'http://localhost:8888/'
#    * url baseUrl

  Scenario Outline: Spring REST Framework
    Given path 'rest/' + '<_PATH>'
    When method <METHOD>
    Then status <STATUS>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:
      | _PATH       | METHOD | STATUS | VAR_3    | VAR_   |
      | user        | GET    | 200    | "VA>R_3" | "VAR_" |
      | role        | GET    | 200    | "VA>R_3" | "VAR_" |
      | offer       | GET    | 200    | "VA>R_3" | "VAR_" |
      | offer_logic | GET    | 200    | "VA>R_3" | "VAR_" |
      | post        | GET    | 200    | "VA>R_3" | "VAR_" |
      | comment     | GET    | 200    | "VA>R_3" | "VAR_" |
      | coin        | GET    | 200    | "VA>R_3" | "VAR_" |
      | author      | GET    | 200    | "VA>R_3" | "VAR_" |
#      | book        | GET    | 200    | "VA>R_3" | "VAR_" |
      | weblink     | GET    | 200    | "VA>R_3" | "VAR_" |


