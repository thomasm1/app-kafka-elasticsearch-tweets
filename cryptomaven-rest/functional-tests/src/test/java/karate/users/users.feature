Feature:  users karate test script

  Background:
#    * url 'http://34.199.129.2:8080/api/'
#    * url 'http://localhost:8080/api/'
  * url baseUrl + /api/

  @Order(1)
  Scenario: get all users and then get the first user by id
    Given path 'users'
    When method get
    Then status 200

    * def first = response[0]

    Given path 'users/' + first.userId
    When method get
    Then status 200

  @Order(2)
  Scenario: create a user and then get it by id

    * def rando = Math.floor(Math.random() * 1031)
    * def usernameEmail = "user"+rando+"@gmail.com"
    * def cusUrl = "https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a1.jpg"
    * print "_______________________ID____:" + usernameEmail
    * def user =
      """
  {

  "username": '#(usernameEmail)',
  "password": "$2a$10$j/BATcerSAuRXltl7ee5feXlpmHTJgtaAAhNB.eRxuFz2qjuyv5w6",
  "lastName": "Smith",
  "firstName": "Tom1",
  "userType": 3, 
  "email":'#(usernameEmail)',
  "cusUrl": '#(cusUrl)',
  "isActive": 0,
  "contactType": 1,
  "ROLES": [
  {
  "id": 2,
  "name": "ROLE_ADMIN"
  }
  ]
  }
      """
# 1 CREATE
    Given path '/users'
    And request user
    When method POST
    Then status 200

    * json resp = response
    * def localId = resp.userId

    * print 'created id is: ', localId
#2 READ
    * path 'users/' +  localId
    * print 'user is: ',localId
    When method GET
    Then status 200
    And match response contains user
#3 PUT
    Given path 'users/' + localId
    * print 'user is: ', localId
    * user.userId = localId
    And request user
    When method PUT
    Then status 201
    And match response contains user
  #4 DELETE
    Given path 'users/' + localId
    * print 'user is: ', localId
    When method DELETE
    Then status 200


############################1
  @Order(3)
  Scenario Outline: Update a user, get it by id, verify changes
    * def rando = Math.floor(Math.random() * 100)
    * def cusUrl = "https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a2.jpg"
    * def usernameEmail = "user"+rando+"@gmail.com"
    * print "_______________________ID____" + usernameEmail
    * def user =
      """
  {

      "username": '#(usernameEmail)',
      "password": "$2a$10$j/BATcerSAuRXltl7ee5feXlpmHTJgtaAAhNB.eRxuFz2qjuyv5w6",
      "lastName": "Maestas",
      "firstName": "Tom2",
      "userType": 3,
      "email":'#(usernameEmail)', 
      "cusUrl": '#(cusUrl)',
      "isActive": 0,
      "contactType": 1,
      "ROLES": [
            {
                "id": 1,
                "name": "ROLE_USER"
            }
]
}
      """

    Given path '/users'+ '<newid>'
    And request user
    When method <_meth>
    Then status <_stat>

    * json resp = response
    * def localId = resp.userId
    * def email = resp.email
    * user.email = email
    * def username = resp.username
    * user.username = username
    * def cusUrl = resp.cusUrl
    * user.cusUrl = cusUrl
    * print 'updated   resp.userId]_________: ', localId
    * print 'updated  email is [STILL]_________: ', email
    * print 'updated  username is [STILL]_________: ', username

    Given path '<_path>' +  '<newid>'
    * print 'user is: ', localId
    When method <_meth2>
    Then status <_stat2>

    And match response contains user
    And match response ==
    """
    {"userId":'#number',
    "username":'#string',
    "password":'#string',
    "lastName":'##string',
    "firstName":'##string',
    "userType":'##number',
    "email":'##string',
    "cusUrl":'##string',
    "isActive":'#number',
    "contactType":'##number',
    "ROLES": '#array'
    }
    """
#    [{"id":1,"name":"ROLE_USER"}]

    Examples:
      | _path | _meth | _stat | newid | _meth2 | _stat2 |
      | users | PUT   | 201   | /212  | GET    | 200    |
#      | users | PATCH  | 201   |    | GET    |  200   |

#      | users | POST   | 201   |       | GET    |  200   |
