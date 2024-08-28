package karate.users;

import com.intuit.karate.junit5.Karate;

class UsersTest {
    
    @Karate.Test
    Karate testUsers() {
        return Karate.run( "users").relativeTo(getClass());
    }    

}
