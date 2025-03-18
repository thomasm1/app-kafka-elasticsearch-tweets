package net.ourdailytech.rest;

 
import net.ourdailytech.rest.models.dto.PostEntityDto;
import net.ourdailytech.rest.service.PostService;
import net.ourdailytech.rest.service.PostServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceMockTest {      // *NOTE: change PK postnames before sending to DB


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
    };
    @Mock
    private PostService postServiceMockTest;
    // Impl usersServiceImpl = mock(UsersServiceImpl.class);
    @InjectMocks
    private PostServiceImpl postServiceImpl;

    @BeforeAll // setup
    public static void setupClass() {
        System.out.println("Class/Static setup ");
    }

    @BeforeEach
    public void setup() {
        System.out.println("Method/Instance setup ");
    }

    @Test
    public void add_new_post() {
        PostEntityDto post = PostEntityDto.builder().build();
        when(postServiceMockTest.createPost(post)).thenReturn(assertInstanceOf(PostEntityDto.class, post));
        assertEquals(postServiceMockTest.createPost(post), post);

    }

    @Test
    public void update_post() {
        PostEntityDto post = PostEntityDto.builder().build();

        when(postServiceMockTest.updatePost(post,1)).thenReturn(assertInstanceOf(PostEntityDto.class, post));
        assertEquals(postServiceMockTest.updatePost(post,1), post);

    }
// NEED TO FIX THIS TEST
//    @Test
//    public void get_all_post() {
//        PostEntityResponse post =  postServiceMockTest.getAllPosts(1, 10, "id", "asc");
//        when(postServiceMockTest.getAllPosts(1, 10,"id","asc")).thenReturn(  assertInstanceOf(PostEntityResponse.class, post));
//        assertEquals(postServiceMockTest.getAllPosts(1, 10,"id","asc"), post);
//    }

    @Test
    public void get_post() {
        PostEntityDto post = getPostEntityDto();
        when(postServiceMockTest.getPostById(post.getId())).thenReturn(assertInstanceOf(PostEntityDto.class, post));
        postServiceMockTest.createPost(post) ;
        assertNotNull(postServiceMockTest.getPostById(post.getId())); // Check not null bc dynamic int ID

    }

    @Test
    public void delete_post() {
        PostEntityDto post = getPostEntityDto();
        when(postServiceMockTest.deletePostById(post.getId())).thenReturn(assertInstanceOf(Boolean.class, true));
 postServiceMockTest.createPost(post) ;

        Assertions.assertTrue(postServiceMockTest.deletePostById(post.getId()));
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("After Class executing ...");
    } // teardown


}