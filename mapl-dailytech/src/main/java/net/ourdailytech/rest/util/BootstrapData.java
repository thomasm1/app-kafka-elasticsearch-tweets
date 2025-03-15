package net.ourdailytech.rest.util;

import lombok.extern.slf4j.Slf4j;
import net.ourdailytech.rest.mapper.CommentMapper;
import net.ourdailytech.rest.mapper.PostEntityMapper;
import net.ourdailytech.rest.mapper.RoleMapper;
import net.ourdailytech.rest.mapper.UserMapper;
import net.ourdailytech.rest.models.Comment;
import net.ourdailytech.rest.models.PostEntity;
import net.ourdailytech.rest.models.Role;
import net.ourdailytech.rest.models.User;
import net.ourdailytech.rest.models.dto.CommentDto;
import net.ourdailytech.rest.models.dto.PostEntityDto;
import net.ourdailytech.rest.models.dto.RegisterDto;
import net.ourdailytech.rest.models.dto.UserDto;
import net.ourdailytech.rest.repositories.CommentsRepository;
import net.ourdailytech.rest.repositories.PostRepository;
import net.ourdailytech.rest.repositories.RoleRepository;
import net.ourdailytech.rest.repositories.UsersRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static net.ourdailytech.rest.util.PasswordGeneratorEncoder.encode;

@Slf4j
@Profile({"test"})
@Configuration
public class BootstrapData {

    private static final Faker faker = new Faker();

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private final RoleRepository rolesRepository;
    private final UsersRepository usersRepository;
    private final PostRepository postRepository;
    private final PostEntityMapper postEntityMapper;
    private final CommentsRepository commentsRepository;
    private final CommentMapper commentMapper;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    Set<Role> roles;
    List<RegisterDto> registerDtos;
    List<UserDto> userDtos;
    List<PostEntityDto> postEntityDtos = new ArrayList<>();
    List<CommentDto> commentDtos;

    public BootstrapData(RoleRepository rolesRepository, PostRepository postRepository, PostEntityMapper postEntityMapper, CommentsRepository commentsRepository, CommentMapper commentMapper, UserMapper userMapper, UsersRepository usersRepository, RoleMapper roleMapper) {
        this.rolesRepository = rolesRepository;
        this.postRepository = postRepository;
        this.postEntityMapper = postEntityMapper;
        this.commentsRepository = commentsRepository;
        this.commentMapper = commentMapper;
        this.userMapper = userMapper;
        this.usersRepository = usersRepository;
        this.roleMapper = roleMapper;
    }

    @Transactional
    @Bean
    public ApplicationRunner runner() {
        return args -> {
            if (rolesRepository.count() <= 2)
                loadRoles();
            if (usersRepository.count() <= 10)
                loadUsers();
            if (postRepository.count() <= 10) {
                loadPosts();
                loadComments();
            }
        };
    }

    private void loadRoles() {
        roles = Set.of(
                new Role(1L, "ROLE_USER"),
                new Role(2L, "ROLE_ADMIN")
        );
        rolesRepository.saveAll(roles);
        rolesRepository.flush();
    }

    public void loadUsers() {
        registerDtos = new ArrayList<>();
        String encryptedPassword = encode("password");
        List<UserDto> newUserDtos = generateRandomUsers(registerDtos);

        log.info("***** Generated Example Users *****");
        log.info("userDtos COUNT______________: {}", newUserDtos.size());
        List<User> users = newUserDtos.stream().map(userMapper::toEntity).toList();
        Role roleUser = rolesRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Role not found"));
        for (User user : users) {
            user.setRoles(Set.of(roleUser));
            user.setPassword(encryptedPassword);
        }
        usersRepository.saveAll(users);
        usersRepository.flush();
        log.info("Saved {} example posts.", users.size());
    }

    public void loadPosts() {

        generateRandomPosts(postEntityDtos);

        log.info("***** Generated Example Posts *****");
        postEntityDtos.forEach(post -> log.info("Title: {}, Author: {}, Date: {}", post.getTitle(), post.getAuthor(), post.getDate()));
        List<PostEntity> posts = postEntityDtos.stream().map(postEntityMapper::toEntity).toList();
        postRepository.saveAll(posts);
        postRepository.flush();
        log.info("Saved {} example posts.", posts.size());
    }

    public void loadComments() {
        commentDtos = new ArrayList<>();
        List<CommentDto> newCommentDtos = generateRandomComments(commentDtos);
        List<PostEntity> posts = (List<PostEntity>) postRepository.findAll();

        log.info("***** Generated Example Posts *****");
        newCommentDtos.forEach(cd -> log.info("Email: {}, Name: {}, Body: {}", cd.getEmail(), cd.getName(), cd.getBody()));
        List<Comment> comments = newCommentDtos.stream().map(commentMapper::toEntity).toList();

//            comments.get(i).setPost(commentDtos.get(i).getPostId() != 0 ? posts.get((int) (commentDtos.get(i).getPostId() - 1)) : PostEntity.builder().build());
        for (int i = 0; i < comments.size(); i++) {
            PostEntity post = posts.get((int) (posts.get(i) != null ? posts.get(i) : new PostEntity.SimplePost()));
            postEntityDtos.get(i).getPost();
            comments.get(i).setPost(post);
        }

        commentsRepository.saveAll(comments);
        commentsRepository.flush();
        log.info("Saved {} example comments.", comments.size());
    }

    private List<UserDto> generateRandomUsers(List<RegisterDto> registerDtos) {
        userDtos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            registerDtos.add(RegisterDto.builder()
                    .email(faker.internet().emailAddress())
                    .password(bCryptPasswordEncoder.encode(faker.internet().password()))
                    .build());
        }
        for (int i = 0; i < 10; i++) {
            userDtos.add(UserDto.builder()
                    .id(String.valueOf(i))
                    .userId(i+1)
                    .email(registerDtos.get(0).getEmail())
                    .username(registerDtos.get(0).getEmail())
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .userType(faker.number().numberBetween(1, 3))
                    .organizationCode("CD")
                    .cusUrl("http://www.dailytech.net/photoPath")
                    .dashboardCode("dashboardCd")
                    .isActive(1)
                    .contactType(1)
                    .build());
        }

        return userDtos;
    }

    private List<PostEntityDto> generateRandomPosts(List<PostEntityDto> postEntityDtos) {


        for (int i = 1; i <= 10; i++) {
            postEntityDtos.add(PostEntityDto.builder()
                    .id(i)
                    .did("10-" + (10 + i) + "-18")
                    .date("October " + (10 + i) + ", 2018")
                    .author("by Thomas Maestas")
                    .monthOrder("October")
                    .cat3(faker.book().genre()) // Random category
                    .title(faker.book().title()) // Random book title
                    .post("<p class='firstparagraph'>" + faker.lorem().paragraph() + "</p>")
                    .blogcite("<p class='cite'><a href='" + faker.internet().url() + "'>Source</a></p>")
                    .email(userDtos.get(i - 1).getEmail())
                    .categoryId(1L)
                    .build());
        }
        return postEntityDtos;
    }

    private List<CommentDto> generateRandomComments(List<CommentDto> commentDtos) {

        for (int i = 1;  i < 10; i++) {
            commentDtos.add(CommentDto.builder()
                    .id(i)
                    .name(faker.name().fullName())
                    .email(userDtos.get(i - 1).getUsername())
                    .body(faker.lorem().paragraph())
                    .build());
        }
        return commentDtos;
    }
}

