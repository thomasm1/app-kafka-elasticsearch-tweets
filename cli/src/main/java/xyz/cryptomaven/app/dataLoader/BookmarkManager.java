package xyz.cryptomaven.app.dataLoader;

import xyz.cryptomaven.app.dao.BookmarkDaoImpl;
import xyz.cryptomaven.app.models.Book;
import xyz.cryptomaven.app.models.Bookmark;
import xyz.cryptomaven.app.models.Movie;
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.models.UserBookmark;
import xyz.cryptomaven.app.models.Weblink;
import xyz.cryptomaven.app.util.DownloadSequential;
import xyz.cryptomaven.app.util.InputOutput;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	public static BookmarkDaoImpl bookmarkDaoImpl = new BookmarkDaoImpl();
	
	private BookmarkManager() {}
	
	public static BookmarkManager getInstance() {
		return instance;
	}
	
	public Movie createMovie(long id, String title,  int releaseYear,	String cast, String directors, String genre, double imbdRating ) {

	Movie movie = new Movie();
	movie.setId(id);
	movie.setTitle(title); 
	movie.setReleaseYear(releaseYear);
	movie.setCast(cast);
	movie.setDirectors(directors);
	movie.setGenre(genre);
	movie.setImbdRating(imbdRating);
	return movie;
	}
 
	public Book createBook( long id, String title,  int publicationYear,String publisher,String authors,
			  String genre,double rating  ) {

		Book book = new Book();
		book.setId(id);
		book.setTitle(title); 
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setRating(rating);
	
	return book;
	}
 
	public Weblink createWeblink( long id, String url, String host ) {

		Weblink weblink = new Weblink();
		weblink.setId(id); 
		weblink.setUrl(url);
		weblink.setHost(host);
	return weblink;
	}


	public void saveUserBookmark(User user, Bookmark bookmark) {
	    UserBookmark userBookmark = new UserBookmark();
	    userBookmark.setUser(user);
	    userBookmark.setBookmark(bookmark);
	    bookmarkDaoImpl.saveUserBookmark(userBookmark);

		if(bookmark instanceof Weblink) {
			try {
				String url = ((Weblink) bookmark).getUrl();
				if(!url.endsWith(".pdf")) {
					String website = DownloadSequential.downloadFromUrl(((Weblink) bookmark).getUrl());
					if(website != null) {
						InputOutput.writeWebpage(website, bookmark.getId());
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
	    
	}
public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
	System.out.println("Data to be shared by" + user + " : "+bookmark);
	if (bookmark instanceof Book) {
		System.out.println(((Book) bookmark).getItemData());
	} else if (bookmark instanceof Weblink) {
		System.out.println(((Weblink) bookmark).getItemData());

	}
}
	public List<List<Bookmark>> getBookmarksArray() {
		return bookmarkDaoImpl.getBookmarksArray();
	}
}
