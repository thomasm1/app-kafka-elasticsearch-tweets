//package app.mapl.serviceTests
//
//import app.mapl.dto.RegisterDto
//import app.mapl.dto.UserDto
//import app.mapl.models.*
//
//import app.mapl.repositories.UsersRepository
//import app.mapl.service.UsersServiceImpl
//import spock.lang.Specification
//import spock.lang.Unroll
//
//class UsersServiceImplTest extends Specification {
//    def testObj = new UsersServiceImpl()
//    def usersRepository = Mock(UsersRepository)
//    def userMapper = Mock(UserMapper)
//    def userAccountRepository = Mock(UserAccountRepository)
//    def expectedResult
//    def setup() {
//
//        testObj.usersRepository = usersRepository
//        testObj.userMapper = userMapper
//        testObj.userAccountRepository = userAccountRepository
//    }
//
//    @Unroll
//    def "createUserCLI"() {
//        when:
//        expectedResultt = testObj.createUserCLI(user)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        user                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 || expectedResult
//        new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, null)
//    }
//
//    @Unroll
//    def "registerUser"() {
//        given: "_"
//
//        and: "_"
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, null)
//        userMapper.toEntity(_) >> new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, null)
//
//        when:
//        expectedResultt = testObj.registerUser(registerDto)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        registerDto                                                               || expectedResult
//        new RegisterDto("username", "lastName", "firstName", "email", "password") ||  new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//
//
//        @Unroll
//    def "loginUser"() {
//        given: "_"
//
//        and: "_"
//        usersRepository.findByUsernameOrEmail(_, _) >> null
//        userMapper.toDto(_) >> new  UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//
//            when:
//        expectedResultt = testObj.loginUser(usernameOrEmail, password)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        "password" | "usernameOrEmail" ||  UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>}
//        password   | usernameOrEmail   || expectedResult
//
//    @Unroll
//    def "createUser"() {
//        given: "_"
//
//        and: "_"
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//        userMapper.toEntity(_) >> new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)
//
//        when:
//        expectedResultt = testObj.createUser(user)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        user || expectedResult
//        new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>) || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//    }
//
//    @Unroll
//    def "getUser"() {
//        given: "_"
//
//        and: "_"
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//
//        when:
//        expectedResultt = testObj.getUser(id)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        id || expectedResult
//        0  || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//    }
//
//    @Unroll
//    def "getUser2"() {
//        given: "_"
//
//        and: "_"
//        usersRepository.findByEmail(_) >> null
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//
//        when:
//        r = testObj.getUser(email)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        email   || r
//        "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//    }
//
//    @Unroll
//    def "getUsers"() {
//        given: "_"
//
//        and: "_"
//        usersRepository.findAll() >> [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)]
//
//        when:
//        expectedResultt = testObj.getUsers()
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        expectedResult << [new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)]
//    }
//
//    @Unroll
//    def "getUserByEmailAndPassword"() {
//        given: "_"
//
//        and: "_"
//        usersRepository.findByEmailAndPassword(_, _) >> null
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//
//        when:
//        expectedResultt = testObj.getUserByEmailAndPassword(email, pw)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        pw   | email   || expectedResult
//        "pw" | "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//    }
//
//    @Unroll
//    def "getUserByEmail"() {
//        given: "_"
//
//        and: "_"
//        usersRepository.findByEmail(_) >> null
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//
//        when:
//        expectedResultt = testObj.getUserByEmail(email)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        email   || expectedResult
//        "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//    }
//
//    @Unroll
//    def "getUsersWithCoins"() {
//        given: "_"
//
//        and: "_"
//        usersRepository.findAll() >> [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)]
//
//        when:
//        expectedResultt = testObj.getUsersWithCoins()
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        expectedResult << [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)]
//    }
//
//    @Unroll
//    def "getUserByPassword"() {
//        when:
//        expectedResultt = testObj.getUserByPassword(username, password)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        password   | username   || expectedResult
//        "password" | "username" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//    }
//
//    @Unroll
//    def "updateUser"() {
//        given: "_"
//
//        and: "_"
//        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//        userMapper.toEntity(_) >> new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)
//
//        when:
//        expectedResultt = testObj.updateUser(change)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        change || expectedResult
//        new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>) || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
//    }
//
//    @Unroll
//    def "deleteUser"() {
//        given: "_"
//
//        and: "_"
//        usersRepository.findByEmail(_) >> null
//
//        when:
//        expectedResultt = testObj.deleteUser(email)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        email   || expectedResult
//        "email" || true
//    }
//
//    @Unroll
//    def "deleteUser2"() {
//        given: "_"
//
//        and: "_"
//        usersRepository.findByEmail(_) >> null
//
//        when:
//        expectedResultt = testObj.deleteUser(user)
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        user || expectedResult
//        new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Coin(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>) || true
//    }
//
//    @Unroll
//    def "getUserCoins"() {
//        given: "_"
//
//        and: "_"
//        userAccountRepository.getUserCoins() >> [null]
//
//        when:
//        expectedResultt = testObj.getUserCoins()
//
//        then: "_"
//        with(expectedResult) {
//
//        }
//        where: "_"
//        expectedResult << [null]
//    }
//}
//
