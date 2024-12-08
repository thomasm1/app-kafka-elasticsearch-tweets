package app.mapl.controllerTests;

import app.mapl.controllers.NftController;
import app.mapl.models.dto.NftDto;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = NftController.class)
@AutoConfigureMockMvc(addFilters = false)
class NftControllerTest {

    private static String SPECIFIC_URL = "http://localhost:8080/api/nfts/1";

    private static String GENERIC_URL = "http://localhost:8080/api/nfts/";
    @MockBean
    private NftController nftController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createNft() {
    }

    @Test
    void getNft() throws Exception {
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(SPECIFIC_URL).accept(MediaType.APPLICATION_JSON);


        ResponseEntity<NftDto> nft =  nftController.getNft(1);

        when(nftController.getNft(1)).thenReturn(nft);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String expectedResponse = """
				{

					"id":1,
					"name":"Polygon",
					"amount":3,
					"metadata":null

				}

				""";


        MockHttpServletResponse response = mvcResult.getResponse();

        assertEquals(200, response.getStatus());
        JSONAssert.assertEquals(expectedResponse, response.getContentAsString(), false);

    }

    @Test
    void getAllNFTs() {
    }

    @Test
    void getAllNfts() {
    }

    @Test
    void updateNft() {
    }

    @Test
    void deleteNft() {
    }
}
