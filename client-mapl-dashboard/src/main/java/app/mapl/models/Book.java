package app.mapl.models;

import app.mapl.util.Shareable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import jakarta.persistence.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;



@Setter
@Getter
@Entity
@Table(name = "BOOKS")
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class Book extends Bookmark implements Shareable {
//	@Id
////	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BOOK_SEQUENCE" )
////	@SequenceGenerator(name = "BOOK_SEQUENCE", sequenceName = "BOOK_SEQUENCE", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")
//	private long id;
	@Column(name="pubyear")
	private int publicationYear;
	private String publisher;
	private String authors;
	private String genre;
	private double rating;

	private String title;

	public Book() {
		super();
	}

	public Book(int i, String title, String publisher, String authors, String genre, double v, int i1) {
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

	/**
	 * @return
	 */
	@Override
	public boolean isWeb3Link() {
		return false;
	}

}
