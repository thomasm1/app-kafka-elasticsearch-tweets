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
import util.InputOutput;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class CliLoader {
    // app-wide vars
    private static List<User> users;
    private static List<List<Bookmark>> bookmarks;
    private static List<Car> cars;

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

    private static void printUserData() throws FileNotFoundException, UnsupportedEncodingException {
        for (User u : users) {
            System.out.println(u);
            InputOutput.writeUser(u);
            InputOutput.writeUsers(users);
        }
    }

    private static void printBookmarks() {
        for (List<Bookmark> i : bookmarks) {
            for (Bookmark j : i) {
                System.out.println(j);
            }
        }
    }

    static void startBookmarking() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("\n2. Start Bookmarking");
        for (User user: users) {
            View.bookmark(user,bookmarks);
        }
    }
    // random loader
    public static void shareBookmark() {
        for(User user: users) {
        System.out.println("\n" + user.getEmail() + " is sharing two instance: link or book");
        for(int x = 0;x<=1;x++) {
            int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
            Bookmark bookmark = bookmarks.get(x).get(bookmarkOffset);
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
