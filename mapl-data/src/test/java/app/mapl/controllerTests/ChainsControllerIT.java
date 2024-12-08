package app.mapl.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import app.mapl.controllers.ChainsController;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.models.Chain;
import app.mapl.mapper.ChainMapper;
import app.mapl.models.dto.ChainDto;
import app.mapl.models.dto.Symbol;
import app.mapl.repositories.ChainsRepository;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ChainsControllerIT {
    @Autowired
    ChainsController chainController;

    @Autowired
    ChainsRepository chainRepository;

    @Autowired
    ChainMapper chainMapper;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void tesListChainsBySymbolAndNameShowInventoryTruePage2() throws Exception {
        mockMvc.perform(get(ChainsController.CHAIN_PATH)
                        .queryParam("name", "Ethereum")
                        .queryParam("symbol", Symbol.ETH.name())
                        .queryParam("pageNumber", "2")
                        .queryParam("pageSize", "50"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.size()", is(50)))
                .andExpect(jsonPath("$.content[0].quantityOnHand").value(IsNull.notNullValue()));
    }

    @Test
    void tesListChainsBySymbolAndNameShowInventoryTrue() throws Exception {
        mockMvc.perform(get(ChainsController.CHAIN_PATH)
                        .queryParam("name", "Ethereum")
                        .queryParam("symbol", Symbol.ETH.name())
                        .queryParam("pageSize", "800"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.size()", is(310)))
                .andExpect(jsonPath("$.content[0].quantityOnHand").value(IsNull.notNullValue()));
    }

    @Test
    void tesListChainsBySymbolAndNameShowInventoryFalse() throws Exception {
        mockMvc.perform(get(ChainsController.CHAIN_PATH)
                        .queryParam("name", "Ethereum")
                        .queryParam("symbol", Symbol.ETH.name())
                        .queryParam("pageSize", "800"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.size()", is(310)))
                .andExpect(jsonPath("$.content[0].quantityOnHand").value(IsNull.nullValue()));
    }

    @Test
    void tesListChainsBySymbolAndName() throws Exception {
        mockMvc.perform(get(ChainsController.CHAIN_PATH)
                        .queryParam("name", "Ethereum")
                        .queryParam("symbol", Symbol.ETH.name())
                        .queryParam("pageSize", "800"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.size()", is(310)));
    }

    @Test
    void tesListChainsBySymbol() throws Exception {
        mockMvc.perform(get(ChainsController.CHAIN_PATH)
                        .queryParam("name", "Ethereum")
                        .queryParam("symbol", Symbol.ETH.name())
                        .queryParam("pageSize", "800"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.size()", is(548)));
    }

    @Test
    void tesListChainsByName() throws Exception {
        mockMvc.perform(get(ChainsController.CHAIN_PATH)
                .queryParam("name", "BNB")
                .queryParam("pageSize", "800"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.size()", is(336)));
    }

    @Test
    void testPatchChainBadName() throws Exception {
        Chain chain = chainRepository.findAll().get(0);

        Map<String, Object> chainMap = new HashMap<>();
        chainMap.put("name", "New Name 1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

        mockMvc.perform(patch(ChainsController.CHAIN_PATH_ID, chain.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(chainMap)))
                .andExpect(status().isBadRequest());

    }

    @Test
    void testDeleteByIDNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> {
            chainController.deleteChain((int) Math.floor(Math.random()*31));
        });
    }

    @Rollback
    @Transactional
    @Test
    void deleteByIdFound() {
        Chain chain = chainRepository.findAll().get(0);

        ResponseEntity responseEntity = chainController.deleteChain(chain.getChainId());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        assertThat(chainRepository.findById(chain.getChainId()).isEmpty());
    }

    @Test
    void testUpdateNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> {
            chainController.updateById((int) Math.floor(Math.random()*31), ChainDto.builder().build());
        });
    }

    @Rollback
    @Transactional
    @Test
    void updateExistingChain() {
        Chain chain = chainRepository.findAll().get(0);
        ChainDto chainDto = chainMapper.toOneDto(chain);
        chainDto.setId(null);
//        chainDto.setVersion(null);
        final String name = "UPDATED";
        chainDto.setName(name);

        ResponseEntity responseEntity = chainController.updateById(chain.getChainId(), chainDto);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        Chain updatedChain = chainRepository.findById(chain.getChainId()).get();
        assertThat(updatedChain.getName()).isEqualTo(name);
    }

//    @Rollback
//    @Transactional
//    @Test
//    void saveNewChainTest() {
//        ChainDto chainDto = ChainDto.builder()
//                .name("New Chain")
//                .build();
//
//        ResponseEntity responseEntity = chainController.handlePost(chainDto);
//
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
//        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();
//
//        String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
//        UUID savedUUID = UUID.fromString(locationUUID[4]);
//
//        Chain chain = chainRepository.findById(savedUUID).get();
//        assertThat(chain).isNotNull();
//    }

    @Test
    void testChainIdNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> {
            chainController.getChainByChainId((int) Math.floor(Math.random()*31));
        });
    }

    @Test
    void testGetById() {
        Chain chain = chainRepository.findAll().get(0);

        ChainDto dto = chainController.getChainByChainId(chain.getChainId());

        assertThat(dto).isNotNull();
    }

//    @Test
//    void testListChains() {
//        Page<ChainDto> dtos = chainController.listChains(null, null,   1, 2413);
//
//        assertThat(dtos.getContent().size()).isEqualTo(1000);
//    }
//
//    @Rollback
//    @Transactional
//    @Test
//    void testEmptyList() {
//        chainRepository.deleteAll();
//        Page<ChainDto> dtos = chainController.listChains(null, null,   1, 25);
//
//        assertThat(dtos.getContent().size()).isEqualTo(0);
//    }
}
