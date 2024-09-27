package app.mapl.models;

import app.mapl.util.Shareable;

import jakarta.persistence.*;

@Entity
@Table(name = "MOVIES")
public class Movie extends Bookmark implements Shareable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	private int releaseYear;
	private String cast;
	private String directors;
	private String genre;
	private double imdbRating;
	private String title;


	/**
     */
	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>Book</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<directors>").append(directors).append("</directors>");
		builder.append("<cast>").append(cast).append("</cast>");
		builder.append("<imdbRating>").append(imdbRating).append("</imdbRating>");
		builder.append("<releaseYear>").append(releaseYear).append("</releaseYear>");
		builder.append("<genre").append(genre).append("</genre>");
		builder.append("</item>");
		return builder.toString();
	}

	/**
     */
	@Override
	public boolean isWeb3Link() {
		return false;
	}
}
