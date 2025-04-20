package xyz.cryptomaven.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import xyz.cryptomaven.rest.models.dto.AddressDto;
import xyz.cryptomaven.rest.models.dto.ChainDto;
import xyz.cryptomaven.rest.models.dto.CoinDto;
import xyz.cryptomaven.rest.services.AddressesService; // Assuming you have an AddressesService interface/class

import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq; // Use eq() for specific primitive/wrapper values
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static xyz.cryptomaven.rest.util.constants.Constants.API_ADDRESSES;

// Use @ExtendWith(MockitoExtension.class) for JUnit 5 with Mockito if not using MockitoAnnotations.openMocks
public class AddressesControllerTest {

  @Mock
  private AddressesService addressesService; // Use the interface or class type here

  @InjectMocks
  private AddressesController addressesController;

  private MockMvc mockMvc;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    // Initializes mocks annotated with @Mock and injects them into @InjectMocks
    MockitoAnnotations.openMocks(this);
    // Build MockMvc instance standalone, without full Spring context
    mockMvc = MockMvcBuilders.standaloneSetup(addressesController).build();
    objectMapper = new ObjectMapper();
  }

  @Test
  void getAllAddresses_ShouldReturnListOfAddresses() throws Exception {
    // Arrange
    AddressDto address1 = new AddressDto(); // Consider using builders if you have them
    address1.setId(1L);
    address1.setAddress("address1");
    AddressDto address2 = new AddressDto();
    address2.setId(2L);
    address2.setAddress("address2");
    List<AddressDto> addressDtos = Arrays.asList(address1, address2);

    when(addressesService.getAllAddresses()).thenReturn(addressDtos);

    // Act & Assert
    mockMvc.perform(get(API_ADDRESSES))
            .andExpect(status().isOk()) // Check HTTP Status 200
            .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Check Content-Type header
            .andExpect(jsonPath("$", hasSize(2))) // Check if the root JSON is an array of size 2
            .andExpect(jsonPath("$[0].id", is(1))) // Check fields of the first element
            .andExpect(jsonPath("$[0].address", is("address1")))
            .andExpect(jsonPath("$[1].id", is(2))) // Check fields of the second element
            .andExpect(jsonPath("$[1].address", is("address2")));

    // Verify that the service method was called exactly once
    verify(addressesService, times(1)).getAllAddresses();
    verifyNoMoreInteractions(addressesService); // Optional: ensure no other service methods were called
  }

  @Test
  void getAddress_WithValidId_ShouldReturnAddress() throws Exception {
    // Arrange
    long addressId = 1L;
    AddressDto address = new AddressDto();
    address.setId(addressId);
    address.setAddress("address1");

    // Mock the service call for the specific ID
    when(addressesService.getAddress(eq(addressId))).thenReturn(Optional.of(address));

    // Act & Assert
    mockMvc.perform(get(API_ADDRESSES + "/{id}", addressId)) // Use path variable substitution
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id", is((int)addressId))) // JSONPath often treats numbers generically
            .andExpect(jsonPath("$.address", is("address1")));

    verify(addressesService, times(1)).getAddress(eq(addressId));
    verifyNoMoreInteractions(addressesService);
  }

  @Test
  void getAddress_WithInvalidId_ShouldReturnNotFound() throws Exception {
    // Arrange
    long addressId = 99L; // An ID that doesn't exist
    when(addressesService.getAddress(eq(addressId))).thenReturn(Optional.empty()); // Service returns empty Optional

    // Act & Assert
    mockMvc.perform(get(API_ADDRESSES + "/{id}", addressId))
            .andExpect(status().isNotFound()); // Expect HTTP Status 404

    verify(addressesService, times(1)).getAddress(eq(addressId));
    verifyNoMoreInteractions(addressesService);
  }

  @Test
  void getAddressCoins_WithValidId_ShouldReturnCoins() throws Exception {
    // Arrange
    long addressId = 1L;
    AddressDto address = new AddressDto();
    address.setId(addressId);

    CoinDto coin1 = new CoinDto(); coin1.setId(10L); coin1.setName("Bitcoin");
    CoinDto coin2 = new CoinDto(); coin2.setId(20L); coin2.setName("Ethereum");
    Set<CoinDto> coins = new HashSet<>(Arrays.asList(coin1, coin2));
    address.setCoins(coins); // Assume AddressDto has a setCoins method

    // IMPORTANT: This test assumes the controller calls getAddress() first.
    // If the controller has a more specific service call like getCoinsForAddress(), mock that instead.
    when(addressesService.getAddress(eq(addressId))).thenReturn(Optional.of(address));

    // Act & Assert
    mockMvc.perform(get(API_ADDRESSES + "/{id}/coins", addressId))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(2)))
            // Note: Order in Set/JSON array isn't guaranteed, these checks might be fragile.
            // Consider checking for existence of elements instead if order is not fixed.
            .andExpect(jsonPath("$[?(@.id == 10)].name", is(List.of("Bitcoin")))) // Check if coin with id 10 exists and has name Bitcoin
            .andExpect(jsonPath("$[?(@.id == 20)].name", is(List.of("Ethereum")))); // Check if coin with id 20 exists and has name Ethereum

    verify(addressesService, times(1)).getAddress(eq(addressId));
    verifyNoMoreInteractions(addressesService);
  }

  @Test
  void getAddressCoins_WithInvalidId_ShouldReturnNotFound() throws Exception {
    // Arrange
    long addressId = 99L;
    when(addressesService.getAddress(eq(addressId))).thenReturn(Optional.empty());

    // Act & Assert
    mockMvc.perform(get(API_ADDRESSES + "/{id}/coins", addressId))
            .andExpect(status().isNotFound());

    verify(addressesService, times(1)).getAddress(eq(addressId));
    verifyNoMoreInteractions(addressesService);
  }

  @Test
  void getAddressChains_WithValidId_ShouldReturnChains() throws Exception {
    // Arrange
    long addressId = 1L;
    AddressDto address = new AddressDto();
    address.setId(addressId);

    ChainDto chain1 = new ChainDto(); chain1.setId(100L); chain1.setName("Bitcoin Chain");
    ChainDto chain2 = new ChainDto(); chain2.setId(200L); chain2.setName("Ethereum Chain");
    Set<ChainDto> chains = new HashSet<>(Arrays.asList(chain1, chain2));
    address.setChains(chains); // Assume AddressDto has a setChains method

    when(addressesService.getAddress(eq(addressId))).thenReturn(Optional.of(address));

    // Act & Assert
    mockMvc.perform(get(API_ADDRESSES + "/{id}/chains", addressId))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(2)))
            // Similar to coins, check existence rather than order if necessary
            .andExpect(jsonPath("$[?(@.id == 100)].name", is(List.of("Bitcoin Chain"))))
            .andExpect(jsonPath("$[?(@.id == 200)].name", is(List.of("Ethereum Chain"))));

    verify(addressesService, times(1)).getAddress(eq(addressId));
    verifyNoMoreInteractions(addressesService);
  }

  @Test
  void getAddressChains_WithInvalidId_ShouldReturnNotFound() throws Exception {
    // Arrange
    long addressId = 99L;
    when(addressesService.getAddress(eq(addressId))).thenReturn(Optional.empty());

    // Act & Assert
    mockMvc.perform(get(API_ADDRESSES + "/{id}/chains", addressId))
            .andExpect(status().isNotFound());

    verify(addressesService, times(1)).getAddress(eq(addressId));
    verifyNoMoreInteractions(addressesService);
  }

  @Test
  void createAddress_ShouldReturnCreatedAddress() throws Exception {
    // Arrange
    AddressDto addressToCreate = new AddressDto();
    // Set properties needed for creation (e.g., address string, email, etc.)
    // Do NOT set the ID if it's generated by the backend.
    addressToCreate.setAddress("newAddress");
    addressToCreate.setEmail("test@example.com"); // Example property

    AddressDto createdAddress = new AddressDto();
    createdAddress.setId(1L); // The ID assigned after creation
    createdAddress.setAddress("newAddress");
    createdAddress.setEmail("test@example.com");

    // Mock the service create method. Use any(AddressDto.class) if you don't need to match exact input.
    when(addressesService.createAddress(any(AddressDto.class))).thenReturn(createdAddress);

    // Act & Assert
    mockMvc.perform(post(API_ADDRESSES) // POST request to the base path
                    .contentType(MediaType.APPLICATION_JSON) // Set Content-Type header
                    .content(objectMapper.writeValueAsString(addressToCreate))) // Set request body as JSON
            .andExpect(status().isCreated()) // Expect HTTP Status 201
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id", is(1))) // Check the returned ID
            .andExpect(jsonPath("$.address", is("newAddress"))) // Check other returned fields
            .andExpect(jsonPath("$.email", is("test@example.com")));

    // Verify the service method was called once with any AddressDto argument
    verify(addressesService, times(1)).createAddress(any(AddressDto.class));
    verifyNoMoreInteractions(addressesService);
  }

  @Test
  void updateAddress_WithValidId_ShouldReturnUpdatedAddress() throws Exception {
    // Arrange
    long addressId = 1L;
    AddressDto addressToUpdate = new AddressDto();
    addressToUpdate.setId(addressId); // ID is usually needed for update
    addressToUpdate.setAddress("updatedAddress");
    addressToUpdate.setEmail("updated@example.com");

    // Assume the update service method returns the updated DTO
    when(addressesService.updateAddress(any(AddressDto.class))).thenReturn(addressToUpdate);

    // Act & Assert
    // *** IMPORTANT: Check if your PUT mapping is /api/addresses or /api/addresses/{id} ***
    // This test assumes PUT to /api/addresses/{id}
    mockMvc.perform(put(API_ADDRESSES + "/{id}", addressId) // PUT request to the specific resource path
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(addressToUpdate)))
            .andExpect(status().isOk()) // Expect HTTP Status 200 (or maybe 204 No Content depending on impl)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // If status is 200, expect body
            .andExpect(jsonPath("$.id", is((int)addressId)))
            .andExpect(jsonPath("$.address", is("updatedAddress")))
            .andExpect(jsonPath("$.email", is("updated@example.com")));

    // Verify service call. Use any() or capture the argument if needed.
    verify(addressesService, times(1)).updateAddress(any(AddressDto.class));
    verifyNoMoreInteractions(addressesService);

        /*
        // --- OR --- If your PUT mapping is just /api/addresses (less common for updates):
        mockMvc.perform(put(API_ADDRESSES)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addressToUpdate)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is((int)addressId)))
                .andExpect(jsonPath("$.address", is("updatedAddress")))
                .andExpect(jsonPath("$.email", is("updated@example.com")));

        verify(addressesService, times(1)).updateAddress(any(AddressDto.class));
        verifyNoMoreInteractions(addressesService);
        */
  }

  @Test
  void updateAddress_WithInvalidId_ShouldReturnNotFound() throws Exception {
    // Arrange
    long addressId = 99L;
    AddressDto addressToUpdate = new AddressDto();
    addressToUpdate.setId(addressId);
    addressToUpdate.setAddress("updatedAddress");

    // Mock the service to indicate failure (e.g., return null or throw exception,
    // depending on how your service/controller handles non-existent updates)
    // Option 1: Service returns null/empty/false (adjust based on actual service method signature)
    when(addressesService.updateAddress(any(AddressDto.class))).thenReturn(null); // Or throw exception

    // Option 2: If update requires finding first, mock the find call
    // when(addressesService.getAddress(eq(addressId))).thenReturn(Optional.empty());


    // Act & Assert
    // Assuming PUT to /api/addresses/{id} and controller handles null/exception by returning 404
    mockMvc.perform(put(API_ADDRESSES + "/{id}", addressId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(addressToUpdate)))
            .andExpect(status().isNotFound()); // Expect 404 if update target doesn't exist

    // Verify service call was attempted
    verify(addressesService, times(1)).updateAddress(any(AddressDto.class));
    verifyNoMoreInteractions(addressesService);
  }


  @Test
  void deleteAddress_WithValidId_ShouldReturnOkAndTrue() throws Exception {
    // Arrange
    long addressId = 1L;
    // Mock the service delete method to return true (success)
    when(addressesService.deleteAddress(eq(addressId))).thenReturn(true);

    // Act & Assert
    mockMvc.perform(delete(API_ADDRESSES + "/{id}", addressId)) // DELETE request
            .andExpect(status().isOk()) // Expect HTTP 200 OK
            .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Assuming it returns boolean JSON
            .andExpect(content().string("true")); // Check the response body is "true"

    verify(addressesService, times(1)).deleteAddress(eq(addressId));
    verifyNoMoreInteractions(addressesService);
  }

  @Test
  void deleteAddress_WithInvalidId_ShouldReturnOkAndFalse() throws Exception {
    // Arrange
    long addressId = 99L; // Non-existent ID
    // Mock the service delete method to return false (failure/not found)
    when(addressesService.deleteAddress(eq(addressId))).thenReturn(false);

    // Act & Assert
    mockMvc.perform(delete(API_ADDRESSES + "/{id}", addressId))
            .andExpect(status().isOk()) // Controller might still return 200 OK...
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string("false")); // ...but the body indicates failure

    // Alternative: If your controller returns 404 for deleting non-existent resource:
    // .andExpect(status().isNotFound());

    verify(addressesService, times(1)).deleteAddress(eq(addressId));
    verifyNoMoreInteractions(addressesService);
  }
}