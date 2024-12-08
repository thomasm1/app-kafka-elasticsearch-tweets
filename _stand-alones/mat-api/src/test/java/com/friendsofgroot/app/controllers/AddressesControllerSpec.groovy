package com.friendsofgroot.app.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.friendsofgroot.app.models.dto.AddressDto
import com.friendsofgroot.app.mapper.AddressMapper
import com.friendsofgroot.app.models.Address
import com.friendsofgroot.app.models.NftAddress
import com.friendsofgroot.app.models.User
import com.friendsofgroot.app.service.AddressesService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Shared
import spock.lang.Specification

class AddressesControllerSpec extends Specification {
    AddressMapper addressMapper
    AddressesController controller
    AddressesService addressesService
    MockMvc mockMvc

    @Shared
    def objectMapper = new ObjectMapper()

    def setup() {
        addressesService = Mock()
        addressMapper = Mock()
        controller = new AddressesController(addressesService)
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
//
//        def address = new Address(description: "home", email: "test@example.com", address: "123 Main St", chain: "Ethereum", iconUrl: "http://example.com/icon.png", blockExplorerUrl: "http://example.com/explorer", user: new User(), chainId: 1, nftAddress:new NftAddress() )
//        def newUser = new User()
//        def addressDto = new AddressDto(description: address.description, email: address.email, address: address.address, chain: address.chain, iconUrl: address.iconUrl, blockExplorerUrl: address.blockExplorerUrl, user: address.user , chainId: address.chainId, nftAddress: address.nftAddress )
    }

    def "test createAddress"() {
        given:
        def result = new AddressDto()
        def addressDto1 = new AddressDto(description: address.description, email: address.email, address: null, chain: address.chain, iconUrl: address.iconUrl, blockExplorerUrl: address.blockExplorerUrl, user: address.user, chainId: null, nftAddress: null)
        when:
        result = mockMvc.perform(MockMvcBuilders.post("/api/addresses")
                .contentType(MediaType.APPLICATION_JSON)
                .andExpect(HttpStatus.CREATED.value())
                .andReturn().response().contentAsString()) as AddressDto
        then:
        result.response.contentAsString == objectMapper.writeValueAsString(addressDto1)
        1 * addressesService.createAddress(_ as Address) >> address
        when:
        def responseEntity = controller.createAddress(addressDto1)
        then:
        responseEntity.statusCode == HttpStatus.CREATED
        responseEntity.body == addressDto1


//        given:
//        def address = new Address(description: "home", email: "test@example.com", address: "123 Main St", chain: "Ethereum", iconUrl: "http://example.com/icon.png", blockExplorerUrl: "http://example.com/explorer", user: new User(), chainId: 1, nftAddress:new NftAddress() )
//        def newUser = new User()
//        def addressesService = Mock(AddressesService)
//
//        def addressDto = new AddressDto(description: address.description, email: address.email, address: address.address, chain: address.chain, iconUrl: address.iconUrl, blockExplorerUrl: address.blockExplorerUrl, user: address.user , chainId: address.chainId, nftAddress: address.nftAddress )
//        1 * addressesService.createAddress(_ as Address) >> address
//        when:
//        def responseEntity = controller.createAddress(addressDto)
//        then:
//        responseEntity.statusCode == HttpStatus.CREATED
//        responseEntity.body == addressDto
//
//        and:
//        1 * addressesService.createAddress(_ as Address) >> address
    }

    def "test getAddress"() {
        given:
        def addressesService = Mock(AddressesService)
        def controller = new AddressesController()
        def address = new Address(id: 1, description: "home", email: "test@example.com", address: "123 Main St", chain: "Ethereum", iconUrl: "http://example.com/icon.png", blockExplorerUrl: "http://example.com/explorer", user: new User(), chainId: 1, nftAddress: new NftAddress())
        def addressDto = addressMapper.addressToAddressDto(address)
        1 * addressMapper.addressDtoToAddress(_) >> address
        1 * addressesService.getAddress(_) >> address

        when:
        def responseEntity = controller.getAddress(1)

        then:
        responseEntity.statusCode == HttpStatus.OK
        responseEntity.body == addressDto

        and:
        1 * addressesService.getAddress(1)
    }

    def "test getAllAddresses"() {
        given:
        def addressesService = Mock(AddressesService)
        def controller = new AddressesController()
        controller.addressesService = addressesService
        def address = new Address(description: "home", email: "test@example.com", address: "123 Main St", chain: "Ethereum", iconUrl: "http://example.com/icon.png", blockExplorerUrl: "http://example.com/explorer", user: new User(), chainId: 1, nftAddress: new NftAddress())
        def addressDtoList = [new AddressDto(description: address.description, email: address.email, address: address.address, chain: address.chain, iconUrl: address.iconUrl, blockExplorerUrl: address.blockExplorerUrl, user: address.user.userId, chainId: address.chainId, nftAddressId: address.nftAddress.id)]
        1 * addressesService.getAllAddresses() >> [address]


        when:
        def responseEntity = controller.getAddress(1)

        then:
        responseEntity.statusCode == HttpStatus.OK
        responseEntity.body == addressDto

        and:
        1 * addressesService.getAddress(1)
    }
}
