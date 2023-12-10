package app.mapl.service;
import java.util.List;

import app.mapl.dao.BookmarkDAO;
import app.mapl.dao.BookmarkDaoImpl;
import app.mapl.models.Bookmark;

public class BookmarkService {

    public static BookmarkDAO bookmarkdao = new BookmarkDaoImpl();

//	 * This method is now a static version of the getBookmark() method. To get a bookmark by ID,
//	 * BookmarkService.getBookmark(id); NOT bookmarkManager.getInstance()!

    public static boolean createBookmark(Bookmark bkmk) {
        return bookmarkdao.createBookmark(bkmk);
    }

    public static Bookmark getBookmark(int id) {
        return bookmarkdao.getBookmark(id);
    };


    public static List<Bookmark> getAllBookmarks() {
        return bookmarkdao.getBookmarks();
    };

    public static boolean updateBookmark(Bookmark change) {
        return bookmarkdao.updateBookmark(change);
    }

    public static boolean deleteBookmark(int id) {
        return bookmarkdao.deleteBookmark(id);
    }
}
