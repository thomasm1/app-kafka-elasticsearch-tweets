package app.mapl.service;


import app.mapl.models.Bookmark;
import app.mapl.models.User;
import app.mapl.dataLoader.BookmarkManager;

import java.util.List;


// Like Singleton Managers, This Service is a Controllers return singletons


public class BookmarkServlet {

    private static BookmarkServlet instance = new BookmarkServlet();
    private BookmarkServlet() {}
    public static BookmarkServlet getInstance() {
        return instance;
    }
    public void saveLocalUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveLocalUserBookmark(user, bookmark);

    }
    public List<Bookmark> getLocalUserBookmarksByUser(User user) {
        List bookmarks = BookmarkManager.getInstance().getLocalUserBookmarksByUser(user);
        return null;
    }
    public void shareBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().share(user, bookmark);
    }


//    public static BookmarkDAO bookmarkdao = new BookmarkDaoImpl();
//
////	 * This method is now a static version of the getBookmark() method. To get a bookmark by ID,
////	 * BookmarkService.getBookmark(id); NOT bookmarkManager.getInstance()!
//
//    public static boolean createBookmark(Bookmark bkmk) {
//        return bookmarkdao.createBookmark(bkmk);
//    }
//
//    public static Bookmark getBookmark(int id) {
//        return bookmarkdao.getBookmark(id);
//    };
//
//
//    public static List<Bookmark> getAllBookmarks() {
//        return bookmarkdao.getBookmarks();
//    };
//
//    public static boolean updateBookmark(Bookmark change) {
//        return bookmarkdao.updateBookmark(change);
//    }
//
//    public static boolean deleteBookmark(int id) {
//        return bookmarkdao.deleteBookmark(id);
//    }
}
