package com.friendsofgroot.app.service

import com.friendsofgroot.app.mapper.UserMapper
import com.friendsofgroot.app.models.Address
import com.friendsofgroot.app.models.Role
import com.friendsofgroot.app.models.User
import com.friendsofgroot.app.models.dto.UserDto
import com.friendsofgroot.app.repositories.RoleRepository
import com.friendsofgroot.app.repositories.UsersRepository
import org.slf4j.Logger
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class UsersServiceImplTest extends Specification {
    @Mock
    Logger log
    @Mock
    UsersRepository usersRepository
    @Mock
    RoleRepository roleRepository
    @Mock
    PasswordEncoder passwordEncoder
    @Mock
    UserMapper userMapper
    @InjectMocks
    UsersServiceImpl usersServiceImpl

    def setup() {
        MockitoAnnotations.openMocks(this)
    }

    def "test create User CLI"() {
        when:
        User result = usersServiceImpl.createUserCLI(new User(0, null, null, null, null, 0, null, null, null, null, 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0)]))

        then:
        result == new User(0, null, null, null, null, 0, null, null, null, null, 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0)] as Set<Role>)
    }

    def "test create User"() {
        given:
        when(usersRepository.findByEmail(anyString())).thenReturn(null)
        when(userMapper.toEntity(any())).thenReturn
        when(userMapper.toDto(any())).thenReturn(new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        when:
        UserDto result = usersServiceImpl.registerUser(new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        then:
        result == new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
    }

    def "test get User"() {
        given:
        when(userMapper.toDto(any())).thenReturn(new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        when:
        UserDto result = usersServiceImpl.getUser(0)

        then:
        result == new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
    }

    def "test get User 2"() {
        given:
        when(usersRepository.findByEmail(anyString())).thenReturn(null)
        when(userMapper.toDto(any())).thenReturn(new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        when:
        UserDto result = usersServiceImpl.getUser("email")

        then:
        result == new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
    }

    def "test get Users"() {
        when:
        List<UserDto> result = usersServiceImpl.getUsers()

        then:
        result == [new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)]
    }

    def "test get User By Email And Password"() {
        given:
        when(usersRepository.findByEmailAndPassword(anyString(), anyString())).thenReturn(null)
        when(userMapper.toDto(any())).thenReturn(new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        when:
        UserDto result = usersServiceImpl.getUserByEmailAndPassword("email", "pw")

        then:
        result == new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
    }

    def "test get User By Email"() {
        given:
        when(usersRepository.findByEmail(anyString())).thenReturn(null)
        when(userMapper.toDto(any())).thenReturn(new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        when:
        UserDto result = usersServiceImpl.getUserByEmail("email")

        then:
        result == new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
    }

    def "test update User"() {
        given:
        when(usersRepository.findByEmail(anyString())).thenReturn(null)
        when(userMapper.toEntity(any())).thenReturn(new User(0, null, null, null, null, 0, null, null, null, null, 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0)]))
        when(userMapper.toDto(any())).thenReturn(new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        when:
        UserDto result = usersServiceImpl.updateUser(new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        then:
        result == new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>)
    }

    def "test update User By Id"() {
        given:
        when(userMapper.toDto(any())).thenReturn(new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        when:
        Optional<UserDto> result = usersServiceImpl.updateUserById(0, new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        then:
        result == null
    }

    def "test patch User By Id"() {
        given:
        when(userMapper.toDto(any())).thenReturn(new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        when:
        Optional<UserDto> result = usersServiceImpl.patchUserById(0, new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        then:
        result == null
    }

    def "test delete User"() {
        given:
        when(usersRepository.findByEmail(anyString())).thenReturn(null)

        when:
        boolean result = usersServiceImpl.deleteUser("email")

        then:
        result == true
    }

    def "test delete User 2"() {
        given:
        when(usersRepository.findByEmail(anyString())).thenReturn(null)

        when:
        boolean result = usersServiceImpl.deleteUser(new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Role(0, "name")] as Set<Role>))

        then:
        result == true
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
