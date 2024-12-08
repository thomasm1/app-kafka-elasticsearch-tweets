package app.mapl.repositories;

import app.mapl.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UsersRepository userRepository;

    @Test
    void testSaveUser() {
        User user = userRepository.save(User.builder()
                        .username("New Name")
                .build());

    System.out.println("user: " + user);
    }
}
