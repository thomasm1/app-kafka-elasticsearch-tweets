package dao;

import db.DataStore;
import models.Bookmark;
import models.UserBookmark;
 
public class BookmarkDaoImpl {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}
}
