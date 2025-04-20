package xyz.cryptomaven.rest.controllerTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import xyz.cryptomaven.rest.controllers.ChainsController;
import xyz.cryptomaven.rest.models.dto.ChainDto;
import xyz.cryptomaven.rest.services.ChainsService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ChainsControllerTest {
    @Mock
    private ChainsService chainsService;

    @InjectMocks
    private ChainsController chainsController;

    @BeforeEach
    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllChains() {
    List<ChainDto> chainDtos = Collections.singletonList(new ChainDto());
    when(chainsService.getAllChains()).thenReturn(chainDtos);

    ResponseEntity<List<ChainDto>> response = chainsController.getAllChains();

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(chainDtos, response.getBody());
    }

    @Test
    public void testGetChain() {
        ChainDto chainDto = new ChainDto();
        when(chainsService.getChain(1L)).thenReturn(chainDto);

        ChainDto response = chainsController.getChain(1L).getBody();

        assertEquals(chainDto, response);
    }
    @Test
    public void testGetChainByName() {
        ChainDto chainDto = new ChainDto();
        when(chainsService.getChainByName("chainName")).thenReturn(chainDto);

        ChainDto response = chainsController.getChainByName("chainName").getBody();

        assertEquals(chainDto, response);
    }

    @Test
    public void testGetChainById() {
        ChainDto chainDto = new ChainDto();
        when(chainsService.getChain(1L)).thenReturn(chainDto);

        ChainDto response = chainsController.getChain(1L).getBody();

        assertEquals(chainDto, response);
}


    @Test
    public void testCreateChain() {
        ChainDto chainDto = new ChainDto();
        when(chainsService.createChain(chainDto)).thenReturn(chainDto);

        ResponseEntity<ChainDto> response = chainsController.createChain(chainDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(chainDto, response.getBody());
    }
    @Test
    public void testUpdateChain() {
        ChainDto chainDto = new ChainDto();
        when(chainsService.updateChain(chainDto)).thenReturn(chainDto);

        ResponseEntity<ChainDto> response = chainsController.updateChain(chainDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(chainDto, response.getBody());
    }
    @Test
    public void testDeleteChain() {
        when(chainsService.deleteChain(1L)).thenReturn(true);

        boolean response = chainsController.deleteChain(1L);

        assertEquals(true, response);
    }


}
