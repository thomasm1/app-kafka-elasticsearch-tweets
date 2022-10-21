package xyz.cryptomaven.app.controllers;

import xyz.cryptomaven.app.models.Bookmark;
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.dataLoader.BookmarkManager;
 

// Like Singleton Managers, Controllers return singletons
public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController() {}
	public static BookmarkController getInstance() {
		return instance;
	}
	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
	}
	public void shareBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user, bookmark);
	}

}
