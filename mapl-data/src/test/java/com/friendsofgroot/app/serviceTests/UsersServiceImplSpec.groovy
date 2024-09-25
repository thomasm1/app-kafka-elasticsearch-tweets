package com.friendsofgroot.app.serviceTests

import com.friendsofgroot.app.mapper.UserMapper
import com.friendsofgroot.app.models.Address
import com.friendsofgroot.app.models.Attribute
import com.friendsofgroot.app.models.Metadata
import com.friendsofgroot.app.models.NftAddress
import com.friendsofgroot.app.models.Role
import com.friendsofgroot.app.models.User
import com.friendsofgroot.app.models.dto.RegisterDto
import com.friendsofgroot.app.models.dto.UserDto
import com.friendsofgroot.app.repositories.UserAccountRepository
import com.friendsofgroot.app.repositories.UsersRepository
import com.friendsofgroot.app.service.UsersService
import com.friendsofgroot.app.service.UsersServiceImpl
import spock.lang.*

class UsersServiceImplSpec extends Specification {
UsersService testObj
    UserMapper userMapper
    UsersRepository usersRepository
    def expectedResult
    UserDto registerDto
    def setup() {
    testObj = new UsersServiceImpl()
    usersRepository = Mock(UsersRepository)
    userMapper = Mock()

        testObj.usersRepository = usersRepository
        testObj.userMapper = userMapper
    }

    @Unroll
    def "createUserCLI"() {
        when:
        User user = new User (0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)

        expectedResult = testObj.createUserCLI(user as User)

        then: "then"
        with(expectedResult) {
//               id == 0
                username =="username"
//            password == null
//                lastName == null
//                firstName == null
//                phone == 0
//                email == null
//                cusUrl == null
//                photoPath == null
//                nftAddress == null
//                chainId == 0
//                addresses == [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0)] as Set<Role>
        }

        }

    @Unroll
    def "registerUser"() {
        given: "given"

        and: "_mock"
        userMapper.toDto(_ as User) >>  new UserDto (0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
        userMapper.toEntity(_ as UserDto) >>   new User (0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
        usersRepository.findByUsernameOrEmail(_ as String, _ as String) >> null



        when:
        expectedResult = testObj.registerUser(registerDto as UserDto)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        registerDto                                                               || expectedResult
        new RegisterDto("username", "lastName", "firstName", "email", "password") || new UserDto (0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
    }

    @Unroll
    def "loginUser"() {
        given: "given"

        and: "_mock"
        usersRepository.findByUsernameOrEmail(_ as String, _ as String) >> null
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)

        when:
        expectedResult = testObj.loginUser(usernameOrEmail, password)

        then: "then"
        with(expectedResult) {
it != null
        }
        where: "where"
      expectedResult << [     userBuilder() ]
    }

    private void userBuilder() {
        "password" | "usernameOrEmail" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
    }

//    @Unroll
//    def "createUser"() {
//        given: "given"
//var user =  new UserDto (0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//
//        and: "_mock"
//       var user1 =  userMapper.toDto(_ as User) >> new UserDto (0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//        userMapper.toEntity(_ as UserDto) >> new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//        usersRepository.findByUsernameOrEmail(_ as String, _ as String) >> user1
//
//        when:
//        expectedResult = testObj.registerUser(user)
//
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//
//
//    }
//
//    @Unroll
//    def "getUser"() {
//        given: "given"
//
//        and: "_mock"
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//
//        when:
//        expectedResult = testObj.getUser(id)
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//        where: "where"
//        id || expectedResult
//        0  || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//    }
//
//    @Unroll
//    def "getUser2"() {
//        given: "given"
//
//        and: "_mock"
//        usersRepository.findByEmail(_) >> null
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//
//        when:
//        expectedResult = testObj.getUser(email)
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//        where: "where"
//        email   || expectedResult
//        "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//    }
//
//    @Unroll
//    def "getUsers"() {
//        given: "given"
//
//        and: "_mock"
//        usersRepository.findAll() >> [new User (0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//]
//        when:
//        expectedResult = testObj.getUsers()
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//        where: "where"
//        expectedResult << [new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)]
//    }
//
//    @Unroll
//    def "getUserByEmailAndPassword"() {
//        given: "given"
//
//        and: "_mock"
//        usersRepository.findByEmailAndPassword(_, _) >> null
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//        1 * usersRepository.findByEmailAndPassword(_, _) >> null
//
//
//        when:
//        expectedResult = testObj.getUserByEmailAndPassword(email, pw)
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//        where: "where"
//        pw   | email   || expectedResult
//        "pw" | "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//    }
//
//    @Unroll
//    def "getUserByEmail"() {
//        given: "given"
//
//        and: "_mock"
//        usersRepository.findByEmail(_) >> null
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//
//        when:
//        expectedResult = testObj.getUserByEmail(email)
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//        where: "where"
//        email   || expectedResult
//        "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//    }
//
//    @Unroll
//    def "getUsersWithCoins"() {
//        given: "given"
//
//        and: "_mock"
//        usersRepository.findAll() >> [new User (0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)]
//        1 * usersRepository.findAll() >> [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)]
//
//        when:
//        expectedResult = testObj.getUsersWithCoins()
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//        where: "where"
//        expectedResult << [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)]
//    }
//
//    @Unroll
//    def "getUserByPassword"() {
//        when:
//        expectedResult = testObj.getUserByPassword(username, password)
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//        where: "where"
//        password   | username   || expectedResult
//        "password" | "username" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)   }
//
//    @Unroll
//    def "updateUser"() {
//        given: "given"
//
//        and: "_mock"
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//        userMapper.toEntity(_) >> new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
//
//        when:
//        expectedResult = testObj.updateUser(change)
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//        where: "where"
//       expectedResult << new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)    }
//
//    @Unroll
//    def "deleteUser"() {
//        given: "given"
//
//        and: "_mock"
//        usersRepository.findByEmail(_) >> null
//
//        when:
//        expectedResult = testObj.deleteUser(email)
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//        where: "where"
//        email   || expectedResult
//        "email" || true
//    }
//
//    @Unroll
//    def "deleteUser2"() {
//        given: "given"
//
//        and: "_mock"
//        usersRepository.findByEmail(_) >> null
//
//        when:
//        expectedResult = testObj.deleteUser(user)
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//        where: "where"
//        user || expectedResult
//        new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>) || true
//    }
//
//    @Unroll
//    def "getUserChains"() {
//        given: "given"
//
//        and: "_mock"
//        userAccountRepository.getUserChains() >> [null]
//
//        when:
//        expectedResult = testObj.getUserChains()
//
//        then: "then"
//        with(expectedResult) {
//
//        }
//        where: "where"
//        expectedResult << [null]
//    }
}
