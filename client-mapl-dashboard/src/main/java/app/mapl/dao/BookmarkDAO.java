package app.mapl.dao;

import app.mapl.models.Bookmark;
import app.mapl.models.Weblink;

import java.util.List;
 
public interface BookmarkDAO {

    public boolean createBookmark(Bookmark bookmark); // void
    public Bookmark getBookmark(int id);
    public List<Bookmark> getBookmarks();
    public boolean updateBookmark(Bookmark change); // void
    public boolean deleteBookmark(int id); // void 

    public List<List<Bookmark>> getBookmarksArray();
    public List<Weblink> getAllWebLinks();
    public List<Weblink> getWebLinks(Weblink.DownloadStatus downloadStatus);

}