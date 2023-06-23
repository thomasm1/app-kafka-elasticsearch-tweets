package app.mapl.dao;


import app.mapl.dataLoader.BookmarkManager;
import app.mapl.models.Bookmark;
import app.mapl.models.User;
import app.mapl.models.UserBookmark;
import app.mapl.models.Weblink;
import app.mapl.util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                Bookmark bookmark = new Bookmark();
                bookmark.setId(rs.getInt("id"));
                bookmark.setTitle(rs.getString("title"));
                bookmark.setProfileUrl(rs.getString("profileurl"));
                return  bookmark;
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

    @Override
    public List<List<Bookmark>> getBookmarksArray() {
        return BookmarkManager.TestDataStore.getBookmarksArray();
    }

    // Wide-net Http weblinks
    public List<Weblink> getAllWebLinks() {
        List<Weblink> result = new ArrayList<>();
        List<List<Bookmark>> bookmarks = BookmarkManager.TestDataStore.getBookmarksArray();
        List<Bookmark> allWeblinks = bookmarks.get(0);
        for (Bookmark wl : allWeblinks) {
            result.add((Weblink) wl);
        }
        return result;
    }

    // Filter from get-ALL-WebLinks to get only 200's
    public List<Weblink> getWebLinks(Weblink.DownloadStatus downloadStatus) {
        List<Weblink> result = new ArrayList<>();
        List<Weblink> allWeblinks = getAllWebLinks();
        for (Weblink weblink : allWeblinks) {
            if (weblink.getDownloadStatus().equals(downloadStatus)) {
                result.add(weblink);
            }
        }
        return result;
    }
    public  void add(UserBookmark userBookmark) {
        BookmarkManager.TestDataStore.add(userBookmark);
    }

    public  void saveLocalUserBookmark(UserBookmark userBookmark) {
        BookmarkManager.TestDataStore.add(userBookmark);
    }

    public List<Bookmark> getLocalUserBookmarksByUser(User user) {
      return BookmarkManager.TestDataStore.getLocalUserBookmarksByUser(user);
    }
}