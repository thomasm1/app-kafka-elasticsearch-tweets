Feature: comments feature api

  Background: background
#
#    * url 'http://34.199.129.2:8888/api'
    * url 'http://localhost:8888/'
    * def pathstart = 'api/'
#    * url baseUrl

  Scenario Outline: '<_path>'
    Given path pathstart + '<_path>' +  '<_var1>'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:/
      | _path     | _meth | _stat | _var1  | _var2 | _var3 |
      | posts | GET   | 200   |        |       |       |
      | posts | GET   | 200   | /10002 |       |       |

      | categories    | GET   | 200   |        |       |       |
      | categories    | GET   | 200   | /11501 |       |       |

      | coins    | GET   | 200   |        |       |       |
      | coins    | GET   | 200   | /11501 |       |       |

      | users     | GET   | 200   |        |       |       |
      | users     | GET   | 200   | /211   |       |       |

      | weblinks      | GET   | 200   |        |       |       |
      | weblinks      | GET   | 200   | /4002  |       |       |


  Scenario Outline: '<_path>' FOR KEYS
    Given def pathstart = "login/"
    And path pathstart + '<_path>'
    When method <_meth>
    Then status <_stat>
    * json res = response
    * def payload = res.data
    * print payload

    Examples:/
      | _path          | _meth | _stat | _var1 | _var2 | _var3 |
      | getMoralisApi  | GET   | 200   |       |       |       |
      | getNasaApi     | GET   | 200   |       |       |       |
      | getGoogleApi   | GET   | 200   |       |       |       |
      | getFirebaseApi | GET   | 200   |       |       |       |
      | getNytApi      | GET   | 200   |       |       |       |
      | getOpenAiAPI   | GET   | 200   |       |       |       |
