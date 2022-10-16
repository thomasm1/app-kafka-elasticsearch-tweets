package xyz.cryptomaven.app.cli;

import controllers.BookmarkController;
import db.DataStore;
import logger.CliLogger;
import models.Bookmark;
import models.Car;
import models.User;
import singletons.BookmarkManager;
import singletons.CarManager;
import singletons.UserManager;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class CliLoader {
    // app-wide vars
    private static User[] users;
    private static Bookmark[][] bookmarks;
    private static Car[] cars;

    // launch methods
    static void cliDataLoader() throws FileNotFoundException, UnsupportedEncodingException {

        System.out.println(CliLogger.getInstance());;
        System.out.println("1. LOADING BOOKMARK DATA");
        DataStore.loadData();
        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarksArray();
        cars = CarManager.getInstance().getCars();

        System.out.println("printing user data: ");
        printUserData();
        System.out.println("printing bookmark data: ***Paused until AWS DB PS/SQL UPDATED");
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
    public static void shareBookmark() {
        for(User user: users) {
        System.out.println("\n" + user.getEmail() + " is sharing two instance of link or book");
        for (int i = 0; i < 2; i++) { // shareing 2

            int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);

            Bookmark bookmark = bookmarks[i][bookmarkOffset];
            BookmarkController.getInstance().shareBookmark(user, bookmark);
            System.out.println("User: " + user + "inside View; bookmark: " + bookmark);

        }
        }
    }

    static void buyCar() {
        System.out.println("\n3. Buy Cars");
        for(User user: users) {
            View.buyCar(user,cars);
        }
    }
}
