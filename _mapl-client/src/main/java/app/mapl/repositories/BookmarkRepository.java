package app.mapl.repositories;

import app.mapl.models.Book;
import app.mapl.models.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    boolean createBookmark(Bookmark bkmk);

    Bookmark getBookmark(int id);

    boolean deleteBookmark(int id);

    List<Bookmark> getBookmarks();

    boolean updateBookmark(Bookmark change);
}
