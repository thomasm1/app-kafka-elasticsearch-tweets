package dao;


import java.sql.Connection;

import db.DataStore;
import models.Bookmark;
import util.JDBCConnection;
//import db.DataStore;
import models.UserBookmark;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static db.DataStore.bookmarkIndex;
import static db.DataStore.userBookmarks;

public class BookmarkDaoImpl   implements BookmarkDAO {

	public static Connection conn = JDBCConnection.getConnection();

	@Override   // aws thomas1 oracle 19
	public boolean createBookmark(Bookmark bookmark) { 
		String sql = "CALL add_new_bookmark(?,?,?)";

		try {
			PreparedStatement bookmarks = conn.prepareStatement(sql);
			bookmarks.setString(1, Long.toString(bookmark.getId()));
			bookmarks.setString(2, bookmark.getTitle());
			bookmarks.setString(3, bookmark.getProfileUrl());
			bookmarks.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Double-check DB connection on creating bookmark");
			e.printStackTrace();
		}
		return false;
	} 

	@Override
	public Bookmark getBookmark(int id) {
		try {
			String sql = "SELECT * FROM bookmarktable WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Long.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new Bookmark(rs.getLong("id"), rs.getString("title"), rs.getString("profileurl"));
			}
		} catch (SQLException e) {
			System.out.println("Double-check DB connection o BOokmakr get-id");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Bookmark> getBookmarks() {
		return null;
	}

	@Override
	public boolean updateBookmark(Bookmark change) {
		return false;
	}

	@Override
	public boolean deleteBookmark(int id) {
		return false;
	}

	public static void add(UserBookmark userBookmark) {
		userBookmarks[bookmarkIndex] = userBookmark;
		bookmarkIndex++;

	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);

	}
}
