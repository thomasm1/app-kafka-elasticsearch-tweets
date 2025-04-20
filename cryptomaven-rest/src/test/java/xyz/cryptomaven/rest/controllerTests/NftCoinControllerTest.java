package xyz.cryptomaven.rest.controllers; // Corrected package name based on previous context

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import xyz.cryptomaven.rest.models.dto.AttributeDto;
import xyz.cryptomaven.rest.models.dto.MetadataDto;
import xyz.cryptomaven.rest.models.dto.NftCoinDto;
import xyz.cryptomaven.rest.services.NftService; // Assuming NftService interface exists

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq; // Use eq() for specific primitive/wrapper values
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static xyz.cryptomaven.rest.util.constants.Constants.API_NFT_COINS;

class NftCoinControllerTest {

    @Mock
    private NftService nftService;

    @InjectMocks
    private NftCoinController nftCoinController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(nftCoinController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void getNft_WithValidId_ShouldReturnNft() throws Exception {
        // Arrange
        long nftId = 1L;
        NftCoinDto nftCoinDto = new NftCoinDto();
        nftCoinDto.setId(nftId);
        nftCoinDto.setName("NFT1");
        nftCoinDto.setAmount(1.0);
        // Add metadata if needed for the response check
        MetadataDto metadataDto = new MetadataDto();
        metadataDto.setMetadataId(10L); // Example metadata ID
        metadataDto.setName("Meta1");
        nftCoinDto.setMetadata(metadataDto);


        when(nftService.getNft(eq(nftId))).thenReturn(Optional.of(nftCoinDto));

        // Act & Assert
        mockMvc.perform(get(API_NFT_COINS + "/{id}", nftId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is((int)nftId))) // Cast long to int for 'is' matcher if needed
                .andExpect(jsonPath("$.name", is("NFT1")))
                .andExpect(jsonPath("$.amount", is(1.0)))
                .andExpect(jsonPath("$.metadata.metadataId", is(10))); // Check nested field

        verify(nftService, times(1)).getNft(eq(nftId));
        verifyNoMoreInteractions(nftService);
    }

    @Test
    void getNft_WithInvalidId_ShouldReturnNotFound() throws Exception {
        // Arrange
        long nftId = 99L;
        when(nftService.getNft(eq(nftId))).thenReturn(Optional.empty());

        // Act & Assert
        mockMvc.perform(get(API_NFT_COINS + "/{id}", nftId))
                .andExpect(status().isNotFound());

        verify(nftService, times(1)).getNft(eq(nftId));
        verifyNoMoreInteractions(nftService);
    }

    @Test
    void getAllNfts_ShouldReturnListOfNfts() throws Exception {
        // Arrange
        NftCoinDto nftCoinDto1 = new NftCoinDto();
        nftCoinDto1.setId(1L);
        nftCoinDto1.setName("NFT1");
        nftCoinDto1.setAmount(1.0);

        NftCoinDto nftCoinDto2 = new NftCoinDto();
        nftCoinDto2.setId(2L);
        nftCoinDto2.setName("NFT2");
        nftCoinDto2.setAmount(2.0);
        List<NftCoinDto> nftCoinDtos = Arrays.asList(nftCoinDto1, nftCoinDto2);

        when(nftService.getAllNFTs()).thenReturn(nftCoinDtos);

        // Act & Assert
        mockMvc.perform(get(API_NFT_COINS)) // Test "" or "/" mapping
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("NFT1")))
                .andExpect(jsonPath("$[0].amount", is(1.0)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("NFT2")))
                .andExpect(jsonPath("$[1].amount", is(2.0)));

        verify(nftService, times(1)).getAllNFTs();
        verifyNoMoreInteractions(nftService);
    }

    @Test
    void createNft_ShouldReturnCreatedNft() throws Exception {
        // Arrange
        // --- Input DTO ---
        NftCoinDto nftCoinDtoToCreate = new NftCoinDto();
        nftCoinDtoToCreate.setName("NewNFT");
        nftCoinDtoToCreate.setAmount(10.0);

        MetadataDto metadataToCreate = new MetadataDto();
        metadataToCreate.setName("NewMetadata");
        metadataToCreate.setDescription("NewDescription");
        metadataToCreate.setImage("NewImage.png");
        metadataToCreate.setExternal_url("http://example.com/nft");

        AttributeDto attributeToCreate = new AttributeDto();
        attributeToCreate.setAttribute_value("Blue");
        attributeToCreate.setTrait_type("Color");
        // Don't set ID for attribute if it's generated

        metadataToCreate.setAttributes(List.of(attributeToCreate));
        nftCoinDtoToCreate.setMetadata(metadataToCreate);
        // Don't set ID for NftCoinDto or MetadataDto if generated

        // --- Expected Output DTO (mocked service response) ---
        NftCoinDto createdNftCoinDto = new NftCoinDto();
        createdNftCoinDto.setId(1L); // ID assigned by service/DB
        createdNftCoinDto.setName("NewNFT");
        createdNftCoinDto.setAmount(10.0);

        MetadataDto createdMetadataDto = new MetadataDto();
        createdMetadataDto.setMetadataId(10L); // ID assigned by service/DB
        createdMetadataDto.setName("NewMetadata");
        createdMetadataDto.setDescription("NewDescription");
        createdMetadataDto.setImage("NewImage.png");
        createdMetadataDto.setExternal_url("http://example.com/nft");


        AttributeDto createdAttributeDto = new AttributeDto();
        createdAttributeDto.setAttrid(100L); // ID assigned by service/DB
        createdAttributeDto.setAttribute_value("Blue");
        createdAttributeDto.setTrait_type("Color");

        createdMetadataDto.setAttributes(List.of(createdAttributeDto));
        createdNftCoinDto.setMetadata(createdMetadataDto);

        // Mock the service call
        when(nftService.createNft(any(NftCoinDto.class))).thenReturn(createdNftCoinDto);

        // Act & Assert
        mockMvc.perform(post(API_NFT_COINS) // Test "" or "/" mapping
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(nftCoinDtoToCreate)))
                .andExpect(status().isCreated()) // Check HTTP 201
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("NewNFT")))
                .andExpect(jsonPath("$.amount", is(10.0)))
                .andExpect(jsonPath("$.metadata.metadataId", is(10))) // Check nested fields
                .andExpect(jsonPath("$.metadata.name", is("NewMetadata")))
                .andExpect(jsonPath("$.metadata.description", is("NewDescription")))
                .andExpect(jsonPath("$.metadata.image", is("NewImage.png")))
                .andExpect(jsonPath("$.metadata.external_url", is("http://example.com/nft")))
                .andExpect(jsonPath("$.metadata.attributes", hasSize(1)))
                .andExpect(jsonPath("$.metadata.attributes[0].id", is(100)))
                .andExpect(jsonPath("$.metadata.attributes[0].attribute_value", is("Blue")))
                .andExpect(jsonPath("$.metadata.attributes[0].trait_type", is("Color")));

        verify(nftService, times(1)).createNft(any(NftCoinDto.class)); // Verify service interaction
        verifyNoMoreInteractions(nftService);
    }

    @Test
    void updateNft_WithValidId_ShouldReturnCreatedAndTrue() throws Exception {
        // Arrange
        long nftIdToUpdate = 1L;
        long metadataId = 10L;
        long attributeId = 100L;

        NftCoinDto nftCoinDtoToUpdate = new NftCoinDto();
        nftCoinDtoToUpdate.setId(nftIdToUpdate); // ID is crucial for update
        nftCoinDtoToUpdate.setName("UpdatedNFT");
        nftCoinDtoToUpdate.setAmount(20.0);

        MetadataDto metadataDto = new MetadataDto();
        metadataDto.setMetadataId(metadataId); // ID needed if updating existing metadata record
        metadataDto.setName("UpdatedMetadata");
        metadataDto.setDescription("UpdatedDescription");
        metadataDto.setImage("UpdatedImage.jpg");
        metadataDto.setExternal_url("http://example.com/nft/updated");


        AttributeDto attributeDto = new AttributeDto();
        attributeDto.setAttrid(attributeId); // ID needed if updating existing attribute record
        attributeDto.setAttribute_value("Red");
        attributeDto.setTrait_type("Color");

        metadataDto.setAttributes(List.of(attributeDto));
        nftCoinDtoToUpdate.setMetadata(metadataDto);

        // Mock service to return true (update successful)
        when(nftService.updateNft(any(NftCoinDto.class))).thenReturn(true);

        // Act & Assert
        mockMvc.perform(put(API_NFT_COINS + "/{id}", nftIdToUpdate) // Use the mapping with ID
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(nftCoinDtoToUpdate)))
                .andExpect(status().isCreated()) // Controller returns CREATED (201)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Expect boolean JSON
                .andExpect(content().string("true")); // Expect "true" body

        // Verify service call. Use ArgumentCaptor if you need to check the DTO passed to the service.
        verify(nftService, times(1)).updateNft(any(NftCoinDto.class));
        verifyNoMoreInteractions(nftService);
    }

    @Test
    void updateNft_WithInvalidId_ShouldReturnCreatedAndFalse() throws Exception {
        // Arrange
        long nftIdToUpdate = 99L; // Non-existent ID

        NftCoinDto nftCoinDtoToUpdate = new NftCoinDto();
        nftCoinDtoToUpdate.setId(nftIdToUpdate);
        nftCoinDtoToUpdate.setName("UpdatedNFT");
        nftCoinDtoToUpdate.setAmount(20.0);
        // Metadata can be minimal if the main check is the ID not found
        nftCoinDtoToUpdate.setMetadata(new MetadataDto());

        // Mock service to return false (update failed, e.g., NFT not found)
        when(nftService.updateNft(any(NftCoinDto.class))).thenReturn(false);

        // Act & Assert
        mockMvc.perform(put(API_NFT_COINS + "/{id}", nftIdToUpdate) // Use the mapping with ID
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(nftCoinDtoToUpdate)))
                .andExpect(status().isCreated()) // Controller still returns CREATED (201) as per its code
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Expect boolean JSON
                .andExpect(content().string("false")); // Expect "false" body

        verify(nftService, times(1)).updateNft(any(NftCoinDto.class));
        verifyNoMoreInteractions(nftService);
    }

    @Test
    void deleteNft_WithValidId_ShouldReturnOkAndTrue() throws Exception {
        // Arrange
        long nftIdToDelete = 1L;
        when(nftService.deleteNft(eq(nftIdToDelete))).thenReturn(true);

        // Act & Assert
        mockMvc.perform(delete(API_NFT_COINS + "/{id}", nftIdToDelete))
                .andExpect(status().isOk()) // Expect HTTP 200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Expect boolean JSON
                .andExpect(content().string("true")); // Expect "true" body

        verify(nftService, times(1)).deleteNft(eq(nftIdToDelete));
        verifyNoMoreInteractions(nftService);
    }

    @Test
    void deleteNft_WithInvalidId_ShouldReturnOkAndFalse() throws Exception {
        // Arrange
        long nftIdToDelete = 99L; // Non-existent ID
        when(nftService.deleteNft(eq(nftIdToDelete))).thenReturn(false); // Service indicates failure

        // Act & Assert
        mockMvc.perform(delete(API_NFT_COINS + "/{id}", nftIdToDelete))
                .andExpect(status().isOk()) // Controller returns OK (200)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Expect boolean JSON
                .andExpect(content().string("false")); // Expect "false" body

        verify(nftService, times(1)).deleteNft(eq(nftIdToDelete));
        verifyNoMoreInteractions(nftService);
    }
}