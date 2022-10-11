package xyz.cryptomaven.app.cli;

import db.DataStore;
import logger.CliLogger;
import models.Bookmark;
import models.Car;
import models.User;
import singletons.BookmarkManager;
import singletons.CarManager;
import singletons.UserManager;

public class CliLoader {
    // app-wide vars
    private static User[] users;
    private static Bookmark[][] bookmarks;
    private static Car[] cars;

    // launch methods
    static void cliDataLoader() {

        System.out.println(CliLogger.getInstance());;
        System.out.println("1. LOADING BOOKMARK DATA");
        DataStore.loadData();
        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();
        cars = CarManager.getInstance().getCars();

        System.out.println("printing user data: ");
        printUserData();
        System.out.println("printing bookmark data: ");
        printBookmarks();
        System.out.println("printing car data: ");
        printCars();

    }

    private static void printCars() {
        for (Car c: cars) {
            System.out.println(c);
        }

    }

    private static void printUserData() {
        for (User u : users) {
            System.out.println(u);
        }
    }

    private static void printBookmarks() {
        for (Bookmark[] i : bookmarks) {
            for (Bookmark j : i) {
                System.out.println(j);
            }
        }
    }

    static void startBookmarking() {
        System.out.println("\n2. Start Bookmarking");
        for (User user: users) {
            View.bookmark(user,bookmarks);

        }
    }

    static void buyCar() {
        System.out.println("\n3. Buy Cars");
        for(User user: users) {
            View.buyCar(user,cars);
        }
    }
}
