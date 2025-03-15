//package net.ourdailytech.rest.repositoryTests;
//
//import net.ourdailytech.rest.models.User;
//import net.ourdailytech.rest.repositories.UsersRepository;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.annotation.Commit;
//import org.springframework.test.context.ActiveProfiles;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@ActiveProfiles("local")
//@DataJpaTest
//@ComponentScan(basePackages = {"net.ourdailytech.rest.util"})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class UserRepositoryTest {
//
//    @Autowired
//    UsersRepository userRepository;s
//
//    @Commit
//    @Order(1)
//    @Test
//    void testSaveUserSplice() {
//        long countBefore = userRepository.count();
//        assertThat(countBefore).isEqualTo(0);
//        User user = userRepository.save(User.builder()
//                        .username("New Name")
//                        .email("user@user.com")
//                        .password("password")
//                .build());
//        long countAfter = userRepository.count();
//        assertThat(countBefore).isLessThan(countAfter);
//
//    System.out.println("user: " + user);
//    }
//
//    @Order(2)
//    @Test
//    void testSaveUserSpliceTransaction() {
//        long countBefore = userRepository.count();
//        assertThat(countBefore).isEqualTo(1);
//
//        User user = userRepository.save(User.builder()
//                .username("New Name")
//                .email("user@user.com")
//                .password("password")
//                .build());
//        long countAfter = userRepository.count();
//        assertThat(countBefore).isLessThan(countAfter);
//
//        System.out.println("user: " + user);
//    }
//}
