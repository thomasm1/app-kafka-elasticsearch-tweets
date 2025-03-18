package net.ourdailytech.rest.util;

import lombok.RequiredArgsConstructor;
import net.ourdailytech.rest.models.Comment;
import net.ourdailytech.rest.models.PostEntity;
import net.ourdailytech.rest.models.Role;
import net.ourdailytech.rest.models.User;
import net.ourdailytech.rest.repositories.CommentsRepository;
import net.ourdailytech.rest.repositories.PostRepository;
import net.ourdailytech.rest.repositories.RoleRepository;
import net.ourdailytech.rest.repositories.UsersRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Set;


/**
 *
 */
@Component
@Profile({"test"})
public class TestDataLoader implements CommandLineRunner {


  public TestDataLoader(PostRepository postRepository, CommentsRepository commentsRepository, UsersRepository userRepository, RoleRepository roleRepository) {
        this.postRepository = postRepository;
        this.commentsRepository = commentsRepository;
        this.userRepository = userRepository;
      this.roleRepository = roleRepository;
    }

    private static final Logger log = LoggerFactory.getLogger(TestDataLoader.class);
    private final PostRepository postRepository;
    private final CommentsRepository commentsRepository;
    private final UsersRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        commentsRepository.deleteAll();
        postRepository.deleteAll();
        postRepository.flush();

        PostEntity post = PostEntity.builder().title("Post 1").build();
        PostEntity postSaved = postRepository.save(post);
        postRepository.flush();

        Comment comment = Comment.builder().body("Comment 1").post(postSaved).build();
        Comment commentSaved = commentsRepository.save(comment);
        commentsRepository.flush();

        Role roleUser = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Role not found"));
        User user = User.builder().email("user1@gmail.com").password("password").roles(Set.of(roleUser)).build();
        User userSaved = userRepository.save(user);
        userRepository.flush();


        postRepository.findAll().forEach(p -> {
            log.info("Post: {}", p.getTitle());
        });
        commentsRepository.findAll().forEach(c -> {
            log.info("Comment: {}", c.getBody());
        });
        userRepository.findAll().forEach(u -> {
            log.info("User: {}", u.getEmail());
        });
    }


}
