package xyz.cryptomaven.rest.repositoryTests;//package net.ourdailytech.rest.repositoryTests;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import xyz.cryptomaven.rest.models.User;
import xyz.cryptomaven.rest.repositories.UsersRepository;

import static org.assertj.core.api.Assertions.assertThat;

//@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"xyz.cryptomaven.rest.util"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    UsersRepository userRepository;

    @Commit
    @Order(1)
    @Test
    void testSaveUserSplice() {
        long countBefore = userRepository.count();
        User user = userRepository.save(User.builder()
                        .username("New Name")
                        .email("user@user.com")
                .build());
        long countAfter = userRepository.count();
        assertThat(countBefore).isLessThan(countAfter);

    System.out.println("user: " + user);
    }

    @Order(2)
    @Test
    void testSaveUserSpliceTransaction() {
        long countBefore = userRepository.count();
        assertThat(countBefore).isGreaterThan(0);

        User user = userRepository.save(User.builder()
                .username("New Name")
                .email("user@user.com")
                .build());
        long countAfter = userRepository.count();
        assertThat(countBefore).isLessThan(countAfter);

        System.out.println("user: " + user);
    }
}



