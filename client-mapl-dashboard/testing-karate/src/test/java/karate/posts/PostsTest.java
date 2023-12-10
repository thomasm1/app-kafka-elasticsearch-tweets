package karate.posts;

import com.intuit.karate.junit5.Karate;

/**
 *
 */
public class PostsTest {

    @Karate.Test
    Karate testPosts() {
        return Karate.run("posts").relativeTo(getClass());
    }
}
