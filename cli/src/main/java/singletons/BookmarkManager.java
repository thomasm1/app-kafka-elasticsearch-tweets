package singletons;

import dao.BookmarkDaoImpl;
import models.Book;
import models.Bookmark;
import models.Movie;
import models.User;
import models.UserBookmark;
import models.Weblink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	public static BookmarkDaoImpl bookmarkDaoImpl = new BookmarkDaoImpl();
	
	private BookmarkManager() {}
	
	public static BookmarkManager getInstance() {
		return instance;
	}
	
	public Movie createMovie(long id, String title,  int releaseYear,	String[] cast, String[] directors, String genre, double imbdRating ) {

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
 
	public Book createBook( long id, String title,  int publicationYear,String publisher,String[] authors,
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
	
	public Bookmark[][] getBookmarks() {
		return bookmarkDaoImpl.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
	    UserBookmark userBookmark = new UserBookmark();
	    userBookmark.setUser(user);
	    userBookmark.setBookmark(bookmark);
	    bookmarkDaoImpl.saveUserBookmark(userBookmark);
	    
	}

	}
