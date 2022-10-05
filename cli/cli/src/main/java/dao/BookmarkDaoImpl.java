package dao;

import db.DataStore;
import models.Bookmark;
 
public class BookmarkDaoImpl {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}
}
