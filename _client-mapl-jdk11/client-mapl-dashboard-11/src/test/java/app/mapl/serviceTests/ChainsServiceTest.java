package app.mapl.serviceTests;


import static org.mockito.Mockito.mock;


import app.mapl.mapper.ChainMapper;

import app.mapl.service.ChainsService;
import app.mapl.service.ChainsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ChainsServiceTest {      // *NOTE: change PK coinnames before sending to DB

//        Setup Coin  p1; get
//		  Coin  p2; update
//		  Coin p3; delete
	@InjectMocks
	ChainsService chainsService;
	ChainMapper chainMapper;

	@Mock
	ChainsServiceImpl chainsServiceImpl = mock(ChainsServiceImpl.class);

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

	}
    @Test   
   	public void update_chain() {

   		
   	}
    @Test   
   	public void get_chain_make() {

   		
   	} 
    @Test   
   	public void get_chain() {

   		
   	} 
	@Test   
   	public void delete_chain() {										  // PASSES

   	}
     
	@AfterAll
	public static void tearDownClass() {
		System.out.println("After Class executing ...");
	} // teardown


}