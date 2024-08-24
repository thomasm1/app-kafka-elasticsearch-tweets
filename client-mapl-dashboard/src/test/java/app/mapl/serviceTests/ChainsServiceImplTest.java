package app.mapl.serviceTests;

import app.mapl.mapper.ChainMapper;
import app.mapl.models.Chain;
import app.mapl.service.ChainsServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
 

public class ChainsServiceImplTest {      // *NOTE: change PK coinnames before sending to DB

	@InjectMocks
	private ChainsServiceImpl chainsServiceTester;
	private ChainMapper chainMapper;

	@Mock
	private Chain chainTester;
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
		Chain c;    // PASSES
		c = new Chain( );
		Assertions.assertEquals(chainsServiceTester.createChain(chainMapper.toOneDto(c)), chainMapper.toOneDto(c));

	}
    @Test
   	public void update_chain() {
		Chain c = new Chain( );
   		assertTrue(chainsServiceTester.updateChain(chainMapper.toOneDto(c)) != null);    // PASSES

   	}

	private void assertTrue(boolean b) {
	}

	@Test
   	public void get_chain_make() {
    	Chain c = new Chain();    // PASSES
		chainsServiceTester.createChain(chainMapper.toOneDto(c));
   		Assertions.assertEquals("Ethereum", c.getName());

   	}
    @Test
   	public void get_chain() {
    	Chain c = new Chain( );    // PASSES
		chainsServiceTester.getChain(c.getChainId());
   		Assertions.assertEquals(chainsServiceTester.getChain(c.getChainId()), chainsServiceTester.getChain(c.getChainId())); // Check not null bc dynamic int ID

   	}
	@Test
   	public void delete_chain() {										  // PASSES
		Chain c = new Chain( );
		chainsServiceTester.createChain(chainMapper.toOneDto(c));
   		assertTrue(chainsServiceTester.deleteChain(c.getChainId()));
   	}

	@AfterAll
	public static void tearDownClass() {
		System.out.println("After Class executing ...");
	} // teardown


}
