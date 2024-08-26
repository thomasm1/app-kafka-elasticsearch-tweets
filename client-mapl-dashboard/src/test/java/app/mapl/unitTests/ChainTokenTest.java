package app.mapl.unitTests;

import app.mapl.models.dto.ChainDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class ChainTokenTest {
//int chainId, String chainToken, String chainSymbol, double priceTotal, int chainCount, boolean purchased, int status
	@BeforeAll // setup
	public static void setupClass() {
		System.out.println("Class/Static setup "); 
	}

	@BeforeEach
	public void setup() {
		ChainDto newChain = ChainDto.builder()
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
		System.out.println(newChain);
	}

	@Test
	public void getChainId() {										  // PASSES
		ChainDto newChain = ChainDto.builder()
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
		assertEquals(345, newChain.getChainId());
	}

	@Test
	public void setChainId() {										  // PASSES
		ChainDto newChain = ChainDto.builder()
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
				.build();	newChain.setChainId(1010);
		assertEquals(1010, newChain.getChainId());
	}

	@Test
	public void getChainToken() {										  // PASSES
		ChainDto newChain = ChainDto.builder()
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
				.build();	assertEquals("eth", newChain.getChainToken());
		System.out.println("ChainDto Token: " + newChain.getChainToken());
	}

	@Test
	public void setChainToken() {										  // PASSES
		ChainDto newChain = ChainDto.builder()
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
		newChain.setChainId(null);
		assertNull(null, newChain.getChainToken());
		System.out.println(newChain.getChainToken());
	}

	@Test
	public void getChainSymbol() {										  // PASSES
		ChainDto newChain = ChainDto.builder()
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
		String whatsSymbol = newChain.getSymbol();
		System.out.println("ChainDto Symbol: " + whatsSymbol);
	}

	@Test
	public void setChainSymbol() {										  // PASSES
		ChainDto newChain = ChainDto.builder()
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
		newChain.setSymbol("Cherokee");
		assertEquals("Cherokee", newChain.getSymbol());
		System.out.println("New model : " + newChain.getSymbol());
	}

	@Test
	public void isListed() {
		ChainDto newChain = ChainDto.builder()
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
				.build();	// PASSES
		assertEquals("chainlisticon", newChain.getChainListIcon());
		System.out.println("ChainDto Bought? : " + newChain.getChainListIcon());
	}

}