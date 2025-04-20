
Feature: To send the get request with JWT token
    Background:
#    * url 'http://52.3.58.191:8083/api'
#    * url 'http://localhost:8083/api/'
#* configure karate.baseUrl = karate.properties['baseUrl']

    * url baseUrl + '/api/users'



  Scenario: Send the GET request with JWT token
    * path '/auth/login'
    * def token = call read('utils/getToken.feature')
  #{ username: '#(username)',  password: '#(password)' }
    Given url baseUrl + '/auth/login'
    And headers {Accept:'application/json',Authorization:'#("Bearer " + token.accessToken)'}
    When method get
    Then status 200

  Scenario: Send the GET request without JWT token
    * path '/auth/login'
    And headers {Accept:'application/json'}
    When method get
    Then status 401