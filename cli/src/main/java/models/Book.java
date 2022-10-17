package models;

import org.apache.commons.lang.StringUtils;
import util.Shareable;

import java.util.Arrays;

public   class Book extends Bookmark implements Shareable {
	private int publicationYear;
	private String publisher;
	private String authors;
	private String genre;
	private double rating;

	public Book(long id, String title, String profileUrl) {
		super(id, title, profileUrl);
	}

	public Book() {
		super();
	}

	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}

//	@Override
//	public boolean isWeb3Link() {
//		return true;
//	}

	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", authors="
				+  authors + ", genre=" + genre + ", rating=" + rating + "]";
	}


	@Override
	public  String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
			builder.append("<type>Book</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<authors>").append(authors).append("</authors>");
		builder.append("<publisher>").append(publisher).append("</publisher>");
		builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
		builder.append("<genre").append(genre).append("</genre>");
		builder.append("</item>");
		return builder.toString();
	}
}
