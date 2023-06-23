package app.mapl.unitTests;

import app.mapl.bootstrap.ManagerBookmarks;
import app.mapl.models.Weblink;
import org.junit.jupiter.api.Test;

public class WeblinkTest {
    @Test
    public void isWeb3Link() {
    // test 1 web3 in title
       Weblink weblinkHost =  ManagerBookmarks.getInstance().createWeblink(2000,  "http://www.javaworld.com/article/2072759/core-java/part-2.html","http://www.web3.com" );
//        boolean isWeb3 = weblinkHost.isWeb3Link();
//        assertTrue( isWeb3,"isWeb3link must return true");

        // test 2 web3 in url
        Weblink weblinkUrl =  ManagerBookmarks.getInstance().createWeblink(2000,  "http://www.javaworld.com/article/2072759/core-java/web3-tiger--part-2.html","http://www.javaworld.com" );
//        boolean isWeb3Url = weblinkUrl.isWeb3Link();
//        assertTrue( isWeb3Url,"isWeb3link must return true");

    }
}
