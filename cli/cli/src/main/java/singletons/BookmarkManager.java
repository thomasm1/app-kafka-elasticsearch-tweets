package singletons;

import models.Book;
import models.Movie;
import models.Weblink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	
	private BookmarkManager() {}
	
	public static BookmarkManager getInstance() {
		return instance;
	}
	
	public Movie createMovie(long id, String title, String profileUrl, int releaseYear,	String[] cast, String[] directors, double imbdRating ) {

	Movie movie = new Movie();
	movie.setId(id);
	movie.setTitle(title);
	movie.setProfileUrl(profileUrl);
	movie.setReleaseYear(releaseYear);
	movie.setCast(cast);
	movie.setDirectors(directors);
	movie.setImbdRating(imbdRating);
	return movie;
	}
	
	
	public Book createBook( long id, String title, String profileUrl, int publicationYear,String publisher,String[] authors,
			  String genre,double rating  ) {

		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setProfileUrl(profileUrl); 
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setRating(rating);
	
	return book;
	}
	
	public Weblink createWebLink( long id, String title, String profileUrl, String url, String host ) {

		Weblink weblink = new Weblink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setProfileUrl(profileUrl); 
		weblink.setUrl(url);
		weblink.setHost(host);
 
	return weblink;
	}
	}
