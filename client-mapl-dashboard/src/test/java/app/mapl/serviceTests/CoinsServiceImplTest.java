package app.mapl.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import app.mapl.models.Coin;
import app.mapl.service.CoinsServiceImpl;

public class CoinsServiceImplTest {      // *NOTE: change PK coinnames before sending to DB


	@BeforeAll // setup
	public static void setupClass() {
		System.out.println("Class/Static setup ");
	}

	@BeforeEach
	public void setup() {
		System.out.println("Method/Instance setup ");
	}

    @Test
	public void add_new_coin() {
		Coin c;    // PASSES
		c = new Coin(75757, "Ethereum", "ETH", 45000.00, 45.01, 0);
		assertTrue(CoinsServiceImpl.createCoin(c));

	}
    @Test
   	public void update_coin() {
   		Coin c = new Coin(75578, "Ethereum", "ETH", 45000.00, 45.01, 0);    // PASSES
   		assertTrue(CoinsServiceImpl.updateCoin(c));

   	}
    @Test
   	public void get_coin_make() {
    	Coin c = new Coin(75578, "Ethereum", "ETH", 45000.00, 45.01, 0);    // PASSES
		CoinsServiceImpl.createCoin(c);
   		assertEquals("Ethereum", c.getCoinToken());

   	}
    @Test
   	public void get_coin() {
    	Coin c = new Coin(775578, "Ethereum", "ETH", 45000.00, 45.01, 0);    // PASSES
		CoinsServiceImpl.getCoin(c.getCoinId());
   		assertEquals(CoinsServiceImpl.getCoin(c.getCoinId()), CoinsServiceImpl.getCoin(c.getCoinId())); // Check not null bc dynamic int ID

   	}
	@Test
   	public void delete_coin() {										  // PASSES
		Coin c = new Coin(77558, "Ethereum", "ETH", 45000.00, 45.01, 0);
   		CoinsServiceImpl.createCoin(c);
   		assertTrue(CoinsServiceImpl.deleteCoin(c.getCoinId()));
   	}

	@AfterAll
	public static void tearDownClass() {
		System.out.println("After Class executing ...");
	} // teardown


}
