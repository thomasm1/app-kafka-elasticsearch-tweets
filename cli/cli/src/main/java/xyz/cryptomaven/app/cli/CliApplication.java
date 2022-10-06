package xyz.cryptomaven.app.cli;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import db.DataStore;
import models.Bookmark;
import models.Car;
import models.User;
import singletons.BookmarkManager;
import singletons.CarManager;
import singletons.UserManager;
import systemUser.UserMain;

@SpringBootApplication
public class CliApplication {
	// app-wide vars
	private static User[] users;
	private static Bookmark[][] bookmarks;
	private static Car[] cars;

	// launch methods
	private static void loadData() {
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
	
	private static void startBookmarking() {
	 System.out.println("\n2. Start Bookmarking");
	 for (User user: users) {
		 View.bookmark(user,bookmarks);
		 
	 }
	}

	private static void buyCar() {
		System.out.println("\n3. Buy Cars");
		for(User user: users) {
			View.buyCar(user,cars);
		}
	}
	private static void cliUser() {
		try {
			String[] args = { "first", "cli", "optional", "strings" };
			UserMain.mainUser(args);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println("PROBLEM WITH UserMain.mainUser");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//server
//		SpringApplication.run(CliApplication.class, args);

		// Bookmarks
		loadData();
		// Automated USER
		startBookmarking();
		buyCar();
		// USER MAIN
//		cliUser(); 

	}


}
