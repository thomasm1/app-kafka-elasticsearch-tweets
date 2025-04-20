Feature: Thorough Testing of Spring Data REST APIs

  Background: background
#    * url 'http://52.3.58.191:8083/api'
#    * url 'http://localhost:8083/api/'
    * url baseUrl + '/'
    * def id = 20
 # Test - Retrieve All Users (GET)
  Scenario: Get All Users
    Given path 'rest/users'
    When method get
    Then status 200
    * def users = response
    * match users._embedded.users != null
    * match users.page.size == '#number'
    * match users.page.totalPages == '#number'
    * match users.page.number == '#number'
    * print users
    * print id

  # Test - Retrieve Single User by ID (GET)
  Scenario: Get All Users
  Given path 'rest/users/' + 20
    When method get
    Then status 200
    * def user = response
    * match user.username == '#string'
    * match user.email == '#string'
    * match user._links.self.href == baseUrl + 'rest/users/' + 20
    * print user

  # Test - Create New User (POST)
  Scenario: Create New User
    Given path 'rest/users'
    And request
  """
  {
  "username": "newuser@gmail.com",
  "password": "newpassword",
  "firstName": "New",
  "lastName": "User",
  "userType": 1,
  "email": "newuser@gmail.com",
  "isActive": 1
  }
  """
    When method post
    Then status 401
#    * def newUser = response.data
#    * match newUser.username == 'newuser@gmail.com'
#    * print newUser

  # Test - Update Existing User (PUT)

    * path 'rest/users/' + 20
    And request
    """
    {
    "userId":20
  "firstName": "Updated",
  "lastName": "User"
  }
    """
    When method put
    Then status 401
#    * def updatedUser = response
#    * match updatedUser.firstName == 'Updated'
#    * match updatedUser.lastName == 'User'
#    * print updatedUser
#    * id =   newUser.userId


#    * path 'rest/users/' + id
#    When method delete
#    Then status 204
#    * print 'User deleted successfully'

  # Test - Verify User Deletion (GET)

#    * path 'rest/users/' + 24
#    When method get
#    Then status 404
#    * print 'User not found, deletion verified'

  # Test - Retrieve User Addresses
    * path 'rest/users/'+ id + '/addresses'
    When method get
    Then status 200
    * def addresses = response
    * match addresses._embedded.addresses != null
    * print addresses

  # Test - Retrieve User Roles
    * path 'rest/users/'+ id + '/roles'
    When method get
    Then status 200
    * def roles = response
    * match roles._embedded.roles != null
    * print roles
