Feature:  users karate test script

  Background: background
#    * url 'http://52.3.58.191:8083/api'
#    * url 'http://localhost:8083/api/'

    * url baseUrl + '/api/'



  @Order(1)
  Scenario: get all users and then get the first user by id
    Given path 'users'
    When method get
    Then status 200

    * def first = response[1]

    Given path 'users/' + first.userId
    When method get
    Then status 200

  @Order(2)
  Scenario Outline: create a user and then get it by id

    * def rando = Math.floor(Math.random() * 1031)
    * def usernameEmail = "user"+rando+"@gmail.com"
    * print "_______________________ID____:" + usernameEmail
    * def user =
      """
      {
  "username": '#(usernameEmail)',
        "lastName": "Wonderland",
        "firstName": "Alice",
        "organizationCode": "ORG001",
        "dashboardCode": "DASH-A",
        "cusUrl": "https://example.com/alice",
        "userType": 1,
        "email": '#(usernameEmail)',
        "contactType": 101,
        "isActive": 1,
        "roles": [
            {
                "id": 1,
                "name": "ROLE_ADMIN"
            }
        ],
        "id": null
    }
      """
# 1 CREATE
    Given path 'users'
    And request user
    When method POST
    Then status 201

    * json resp = response
    * def localId = resp.userId

    * print 'created id is: ', localId
#2 READ
    * path 'users/' +  localId
    * print 'user is: ',localId
    When method GET
    Then status 200
#    And match response contains user
#3 PUT
    Given path 'users/' + localId
    * print 'user is: ', localId
    * user.userId = localId
    And request user
    When method PUT
    Then status 201
#    And match response contains user
  #4 DELETE
    Given path 'users/' + localId
    * print 'user is: ', localId
    When method DELETE
    Then status 200

    Examples:
      | _path  | _meth | _stat | newid      | _meth2 | _stat2 |
      | users/ | PUT   | 201   | '#(newid)' | GET    | 200    |
#      | users | PATCH  | 201   |    | GET    |  200   |

#      | users | POST   | 201   |       | GET    |  200   |


############################1
  @Order(3)
    @ignore
  Scenario Outline: Update a user, get it by id, verify changes
    * def rando = Math.floor(Math.random() * 100)
    * def usernameEmail = "user"+rando+"@gmail.com"
    * print "_______________________ID____" + usernameEmail
    * def user =
      """
     {
  "username": '#(usernameEmail)',
        "lastName": "Wonderland",
        "firstName": "Alice",
        "organizationCode": "ORG001",
        "dashboardCode": "DASH-A",
        "cusUrl": "https://example.com/alice",
        "userType": 1,
        "email": '#(usernameEmail)',
        "contactType": 101,
        "isActive": 1,
        "roles": [
            {
                "id": 1,
                "name": "ROLE_ADMIN"
            }
        ],
        "id": 4
    }
      """

    Given path '/users/'+ '<newid>'
    And request user
    When method <_meth>
    Then status <_stat>

    * json resp = response
    * def localId = resp.userId
    * def email = resp.email
    * user.email = email
    * def username = resp.username
    * user.username = username
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
    "roles": '#array'
    }
    """
#    [{"id":1,"name":"ROLE_USER"}]

    Examples:
      | _path  | _meth | _stat | newid      | _meth2 | _stat2 |
      | users/ | PUT   | 201   | '#(newid)' | GET    | 200    |
#      | users | PATCH  | 201   |    | GET    |  200   |

#      | users | POST   | 201   |       | GET    |  200   |
