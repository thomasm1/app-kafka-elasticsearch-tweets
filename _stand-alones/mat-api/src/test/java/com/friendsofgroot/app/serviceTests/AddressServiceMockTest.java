package com.friendsofgroot.app.serviceTests;

import com.friendsofgroot.app.models.dto.AddressDto;
import com.friendsofgroot.app.service.AddressesService;
import com.friendsofgroot.app.service.AddressesServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceMockTest {      // *NOTE: change PK coinnames before sending to DB

    //        Setup Coin  p1; get
//		  Coin  p2; update
//		  Coin p3; delete
    @Mock
    private AddressesService addressesServiceMockTest;
    // Impl usersServiceImpl = mock(UsersServiceImpl.class);
    @InjectMocks
    private AddressesServiceImpl addressesServiceImpl;

    @BeforeAll // setup
    public static void setupClass() {
        System.out.println("Class/Static setup ");
    }

    @BeforeEach
    public void setup() {
        System.out.println("Method/Instance setup ");
    }

    @Test
    public void add_new_address() {
        AddressDto c = new AddressDto();    // PASSES
        when(addressesServiceMockTest.createAddress(c)).thenReturn(assertInstanceOf(AddressDto.class, c));
        assertEquals(addressesServiceMockTest.createAddress(c), c);

    }
    @Test
    public void get_address() {
        AddressDto c = new AddressDto( );    // PASSES
        when(addressesServiceMockTest.getAddress(c.getId())).thenReturn(assertInstanceOf(AddressDto.class, c));
        assertEquals(addressesServiceMockTest.getAddress(c.getId()), c); //addressesServiceMockTest.getAddress(c.getId())); // Check not null bc dynamic int ID

    }

    @Test
    public void get_all_addresses() {
        List<AddressDto> addresses = addressesServiceMockTest.getAllAddresses();
        when(addressesServiceMockTest.getAllAddresses()).thenReturn((List<AddressDto>) assertInstanceOf(List.class, addresses));
        assertEquals(addressesServiceMockTest.getAllAddresses(), addresses);
    }



    @Test
    public void update_address() {
        Integer id = 10000;
        AddressDto c = new AddressDto( );    // PASSES

        when(addressesServiceMockTest.updateAddress(id, c)).thenReturn((Optional<AddressDto>) assertInstanceOf(Optional.class, c));
        assertEquals(addressesServiceMockTest.updateAddress(id, c), c);

    }
    @Test
    public void delete_address() {                                          // PASSES
        AddressDto c = new AddressDto( );
		when(addressesServiceMockTest.deleteAddress(c.getId())).thenReturn(assertInstanceOf(Boolean.class, true));
        assertTrue(addressesServiceMockTest.deleteAddress(c.getId()));
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("After Class executing ...");
    } // teardown


}
