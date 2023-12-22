package karate.comments;

import com.intuit.karate.junit5.Karate;

public class CommentsTest {

    @Karate.Test
    Karate testComments() {
        return Karate.run("comments").relativeTo(getClass());
    }
}
