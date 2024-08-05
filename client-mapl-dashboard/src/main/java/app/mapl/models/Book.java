package app.mapl.models;

import app.mapl.util.Shareable;
import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "books")
public class Book extends Bookmark implements Shareable {
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BOOK_SEQUENCE" )
//	@SequenceGenerator(name = "BOOK_SEQUENCE", sequenceName = "BOOK_SEQUENCE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	@Column(name="pubyear")
	private int publicationYear;
	private String publisher;
	private String authors;
	private String genre;
	private double rating;

	private String title;

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

	/**
	 * @return
	 */
	@Override
	public boolean isWeb3Link() {
		return false;
	}

}
