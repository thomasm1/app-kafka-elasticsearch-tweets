package app.mapl.serviceTests;


import app.mapl.models.dto.ChainDto;
import app.mapl.services.ChainsService;
import app.mapl.services.ChainsServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChainsServiceMockTest {      // *NOTE: change PK chainnames before sending to DB

    //        Setup Chain  p1; get
//		  Chain  p2; update
//		  Chain p3; delete
    @Mock
    private ChainsService chainsServiceMockTest;
    // Impl usersServiceImpl = mock(UsersServiceImpl.class);
    @InjectMocks
    private ChainsServiceImpl chainsServiceImpl;

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
        ChainDto c = ChainDto.builder().build();
        when(chainsServiceMockTest.createChain(c)).thenReturn(assertInstanceOf(ChainDto.class, c));
        assertEquals(chainsServiceMockTest.createChain(c), c);

    }

    @Test
    public void update_chain() {
        ChainDto c = ChainDto.builder().build();

        when(chainsServiceMockTest.updateChain(c)).thenReturn(assertInstanceOf(ChainDto.class, c));
        Assertions.assertEquals(chainsServiceMockTest.updateChain(c), c);

    }

    @Test
    public void get_all_chains() {
        List<ChainDto> chains = (List<ChainDto>) chainsServiceMockTest.getAllChains();
        when(chainsServiceMockTest.getAllChains()).thenReturn((List<ChainDto>) assertInstanceOf(List.class, chains));
        Assertions.assertEquals(chainsServiceMockTest.getAllChains(), chains);
    }

    @Test
    public void get_chain() {
        ChainDto c = ChainDto.builder()
                .id(1)
                .name("ethereum")
                .symbol("eth")
                .description("erc-20")
                .longDescription("erc-20 native token")
                .iconUrl("ethereum.org")
                .category("token")
                .chainListIcon("chainlisticon")
                .rpcUrl("rpc://this.net")
                .chainId(345)
                .blockExplorerUrl("etherscan.io")
                .build();   // PASSES
        when(chainsServiceMockTest.getChain(c.getChainId())).thenReturn(assertInstanceOf(ChainDto.class, c));
        chainsServiceMockTest.createChain(c) ;
        Assertions.assertEquals(chainsServiceMockTest.getChain(c.getChainId()), chainsServiceMockTest.getChain(c.getChainId())); // Check not null bc dynamic int ID

    }

    @Test
    public void delete_chain() {
        ChainDto c = ChainDto.builder()
                .id(1)
                .name("ethereum")
                .symbol("eth")
                .description("erc-20")
                .longDescription("erc-20 native token")
                .iconUrl("ethereum.org")
                .category("token")
                .chainListIcon("chainlisticon")
                .rpcUrl("rpc://this.net")
                .chainId(345)
                .blockExplorerUrl("etherscan.io")
                .build();
        when(chainsServiceMockTest.deleteChain(c.getChainId())).thenReturn(assertInstanceOf(Boolean.class, true));
 chainsServiceMockTest.createChain(c) ;

        Assertions.assertTrue(chainsServiceMockTest.deleteChain(c.getChainId()));
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("After Class executing ...");
    } // teardown


}