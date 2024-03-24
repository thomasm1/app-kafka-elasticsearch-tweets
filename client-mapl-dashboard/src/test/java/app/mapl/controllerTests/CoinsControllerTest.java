package app.mapl.controllerTests;

import app.mapl.controllers.CoinsController;
import app.mapl.service.CoinsServiceJPA;
import com.fasterxml.jackson.databind.ObjectMapper;
import app.mapl.mapper.CoinMapper;
import app.mapl.dto.CoinDto;
//import app.mapl.models.dto.Symbol;
import app.mapl.repositories.CoinsRepository;
import app.mapl.service.CoinsService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(CoinsController.class)
   public    class CoinsControllerTest {

        @Autowired
        MockMvc mockMvc;

        @Autowired
        ObjectMapper objectMapper;

        @MockBean
        CoinsService chainService;

        @MockBean
        CoinsServiceJPA chainServiceImpl;
        @MockBean
        CoinsRepository chainsRepository;
        @MockBean
        CoinMapper chainMapper;

        @Captor
        ArgumentCaptor<UUID> uuidArgumentCaptor;

        @Captor
        ArgumentCaptor<CoinDto> chainArgumentCaptor;



        @BeforeEach
        void setUp() {
            chainsRepository = mock(CoinsRepository.class);
            chainMapper = mock(CoinMapper.class);
        }


//        @Test
//        void testPatchCoin() throws Exception {
//            CoinDto chain = chainServiceImpl.listCoins("Ethereum", Symbol.valueOf("ETH"),   1, 25).getContent().get(0);
//
//            Map<String, Object> chainMap = new HashMap<>();
//            chainMap.put("name", "New Name");
//
//            mockMvc.perform(patch(CoinsController.CHAIN_PATH_ID, chain.getName())
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .accept(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(chainMap)))
//                    .andExpect(status().isNoContent());
//
//            verify(chainService.patchCoinById(uuidArgumentCaptor.capture(), chainArgumentCaptor.capture()));
//
//            assertThat(chain.getCoinId()).isEqualTo(uuidArgumentCaptor.getValue());
//            assertThat(chainMap.get("name")).isEqualTo(chainArgumentCaptor.getValue().getName());
//        }

//        @Test
//        void testDeleteCoin() throws Exception {
//            CoinDto chain = chainServiceImpl.listCoins(null, null,  1, 25).getContent().get(0);
//
//            given(chainService.deleteById(any())).willReturn(Optional.of(chain));
//
//            mockMvc.perform((RequestBuilder) delete(CoinsController.CHAIN_PATH_ID, chain.getUserId())
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isNoContent());
//
//            verify(chainService).delete(uuidArgumentCaptor.capture());
//
//            assertThat(chain.getUserId()).isEqualTo(uuidArgumentCaptor.getValue());
//        }
//
//        @Test
//        void testUpdateCoin() throws Exception {
//            CoinDto chain = chainServiceImpl.listCoins(null, null,  1, 25).getContent().get(0);
//
//            given(chainService.updateCoinByCoinId(any(), any())).willReturn(Optional.of(chain));
//
//            mockMvc.perform(put(CoinsController.CHAIN_PATH_ID, chain.getCoinId())
//                            .accept(MediaType.APPLICATION_JSON)
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(chain)))
//                    .andExpect(status().isNoContent());
//
//            verify(chainService).updateCoinByCoinId(chain.getCoinId(), any(CoinDto.class));
//        }
//
//        @Test
//        void testUpdateCoinBlankName() throws Exception {
//            CoinDto chain = chainService.listCoins(null, null,  1, 25).getContent().get(0);
//            chain.setName("");
//            given(chainService.updateCoinByCoinId(any(), any())).willReturn(Optional.of(chain));
//
//            mockMvc.perform(put(CoinsController.CHAIN_PATH_ID, chain.getCoinId())
//                            .accept(MediaType.APPLICATION_JSON)
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(chain)))
//                    .andExpect(status().isBadRequest())
//                    .andExpect(jsonPath("$.length()", is(1)));
//
//        }
//
//        @Test
//        void testCreateNewCoin() throws Exception {
//            CoinDto chain = chainServiceImpl.listCoins(null, null,  1, 25).getContent().get(0);
////            chain.setVersion(null);
//            chain.setId(null);
//
//            given(chainService.saveNewCoin(any(CoinDto.class))).willReturn(chainServiceImpl.listCoins(null, null,  1, 25).getContent().get(1));
//
//            mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post(CoinsController.CHAIN_PATH)
//                            .accept(MediaType.APPLICATION_JSON)
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(chain)))
//                    .andExpect(status().isCreated())
//                    .andExpect(header().exists("Location"));
//        }
//
//        @Test
//        void testCreateCoinNullName() throws Exception {
//
//            CoinDto chainDto = CoinDto.builder().build();
//
//            given(chainService.saveNewCoin(any(CoinDto.class))).willReturn(chainServiceImpl.listCoins(null, null,  1, 25).getContent().get(1));
//
//            MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post(CoinsController.CHAIN_PATH)
//                            .accept(MediaType.APPLICATION_JSON)
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(chainDto)))
//                    .andExpect(status().isBadRequest())
//                    .andExpect(jsonPath("$.length()", is(6)))
//                    .andReturn();
//
//            System.out.println(mvcResult.getResponse().getContentAsString());
//        }
//
//        @Test
//        void testListCoins() throws Exception {
//            given(chainService.listCoins(any(), any() , any(), any()))
//                    .willReturn(chainServiceImpl.listCoins(null, null,  null, null));
//
//            mockMvc.perform(get(CoinsController.CHAIN_PATH)
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(jsonPath("$.content.length()", is(3)));
//        }
//
//        @Test
//        void getCoinByIdNotFound() throws Exception {
//
//            given(chainService.getCoinByCoinId(any(Integer.class))).willReturn(Optional.empty());
//
//            mockMvc.perform(get(CoinsController.CHAIN_PATH_ID, (int) Math.floor(Math.random()*31)))
//                    .andExpect(status().isNotFound());
//        }
//
//        @Test
//        void getCoinById() throws Exception {
//            CoinDto testCoin = chainServiceImpl.listCoins(null, null,  1, 25).getContent().get(0);
//
//            given(chainService.getCoinByCoinId(testCoin.getCoinId())).willReturn(Optional.of(testCoin));
//
//            mockMvc.perform(get(CoinsController.CHAIN_PATH_ID, testCoin.getCoinId())
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(jsonPath("$.id", is(testCoin.getCoinId().toString())))
//                    .andExpect(jsonPath("$.name", is(testCoin.getName())));
//        }
    }

