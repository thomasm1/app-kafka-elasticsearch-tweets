package app.mapl.unitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CoinTokenTest {
//int coinId, String coinToken, String coinSymbol, double priceTotal, int coinCount, boolean purchased, int status
	@BeforeAll // setup
	public static void setupClass() {
		System.out.println("Class/Static setup "); 
	}

	@BeforeEach
	public void setup() {
		Coin newCoin = new Coin(1010, "Jeep", "Wrangler", 24000.01, 0);
		System.out.println(newCoin);
	}

	@Test
	public void getCoinId() {										  // PASSES
		Coin newCoin = new Coin(1010, "Jeep", "Wrangler", 24000.01, 0);
		assertEquals(1010, newCoin.getCoinId());
	}

	@Test
	public void setCoinId() {										  // PASSES
		Coin newCoin = new Coin(1010, "Jeep", "Wrangler", 24000.01, 0);
		newCoin.setCoinId(1010);
		assertEquals(1010, newCoin.getCoinId());
	}

	@Test
	public void getCoinToken() {										  // PASSES
		Coin newCoin = new Coin(1010, "Jeep", "Wrangler", 24000.01, 0);
		assertEquals("Jeep", newCoin.getCoinToken());
		System.out.println("Coin Token: " + newCoin.getCoinToken());
	}

	@Test
	public void setCoinToken() {										  // PASSES
		Coin newCoin = new Coin(1010, "Jeep", "Wrangler", 24000.01, 0);
		newCoin.setCoinToken(null);
		assertNull(null, newCoin.getCoinToken());
		System.out.println(newCoin.getCoinToken());
	}

	@Test
	public void getCoinSymbol() {										  // PASSES
		Coin newCoin = new Coin(1010, "Jeep", "Wrangler", 24000.01, 0);
		String whatsSymbol = newCoin.getCoinSymbol();
		System.out.println("Coin Symbol: " + whatsSymbol);
	}

	@Test
	public void setCoinSymbol() {										  // PASSES
		Coin newCoin = new Coin(1010, "Jeep", "Wrangler", 24000.01, 0);
		newCoin.setCoinSymbol("Cherokee");
		assertEquals("Cherokee", newCoin.getCoinSymbol());
		System.out.println("New model : " + newCoin.getCoinSymbol());
	}

	@Test
	public void isPurchased() {										  // PASSES
		Coin newCoin = new Coin(1010, "Jeep", "Wrangler", 24000.01, 0);
		assertEquals(0, newCoin.isPurchased());
		System.out.println("Coin Bought? : " + newCoin.isPurchased());
	}

}