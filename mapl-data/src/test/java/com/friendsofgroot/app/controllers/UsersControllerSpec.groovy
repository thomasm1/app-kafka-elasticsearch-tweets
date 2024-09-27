package com.friendsofgroot.app.controllers

import com.friendsofgroot.app.models.dto.UserDto
import com.friendsofgroot.app.service.AuthService
import com.friendsofgroot.app.service.UsersService
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.*


class UsersControllerSpec extends Specification {
    def expectedResult
    UsersController testObj
    PasswordEncoder bcrypt
    UsersService usersService
    AuthService authService

    def setup() {
        bcrypt = Mock()
        usersService = Mock()
        authService = Mock()
        testObj = new UsersController(authService, usersService, bcrypt)
    }

    @Unroll
    def "loginUser"() {
        given: "given"
        def code = v_exp

        when:
        expectedResult = testObj.loginUser("usernameOrEmail", "password")

        then: "then"
        authService.login(_) >> code
        expectedResult.statusCode == code

        where: "where"
        password   | usernameOrEmail   || v_exp
        "password" | "usernameOrEmail" || HttpStatus.OK
//        EMPTY: <[]>
//                body: com.friendsofgroot.app.dto.JWTAuthResponse@64bc21ac
//        headers: [:]
//        status: 200 OK
    }

    @Unroll
    def "registerUser"() {
        given: "given"
        def code = v_exp

        when:
        expectedResult = testObj.registerUser(email, password, firstName, lastName)

        then: "then"
        authService.register(_) >> code
        expectedResult.statusCode == code

        where: "where"
        firstName   | lastName   | password   | email   || v_exp
        "firstName" | "lastName" | "password" | "email" || HttpStatus.CREATED
    }

    @Unroll
    def "createUser"() {
        given: "given"
        def code = v_exp

        when:
        expectedResult = testObj.registerUser(v1)

        then: "then"
        expectedResult.statusCode == code

        where: "where"
        v1            || v_exp
        new UserDto() || HttpStatus.CREATED

    }

    @Unroll
    def "getUser"() {

        when:
        expectedResult = testObj.getUser(userId)

        then: "then"
        usersService.getUser(_) >> new UserDto();
        where: "where"
        userId || expectedResult
        0      || null
    }

    @Unroll
    def "getUserByEmail"() {


        when:
        expectedResult = testObj.getUserByEmail(email)

        then: "then"

        usersService.getUser(_) >> new UserDto();
        with(expectedResult) {
            it != null
        }
        where: "where"
        email   || expectedResult
        "email" || null
    }

    @Unroll
    def "getUsers"() {
        when:
        expectedResult = testObj.getUsers()

        then: "then"
        1 * usersService.getUsers() >> [new UserDto()]
        with(expectedResult) {
            it != null
        }
        where: "where"
        expectedResult << new UserDto()
    }

    @Unroll
    def "updateUser"() {


        when:
        expectedResult = testObj.updateUser(1, userDto)

        then: "then"
        usersService.registerUser(_ as UserDto) >> new UserDto()

        with(expectedResult) {
            it != null
        }
        where: "where"
        userDto       || expectedResult
        new UserDto() || new UserDto()
    }

    @Unroll
    def "deleteUser"() {
        given: "given"

        and: "_mock"
        usersService.getUser(_ as String) >> new UserDto()
        usersService.deleteUser(_ as String) >> true

        when:
        expectedResult = testObj.deleteUser(userId)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        userId || expectedResult
        0      || null
    }
}
