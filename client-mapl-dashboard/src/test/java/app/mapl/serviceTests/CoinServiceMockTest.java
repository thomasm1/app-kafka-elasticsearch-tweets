package app.mapl.serviceTests;

import app.mapl.dto.CoinDto;
import app.mapl.service.CoinsService;
import app.mapl.service.CoinsServiceJPA;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CoinServiceMockTest {      // *NOTE: change PK coinnames before sending to DB

    //        Setup Coin  p1; get
//		  Coin  p2; update
//		  Coin p3; delete
    @Mock
    private CoinsService coinsServiceMockTest;
    // Impl usersServiceImpl = mock(UsersServiceImpl.class);
    @InjectMocks
    private CoinsServiceJPA coinsServiceJPA;

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
        CoinDto c = new CoinDto();    // PASSES
        when(coinsServiceMockTest.createCoin(c)).thenReturn(assertInstanceOf(CoinDto.class, c));
        assertEquals(coinsServiceMockTest.createCoin(c), c);

    }

    @Test
    public void update_coin() {
        CoinDto c = new CoinDto(75578, "Ethereum", "ETH", 45000.00, 0);    // PASSES

        when(coinsServiceMockTest.updateCoin(c)).thenReturn(assertInstanceOf(CoinDto.class, c));
        assertEquals(coinsServiceMockTest.updateCoin(c), c);

    }

    @Test
    public void get_all_coins() {
        List<CoinDto> coins = coinsServiceMockTest.getAllCoins();
        when(coinsServiceMockTest.getAllCoins()).thenReturn((List<CoinDto>) assertInstanceOf(List.class, coins));
        assertEquals(coinsServiceMockTest.getAllCoins(), coins);
    }

    @Test
    public void get_coin() {
        CoinDto c = new CoinDto(775578, "Ethereum", "ETH", 45000.00, 0);    // PASSES
        when(coinsServiceMockTest.getCoin(c.getCoinId())).thenReturn(assertInstanceOf(CoinDto.class, c));
        assertEquals(coinsServiceMockTest.getCoin(c.getCoinId()), coinsServiceMockTest.getCoin(c.getCoinId())); // Check NOT NULL bc dynamic int ID

    }

    @Test
    public void delete_coin() {                                          // PASSES
        CoinDto c = new CoinDto(77558, "Ethereum", "ETH", 45000.00, 0);
		when(coinsServiceMockTest.deleteCoin(c.getCoinId())).thenReturn(assertInstanceOf(Boolean.class, true));
        assertTrue(coinsServiceMockTest.deleteCoin(c.getCoinId()));
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("After Class executing ...");
    } // teardown


}