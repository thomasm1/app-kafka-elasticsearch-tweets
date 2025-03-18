package net.ourdailytech.rest;

import net.ourdailytech.rest.mapper.PostEntityMapper;
import net.ourdailytech.rest.models.dto.PostEntityDto;
import net.ourdailytech.rest.service.PostService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;


public class PostServiceImplTest {      // *NOTE: change PK coinnames before sending to DB

    @Mock
    private PostService postServiceTester;
    private PostEntityMapper postMapper;

    @BeforeAll // setup
    public static void setupClass() {
        System.out.println("Class/Static setup ");
    }

    private PostEntityDto getPostEntityDto() {
        PostEntityDto postEntityDto = PostEntityDto.builder()
                .id(1)
                .author("thomas")
                .post("post")
                .did("did")
                .cat3("cat3")
                .blogcite("blogcite")
                .email("email")
                .categoryId(1L) // Long
                .build();
        return postEntityDto;
    }


    @BeforeEach
    public void setup() {
        System.out.println("Method/Instance setup ");
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void add_new_post() {
        PostEntityDto post = getPostEntityDto();
        when(postServiceTester.createPost(post)).thenReturn(post);
        Assertions.assertEquals(postServiceTester.createPost(post), post);
    }

    @Test
    public void update_post() {
        PostEntityDto post = getPostEntityDto();
        when(postServiceTester.createPost(post)).thenReturn(post);
        when(postServiceTester.updatePost(post, post.getId())).thenReturn(post);
        Assertions.assertNotNull(postServiceTester.updatePost(post, post.getId()));
    }

    @Test
    public void get_post_make() {
        PostEntityDto post = getPostEntityDto();
        when(postServiceTester.createPost(post)).thenReturn(post);
        Assertions.assertEquals("thomas", post.getAuthor());
    }

    @Test
    public void get_post() {
        PostEntityDto post = getPostEntityDto();
        when(postServiceTester.createPost(post)).thenReturn(post);
        when(postServiceTester.getPostById(post.getId())).thenReturn(post); // Check not null bc dynamic int ID
        Assertions.assertEquals(post.getId(), 1);
    }

    @Test
    public void delete_post() {
        PostEntityDto cd = getPostEntityDto();
        when(postServiceTester.createPost(cd)).thenReturn(cd);
        when(postServiceTester.deletePostById(cd.getId())).thenReturn(true);
// 	Assertions.assertTrue(postServiceTester.deletePost(cd.getId()));
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("After Class executing ...");
    } // teardown


}
