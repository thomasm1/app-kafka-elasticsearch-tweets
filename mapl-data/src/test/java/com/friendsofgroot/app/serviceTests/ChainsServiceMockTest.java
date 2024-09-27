package com.friendsofgroot.app.serviceTests;

import com.friendsofgroot.app.models.dto.ChainDto;
import com.friendsofgroot.app.service.ChainsService;
import com.friendsofgroot.app.service.ChainsServiceImpl;
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
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ChainsServiceMockTest {      // *NOTE: change PK coinnames before sending to DB

    //        Setup Coin  p1; get
//		  Coin  p2; update
//		  Coin p3; delete
    @Mock
    private ChainsService  chainsServiceMockTest;
    // Impl usersServiceImpl = mock(UsersServiceImpl.class);
    @InjectMocks
    private ChainsServiceImpl  chainsServiceImpl;

    @BeforeAll // setup
    public static void setupClass() {
        System.out.println("Class/Static setup ");
    }

    @BeforeEach
    public void setup() {
        System.out.println("Method/Instance setup ");
    }

    @Test
    public void add_new_chain() {
        ChainDto c = new ChainDto();    // PASSES
        when( chainsServiceMockTest.saveNewChain(c)).thenReturn(assertInstanceOf(ChainDto.class, c));
        assertEquals( chainsServiceMockTest.saveNewChain(c), c);

    }
    @Test
    public void get_chain() {
        ChainDto c = new ChainDto( );    // PASSES
        c.setChainId((int) Math.floor(Math.random()*31));
//        when( chainsServiceMockTest.getChainByChainId(c.getChainId())).thenReturn(          assertEquals( chainsServiceMockTest.getChainByChainId(c.getChainId()), c); // chainsServiceMockTest.getChain(c.getId())); // Check not null bc dynamic int ID

    }

    @Test
    public void get_all_chains() {
        List<ChainDto>  chains =  chainsServiceMockTest.getAllChains();
        when( chainsServiceMockTest.getAllChains()).thenReturn((List<ChainDto>) assertInstanceOf(List.class,  chains));
        assertEquals( chainsServiceMockTest.getAllChains(),  chains);
    }



    @Test
    public void update_chain() {
        ChainDto c = new ChainDto( );    // PASSES

        when( chainsServiceMockTest.updateChain(c)).thenReturn(assertInstanceOf(ChainDto.class, c));
        assertEquals( chainsServiceMockTest.updateChain(c), c);

    }
    @Test
    public void delete_chain() {                                          // PASSES
        ChainDto c = new ChainDto( );
        c.setChainId((int) Math.floor(Math.random()*31));
		when( chainsServiceMockTest.deleteById(c.getChainId())).thenReturn(assertInstanceOf(Boolean.class, true));
        assertTrue( chainsServiceMockTest.deleteById(c.getChainId()));
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("After Class executing ...");
    } // teardown


}
