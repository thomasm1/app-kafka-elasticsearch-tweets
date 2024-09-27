@ignore
Feature: To send the get request with JWT token
  GET   Given url 'http://localhost:8080/api/auth/login'

  Scenario: Send the GET request with JWT token
    * def token = call read('utils/getToken.feature') {username:'thomas1.maestas@gmail.com',password:'password'}
    Given url 'http://localhost:8080/api/auth/login'
    And headers {Accept:'application/json',Authorization:'#("Bearer " + token.authToken)'}
    When method get
    Then status 200

  Scenario: Send the GET request with JWT token
    Given url 'http://localhost:8080/api/auth/login'
    And headers {Accept:'application/json'}
    When method get
    Then status 401
