package xyz.cryptomaven.app.cli;

import controllers.BookmarkController;
import controllers.UserController;
import db.DataStore;
import models.Book;
import models.Bookmark;
import models.Car;
import models.User;

public class View {

	public static void bookmark(User user, Bookmark[][] bookmarks) {

		System.out.println("\n" + user.getEmail() + " is bookmarking");
		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
			int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);

			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
			System.out.println(bookmark);
		}
	}

	public static void buyCar(User user, Car[] cars) {
		System.out.println("\n" + user.getEmail() + " is carbuying");
		for (int i = 0; i < 2; i++) {  // buy 2 randomly among inventory
			int carOffset = (int) (Math.random() * DataStore.CAR_INVENTORY);
			Car car = cars[carOffset];
			UserController.getInstance().saveUserCar(user, car);
			System.out.println(car);
		}
	}


}
