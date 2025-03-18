package app.mapl.serviceTests;

import app.mapl.mapper.ChainMapper;
import app.mapl.models.dto.ChainDto;
import app.mapl.services.ChainsService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


public class ChainsServiceImplTest {      // *NOTE: change PK coinnames before sending to DB

	@Mock
	private ChainsService chainsServiceTester;
	private ChainMapper chainMapper;
	@BeforeAll // setup
	public static void setupClass() {
		System.out.println("Class/Static setup ");
	}

	@BeforeEach
	public void setup() {
		System.out.println("Method/Instance setup ");
		MockitoAnnotations.openMocks(this);
	}

    @Test
	public void add_new_chain() {
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
		when(chainsServiceTester.createChain(c)).thenReturn(c);
	  Assertions.assertEquals(chainsServiceTester.createChain(c), c);
	}
    @Test
   	public void update_chain() {
		ChainDto c = ChainDto.builder()
				.id(1)
				.name("Ethereum")
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
		when(chainsServiceTester.createChain(c)).thenReturn(c);
		when(chainsServiceTester.updateChain(c)).thenReturn(c);
        Assertions.assertNotNull(chainsServiceTester.updateChain(c));

   	}

	@Test
   	public void get_chain_make() {
		ChainDto c = ChainDto.builder()
				.id(1)
				.name("Ethereum")
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
		when(chainsServiceTester.createChain(c)).thenReturn(c);
   		Assertions.assertEquals("Ethereum", c.getName());

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
				.build();
		when(chainsServiceTester.getChain(c.getChainId())).thenReturn(c); // Check not null bc dynamic int ID
	Assertions.assertEquals(c.getChainId(),345);
   	}

	@Test
   	public void delete_chain() {
		ChainDto cd = ChainDto.builder()
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
// 	Assertions.assertTrue(chainsServiceTester.deleteChain(cd.getId()));
   	}

	@AfterAll
	public static void tearDownClass() {
		System.out.println("After Class executing ...");
	} // teardown


}
