package app.mapl.controllerTests;


import app.mapl.controllers.PostEntityController;
import app.mapl.dto.PostEntityDto;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = PostEntityController.class)
@AutoConfigureMockMvc(addFilters = false)
class PostEntityControllerTest {

    private static String SPECIFIC_URL = "http://localhost:8080/api/posts/1";

    private static String GENERIC_URL = "http://localhost:8080/api/posts/";
    @MockBean
    private PostEntityController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPostEntity() {
    }

    @Test
    void getPostEntity() throws Exception {
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get(SPECIFIC_URL).accept(MediaType.APPLICATION_JSON);


        ResponseEntity<PostEntityDto> postEntity =  controller.getPostById(1);

        when(controller.getPostById(1)).thenReturn(postEntity);

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
    void getAllPostEntitys() {
    }

    @Test
    void updatePostEntity() {
    }

    @Test
    void deletePostEntity() {
    }
}
