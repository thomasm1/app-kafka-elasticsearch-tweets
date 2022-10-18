package xyz.cryptomaven.app.cli;

import controllers.BookmarkController;
import controllers.UserController;
import db.TestDataStore;
import models.Bookmark;
import models.Car;
import models.User;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class View {

	public static void bookmark(User user, List<List<Bookmark>> bookmarks) throws FileNotFoundException, UnsupportedEncodingException {

		System.out.println("\n" + user.getEmail() + " is bookmarking");
		int count = 0;
		for (int i = 0; i < TestDataStore.USER_BOOKMARK_LIMIT; i++) {
			// BOOKMARK_TYPES_COUNT 0= webLink, 1=book, 2=movie
			int typeOffset = (int) (Math.random() * TestDataStore.BOOKMARK_TYPES_COUNT);
			int bookmarkOffset = (int) (Math.random() * TestDataStore.BOOKMARK_COUNT_PER_TYPE);
			Bookmark bookmark = bookmarks.get(typeOffset).get(bookmarkOffset);
			boolean isBookmarked = getBookmarkDecision(bookmark); //bookmark ~ 4 of 10
			if(isBookmarked) {
				count++;
				BookmarkController.getInstance().saveUserBookmark(user, bookmark);
				System.out.println(count+ "[Bookmarke]"+bookmark);
			}
		}
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return (Math.random() <.4);
	}

	public static void buyCar(User user, List<Car> cars) {
		System.out.println("\n" + user.getEmail() + " is carbuying");
		for (int i = 0; i < 2; i++) {  // buy 2 randomly among inventory
			int carOffset = (int) (Math.random() * TestDataStore.getCarInventory());
			Car car = cars.get(carOffset);
			UserController.getInstance().saveUserCar(user, car);
			System.out.println(car);
		}
	}
	}
