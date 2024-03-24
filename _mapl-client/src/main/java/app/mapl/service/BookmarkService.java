package app.mapl.service;
import java.util.List;

import app.mapl.models.Bookmark;
import app.mapl.models.User;
import app.mapl.repositories.BookmarkRepository;

public class BookmarkService implements IBookmarkService {
    private final BookmarkRepository bookmarkdao;

    public BookmarkService(BookmarkRepository bookmarkdao) {
        this.bookmarkdao = bookmarkdao;
    }

    public   void shareBookmark(User user, Bookmark bookmark) {
    }

//	 * This method is now a static version of the getBookmark() method. To get a bookmark by ID,
//	 * BookmarkService.getBookmark(id); NOT bookmarkManager.getInstance()!

    public boolean createBookmark(Bookmark bkmk) {
        return bookmarkdao.createBookmark(bkmk);
    }

    public Bookmark getBookmark(int id) {
        return bookmarkdao.getBookmark(id);
    };


    public List<Bookmark> getAllBookmarks() {
        return bookmarkdao.getBookmarks();
    };

    public boolean updateBookmark(Bookmark change) {
        return bookmarkdao.updateBookmark(change);
    }

    public boolean deleteBookmark(int id) {
        return bookmarkdao.deleteBookmark(id);
    }
}
