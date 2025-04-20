package xyz.cryptomaven.rest.controllerTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import xyz.cryptomaven.rest.controllers.AddressesController;
import xyz.cryptomaven.rest.models.dto.AddressDto;
import xyz.cryptomaven.rest.models.dto.ChainDto;
import xyz.cryptomaven.rest.models.dto.CoinDto;
import xyz.cryptomaven.rest.services.AddressesService;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddressesControllerTest {

  @Mock
  private AddressesService addressesService;

  @InjectMocks
  private AddressesController addressesController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetAllAddresses() {
    List<AddressDto> addressDtos = Collections.singletonList(new AddressDto());
    when(addressesService.getAllAddresses()).thenReturn(addressDtos);

    ResponseEntity<List<AddressDto>> response = addressesController.getAllAddresses();

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(addressDtos, response.getBody());
  }

  @Test
  public void testGetAddress() {
    AddressDto addressDto = new AddressDto();
    when(addressesService.getAddress(1L)).thenReturn(addressDto);

    AddressDto response = addressesController.getAddress(1L);

    assertEquals(addressDto, response);
  }

  @Test
  public void testGetAddressCoins() {
    AddressDto addressDto = new AddressDto();
    Set<CoinDto> coinDtos = Collections.singleton(new CoinDto());
//    addressDto.setCoin(coinDtos);
    when(addressesService.getAddress(1L)).thenReturn(addressDto);

    ResponseEntity<Set<CoinDto>> response = addressesController.getAddressCoins(1L);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(coinDtos, response.getBody());
  }

  @Test
  public void testGetAddressChains() {
    AddressDto addressDto = new AddressDto();
    Set<ChainDto> chainDtos = Collections.singleton(new ChainDto());
//    addressDto.setChains(chainDtos);
    when(addressesService.getAddress(1L)).thenReturn(addressDto);

    ResponseEntity<Set<ChainDto>> response = addressesController.getAddressCChains(1L);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(chainDtos, response.getBody());
  }

  @Test
  public void testCreateAddress() {
    AddressDto addressDto = new AddressDto();
    when(addressesService.createAddress(addressDto)).thenReturn(addressDto);

    ResponseEntity<AddressDto> response = addressesController.createAddress(addressDto);

    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(addressDto, response.getBody());
  }

  @Test
  public void testUpdateAddress() {
    AddressDto addressDto = new AddressDto();
    when(addressesService.updateAddress(addressDto)).thenReturn(addressDto);

    ResponseEntity<AddressDto> response = addressesController.updateAddress(addressDto);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(addressDto, response.getBody());
  }

  @Test
  public void testDeleteAddress() {
    when(addressesService.deleteAddress(1L)).thenReturn(true);

    ResponseEntity<Boolean> response = addressesController.deleteAddress(1L);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(true, response.getBody());
  }
}
