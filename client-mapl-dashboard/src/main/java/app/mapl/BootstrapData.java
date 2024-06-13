package app.mapl;

import app.mapl.models.*; // Bookmark, Coin, User, Weblink
import app.mapl.models.auth.Authority;
import app.mapl.models.auth.RequestContext;
import app.mapl.models.auth.RoleEntity;
import app.mapl.models.auth.User;
import app.mapl.repositories.BookRepository;
import app.mapl.repositories.CoinsRepository;
import app.mapl.repositories.RoleEntityRepository;
import app.mapl.repositories.UsersRepository;
import app.mapl.repositories.WeblinksRepository;
import app.mapl.util.FileReadWrite;
import app.mapl.util.constants.Datum;
import app.mapl.util.config.logger.CliLogger;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Profile(value = {"!prod"})
public class BootstrapData implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(BootstrapData.class);

    private final RoleEntityRepository roleRepository;
    private final UsersRepository usersRepository;
    private final WeblinksRepository weblinksRepository;
    private final CoinsRepository coinsRepository;
    private final BookRepository bookRepository;
    private List<User> users;
    List<Coin> coinsStatic;
    List<Weblink> bookmarksStatic; // objects, documents, stored by path=pathname as key for retrieval, like aws-s3
    List<User> usersStatic;

    /**
     * launch methods
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws IOException {
        if (System.getenv("ENV") != null &&
                (System.getenv("ENV").equalsIgnoreCase("dev") ||
                        System.getenv("environment").equalsIgnoreCase("test") ||
                        System.getenv("ENV").equalsIgnoreCase("mysql"))) {

            log.info("ENV: ++++++++++++++  + System.getenv( ENV" );
            CliLogger.getInstance().info("UserDetailsCommandLineRunner.run()");
            //FileDataStore.loadData();


            // ROLEs
            log.info(Datum.ANSI_CYAN + "1. ANSI_CYAN LOADING ROLES");
            RequestContext.setUserId(0L);
            var userRole = new RoleEntity();
            userRole.setName(Authority.USER.name());
            userRole.setAuthorities(Authority.USER);
            roleRepository.save(userRole);

           var adminRole = new RoleEntity();
            userRole.setName(Authority.ADMIN.name());
            userRole.setAuthorities(Authority.ADMIN);
            roleRepository.save(userRole);

            RequestContext.start();

            // USERS
            log.info(Datum.ANSI_CYAN + "1. ANSI_CYAN LOADING USERS");
            usersStatic = FileDataStore.loadUsers();
            users = usersStatic;

            usersRepository.saveAll(users);
            usersRepository.save(User.builder()
                            .firstName("firstName")
                            .lastName("lastName")
                            .email("thomas.maestas@hotmail.com")
                            .password("password")
                            .organizationCode("organizationCode")
                            .dashboardCode("dashboardCode")
                            .role(roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Role not found")))
                            .build());

            Optional<User> userWithIdOne = usersRepository.findById(1);
            log.info("User is retrieved : " + userWithIdOne);

            List<User> users = usersRepository.findAll();
            log.info("All Users : " + users);

            // WEBLINKS
            try {
                bookmarksStatic = FileDataStore.loadWeblinks();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            List<Weblink> bookmarks = bookmarksStatic;
            weblinksRepository.saveAll(bookmarks);
            weblinksRepository.save(new Weblink("https://www.google.com", "<html><head></head><body>Hello!!!!!!!</body></html>", "SUCCESS"));

            // COINS
            log.info(Datum.ANSI_RED + "ANSI_RED printing user data: ");
            coinsStatic = FileDataStore.loadCoins();
            List<Coin> coins = coinsStatic;
            coinsRepository.saveAll(coins);
            coinsRepository.save(new Coin(0, "Ethereum", "ETH", 1455.1111, 1455.1111, 0));
            coinsRepository.save(new Coin(1, "Bitcoin", "BTC", 23455.5455, 1455.1111, 1));


            log.info(Datum.ANSI_GREEN + "ANSI_GREEN printing user data: ");
            printUserData();
            log.info(Datum.ANSI_BLUE + "ANSI_BLUE printing bookmark data: ***Paused until AWS DB PS/SQL UPDATED");
            printBookmarks();
            log.info(Datum.ANSI_PURPLE + "ANSI_PURPLE printing startBrowsingBuying: ");
            startBrowsingBuying();

//        runDownloaderJob();
            log.info(Datum.ANSI_RESET + "ANSI_RESET without runDownloaderJob ");

        } else {
            log.info("MAVEN_HOME: NOT SET");
        }
    }


    void printBookmarks() {
        for (Bookmark i : bookmarksStatic) {
            if (i instanceof Weblink) {
                log.info("WEBLINK" + i);
            } else {
                log.info("NON-WEBLINK" + i);
            }
        }
    }

    void writeUserData() throws IOException {
        for (User u : users) {
            System.out.println("|__________|  WRITING USER  TO FILE |_______|  /n" + u);
            FileReadWrite.writeUser(u);
            FileReadWrite.writeUsers(users);
        }
    }

    void printUserData() throws IOException {
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void startBrowsingBuying() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("\n2. Start Bookmarking");
        for (User user : usersStatic) {
            autoCollectBookmarks(user, bookmarksStatic);
            autoShareBookmarks(user, bookmarksStatic);
            automatedBuyCoins(user, coinsStatic);

        }
    }


    public List<Bookmark> autoCollectBookmarks(User user, List<Weblink> bookmarks) throws IllegalStateException, FileNotFoundException, UnsupportedEncodingException {
        List<Bookmark> subset = new ArrayList<>();
        System.out.println("\n" + user.getEmail() + " is bookmarking");
        int count = 0;
        for (int i = 0; i < FileDataStore.USER_BOOKMARK_LIMIT; i++) {
            // BOOKMARK_TYPES_COUNT 0= webLink, 1=book, 2=movie
//            int typeOffset = (int) (Math.random() * FileDataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffset = (int) (Math.random() * FileDataStore.BOOKMARK_COUNT_PER_TYPE);
            Weblink bookmark = bookmarks.get(bookmarkOffset);
            boolean isBookmarked = getBookmarkDecision(bookmark); //bookmark ~ 4 of 10
            if (isBookmarked) {
                count++;
                System.out.println(count + "[Bookmarke]" + bookmark);
                usersRepository.save(user);
                bookRepository.save(new Book(0, "title", "publisher", "authors", "genre", 4.5, 2021));
                subset.add(bookmark);
            }
        }
        return subset;
    }

    static boolean getBookmarkDecision(Bookmark bookmark) {
        return (Math.random() < .4);
    }

    // user shares subset of browsed bookmarks:
    public void autoShareBookmarks(User user, List<Weblink> bookmarks) {
        System.out.println("\n" + user.getEmail() + " is sharing two instance: (0)link or (1) book; Not (2) movie");
        for (int x = 0; x <= 1; x++) {
            int bookmarkOffset = (int) (Math.random() * FileDataStore.BOOKMARK_COUNT_PER_TYPE);
            Bookmark bookmark = bookmarks.get(bookmarkOffset);
//          bookRepository.shareBookmark(user, bookmark); /// TODO: 3/5/21
            System.out.println("User: " + user.getEmail() + "inside View; bookmark: " + bookmark.getTitle() + bookmark.getClass());
        }
    }

    public void automatedBuyCoins(User user, List<Coin> coins) {
        System.out.println("\n" + user.getEmail() + " is coinbuying");
        for (int i = 0; i < coins.size(); i++) {  // buy 5 randomly among inventory
            int coinOffset = (int) (Math.random() * FileDataStore.getCoinInventory());
            Coin coin = coins.get(coinOffset);
            usersRepository.save(user);
            coinsRepository.save(coin);
        }
    }


}
