package app.mapl.serviceTests;

import app.mapl.models.dto.NftDto;
import app.mapl.service.NftService;
import app.mapl.service.NftServiceImpl;
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
public class NFTServiceMockTest {      // *NOTE: change PK coinnames before sending to DB

    //        Setup Coin  p1; get
//		  Coin  p2; update
//		  Coin p3; delete
    @Mock
    private NftService nftServiceMockTest;
    // Impl usersServiceImpl = mock(UsersServiceImpl.class);
    @InjectMocks
    private NftServiceImpl nftServiceImpl;

    @BeforeAll // setup
    public static void setupClass() {
        System.out.println("Class/Static setup ");
    }

    @BeforeEach
    public void setup() {
        System.out.println("Method/Instance setup ");
    }

    @Test
    public void add_new_nft() {
        NftDto c = new NftDto();    // PASSES
        when(nftServiceMockTest.createNft(c)).thenReturn(assertInstanceOf(Boolean.class, c));
        assertEquals(nftServiceMockTest.createNft(c), c);

    }
    @Test
    public void get_nft() {
        NftDto c = new NftDto( );    // PASSES
        when(nftServiceMockTest.getNft(c.getId())).thenReturn(assertInstanceOf(NftDto.class, c));
        assertEquals(nftServiceMockTest.getNft(c.getId()), c); //nftServiceMockTest.getAddress(c.getId())); // Check not null bc dynamic int ID

    }

    @Test
    public void get_all_nft() {
        List<NftDto> nft = nftServiceMockTest.getAllNfts();
        when(nftServiceMockTest.getAllNfts()).thenReturn((List<NftDto>) assertInstanceOf(List.class, nft));
        assertEquals(nftServiceMockTest.getAllNfts(), nft);
    }



    @Test
    public void update_nft() {
        NftDto c = new NftDto( );    // PASSES

        when(nftServiceMockTest.updateNft(c)).thenReturn(assertInstanceOf(Boolean.class, c));
        assertEquals(nftServiceMockTest.updateNft(c), c);

    }
    @Test
    public void delete_nft() {                                          // PASSES
        NftDto c = new NftDto( );
		when(nftServiceMockTest.deleteNft(c.getId())).thenReturn(assertInstanceOf(Boolean.class, true));
        assertTrue(nftServiceMockTest.deleteNft(c.getId()));
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("After Class executing ...");
    } // teardown


}
