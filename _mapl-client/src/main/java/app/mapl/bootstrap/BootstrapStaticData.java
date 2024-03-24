package app.mapl.bootstrap;

import app.mapl.models.*;
import app.mapl.repositories.BookmarkRepository;
import app.mapl.repositories.CoinsRepository;
import app.mapl.repositories.UsersRepository;
import app.mapl.repositories.WeblinksRepository;
import app.mapl.service.BookmarkService;
import app.mapl.util.ReadWriteFile;
import app.mapl.util.constants.Datum;
import app.mapl.config.logger.CliLogger;
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
@Profile(value={"!prod"})
public class BootstrapStaticData implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(BootstrapStaticData.class);


    private final UsersRepository usersRepository;
    private final WeblinksRepository weblinksRepository;
    private final CoinsRepository coinsRepository;


    private final BookmarkRepository bookmarkRepository;
    private List<User> users;
    List<Coin> coinsStatic;
    List<Weblink> bookmarksStatic;
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
            (  System.getenv("ENV").equals("dev") ||
                    System.getenv("environment").equals("dev") ||
                    System.getenv("ENV").equals("prod"))) {

        System.out.println("ENV: ++++++++++++++++++++++++++" +
                "++++++++++++++++++++++++++" +
                "" + System.getenv("ENV"));
        CliLogger.getInstance().info("UserDetailsCommandLineRunner.run()");

        System.out.println(Datum.ANSI_CYAN + "1. ANSI_CYAN LOADING BOOKMARK DATA");
//        FileDataStore.loadData();

        System.out.println(Datum.ANSI_CYAN + "1. ANSI_CYAN LOADING USERS");// USERS
        usersStatic = FileDataStore.loadUsers();
        users = usersStatic;
        users.stream().map(user -> {
            user.setUsername(user.getEmail());
            return user;
        });

        usersRepository.saveAll(users);
        usersRepository.save(new User(0,"thomas.maestas@hotmail.com", "password", "lastName", "firstName",
                1,   "organizationCode", "thomas.maestas@hotmail.com", "cusUrl", "dashboardCode",  1, 3 ));


        Optional<User> userWithIdOne = usersRepository.findById(1);
        log.info("User is retrieved : " + userWithIdOne);

        List<User> users = usersRepository.findAll();
        log.info("All Users : " + users);

        // WEBLINKS
        try {
            bookmarksStatic = FileDataStore.loadWeblinks();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        List<Weblink> bookmarks = bookmarksStatic;
        weblinksRepository.saveAll(bookmarks);
        weblinksRepository.save(new Weblink(0, "https://www.google.com", "Google", "<html><head></head><body>Hello!!!!!!!</body></html>", Weblink.DownloadStatus.SUCCESS));

        // COINS
        System.out.println(Datum.ANSI_RED + "ANSI_RED printing user data: ");
 coinsStatic = FileDataStore.loadCoins();
        List<Coin> coins = coinsStatic;
        coinsRepository.saveAll(coins);
        coinsRepository.save(new Coin(0, "Ethereum", "ETH", 1455.1111, 1455.1111,0));
        coinsRepository.save(new Coin(1, "Bitcoin", "BTC", 23455.5455,1455.1111, 1));


        System.out.println(Datum.ANSI_GREEN + "ANSI_GREEN printing user data: ");
        printUserData();
        System.out.println(Datum.ANSI_BLUE + "ANSI_BLUE printing bookmark data: ***Paused until AWS DB PS/SQL UPDATED");
        printBookmarks();
        System.out.println(Datum.ANSI_PURPLE + "ANSI_PURPLE printing startBrowsingBuying: ");
        startBrowsingBuying();

//        runDownloaderJob();
        System.out.println(Datum.ANSI_RESET + "ANSI_RESET without runDownloaderJob ");

    } else {
        System.out.println("MAVEN_HOME: NOT SET");
    }
    }


      void printBookmarks() {
        for (Bookmark i : bookmarksStatic) {
            if (i instanceof Weblink) {
                System.out.println("WEBLINK" + i);
            } else {
                System.out.println("NON-WEBLINK" + i);
            }
        }
    }

    void writeUserData() throws IOException {
        for (User u : users) {
            System.out.println("|__________|  WRITING USER  TO FILE |_______|  /n" + u);
            ReadWriteFile.writeUser(u);
            ReadWriteFile.writeUsers(users);
        }
    }

    void printUserData() throws IOException {
        for (User u : users) {
            System.out.println(u);
        }
    }

    public   void startBrowsingBuying() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("\n2. Start Bookmarking");
        for (User user : usersStatic) {
            autoCollectBookmarks(user, bookmarksStatic);
            autoShareBookmarks(user, bookmarksStatic);
            automatedBuyCoins(user, coinsStatic);

        }
    }


    public   List<Bookmark> autoCollectBookmarks(User user, List<Weblink> bookmarks) throws IllegalStateException, FileNotFoundException, UnsupportedEncodingException {
        List<Bookmark> subset = new ArrayList<>();
        System.out.println("\n" + user.getEmail() + " is bookmarking");
        int count = 0;
        for (int i = 0; i < FileDataStore.USER_BOOKMARK_LIMIT; i++) {
            // BOOKMARK_TYPES_COUNT 0= webLink, 1=book, 2=movie
//            int typeOffset = (int) (Math.random() * FileDataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffset = (int) (Math.random() * FileDataStore.BOOKMARK_COUNT_PER_TYPE);
            Bookmark bookmark = bookmarks.get(bookmarkOffset);
            boolean isBookmarked = getBookmarkDecision(bookmark); //bookmark ~ 4 of 10
            if (isBookmarked) {
                count++;
                System.out.println(count + "[Bookmarke]" + bookmark);
                usersRepository.save(user );
                bookmarkRepository.save( bookmark);
                subset.add(bookmark);
            }
        }
        return subset;
    }

    static boolean getBookmarkDecision(Bookmark bookmark) {
        return (Math.random() < .4);
    }

    // user shares subset of browsed bookmarks:
    public   void autoShareBookmarks(User user, List<Weblink> bookmarks) {
        System.out.println("\n" + user.getEmail() + " is sharing two instance: (0)link or (1) book; Not (2) movie");
        for (int x = 0; x <= 1; x++) {
            int bookmarkOffset = (int) (Math.random() * FileDataStore.BOOKMARK_COUNT_PER_TYPE);
            Bookmark bookmark = bookmarks.get(bookmarkOffset);
//          bookmarkRepository.shareBookmark(user, bookmark); /// TODO: 3/5/21
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
